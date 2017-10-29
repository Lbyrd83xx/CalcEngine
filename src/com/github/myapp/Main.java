package com.github.myapp;

import com.github.calcengine.Adder;
import com.github.calcengine.CalculateBase;
import com.github.calcengine.CalculateHelper;
import com.github.calcengine.Divider;
import com.github.calcengine.InvalidStatementException;
import com.github.calcengine.MathEquation;
import com.github.calcengine.Multiplier;
import com.github.calcengine.Subtracter;

public class Main {

    public static void main(String[] args) {
        //useMathEquation();
        // useCalculatorBase();
      //  useCalculatorHelper();
        String[] statements = {
                    "add 25.0 92.0",            // 25.0 + 92.0 = 117.0

        };

        for(String statement:statements)
        {

        }


        //         ***** Test code*****
//        MathEquation testEquation = new MathEquation();
//        testEquation.execute();
//        System.out.print("test = ");
//        System.out.println(testEquation.getResult());


//        double[] leftValues = {100.d, 25.0d, 225.0d, 11.0d};
//        double[] rightValues = {50.0d, 92.0d, 17.0d, 3.0d};
//        char[] opCodes = {'d', 'a', 'm', 's'};
//        //sets results to the same size as opCodes 4
//        double[] results = new double[opCodes.length];
//	    double val1 =100.0;
//	    double val2 = 50.0d;
//	    double result;
//	    //use one letter code to represent the operation to be used
//	    char opCode = 'd';


    }

     static void useCalculatorHelper() {
         String[] statements = {
                 "add 1.0",                  // Error: incorrect number of values
                 "add xx 25.0",              // Error: non-numeric data
                 "addX 0.0 0.0",             // Error: invalid command
                 "divide 100.0 50.0",        // 100.0 /50.0 = 2.0
                 "add 25.0 92.0",            // 25.0 /92.0 = 117.0
                 "subtract 225.0 17.0",      // 225.0 /17.0 = 108.0
                 "multiply 11.0 3.0"         // 11.0 / 3.0 = 33.0
         };

         //uses helper to go through and do all of the work taking string apart and operation
         CalculateHelper helper = new CalculateHelper();
         for (String statement : statements) {
             try
             {
                 helper.process(statement);
                 System.out.println(helper);
             }
             catch (InvalidStatementException e)
             {
                 System.out.println(e.getMessage());
                 // check to if there was another exception, if so get it
                 if (e.getCause() != null)
                     System.out.println("    Original exception: " + e.getCause().getMessage());
             }

         }
    }

    static void useMathEquation() {
        //create new instance of mathEquation class
        MathEquation[] equations = new MathEquation[4];

        //create individual instances for each equation to be in array
        //call constructor in same order
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        //for loop allows you to walk through each value in array
//        for (int i =0; i< opCodes.length; i++) {
//        }

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;

        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());


        //widening conversion from int to double
        //doubles can hold anything inside of an int
        equationOverload.execute(leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double) leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();
        }

        static void useCalculatorBase () {
            //Setting vlues for each item in array
            CalculateBase[] calculators = {
                    new Divider(100.0d, 50.0d),
                    new Adder(25.0d, 92.0d),
                    new Subtracter(225.0d, 17.0d),
                    new Multiplier(11.0d, 03.0d)
            };


            //to loop through all calculators in subclasses
            for (CalculateBase calculator : calculators) {
                calculator.Calculate();
                System.out.print("result = ");
                System.out.println(calculator.getResult());
            }



                                 /* {
                                      // if operation a is selected, add val1 and val2
                                      if (opCode == 'a')
                                          result = val1 + val2;
                                          //if addition is not selected go to next operation add repeat until operation is found
                                      else if (opCode == 's')
                                          result = val1 - val2;
                                      else if (opCode == 'm')
                                          result = val1 * val2;
                                      else if (opCode == 'd')
                                          //make sure we are not trying to divide  by zero
                                          result = val2 != 0.0d ? val1 / val2 : 0.0d;
                                          // means the same as
                                     *//* if (val2 != 0.0d)
                                      {
                                      result = val1 / val2;
                                      }
                                      else {
                                          result = 0.0d;
                                      }
                            /*
                                      else {
                                          // if none of the operation codes above are selected, tell the user that they made an invalid selection
                                          //must be inside block code in order to prevent it from always setting the resultcode to 0
                                          System.out.println("Error - invalid operation code");
                                          result = 0.0d;
                                      }
                                  }*/
                                  //print results

                              }
                                 // ***no need for this method anymore since we are calling the constructors above***
                                //    public static MathEquation create(double leftValue,double rightValue, char opCode)
                                //    {
                                //        MathEquation equation = new MathEquation();
                                //        //take in parameters (info being brought in from another method and set it to corresponding value
                                //        //creates instances of MathEquation setting each of the values
                                //        equation.setLeftValue(leftValue);
                                //        equation.setRightValue(rightValue);
                                //        equation.setOpCode(opCode);
                                //
                                //        //return values
                                //        return equation;
                                //
                                //
                                //    }
}
