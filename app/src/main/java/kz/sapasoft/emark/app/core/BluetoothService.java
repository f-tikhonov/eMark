package kz.sapasoft.emark.app.core;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Log;

import java.util.Set;
import java.util.UUID;

public class BluetoothService {

    private static final String TAG = "BLEq";
    private final Context context;
    private final BluetoothServiceCallback callback;

    private BluetoothGatt bluetoothGatt;

    public BluetoothService(Context context,
                            BluetoothServiceCallback callback) {
        this.context = context.getApplicationContext();
        this.callback = callback;
    }

    @SuppressLint("MissingPermission")
    public void searchAndConnectDevice() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter != null ? bluetoothAdapter.getBondedDevices() : null;

        if (pairedDevices != null) {
            for (BluetoothDevice device : pairedDevices) {
                Log.d(TAG, "Found device: " + device.getName());

                if (device.getName() != null && device.getName().contains("3M")) {
                    connect(device);
                    break;
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void connect(BluetoothDevice device) {
        Log.d(TAG, "Пытаемся подключить устройство " + device.getName().toString());
        bluetoothGatt = device.connectGatt(context, false, gattCallback);
    }

    // unused
    @SuppressLint("MissingPermission")
    private void destroy() {
        bluetoothGatt.close();
    }

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (status == BluetoothGatt.GATT_SUCCESS && newState == BluetoothGatt.STATE_CONNECTED) {
                Log.d(TAG, "Успешное подключение, начинаем service discovery");
                gatt.discoverServices();
            } else {
                Log.e(TAG, "Ошибка соединения: статус = " + status);
                callback.onError(new Exception("Connection failed with status " + status));
                gatt.close();
            }
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status != BluetoothGatt.GATT_SUCCESS) {
                Log.e(TAG, "Ошибка service discovery: статус = " + status);
                callback.onError(new Exception("Service discovery failed"));
                gatt.close();
                return;
            }

            // присвоение значений сервис и характеристи UUID
            UUID serviceUUID = null;
            UUID characteristicUUID = null;
            UUID descriptorUUID = null;

            for (BluetoothGattService serviceItem : gatt.getServices()) {
                Log.d(TAG, "Обнаружен сервис: " + serviceItem.getUuid());
                if (serviceItem.getUuid().toString().contains("aabb")) {
                    Log.d(TAG, "Сервис: " + serviceItem.getUuid());
                    serviceUUID = serviceItem.getUuid();
                    for (BluetoothGattCharacteristic characteristicItem : serviceItem.getCharacteristics()) {
                        if (characteristicItem.getUuid().toString().contains("1bb1")) {
                            Log.d(TAG, "  └── Характеристика: " + characteristicItem.getUuid());
                            characteristicUUID = characteristicItem.getUuid();
                        }
                    }
                }
            }

            BluetoothGattService service = gatt.getService(serviceUUID);
            if (service == null) {
                Log.e(TAG, "Сервис не найден: " + serviceUUID);
                callback.onError(new Exception("Service not found: " + serviceUUID));
                gatt.close();
                return;
            }

            BluetoothGattCharacteristic characteristic = service.getCharacteristic(characteristicUUID);
            for (BluetoothGattDescriptor desc : characteristic.getDescriptors()) {
                Log.d(TAG, "Найден дескриптор: " + desc.getUuid());
                descriptorUUID = desc.getUuid();
            }

            if (characteristic == null) {
                Log.e(TAG, "Характеристика не найдена: " + characteristicUUID);
                callback.onError(new Exception("Characteristic not found: " + characteristicUUID));
                gatt.close();
                return;
            }

            boolean readInitiated = gatt.readCharacteristic(characteristic);
            if (!readInitiated) {
                Log.e(TAG, "Не удалось инициировать чтение характеристики");
                callback.onError(new Exception("Failed to initiate characteristic read"));
                gatt.close();
            }


            // Для уведомлений об измении характеристики
            int props = characteristic.getProperties();
            if ((props & BluetoothGattCharacteristic.PROPERTY_NOTIFY) == 0 &&
                    (props & BluetoothGattCharacteristic.PROPERTY_INDICATE) == 0) {
                Log.e(TAG, "Характеристика не поддерживает уведомления или индикации");
                callback.onError(new Exception("Characteristic doesn't support notifications/indications"));
                gatt.close();
                return;
            }

            if (descriptorUUID == null) {
                Log.e("BLEq", "Notification descriptor not found");
                callback.onError(new Exception("Notification descriptor not found"));
                gatt.close();
                return;
            }

            // Включаем уведомления
            boolean notificationSet = gatt.setCharacteristicNotification(characteristic, true);
            if (!notificationSet) {
                Log.e(TAG, "Не удалось включить уведомления для характеристики");
                callback.onError(new Exception("Failed to set notification"));
                gatt.close();
                return;
            }

           // Находим дескриптор уведомлений
            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(descriptorUUID); // стандартный UUID
            if (descriptor != null) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                gatt.writeDescriptor(descriptor);
            } else {
                Log.e("BLEq", "Дескриптор не найден");
            }

        @SuppressLint("MissingPermission")
        @Override
        public void onCharacteristicRead(BluetoothGatt gatt,
                                         BluetoothGattCharacteristic characteristic,
                                         int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                byte[] value = characteristic.getValue();
                String stringValue = new String(value);
                callback.onDiscovered(stringValue);
            } else {
                Log.e("BLEq", "Ошибка чтения характеристики: " + status);
                callback.onError(new Exception("Characteristic read failed"));
            }
            gatt.close();
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            if (characteristic.getService().getUuid().toString().contains("aabb")) {
                Log.d(TAG, "Уведомление: Сервис: " + characteristic.getService().getUuid());
                for (BluetoothGattCharacteristic item : characteristic.getService().getCharacteristics()) {
                    Log.d(TAG, "Уведомление: Обнаружена характеристика: " + item.getUuid());
                    if (item.getUuid().toString().contains("1bb1")) {
                        byte[] value = characteristic.getValue();
                        String stringValue = new String(value);
                        Log.d(TAG, "Уведомление получено: " + stringValue);
                        callback.onChanged(
                                characteristic.getService().getUuid(),
                                characteristic.getUuid(),
                                stringValue
                        );
                    }
                }
            }
        }
    };
}