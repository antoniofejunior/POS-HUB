package ifpb.ads.pos.hub.recursos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.ejb.Local;

/**
 *
 * @author Junior
 */
@Local
public interface FachadaMQTT extends Serializable{

    public boolean getlampada();

    public int getTemperatura();

    public void setLampada(boolean estado);

    public void setTemperatura(int temperatura);
}
