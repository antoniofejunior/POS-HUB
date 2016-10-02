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
public class ClientThread extends Thread {

    private final String sensor;
    private final String URIServidor;
    private final MqttCallback callback;

    public ClientThread(String sensor, String URIServidor, MqttCallback callback) {
        this.sensor = sensor;
        this.URIServidor = URIServidor;
        this.callback = callback;
    }

    @Override
    public void run() {
        this.iniciar();
        super.run();
    }

    public void iniciar() {

        MqttClient cliente;
        try {
            cliente = new MqttClient(URIServidor,
                    MqttClient.generateClientId());
            cliente.connect();
            cliente.setCallback(callback);
            cliente.subscribe(sensor, 2);
        } catch (MqttException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
