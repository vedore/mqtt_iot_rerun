package org.iot_mqtt.cloud_app.processor.cloud_object;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class RowData {

    private final LocalDate date;

    private final String time;

    private final int activity;

    private final double acceleration_x;

    private final double acceleration_y;

    private final double acceleration_z;

    private final double gyro_x;

    private final double gyro_y;

    private final double gyro_z;

    public RowData(LocalDate date, String time, int activity, double acceleration_x, double acceleration_y, double acceleration_z, double gyro_x, double gyro_y, double gyro_z) {
        this.date = date;
        this.time = time;
        this.activity = activity;
        this.acceleration_x = acceleration_x;
        this.acceleration_y = acceleration_y;
        this.acceleration_z = acceleration_z;
        this.gyro_x = gyro_x;
        this.gyro_y = gyro_y;
        this.gyro_z = gyro_z;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getActivity() {
        return activity;
    }

    public double getAcceleration_x() {
        return acceleration_x;
    }

    public double getAcceleration_y() {
        return acceleration_y;
    }

    public double getAcceleration_z() {
        return acceleration_z;
    }

    public double getGyro_x() {
        return gyro_x;
    }

    public double getGyro_y() {
        return gyro_y;
    }

    public double getGyro_z() {
        return gyro_z;
    }

    @Override
    public String toString() {
        return "RowData{" +
                "date=" + date +
                ", time='" + time + '\'' +
                ", activity=" + activity +
                ", acceleration_x=" + acceleration_x +
                ", acceleration_y=" + acceleration_y +
                ", acceleration_z=" + acceleration_z +
                ", gyro_x=" + gyro_x +
                ", gyro_y=" + gyro_y +
                ", gyro_z=" + gyro_z +
                '}';
    }
}
