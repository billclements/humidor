package com.TDD.Humidor.test;

import com.TDD.Humidor.CigarDataHolder;
import junit.framework.Assert;
import org.junit.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: bill
 * Date: 2/18/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CigarDataHolderTest {
    private int id = 1;
    private int quantity = 3;
    private String brand = "Perdomo";
    private String type = "Grand Cru";
    private String vitola = "Robusto";
    private String wrapper = "Corojo";

    private static CigarDataHolder cigarTester; // = new CigarDataHolder(id, brand, type, vitoal, wrapper, quantity);

    @Before
    public void setUp() throws Exception {
        cigarTester = new CigarDataHolder(id, brand, type, vitola,  wrapper, quantity);
    }

    @After
    public void tearDown() throws Exception {
        cigarTester = null;
    }

    @Test
    public void testSet_id() throws Exception {
            cigarTester.set_id(2);
            Assert.assertEquals(cigarTester.get_id(), 2);
    }

    @Test
    public void testSetBrand() throws Exception {
            cigarTester.setBrand("Diesel");
            Assert.assertEquals(cigarTester.getBrand(), "Diesel");
    }

    @Test
    public void testSetType() throws Exception {
             cigarTester.setType("Unholy Cocktail");
            Assert.assertEquals(cigarTester.getType(), "Unholy Cocktail");

    }

    @Test
    public void testSetVitola() throws Exception {
        cigarTester.setVitola("Torpedo");
        Assert.assertEquals(cigarTester.getVitola(), "Torpedo");
    }

    @Test
    public void testSetWrapper() throws Exception {
        cigarTester.setWrapper("Maduro");
        Assert.assertEquals(cigarTester.getWrapper(), "Maduro");
    }

    @Test
    public void testSetQuantity() throws Exception {
        cigarTester.setQuantity(30);
        Assert.assertEquals(cigarTester.getQuantity(), 30);
    }

    @Test
    public void testGet_id() throws Exception {
        Assert.assertEquals(cigarTester.get_id(), 1);
    }

    @Test
    public void testGetBrand() throws Exception {
        Assert.assertEquals(cigarTester.getBrand(), "Perdomo");
    }

    @Test
    public void testGetType() throws Exception {
        Assert.assertEquals(cigarTester.getType(), "Grand Cru");
    }

    @Test
    public void testGetVitola() throws Exception {
        Assert.assertEquals(cigarTester.getVitola(), "Robusto");
    }

    @Test
    public void testGetWrapper() throws Exception {
        Assert.assertEquals(cigarTester.getWrapper(), "Corojo");
    }

    @Test
    public void testGetQuantity() throws Exception {
        Assert.assertEquals(cigarTester.getQuantity(), 3);
    }
}
