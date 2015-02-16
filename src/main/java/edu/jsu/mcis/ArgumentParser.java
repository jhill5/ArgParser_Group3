package edu.jsu.mcis;

import java.util.ArrayList;
import java.util.Scanner;

public class ArgumentParser {
    
    public String[] numArgs;
    public  int[] intArray;
    public ArrayList<String> argNames = new ArrayList<String>();
    public  int argument1, argument2, argument3;
    public final  Scanner in = new Scanner(System.in);
    public String userInput = "";
    public String missingArguments = "";
    public String unrecognisedArguments = "";
    public String unrecognisedArgumentNames = "";
    public String invalidArguments = "";
    
    public String getUserInput() {
        System.out.println("Enter three arguments: ");
        try {
            userInput = in.nextLine();
            manageInput();
        }
        catch (NumberFormatException | NullPointerException e) {
        }
        return userInput;
    }
    
    public void manageInput() {
        if (userInput.isEmpty()) {
            System.out.println(invalidError());
        }
        else if ("-h".equals(userInput) || "-help".equals(userInput)) {
            System.out.println(showHelp());
        }
        else
            try {
            parse(userInput);
            }
            catch (NumberFormatException e) {
                System.out.println(invalidError());
                System.exit(0);
            }
        
        if (numArgs.length < 3 || argNames.size() < 3)
            checkMissing();
        else if (numArgs.length > 3)
            checkUnrecognised();
        else if (argNames.size() > 3)
            checkUnrecognisedNames();
        else {
            argument1 = intArray[0];
            argument2 = intArray[1];
            argument3 = intArray[2];
        }
    }

    public int[] parse(String s) {
        numArgs = s.split(" ");
        intArray = new int[numArgs.length];
        for (int i=0; i<numArgs.length; i++) {
            intArray[i] = Integer.parseInt(numArgs[i].trim());
        }
        return intArray;
    }

    public String addArgument(String s) {
        argNames.add(s);
        return s;
    }
    
    public int getValue(String s) {
        if (s.equals(argNames.get(0)))
            return argument1;
        else if (s.equals(argNames.get(1)))
            return argument2;
        else if (s.equals(argNames.get(2)))
            return argument3;
        return 0;
    }
	
    public String checkMissing() {
        if (numArgs.length == 1 || argNames.size() == 1) {
            missingArguments = "width, height";
            System.out.println(missingError());
            return missingArguments;
                        }
        else if (numArgs.length == 2 || argNames.size() == 2){
            missingArguments = "height";
            System.out.println(missingError());
            return missingArguments;
        }
        return null;
    }
    
    public String checkUnrecognised() {
        for (int i=3; i<numArgs.length; i++) {
            unrecognisedArguments += " " + numArgs[i];
        }
        System.out.println(unrecognisedError());
        return unrecognisedArguments;
    }
    public String checkUnrecognisedNames() {
        for (int i=3; i<argNames.size(); i++) {
            unrecognisedArgumentNames += " " + argNames.get(i);
        }
        System.out.println(unrecognisedNamesError());
        return unrecognisedArgumentNames;
    }

    public String showHelp() {
        return "\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box";
    }

    public String missingError() {
        return "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: missing arguments: " + missingArguments;
    }

    public String unrecognisedError() {
        return "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: " + unrecognisedArguments;
    }
    
    public String invalidError() {
        return "Usage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: " + userInput + " " + "\nThe following datatypes should be supported: int, float, boolean, and String, which is the default value if type is left unspecified.";
    }

    public String unrecognisedNamesError() {
        return "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: " + unrecognisedArgumentNames;
    }
}