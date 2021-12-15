package com.epam.inheritance2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestRunner extends Runner{

    @Test
    public void testSub() {
        Byn byn = new Byn(100);
        Byn byn2 = new Byn(100);
        Assert.assertEquals(new Byn(0), byn.sub(byn2));
    }

    @Test
    public void testGetCost() {
        Product product = new Product("", new Byn(200));
        AbstractPurchase[] array = {
                new DiscountPurchase(product,5,new Byn(160)),
                new TransportExpensesPurchase(product,300,new Byn(100)),
                new PercentDiscountPurchase(product,16,0.05),
        };
        Assert.assertEquals(new Byn(100), array[1].getCost());
    }

    @Test
    public void testPrchasesEntity() {
        Product product = new Product("", new Byn(200));
        AbstractPurchase[] array = {
                new DiscountPurchase(product,5,new Byn(160)),
                new TransportExpensesPurchase(product,300,new Byn(100)),
                new PercentDiscountPurchase(product,16,0.05),
        };
        Assert.assertNotNull(array[0]);
        Assert.assertNotNull(array[1]);
        Assert.assertNotNull(array[2]);
        Assert.assertEquals(new DiscountPurchase(product,5,new Byn(160)),array[0]);
        Assert.assertEquals(new TransportExpensesPurchase(product,300,new Byn(100)),array[1]);
        Assert.assertEquals(new PercentDiscountPurchase(product,16,0.05),array[2]);
    }

    @Test
    public void testEqualsByn() {
        Byn byn = new Byn(300);
        Byn byn2 = new Byn(300);
        Assert.assertTrue(byn.equals(byn2));
    }

    @Test
    public void testRound() {
        Byn byn = new Byn(2767);
        Assert.assertEquals(new Byn(2700), byn.round(RoundMethod.FLOOR,2));
    }

    @Test
    public void testSearchAtFirstPlace() {
        Product product = new Product("", new Byn(500));
        AbstractPurchase[] array = {
                new DiscountPurchase(product,1,new Byn(0)),
                new DiscountPurchase(product,1,new Byn(100)),
                new PercentDiscountPurchase(product,1,0.05),
                new TransportExpensesPurchase(product,1,new Byn(200)),
                new PercentDiscountPurchase(product,15,0.99),
        };
        Arrays.sort(array);
        final int NUMBER_OF_SEARCH = 2;
        Assert.assertEquals(NUMBER_OF_SEARCH, Arrays.binarySearch(array, new DiscountPurchase(new Product("",new Byn(500)),1,new Byn(0))));
    }

}
