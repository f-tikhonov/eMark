package kz.sapasoft.emark.app.core;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Log;

import java.util.UUID;

public class BluetoothService {

    private final Context context;
    private final BluetoothDevice device;
    private final UUID serviceUUID;
    private final UUID characteristicUUID;
    private final BluetoothServiceCallback callback;

    private BluetoothGatt bluetoothGatt;

    public BluetoothService(Context context,
                            BluetoothDevice device,
                            UUID serviceUUID,
                            UUID characteristicUUID,
                            BluetoothServiceCallback callback) {
        this.context = context.getApplicationContext();
        this.device = device;
        this.serviceUUID = serviceUUID;
        this.characteristicUUID = characteristicUUID;
        this.callback = callback;
    }

    @SuppressLint("MissingPermission")
    public void connect() {
        Log.d("BLEq", "Пытаемся подключить устройство " + device.getName().toString());
        bluetoothGatt = device.connectGatt(context, false, gattCallback);
    }

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @SuppressLint("MissingPermission")
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (status == BluetoothGatt.GATT_SUCCESS && newState == BluetoothGatt.STATE_CONNECTED) {
                Log.d("BLEq", "Успешное подключение, начинаем service discovery");
                gatt.discoverServices();
            } else {
                Log.e("BLEq", "Ошибка соединения: статус = " + status);
                callback.onError(new Exception("Connection failed with status " + status));
                gatt.close();
            }
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status != BluetoothGatt.GATT_SUCCESS) {
                Log.e("BLEq", "Ошибка service discovery: статус = " + status);
                callback.onError(new Exception("Service discovery failed"));
                gatt.close();
                return;
            }

            BluetoothGattService service = gatt.getService(serviceUUID);
            if (service == null) {
                Log.e("BLEq", "Сервис не найден: " + serviceUUID);
                callback.onError(new Exception("Service not found: " + serviceUUID));
                gatt.close();
                return;
            }

            BluetoothGattCharacteristic characteristic = service.getCharacteristic(characteristicUUID);
            for (BluetoothGattDescriptor desc : characteristic.getDescriptors()) {
                Log.d("BLEqq", "Найден дескриптор: " + desc.getUuid());
            }
            if (characteristic == null) {
                Log.e("BLEq", "Характеристика не найдена: " + characteristicUUID);
                callback.onError(new Exception("Characteristic not found: " + characteristicUUID));
                gatt.close();
                return;
            }

            boolean readInitiated = gatt.readCharacteristic(characteristic);
            if (!readInitiated) {
                Log.e("BLEq", "Не удалось инициировать чтение характеристики");
                callback.onError(new Exception("Failed to initiate characteristic read"));
                gatt.close();
            }

            if (characteristic == null) {
                Log.e("BLEq", "Характеристика не найдена: " + characteristicUUID);
                callback.onError(new Exception("Characteristic not found: " + characteristicUUID));
                gatt.close();
                return;
            }

            // Для уведомлений об измении характеристики
            int props = characteristic.getProperties();
            if ((props & BluetoothGattCharacteristic.PROPERTY_NOTIFY) == 0 &&
                    (props & BluetoothGattCharacteristic.PROPERTY_INDICATE) == 0) {
                Log.e("BLEq", "Характеристика не поддерживает уведомления или индикации");
                callback.onError(new Exception("Characteristic doesn't support notifications/indications"));
                gatt.close();
                return;
            }

            // Включаем уведомления
            boolean notificationSet = gatt.setCharacteristicNotification(characteristic, true);
            if (!notificationSet) {
                Log.e("BLEq", "Не удалось включить уведомления для характеристики");
                callback.onError(new Exception("Failed to set notification"));
                gatt.close();
                return;
            }

            // Находим дескриптор уведомлений
            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(
                    UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")); // стандартный UUID

            if (descriptor == null) {
                Log.e("BLEq", "Notification descriptor not found");
                callback.onError(new Exception("Notification descriptor not found"));
                gatt.close();
                return;
            }

            // Устанавливаем значение (уведомления или индикации)
            if ((props & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            } else {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
            }

            boolean descriptorWriteStarted = gatt.writeDescriptor(descriptor);
            if (!descriptorWriteStarted) {
                Log.e("BLEq", "Не удалось записать дескриптор уведомлений");
                callback.onError(new Exception("Failed to write descriptor"));
                gatt.close();
            }

            // уведомления будут приходить в onCharacteristicChanged
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onCharacteristicRead(BluetoothGatt gatt,
                                         BluetoothGattCharacteristic characteristic,
                                         int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                byte[] value = characteristic.getValue();
                String stringValue = new String(value);
                callback.onSuccess(stringValue);
            } else {
                Log.e("BLEq", "Ошибка чтения характеристики: " + status);
                callback.onError(new Exception("Characteristic read failed"));
            }
            gatt.close();
        }
    };

    @SuppressLint("MissingPermission")
    public static void getUuids(Context context, BluetoothDevice device, UuidBluetoothServiceCallback uuidBluetoothServiceCallback){
        device.connectGatt(context, false, new BluetoothGattCallback() {
            @Override
            public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
                if (newState == BluetoothGatt.STATE_CONNECTED) {
                    Log.d("BLEq", "Подключено к устройству. Ищем сервисы...");
                    gatt.discoverServices();
                } else if (newState == BluetoothGatt.STATE_DISCONNECTED) {
                    Log.d("BLEq", "Отключено от устройства.");
                    uuidBluetoothServiceCallback.onError("Отключено от устройства.");
                    gatt.close();
                }
            }

            @Override
            public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
                byte[] value = characteristic.getValue();
                String stringValue = new String(value);
                Log.d("BLEq", "Получено уведомление: " + stringValue);

                // Здесь — только при реальном приходе новых данных
                if(characteristic.getService().getUuid().toString().contains("aabb")) {
                    Log.d("BLEq", "Уведомление: Сервис: " + characteristic.getService().getUuid());
                    for (BluetoothGattCharacteristic item : characteristic.getService().getCharacteristics()) {
                        Log.d("BLEq", "Уведомление: Обнаружена характеристика: " + item.getUuid());
                        if(item.getUuid().toString().contains("1bb1")) {
                            Log.d("BLEq", "Уведомление: вызов фунции onSuccess на добавление маркера ");
                            uuidBluetoothServiceCallback.onSuccess(
                                    characteristic.getService().getUuid(),
                                    characteristic.getUuid()
                            );
                        }
                    }
                }

                // Если хочешь — можно передавать stringValue тоже через отдельный коллбэк
            }

            @Override
            public void onServicesDiscovered(BluetoothGatt gatt, int status) {
                if (status != BluetoothGatt.GATT_SUCCESS) {
                    Log.e("BLEq", "Ошибка при обнаружении сервисов: " + status);
                    uuidBluetoothServiceCallback.onError("Ошибка при обнаружении сервисов: " + status);
                    return;
                }

//                UUID servId = null;
//                UUID charsId = null;
//                for (BluetoothGattService service : gatt.getServices()) {
//                    Log.d("BLEq", "Обнаружен сервис: " + service.getUuid());
//                    if(service.getUuid().toString().contains("aabb")) {
//                        servId = service.getUuid();
//                        Log.d("BLEq", "Сервис: " + service.getUuid());
//                        for (BluetoothGattCharacteristic characteristic : service.getCharacteristics()) {
//                            Log.d("BLEq", "-- Обнаружена характеристика: " + characteristic.getUuid());
//                            if(characteristic.getUuid().toString().contains("1bb1")) {
//                                charsId = characteristic.getUuid();
//                                Log.d("BLEq", "  └── Характеристика: " + characteristic.getUuid());
//                            }
//                        }
//                    }
//                }

//                if (servId != null && charsId != null) {
//                    uuidBluetoothServiceCallback.onSuccess(servId, charsId);
//                } else {
//                    uuidBluetoothServiceCallback.onError("Ошибка servId " + servId + " charsId " + charsId);
//                }

               // gatt.close();
            }
        });
    }
}