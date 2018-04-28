/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;
import static org.junit.Assert.*;

/**
 *
 * @author miguel
 */
public class RatesMapTest extends TestCase{
    
    private RatesMap ratesMap;
    
    @Before
    public void setUp() {
        ratesMap = EasyMock.createMock(RatesMap.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findRate method, of class RatesMap.
     */
    @Test
    public void testFindRate() {
        EasyMock.expect(ratesMap.findRate("USDEUR")).andReturn(0.99);
        EasyMock.replay(ratesMap);
        
        double tmp = ratesMap.findRate("USDEUR");
        assertEquals(tmp, 0.99);
    }

    /**
     * Test of getAllRates method, of class RatesMap.
     */
    @Test
    public void testAddRate() {
        EasyMock.expect(ratesMap.addRate("USDEUR")).andReturn(0.99);
        EasyMock.replay(ratesMap);
        
        double tmp = ratesMap.addRate("USDEUR");
        assertEquals(tmp, 0.99);
    }

    /**
     * Test of convertValue method, of class RatesMap.
     */
    @Test
    public void testConvertValue() {
        EasyMock.expect(ratesMap.convertValue(1, 0.80)).andReturn(0.80);
        EasyMock.replay(ratesMap);
        
        double outcome = ratesMap.convertValue(1, 0.80);
        assertEquals(outcome, 0.80);
    } 
}
