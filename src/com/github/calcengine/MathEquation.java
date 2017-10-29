package com.github.calcengine;

public class MathEquation {

    //create fields for values used
    // encapsulate so that they cannot be modified access modifier =private
    //they can be seen however
    private double leftValue;
    private double rightValue;
    private char opCode;
    private double result;

    //add accessors an mutators to set and get values
    // acessors
    public double getLeftValue() {
        return leftValue;
    }
    //mutators - return no value, so use void keyword
    public void setLeftValue(double leftValue) {
        this.leftValue = leftValue;
    }

    public double getRightValue() {
        return rightValue;
    }

    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }
    // use accessor only to make result a read only value

    public double getResult() {
        return result;
    }

    //mathEquation constructor
    public MathEquation(){}
    public MathEquation(char opCode)
    {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftValue, double rightValue)
    {
        this(opCode);
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public void execute(double leftValue, double rightValue)
    {
        this.leftValue = leftValue;
        this.rightValue= rightValue;

        execute();
    }

    public void execute(int leftValue, int rightValue)
    {
        this.leftValue = leftValue;
        this.rightValue= rightValue;

        execute();

        //cast variable to int so that it produces truncates results
        result = (int)result;
    }

    public void execute()
    {
        // use switch statement to simplify this big if-else statement since we are checking the same value each time
        switch (opCode) {
            case 'a' :
                result = leftValue + rightValue;
                //if match is found break from it
                break;
            //if addition is not selected go to next operation add repeat until operation is found
            case 's':
                result = leftValue - rightValue;
                break;
            case 'm' :
                result = leftValue * rightValue;
                break;
            case 'd' :
                //make sure we are not trying to divide  by zero
                result = rightValue != 0.0d ? leftValue / rightValue : 0.0d;
                // means the same as
                                        /* if (val2 != 0.0d)
                                         {
                                         result = val1 / val2;
                                         }
                                         else {
                                             result = 0.0d;
                                         }*/
                break;
            default :
                // if none of the operation codes above are selected, tell the user that they made an invalid selection
                //must be inside block code in order to prevent it from always setting the resultcode to 0
                System.out.println("Error - invalid operation code");
                result = 0.0d;
                break;

        }
    }
}
