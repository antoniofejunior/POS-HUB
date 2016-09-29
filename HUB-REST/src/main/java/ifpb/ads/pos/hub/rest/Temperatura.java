/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.hub.rest;

import ifpb.ads.pos.hub.recursos.FachadaMQTT;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Junior
 */
@Path("temperatura")
public class Temperatura {

    @EJB
    private FachadaMQTT fachadaMQTT;

    @GET
    public Response getTemperatura() {
        return Response.ok(fachadaMQTT.getTemperatura()).build();
    }

    @Path("{aumentar}")
    @PUT
    public Response setLampada(@PathParam("aumentar") boolean aumentar) {
        int temp = fachadaMQTT.getTemperatura();
        if(aumentar && (temp <= 28)){
            fachadaMQTT.setTemperatura(temp ++);
        }else
            if(temp >= 14)
            fachadaMQTT.setTemperatura(temp --);
            
        return Response.ok(fachadaMQTT.getTemperatura()).build();
    }
}
