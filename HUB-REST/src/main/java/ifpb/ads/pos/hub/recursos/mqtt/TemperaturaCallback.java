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
public class TemperaturaCallback implements MqttCallback {

    private final String URIServidor;
    private final String sensor;
//    private final String atuador;
    public int temperatura;

    public int getTemperatura() {
        return temperatura;
    }

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
        this.temperatura = Integer.parseInt(msg);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
