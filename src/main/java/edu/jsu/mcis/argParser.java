//package edu.jsu.mcis;

import java.util.Scanner;

class argParser {

    public static String[] numArgs;
    public static int[] intArray;
    public static int argument1, argument2, argument3;
    public static Scanner in = new Scanner(System.in);
    public static String userInput = "";
    public static String helpMessage = "Usage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\n\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box";
    public static String unrecognisedMessage = "Usage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: ";
    public static String missingMessage = "Usage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: missing arguments: ";
    public static String missingArguments = "";
    public static String unrecognisedArguments = "";

    public static int[] argParse(String s) {
        numArgs = userInput.split(" ");
        intArray = new int[numArgs.length];
        for (int i=0; i<numArgs.length; i++) {
            intArray[i] = Integer.parseInt(numArgs[i].trim());
        }
        return intArray;
    }

    public static int getValue(String arg) {
        switch (arg) {
            case "length":
                return argument1;
            case "width":
                return argument2;
            case "height":
                return argument3;
        }
    return 0;
    }
	
    public static String checkMissing() {
        if (userInput.isEmpty()) {
            missingArguments = "length, width, height";
            return missingArguments;
        }
        else if (numArgs.length == 1) {
            missingArguments = "width, height";
            return missingArguments;
                        }
        else if (numArgs.length == 2){
            missingArguments = "height";
            return missingArguments;
        }
    return null;
    }
    
    public static String checkUnrecognised() {
        for (int i=3; i<numArgs.length; i++) {
            unrecognisedArguments += " "+numArgs[i];
        }
        return unrecognisedArguments;
    }

    public static void showHelp() {
        System.out.println(helpMessage);
    }

    public static void missingError () {
        System.out.println(missingMessage + missingArguments);
    }

    public static void unrecognisedError() {
        System.out.println(unrecognisedMessage + unrecognisedArguments);
    }

    public static void main(String args[]) throws Exception {
        System.out.println("Enter three arguments: ");
        userInput = in.nextLine();
        
        if (userInput.charAt(0)== '-' && userInput.charAt(0)== 'h') {
            showHelp();
        }
        else if (userInput.isEmpty())
            checkMissing();
        else
            argParse(userInput);
        
        if (numArgs.length < 3) {
            checkMissing();
            missingError();
        }
        else if (numArgs.length > 3) {
            checkUnrecognised();
            unrecognisedError();
        }
        else {
            argument1 = intArray[0];
            argument2 = intArray[1];
            argument3 = intArray[2];
            System.out.println("length = " + getValue("length"));
            System.out.println("width = " + getValue("width"));
            System.out.println("height = " + getValue("height"));
        }
    }
}

//next
//make program handle blank scanner input
//add "-h" help function