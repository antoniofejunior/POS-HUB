/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.rest;

import javax.ws.rs.Path;
import ifpb.ads.pos.hub.recursos.Lampada;
import ifpb.ads.pos.hub.recursos.mqtt.PublicadorMQTTLuminsidade;
import java.io.Serializable;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Junior
 */
@Path("lampada")
@Produces({MediaType.APPLICATION_JSON})
//@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class Luminosidade implements Serializable {

    @Inject
    private Lampada lampada;

    @GET
    public Response getLampada() {
        return Response.ok(lampada).build();
    }

    @Path("ligar")
    @PUT
    public Response setLampada() {
        PublicadorMQTTLuminsidade.ligarLampada(true);
        return Response.ok(lampada).build();
    }

    @Path("desligar")
    @PUT
    public Response desligarLampada() {
        PublicadorMQTTLuminsidade.ligarLampada(false);
        return Response.ok(lampada).build();
    }
}
