package com.epam.inheritance2;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
       final int productCost = 200;
       final Product product = new Product("Delicious", new Byn(productCost));
       AbstractPurchase[] purchases = {
               new DiscountPurchase(product,5,new Byn(160)),
               new TransportExpensesPurchase(product,300,new Byn(10000)),
               new TransportExpensesPurchase(product,580,new Byn(1500)),
               new DiscountPurchase(product,5,new Byn(100)),
               new PercentDiscountPurchase(product,20,0.1),
               new PercentDiscountPurchase(product,16,0.05),
       };

        printResults(purchases);
        Arrays.sort(purchases);
        System.out.println();
        printResults(purchases);
        System.out.println("Min cost: " + purchases[purchases.length - 1].getCost());
        printBinarySearch(purchases);


    }
    private static void printResults(AbstractPurchase[] array) {
        for (AbstractPurchase purchase : array) {
            System.out.println(purchase);
        }
    }
    private static void printBinarySearch(AbstractPurchase[] array) {
        int index = Arrays.binarySearch(array, new DiscountPurchase(new Product("",new Byn(500)),1,new Byn(0)));
        if (index >= 0) {
            System.out.println("Cost 5.00: " + array[index]);
        }
        else {
            System.out.println("No cost 5.00");
        }
    }
}
