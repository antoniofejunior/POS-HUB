/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub;

/**
 *
 * @author Junior
 */
public class App {

    public static void main(String[] args) {
        String URIServidor = "tcp://192.168.99.100:1883";
        String sensor = "hub/sensor/temperatura";
        String atuador = "hub/atuador/arcondicionado";

        new ClientThread(sensor, atuador, URIServidor).start();
           System.out.println("controle temperatura");
        sensor = "hub/sensor/luminosidade";
        atuador = "hub/atuador/lampada";
        new ClientThread(sensor, atuador, URIServidor).start();
           System.out.println("controle liminosidade");

    }
}
