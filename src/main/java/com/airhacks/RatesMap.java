/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;
import javax.annotation.PostConstruct;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author miguel
 */
@Startup
@Singleton
public class RatesMap {
    
    public static final String ACCESS_KEY = "4b3ab4c3e82930d8da426b2b5806a639";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";
    static CloseableHttpClient httpClient = HttpClients.createDefault();
    private Map<String, Rates> ratesMap = null;
    
    @PostConstruct
    public void initialize(){
        this.ratesMap = new HashMap<>();
    }
    
    public double findRate(String str_rate){
        return ratesMap.get(str_rate).getRate(); 
    }
    
    public double addRate(String str_rate) {
        
        if(ratesMap.containsKey(str_rate))
            return findRate(str_rate);
        else
        {
            double rate = sendLiveRequest(str_rate);
            ratesMap.put(str_rate, new Rates(str_rate, rate));
            return rate;
        }
    }
    
    private double sendLiveRequest(String str_rate){
        double rate = 0;
        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            rate = exchangeRates.getJSONObject("quotes").getDouble(str_rate);
            response.close();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return rate;
    }
    
    public List<Rates> getAllRates(){
        return new ArrayList<>(ratesMap.values());
    }
    
    public double convertValue(double rate, double value){
        return rate * value;
    }
}
