package com.epam.inheritance2;

import java.util.Objects;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{

    private final Product product;
    private int number;

    public AbstractPurchase(Product product, int units) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    protected  abstract  Byn getFinalCost(Byn baseCost);

    public  Byn getCost() {
        Byn baseCost = product.getPrice().mul(number,RoundMethod.FLOOR,0);
        Byn finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR,2);
    }

    @Override
    public int compareTo(AbstractPurchase purchase) {
        return purchase.getCost().compareTo(getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPurchase purchase = (AbstractPurchase) o;
        return number == purchase.number && Objects.equals(product, purchase.product);
    }


    protected String fieldsToString() {
        return product + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

}
