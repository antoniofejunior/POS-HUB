/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.rest;

import ifpb.ads.pos.hub.recursos.ArCondicionado;
import ifpb.ads.pos.hub.recursos.mqtt.PublicadorMqttTemperatura;
import java.io.Serializable;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Junior
 */
@Path("arcondicionado")
public class Temperatura implements Serializable{
    
    @Inject
    private ArCondicionado ar;

    @GET
    public Response getTemperatura() {
        return Response.ok(ar).build();
    }

    @Path("aumentar")
    @PUT
    public Response setTemperatura() {
        int temp = ar.getTemperatura();
        PublicadorMqttTemperatura.alterarTemperatura(temp++);
        return Response.ok(ar).build();
    }
    
    @Path("diminuir")
    @PUT
    public Response diminuirTemperatura() {
         int temp = ar.getTemperatura();
        PublicadorMqttTemperatura.alterarTemperatura(temp--);
        return Response.ok(ar).build();
    }
}
