//package edu.jsu.mcis;

import java.util.Scanner;

class ArgumentParser {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        String userInput = "";

        System.out.println("Enter three arguments: ");
        userInput = in.nextLine();

        String[] numArgs;
        int[] intArray;
        int arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9;
		
		//read through string to find individual integers, count them, and add them to an array
        numArgs = userInput.split(" ");
        intArray = new int[numArgs.length];
        for (int i=0; i<numArgs.length; i++) {
                intArray[i] = Integer.parseInt(numArgs[i].trim());
        }

        //check for errors
        if(numArgs.length<3) {
            System.out.println("Not enough arguments!");
        }
        else if (numArgs.length>3) {
            System.out.println("Too many arguments!");
        }
        else {
            //assign value to variables
            arg1 = intArray[0];
            arg2 = intArray[1];
            arg3 = intArray[2];
            //verify it works
            System.out.println("Argument1: "+arg1+ "\nArgument2: "+arg2+ "\nArgument3: "+arg3);
        }
    }
}