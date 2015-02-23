//package edu.jsu.mcis;

import java.util.ArrayList;
import java.util.Arrays;

class ArgumentParser {
    
	VolCalc v = new VolCalc();
    public String[] numArguments;
    public  int[] intArray;
    public ArrayList<String> argumentNames = new ArrayList<>();
    public  int argValue1, argValue2, argValue3;
    public String userInput = "";
    public ArrayList<String> argumentValues = v.argumentValues;
    
    public void manageInput() {
        String invalidArguments = "";
        if (argumentValues.size() == 0) {
            System.out.println(invalidErrorI()+invalidArguments+invalidErrorF());
        }
        else if ("-h".equals(argumentValues.get(0)) || "-help".equals(argumentValues.get(0))) {
            System.out.println(showHelp());
			System.exit(0);
        }
        else {
            try {
            parse();
            }
            catch (NumberFormatException e) {
                checkForInvalidArguments();
                System.exit(0);
            }
		}
		
        if (argumentValues.size() < 3 || argumentNames.size() < 3)
            checkForMissingArguments();
        else if (argumentValues.size()  > 3)
            checkForUnrecognisedValues();
        else if (argumentNames.size() > 3)
            checkForUnrecognisedArguments();
        else {
            argValue1 = intArray[0];
            argValue2 = intArray[1];
            argValue3 = intArray[2];
        }
    }
    
    public int[] parse() {
        intArray = new int[argumentValues.size()];
        for (int i=0; i<argumentValues.size(); i++) {
            intArray[i] = Integer.parseInt(argumentValues.get(i));
        }
        return intArray;
    }
    
    public String addArgument(String s) {
        argumentNames.add(s);
        return s;
    }
    
    public int getValue(String s) {
        if (s.equals(argumentNames.get(0)))
            return argValue1;
        else if (s.equals(argumentNames.get(1)))
            return argValue2;
        else if (s.equals(argumentNames.get(2)))
            return argValue3;
        return 0;
    }
 
    public String checkForMissingArguments() {
        String missingArguments = "";
        if (argumentValues.size()  == 1 || argumentNames.size() == 1) {
            missingArguments = "width, height";
            System.out.println(missingError()+missingArguments);
            return missingArguments;
		}
        else if (argumentValues.size()  == 2 || argumentNames.size() == 2) {
            missingArguments = "height";
            System.out.println(missingError()+missingArguments);
            return missingArguments;
        }
        return null;
    }
    
    public String checkForUnrecognisedValues() {
        String unrecognisedArguments = "";
        for (int i=3; i<argumentValues.size(); i++) {
            unrecognisedArguments += " " + argumentValues.get(i);
        }
        System.out.println(unrecognisedError() + unrecognisedArguments);
        return unrecognisedArguments;
    }
    
    public String checkForUnrecognisedArguments() {
        String unrecognisedArgumentNames = "";
        for (int i=3; i<argumentNames.size(); i++) {
            unrecognisedArgumentNames += " " + argumentNames.get(i);
        }
        System.out.println(unrecognisedNamesError() + unrecognisedArgumentNames);
        return unrecognisedArgumentNames;
    }
	
	public String checkForInvalidArguments() {
		String invalidArguments = "";
         for (int i=0; i<argumentValues.size(); i++) {
			 try {
				Integer.parseInt(argumentValues.get(i));
			}
			catch( Exception e ) {
				invalidArguments += " " + argumentValues.get(i);
			}
        }
		System.out.println(invalidErrorI()+invalidArguments+invalidErrorF());
		return invalidArguments;
	}
    
    public String showHelp() {
        return "\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box";
    }
    
    public String missingError() {
        return "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: missing arguments: ";
    }
    
    public String unrecognisedError() {
        return "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: ";
    }
    
    public String invalidErrorI() {
        return "\nUsage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: ";
    }
    
    public String invalidErrorF() {
        return "\nThe following datatypes should be supported: int, float, boolean, and String, which is the default value if type is left unspecified.";
    }
    
    public String unrecognisedNamesError() {
        return "\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: ";
    }
}