/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miguel
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Converted {
    
    private double rate;
    private double outcome;
    private String str_rate;
    
    public Converted(String str_rate, double rate, double outcome){
        this.str_rate = str_rate;
        this.rate = rate;
        this.outcome = outcome;
    }

    public String getStr_rate() {
        return str_rate;
    }

    public void setStr_rate(String str_rate) {
        this.str_rate = str_rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getOutcome() {
        return outcome;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }
    
    
}
