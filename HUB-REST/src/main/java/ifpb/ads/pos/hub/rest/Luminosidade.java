/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.rest;

import javax.ws.rs.Path;
import ifpb.ads.pos.hub.recursos.FachadaMQTT;
import java.io.Serializable;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
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
public class Luminosidade implements Serializable{

    @Inject
    private FachadaMQTT fachadaMQTT;

    @GET
    public Response getLampada() {
        return Response.ok(fachadaMQTT.getlampada()).build();
    }
    
    @Path("{ligado}")
    @PUT
    public Response setLampada(@PathParam("ligado")boolean estado){
        fachadaMQTT.setLampada(estado);
        return Response.ok(estado).build();
    }
}
