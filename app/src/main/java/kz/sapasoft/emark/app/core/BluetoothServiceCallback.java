package kz.sapasoft.emark.app.core;

import java.util.UUID;

public interface BluetoothServiceCallback {
    void onDiscovered(String value);
    void onChanged(UUID serviceId, UUID characteristicId, String characteristicValue);

    void onError(Exception e);
}