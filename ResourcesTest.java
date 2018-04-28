/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miguel
 */
public class ResourcesTest {
    
    private javax.ws.rs.client.Client client;
    private javax.ws.rs.client.WebTarget target;
    private javax.ws.rs.client.WebTarget target2;

    
    @Before
    public void setUp() {
        this.client =  ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/HW/resources/rates/");
        this.target2 = client.target("http://localhost:8080/HW/resources/rates/add/");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    
    @Test
    public void fetchAllRates() {
        Response response = target.request( MediaType.APPLICATION_JSON).get();
        assertThat( response.getStatus(), CoreMatchers.is(200) );
                    
        JsonArray allRates = response.readEntity( JsonArray.class);
        assertFalse( allRates.isEmpty());
        assertNotEquals( 0, allRates.size());
           
    }

    @Test
    public void createRate() {
       String jsonNewRate = "{\"rate\":0.99,\"str_rate\":\"TESTRATE\"}";
               
       Response response = target2.request(APPLICATION_JSON_TYPE).post( Entity.json(jsonNewRate));
       assertEquals(200, response.getStatus());
       
    }

}
