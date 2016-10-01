/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos;

import java.io.Serializable;
import javax.ejb.Singleton;

/**
 *
 * @author Junior
 */
@Singleton
public class Lampada implements Serializable {

    private boolean ligada;

    public Lampada() {
    this.ligada = true;
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
