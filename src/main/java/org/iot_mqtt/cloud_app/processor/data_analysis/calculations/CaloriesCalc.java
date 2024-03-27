package org.iot_mqtt.cloud_app.processor.data_analysis.calculations;

public class CaloriesCalc {

    private static double getCaloriesInAMin(float velocity, float weight, float height) {
            return 0.035 * weight + ((Math.pow(velocity, 2)) / height) * 0.029 * weight;
    }

}
