/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos;

import java.io.Serializable;
//import javax.ejb.Singleton;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior
 */
//@Singleton
@XmlRootElement
public class Lampada implements Serializable {
//    
    private static Lampada lampada;
    private boolean ligada;

//    public Lampada() {
//    this.ligada = true;
//    }
    private Lampada() {
    this.ligada = true;
    }

    public static Lampada getInstancia(){
      if(lampada == null)
          return new Lampada();
      return lampada;
    }
    
    public boolean isLigada() {
        return ligada;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }

    @Override
    public String toString() {
        return (isLigada())
                ? "Lampada ligada."
                : "Lampada desligada";
    }

}
