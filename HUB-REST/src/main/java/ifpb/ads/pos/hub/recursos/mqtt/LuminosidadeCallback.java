/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos.mqtt;

import javax.ejb.Singleton;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author Junior
 */
@Singleton
public class LuminosidadeCallback implements MqttCallback {

    private final String URIServidor;
    private final String sensor;
    private boolean ligado;

    public LuminosidadeCallback() {
        this.sensor = "hub/sensor/luminosidade";
        this.URIServidor = "tcp://192.168.99.100:1883";
        ligado = false;
    }

    public boolean isLigado() {
        return ligado;
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Perda de conexão erro: ".concat(thrwbl.getMessage()));
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) {
        String msg = new String(mm.getPayload());
        if (ligado != msg.equalsIgnoreCase("ligado")) {
            ligado = msg.equalsIgnoreCase("ligado");
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
