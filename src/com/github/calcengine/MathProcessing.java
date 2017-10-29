package com.github.calcengine;

//interfaces are just a contract
//there are no implementations, it just specifies what terms must be met
public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword(); // add
    char getSymbol();       // +
    double doCalculation(double leftValue, double rightValue);
}
