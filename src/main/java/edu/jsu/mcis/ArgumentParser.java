//package edu.jsu.mcis;

//import edu.jsu.mcis.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

class ArgumentParser {
    
    public List<String> argumentNames = new ArrayList<>();
	public List<String> argumentValues = new ArrayList<>();
	public enum Datatype {STRING, DOUBLE, FLOAT, INT, BOOLEAN};
	public  int argValue1, argValue2, argValue3;
	public  int[] intArray;
	public String type = "";
	public String name = "";
	public String userInput = "";

    public void demo() {
        checkForOptionalArguments();
        checkForType();
		System.out.println("Type: " + type);
        for (String argumentValue : argumentValues) {
            userInput += (argumentValue + " ");
        }
        for (String argumentName : argumentNames) {
            System.out.println("Positional Argument: " + argumentName);
        }
		//System.out.println("Items to Parse: " + userInput);
        for (String argumentValue : argumentValues) {
            System.out.println("Positional Argument Value: " + argumentValue);
        }
    }

	public String checkForType() {
		for (int i=0; i<argumentValues.size(); i++) {
			if (argumentValues.get(i).contains("--type")) {
				type = argumentValues.get(i+1);
				argumentValues.remove(i);
				argumentValues.remove(i);
			}
		}
		return type;
	}

	public void checkForOptionalArguments() {
		for (int i=0; i<argumentValues.size(); i++) {
			if (argumentValues.get(i).contains("--") && !argumentValues.get(i).contains("help")  && !argumentValues.get(i).contains("type") ) {
				name = argumentValues.get(i).replace("--", "");
				//System.out.println("Optional Argument: " + name); //DEMO
				OptionalArgument name = new OptionalArgument();
				name.value = argumentValues.get(i+1);
				//System.out.println("Optional Argument Value: " + name.value); //DEMO
				name.shortName = ("-"+argumentValues.get(i).charAt(2));
				//System.out.println("Optional Argument Short Name: " + name.shortName); //DEMO
                    try {
                        Integer.parseInt(name.value);
                        name.type = Datatype.INT;
                    } catch (Exception e) {
                        try {
                            Float.parseFloat(name.value);
                            name.type = Datatype.FLOAT;
                        } catch (Exception f) {
                            try {
                                Double.parseDouble(name.value);
                                name.type = Datatype.DOUBLE;
                            } catch (Exception g) {
                                    name.type = Datatype.STRING;
                                }
                            }  
                        } 
				//System.out.println("Optional Argument Data Type: " + name.type); //DEMO
				argumentValues.remove(i);
				argumentValues.remove(i);
			}
		}
	}
	
    public void manageInput() {
        String invalidArguments = "";
        if (argumentValues.size() == 0) {
            System.out.println(invalidErrorI()+invalidArguments+invalidErrorF());
        }
		else if (userInput.contains("-h") || userInput.contains("--help")) {
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
        System.out.println(unrecognisedError() + unrecognisedArgumentNames);
        return unrecognisedArgumentNames;
    }
	
	public String checkForInvalidArguments() {
		String invalidArguments = "";
         for (int i=0; i<argumentValues.size(); i++) {
			 try {
				Integer.parseInt(argumentValues.get(i));
			}
			catch(Exception e ) {
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

	public class PositionalArgument {
        public String value = "";
		public String info = "";
        public Datatype type;
    }
    
    public class OptionalArgument {
        public String shortName = "";
        public String value = "";
		public Datatype type;
		public String helpInfo = "";
    }
	
    public class EmptySpecifiedArgumentException extends RuntimeException {
        
    }
}