package kz.sapasoft.emark.app.core;

import android.Manifest;
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

    private static final UUID SPP_UUID =
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // стандартный UUID SPP
    private BluetoothSocket bluetoothSocket;
    private BluetoothDevice device;

    private Context context;

    public BluetoothService(Context context, BluetoothDevice device) {
        this.context = context.getApplicationContext(); // во избежание утечек памяти
        this.device = device;
    }
    public void connectAndRead() {
        new Thread(() -> {
            try {
                if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                bluetoothSocket = device.createRfcommSocketToServiceRecord(SPP_UUID);
                bluetoothSocket.connect();

                InputStream inputStream = bluetoothSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.d("BLE_SPP", "Принято: " + line);
                }

                reader.close();
                bluetoothSocket.close();

            } catch (IOException e) {
                Log.e("BLE_SPP", "Ошибка подключения/чтения: " + e.getMessage(), e);
            }
        }).start();
    }
}
