package com.epam.inheritance2;

public enum RoundMethod {
    FLOOR {
        protected double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    ROUND {
        protected double roundFunction(double d) {
            return Math.round(d);
        }
    },
    CEIL {
        protected double roundFunction(double d) {
            return Math.ceil(d);
        }
    };

    protected abstract double roundFunction(double value);

    public int round(double roundedValue, int d) {
        int tenPow = pow(d);
        return (int) roundFunction(roundedValue / tenPow) * tenPow;
    }

    private static int pow(int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result *= 10;
        }
        return result;
    }
}
