/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos;

import ifpb.ads.pos.hub.recursos.mqtt.LuminosidadeCallback;
import ifpb.ads.pos.hub.recursos.mqtt.PublicadorMQTTLuminsidade;
import ifpb.ads.pos.hub.recursos.mqtt.TemperaturaCallback;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Junior
 */
@Stateless
public class FachadaMqttImp implements FachadaMQTT {

    @EJB
    private LuminosidadeCallback lc;

    @EJB
    private TemperaturaCallback tc;

    @Override
    public boolean getlampada() {
        return lc.isLigado();
    }

    @Override
    public int getTemperatura() {
        return tc.getTemperatura();
    }

    @Override
    public void setLampada(boolean estado) {
        PublicadorMQTTLuminsidade lampada = new PublicadorMQTTLuminsidade();
        lampada.ligar(estado);
    }

    @Override
    public void setTemperatura(int temperatura) {
        
    }

}
