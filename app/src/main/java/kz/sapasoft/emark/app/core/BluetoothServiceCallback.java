package kz.sapasoft.emark.app.core;

public interface BluetoothServiceCallback {
    //void onSuccess(MarkerData markerData);
    void onSuccess(String line);
    void onError(Exception e);
}
