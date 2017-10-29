package com.github.calcengine;


public class CalculateHelper {

    //once field is final, it cant be changed
    //make named constants static so that no class can set them at all
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';


    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    // use caller to handle the exception
    public void process (String statement) throws InvalidStatementException
    {
        //add 1.0 2.0
        //split apart string by spaces
        String[] parts = statement.split(" ");
        //error checking
        // if array does not have 3 elements
        if(parts.length != 3)
        {
            throw new InvalidStatementException("Incorrect number of fields", statement);

        }
        String commandString = parts[0]; //add

        // don't try to parse non numeric data into strings
        try {
            leftValue = Double.parseDouble(parts[1]); //1.0
            rightValue = Double.parseDouble(parts[2]); //2.0
        }
        // if non numeric catch it and throw an exception
        catch (NumberFormatException e)
        {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        //check for invalid commands
        setCommandFromString(commandString);
        if (command == null)
        {
            throw new InvalidStatementException("Invalid command", statement);
        }

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;

            case Subtract:
                calculator = new Subtracter(leftValue, rightValue);
                break;

            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;

            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }
    // Do the actual operator & get result
        calculator.Calculate();
        result = calculator.getResult();
    }

    public void setCommandFromString(String commandString)
    {
        // add --> MathCommand.Add

        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

    @Override
    public String toString()
    {
        // 1.0 + 2.0 = 3.0

        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;

            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;

            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;

            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }
        // create the string builder and pre allocate size for optimal performance
        //builds string up

        StringBuilder sb = new StringBuilder(20);

        // add values to string builder
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();

    }
}
