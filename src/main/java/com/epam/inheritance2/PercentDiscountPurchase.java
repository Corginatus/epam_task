package com.epam.inheritance2;

public class PercentDiscountPurchase extends AbstractPurchase{

   private static final int QUANTITY = 15;
   private double probability;

   public PercentDiscountPurchase(Product product, int number, double percent) {
       super(product, number);
       this.probability = probability;
   }

   public double getPercent() {
       return probability;
   }

   public void setPercent(double percent) {
       this.probability =  percent;
   }

   @Override
    protected Byn getFinalCost(Byn baseCost) {
       if (getNumber() >= QUANTITY) {
           baseCost = baseCost.mul(1 - probability,RoundMethod.FLOOR,0);
       }
        return baseCost;
   }

   @Override
    protected String fieldsToString() {
       return super.fieldsToString() + ";" + probability;
   }

}
