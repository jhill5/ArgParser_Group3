package edu.jsu.mcis;

import java.util.Scanner;

public class argParser {

    private String[] numArgs;
    private  int[] intArray;
    private  int argument1, argument2, argument3;
    private final  Scanner in = new Scanner(System.in);
    private String userInput = "";
    private final  String helpMessage = "\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box";
    private final  String unrecognisedMessage = "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: ";
    private final  String missingMessage = "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: missing arguments: ";
    private  String missingArguments = "";
    private  String unrecognisedArguments = "";

    public int[] argParse(String s) {
        numArgs = userInput.split(" ");
        intArray = new int[numArgs.length];
        for (int i=0; i<numArgs.length; i++) {
            intArray[i] = Integer.parseInt(numArgs[i].trim());
        }
        return intArray;
    }

    public int getValue(String arg) {
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
	
    public String checkMissing() {
        if (userInput.isEmpty()) {
            missingArguments = "length, width, height";
            missingError();
            return missingArguments;
        }
        else if (numArgs.length == 1) {
            missingArguments = "width, height";
            missingError();
            return missingArguments;
                        }
        else if (numArgs.length == 2){
            missingArguments = "height";
            missingError();
            return missingArguments;
        }
        return null;
    }
    
    public String checkUnrecognised() {
        for (int i=3; i<numArgs.length; i++) {
            unrecognisedArguments += " "+numArgs[i];
        }
        unrecognisedError();
        return unrecognisedArguments;
    }

    public void showHelp() {
        System.out.println(helpMessage);
    }

    public void missingError () {
        System.out.println(missingMessage + missingArguments);
    }

    public void unrecognisedError() {
        System.out.println(unrecognisedMessage + unrecognisedArguments);
    }
    
    public String getUserInput() {
        System.out.println("Enter three arguments: ");
        try {
            userInput = in.nextLine();
            readInput();
        }
        catch (NumberFormatException | NullPointerException e) {
        }
        return userInput;
    }
    
    public void readInput() {
        if (userInput.isEmpty())
            checkMissing();
        else if ("-h".equals(userInput) || "-help".equals(userInput)) {
            showHelp();
        }
        else
            argParse(userInput);
        
        if (numArgs.length < 3) {
            checkMissing();
        }
        else if (numArgs.length > 3) {
            checkUnrecognised();
        }
        else {
            argument1 = intArray[0];
            argument2 = intArray[1];
            argument3 = intArray[2];
            printArguments();
        }
    }
    
    public void printArguments() {
        System.out.println("length = " + getValue("length"));
        System.out.println("width = " + getValue("width"));
        System.out.println("height = " + getValue("height"));
    }

    public static void main(String args[]) {
        ArgParse p = new ArgParse();
        p.getUserInput();
    }
}