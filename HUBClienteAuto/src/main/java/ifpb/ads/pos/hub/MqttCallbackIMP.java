/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Junior
 */
public class MqttCallbackIMP implements MqttCallback {

    private final String URIServidor;
    private final String sensor;

    public MqttCallbackIMP(String sensor, String URIServidor) {
        this.sensor = sensor;
        this.URIServidor = URIServidor;
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Perda de conexão erro: ".concat(thrwbl.getMessage()));
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) {
        try {
            //            String msg = new String(mm.getPayload());
            MqttClient mc = new MqttClient(URIServidor,
                    MqttClient.generateClientId(),
                    new MemoryPersistence());
            mc.connect();
            mc.publish(sensor, new String(mm.getPayload()).getBytes(),2,false);
            mc.disconnect();
        } catch (MqttException ex) {
            Logger.getLogger(MqttCallbackIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
