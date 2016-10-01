/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos.mqtt;

import ifpb.ads.pos.hub.recursos.ArCondicionado;
import java.io.Serializable;
import javax.inject.Inject;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author Junior
 */

public class TemperaturaCallback implements MqttCallback, Serializable {
    @Inject
    private ArCondicionado arCondicionado; 
    private final String URIServidor;
    private final String sensor;
//    private final String atuador;

    public TemperaturaCallback() {
       URIServidor = "tcp://192.168.99.100:1883";
       sensor = "hub/sensor/temperatura";
//       atuador = "hub/atuador/arcondicionado";
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Perda de conexão erro: ".concat(thrwbl.getMessage()));
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) {
        String msg = new String(mm.getPayload());
        arCondicionado.setTemperatura(Integer.parseInt(msg));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
