/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/**
 *
 * @author miguel
 */
@Path("rates")
public class Resources {
    
    @Inject
    RatesMap ratesResource;
    
    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStuff(@FormParam("firstBox") double firstValue,
                                @FormParam("currencies1") String curr_1,
                                @FormParam("currencies2") String curr_2){
        
        double rate = ratesResource.addRate(curr_1+curr_2);
        double outcome = ratesResource.convertValue(rate, firstValue);
        
        return Response.ok(new Converted(curr_1+curr_2 ,rate, outcome)).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRates(){
        List<Rates> all = ratesResource.getAllRates();
        
        if(all == null)
            return Response.status(NOT_FOUND).build();
        
        return Response.ok(all).build();
    }
}
