package com.epam.inheritance2;

public class TransportExpensesPurchase extends AbstractPurchase {

    private Byn expenses;

    public TransportExpensesPurchase(Product product, int units, Byn expenses) {
        super(product, units);
        this.expenses = expenses;
    }

    public Byn getExpenses() {
        return expenses;
    }

    public void setExpenses(Byn expenses) {
        this.expenses = expenses;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        return baseCost.sum(expenses);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + expenses;
    }

}
