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

    private final String sensor;
    private final String atuador;
    private final String URIServidor;

    public PublicadorMQTTLuminsidade() {
        this.sensor = "hub/sensor/luminosidade";
        this.atuador = "hub/atuador/lampada";
        this.URIServidor = "tcp://192.168.99.100:1883";
    }

    public void ligar(boolean status) {

        try {
            MqttClient mc = new MqttClient(URIServidor,
                    MqttClient.generateClientId(),
                    new MemoryPersistence());
            mc.connect();
            if (status) {
                mc.publish(atuador, "ligado".getBytes(), 2, false);
            } else {
                mc.publish(atuador, "desligado".getBytes(), 2, false);
            }

            mc.disconnect();
        } catch (MqttException ex) {
            Logger.getLogger(PublicadorMQTTLuminsidade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean getEstado() {
        try {
            MqttClient cliente = new MqttClient(URIServidor,
                    MqttClient.generateClientId(),
                    new MemoryPersistence());
            cliente.connect();
//            cliente.setCallback();
            cliente.subscribe(sensor);

        } catch (MqttException ex) {
            Logger.getLogger(PublicadorMQTTLuminsidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
