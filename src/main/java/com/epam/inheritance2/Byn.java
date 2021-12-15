package com.epam.inheritance2;

public class Byn implements Comparable<Byn>{

    private final int value;

    public Byn(int value) {
        this.value = value;
    }

    public int getCoins() {
        return value % 100;
    }

    public int getRubs() {
        return value / 100;
    }

    @Override
    public String toString() {
        return value / 100 + "." + (value % 100 < 10 ? "0" : "") + value % 100;
    }

    public Byn sum(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn mul(int number) {
        return new Byn(value * number);
    }

    public Byn mul(double number, RoundMethod roundMethod, int constant) {
        return new Byn(roundMethod.round(value * number, constant));
    }

    public Byn round(RoundMethod roundMethod, int constant) {
        return new Byn(roundMethod.round(value, constant));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }
}
