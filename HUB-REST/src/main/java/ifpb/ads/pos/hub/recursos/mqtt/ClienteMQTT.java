/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos.mqtt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Junior
 */
public class ClienteMQTT {

    private final String sensor;
    private final String atuador;
    private final String URIServidor;
    private final MqttCallback callback;

    public ClienteMQTT(String sensor, String atuador, String URIServidor, MqttCallback mqttCallback) {
        this.sensor = sensor;
        this.atuador = atuador;
        this.URIServidor = URIServidor;
        this.callback = mqttCallback;
    }

    public void consumir() {

        MqttClient cliente;
        try {
            cliente = new MqttClient(URIServidor,
                    MqttClient.generateClientId(),
                    new MemoryPersistence());
            cliente.connect();
            cliente.setCallback(callback);
            cliente.subscribe(atuador);
        } catch (MqttException ex) {
            Logger.getLogger(ClienteMQTT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
