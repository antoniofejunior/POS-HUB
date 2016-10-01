/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos;

import ifpb.ads.pos.hub.recursos.mqtt.PublicadorMQTTLuminsidade;
import ifpb.ads.pos.hub.recursos.mqtt.PublicadorMqttTemperatura;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Junior
 */
@Stateless
public class FachadaMqttImp implements FachadaMQTT {

    @EJB
    private Lampada lampada;

    @EJB
    private ArCondicionado arCondicionado;

    @Override
    public boolean getlampada() {
        return lampada.isLigada();
    }

    @Override
    public int getTemperatura() {
        return arCondicionado.getTemperatura();
    }

    @Override
    public void setLampada(boolean estado) {
        PublicadorMQTTLuminsidade plampada = new PublicadorMQTTLuminsidade();
        plampada.ligar(estado);
    }

    @Override
    public void setTemperatura(int temperatura) {
        new PublicadorMqttTemperatura().alterar(temperatura);
    }

}
