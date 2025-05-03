package kz.sapasoft.emark.app.core;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import android.content.Context;

public class BluetoothService {

    private static BluetoothService instance;

    public static final UUID SPP_UUID =
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // стандартный UUID SPP
    private BluetoothSocket bluetoothSocket;
    private BluetoothDevice device;

    private BluetoothServiceCallback callback;

    private Context context;

    private BluetoothService(Context context, BluetoothDevice device, BluetoothServiceCallback callback) {
        this.context = context.getApplicationContext(); // во избежание утечек памяти
        this.device = device;
        this.callback = callback;
    }
    @SuppressLint("MissingPermission")
    public void connectAndRead(UUID uuid) {
        new Thread(() -> {
            try {
                bluetoothSocket = device.createRfcommSocketToServiceRecord(uuid);
                bluetoothSocket.connect();

                InputStream inputStream = bluetoothSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder fullData = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    fullData.append(line).append("\n"); // собираем все строки в одну
                }

                reader.close();
                bluetoothSocket.close();

                // Вызываем callback один раз с полной строкой
                callback.onSuccess(fullData.toString().trim());

            } catch (IOException e) {
                Log.e("BLE", "Ошибка подключения/чтения: " + e.getMessage(), e);
                callback.onError(e);
            }
        }).start();
    }

    public static synchronized BluetoothService getInstance(Context context, BluetoothDevice device, BluetoothServiceCallback callback) {
        if (instance == null) {
            instance = new BluetoothService(context, device, callback);
        } else {
            instance.context = context.getApplicationContext();
            instance.device = device;
            instance.callback = callback;
        }
        return instance;
    }
}
