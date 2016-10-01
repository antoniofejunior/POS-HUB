/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Junior
 */
public class ClientThread extends Thread {

    private final String sensor;
    private final String atuador;
    private final String URIServidor;

    public ClientThread(String sensor, String atuador, String URIServidor) {
        this.sensor = sensor;
        this.atuador = atuador;
        this.URIServidor = URIServidor;
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
                    MqttClient.generateClientId(),
                    new MemoryPersistence());
            cliente.connect();
            cliente.setCallback(new MqttCallbackIMP(sensor, URIServidor));
            cliente.subscribe(atuador,2);
        } catch (MqttException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
