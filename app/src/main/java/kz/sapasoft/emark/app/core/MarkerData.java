package kz.sapasoft.emark.app.core;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MarkerData {
    public String model;
    public String markerId;
    public String type;
    public LocalDateTime timestamp;
    public double latitude;
    public double longitude;
    public String description;
    public String status;

    public static MarkerData parse(String line) {
        String[] parts = line.split(",", -1); // -1 чтобы учитывать пустые поля
        if (parts.length < 7) return null;

        MarkerData data = new MarkerData();
        data.model = parts[0];
        data.markerId = parts[1];
        data.type = parts[2];

        try {
            data.timestamp = LocalDateTime.parse(parts[3] + " " + parts[4],
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            data.latitude = Double.parseDouble(parts[5]);
            data.longitude = Double.parseDouble(parts[6]);
            data.description = parts.length > 7 ? parts[7].replace("\"", "") : "";
            data.status = parts.length > 8 ? parts[8] : "";
            Log.e("MarkerData", "Успешный парсинг: " + data);
        } catch (Exception e) {
            Log.e("MarkerData", "Ошибка парсинга: " + e.getMessage());
            return null;
        }

        return data;
    }
}
