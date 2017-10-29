package com.github.calcengine;

public class Divider extends CalculateBase {
    public Divider() {
    }

    public Divider(double leftValue, double rightValue) {
        //calls up to base class constructor that calls the same values
        super(leftValue, rightValue);
    }

    @Override
    public void Calculate() {
        double value = getLeftValue() / getRightValue();
        setResult(value);
    }
}