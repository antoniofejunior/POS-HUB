/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.recursos.mqtt;

/**
 *
 * @author Junior
 */
public class APP {

    public static void main(String[] args) {
        String lanpada = "hub/sensor/luminosidade";
        String arCondicionado = "hub/sensor/temperatura";
        String URIServidor = "tcp://192.168.99.100:1883";
        new ClientThread(lanpada, URIServidor, new LuminosidadeCallback()).start();
        System.out.println("sensor luminosidade iniciado");
        new ClientThread(arCondicionado, URIServidor, new TemperaturaCallback()).start();
        System.out.println("sensor temperatura iniciado");
    }
}
