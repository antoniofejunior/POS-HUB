/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos.mqtt;

import ifpb.ads.pos.hub.recursos.Lampada;
import java.io.Serializable;
import javax.inject.Inject;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author Junior
 */

public class LuminosidadeCallback implements MqttCallback , Serializable{

    private final String URIServidor;
    private final String sensor;
    @Inject
    private Lampada lampada;

    public LuminosidadeCallback() {
        this.sensor = "hub/sensor/luminosidade";
        this.URIServidor = "tcp://192.168.99.100:1883";
    }

    public boolean isLigado() {
        return lampada.isLigada();
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Perda de conexão erro: ".concat(thrwbl.getMessage()));
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) {
        String msg = new String(mm.getPayload());
        if (lampada.isLigada() != msg.equalsIgnoreCase("ligado")) {
            lampada.setLigada(msg.equalsIgnoreCase("ligado"));
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
