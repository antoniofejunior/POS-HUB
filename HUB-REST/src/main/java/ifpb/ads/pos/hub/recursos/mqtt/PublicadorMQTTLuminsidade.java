/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos.mqtt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Junior
 */
public class PublicadorMQTTLuminsidade {

    public static void ligarLampada(boolean status) {
        String sensor = "hub/sensor/luminosidade";
        String atuador = "hub/atuador/lampada";
        String URIServidor = "tcp://192.168.99.100:1883";

        try {
            MqttClient mc = new MqttClient(URIServidor,
                    MqttClient.generateClientId(),
                    new MemoryPersistence());
            mc.connect();
            if (status) {
                mc.publish(atuador, "ligada".getBytes(), 2, false);
            } else {
                mc.publish(atuador, "desligada".getBytes(), 2, false);
            }

            mc.disconnect();
        } catch (MqttException ex) {
            Logger.getLogger(PublicadorMQTTLuminsidade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
