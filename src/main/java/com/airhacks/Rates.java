/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author miguel
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Rates {
    
    private double rate;
    private String str_rate;
    
    public Rates(String str_rate, double rate){
        this.str_rate = str_rate;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getStr_rate() {
        return str_rate;
    }

    public void setStr_rate(String str_rate) {
        this.str_rate = str_rate;
    }
}
