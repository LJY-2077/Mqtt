package test;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class PubMsg {
    private static int qos = 2; //只有一次
    private static String broker = "tcp://127.0.0.1:2018";


    private static MqttClient connect(String clientId) throws MqttException {
        MemoryPersistence persistence = new MemoryPersistence();
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setConnectionTimeout(10);
        connOpts.setKeepAliveInterval(20);
//      String[] uris = {"tcp://10.100.124.206:1883","tcp://10.100.124.207:1883"};
//      connOpts.setServerURIs(uris);  //起到负载均衡和高可用的作用
        MqttClient mqttClient = new MqttClient(broker, clientId, persistence);
        mqttClient.setCallback(new PushCallback("test"));
        mqttClient.connect(connOpts);
        return mqttClient;
    }

    private static void pub(MqttClient sampleClient, String msg,String topic)
            throws MqttPersistenceException, MqttException {
        MqttMessage message = new MqttMessage("ertwersdfas".getBytes());
        message.setQos(qos);
        message.setRetained(false);
        sampleClient.publish(topic, message);
    }

    private static void publish(String str,String clientId,String topic) throws MqttException{
        MqttClient mqttClient = connect(clientId);

        if (mqttClient != null) {
            pub(mqttClient, str, topic);
            System.out.println("pub-->" + str);
        }

        if (mqttClient != null) {
            mqttClient.disconnect();
        }
    }

    public static void main(String[] args) throws MqttException {
        publish("message content","client-id-0","/gps");
        System.out.println("==============");
    }
}

