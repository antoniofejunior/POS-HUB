/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.rest;

import ifpb.ads.pos.hub.recursos.ArCondicionado;
import ifpb.ads.pos.hub.recursos.mqtt.PublicadorMqttTemperatura;
import java.io.Serializable;
//import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Junior
 */
@Path("arcondicionado")
@Produces(MediaType.APPLICATION_JSON)
public class Temperatura implements Serializable {

//    @Inject
//    private ArCondicionado ar;

    @GET
    public Response getTemperatura() {
        return Response.ok(ArCondicionado.getInstancia()).build();
//        return Response.ok(ar).build();
    }

    @Path("aumentar")
    @PUT
    public Response setTemperatura() {
        int temp = ArCondicionado.getInstancia().getTemperatura();
//        int temp = ar.getTemperatura();
        PublicadorMqttTemperatura.alterarTemperatura(temp + 1);
        return Response.ok(ArCondicionado.getInstancia()).build();
//        return Response.ok(ar).build();
    }

    @Path("diminuir")
    @PUT
    public Response diminuirTemperatura() {
//        int temp = ar.getTemperatura();
        int temp = ArCondicionado.getInstancia().getTemperatura();
        PublicadorMqttTemperatura.alterarTemperatura(temp - 1);
//        return Response.ok(ar).build();
        return Response.ok(ArCondicionado.getInstancia()).build();
    }
}
