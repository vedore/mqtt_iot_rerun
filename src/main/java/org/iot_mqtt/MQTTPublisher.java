package org.iot_mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTPublisher {

    public static void main(String[] args) {

        String serverUrl = "tcp://localhost:1883";

        String clientId = "Publisher";

        String content = "A_funcionar";

        String topic = "sens/1";

        try{

            MemoryPersistence persistence = new MemoryPersistence();

            MqttClient client = new MqttClient(serverUrl, clientId, persistence);
            client.connect();
            System.out.println(client.isConnected());

            MqttMessage message = new MqttMessage(content.getBytes());

            client.publish(topic, message);

            client.disconnect();

        } catch(MqttException me) {
            System.out.println(me.getMessage());
        }

    }
}
