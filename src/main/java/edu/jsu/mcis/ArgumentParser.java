package edu.jsu.mcis;

import java.util.*;

public class ArgumentParser {
	//VARIABLES
    private HashMap<String, PositionalArgument> positionalArguments = new HashMap<>();
    private HashMap<String, OptionalArgument> optionalArguments = new HashMap<>();
	private HashMap<String, String> optionalArgumentShortNames = new HashMap<>();//unused
    public ArrayList<String> userInput = new ArrayList<>();
	private enum Datatype {STRING, DOUBLE, FLOAT, INTEGER, BOOLEAN};
    //ADD ARGUMENTS
    public void addPositionalArgument(String name) {
        positionalArguments.put(name, new PositionalArgument(name));
    }
    
    public void addOptionalArgument(String name) {
        optionalArguments.put(name, new OptionalArgument(name));
		String shortName = "" + name.charAt(0);
		optionalArgumentShortNames.put(shortName, name);
    }
    //ADD ARGUMENT VALUES AND DATATYPES
    public void addPositionalArgumentValue(String name, String value, String type) {
        PositionalArgument temp = new PositionalArgument(name);
        temp.setValue(value);
        temp.setDataType(type);
        positionalArguments.put(name,temp);
    }
    
    public void addOptionalArgumentValue(String name, String value, String type) {
        OptionalArgument temp = new OptionalArgument(name);
        temp.setValue(value);
        temp.setDataType(type);
        optionalArguments.put(name, temp);
    }
    //ADD ARGUMENT DESCRIPTION/HELP INFORMATION
    public void addOptionalArgumentDescription(String name, String i) {
        OptionalArgument temp = new OptionalArgument(name);
        temp.info = i;
        optionalArguments.put(name, temp);
    }
    //GET ARGUMENT DESCRIPTION/HELP INFORMATION
    public String getOptionalArgumentDescription(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        return temp.getInfo();
    }
    //GET ARGUMENT VALUES
	@SuppressWarnings("unchecked")
    public <T> T getPositionalArgument(String name) {  	//NEEDS TO BE GENERIC
		Object v = null;
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
        if(null != temp.type) switch (temp.type) {
            case "INTEGER":
                v = Integer.parseInt(temp.value);
               // parsePositionalArgumentInt(name);
            case "FLOAT":
                v = Float.parseFloat(temp.value);
                //parsePositionalArgumentFloat(name);
            case "DOUBLE":
                v = Double.parseDouble(temp.value);
                //parsePositionalArgumentDouble(name);
            case "BOOLEAN":
                v = Boolean.parseBoolean(temp.value);
                //parsePositionalArgumentBoolean(name);
            case "STRING":
                v = temp.value;
        }
        return (T) v;
    }
    
	@SuppressWarnings("unchecked")
    public <T> T getOptionalArgument(String name) {        //NEEDS TO BE GENERIC
		Object v = null;
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
        if(null != temp.type) switch (temp.type) {
            case "INTEGER":
                v = Integer.parseInt(temp.value);
                //parseOptionalArgumentInt(name);
            case "FLOAT":
                v = Float.parseFloat(temp.value);
                //parseOptionalArgumentFloat(name);
            case "DOUBLE":
                v = Double.parseDouble(temp.value);
                //parseOptionalArgumentDouble(name);
            case "BOOLEAN":
                v = Boolean.parseBoolean(temp.value);
                //parseOptionalArgumentBoolean(name);
            case "STRING":
                v = temp.value;
        }
        return (T) v;
    }
	//POSITIONAL ARGUMENT PARSERS
	/*public String parsePositionalArgumentString(String name) {
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
		return temp.value;
	}
	
	public int parsePositionalArgumentInt(String name) {
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
		return Integer.parseInt(temp.value);
	}
	
	public float parsePositionalArgumentFloat(String name) {
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
		return Float.parseFloat(temp.value);
	}
	
	public double parsePositionalArgumentDouble(String name) {
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
		return Double.parseDouble(temp.value);
	}
	
	public boolean parsePositionalArgumentBoolean(String name) {
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
		return Boolean.parseBoolean(temp.value);
	}*/
	
	//OPTIONAL ARGUMENT PARSERS
	public String parseOptionalArgumentString(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		return temp.value;
	}
	
	public int parseOptionalArgumentInt(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		return Integer.parseInt(temp.value);
	}
	
	public float parseOptionalArgumentFloat(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		return Float.parseFloat(temp.value);
	}
	
	public double parseOptionalArgumentDouble(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		return Double.parseDouble(temp.value);
	}
	
	public boolean parseOptionalArgumentBoolean(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		return Boolean.parseBoolean(temp.value);
	}
	//CHECK FOR ERRORS
    /*public void checkForMissingArguments() {
        String missingArguments = "";
        //CHECK FOR MISSING ARGUMENTS
		throw new missingArgumentException("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: missing arguments: " + missingArguments);
        }
    }
    
    public void checkForUnrecognisedValues() {
        String unrecognisedArguments = "";
        //CHECK FOR UNRECOGNISED VALUES
		throw new unrecognisedArgumentException ("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: " + unrecognisedArguments);
    }
    
    public void checkForUnrecognisedArguments() {
        String unrecognisedArgumentNames = "";
		//CHECK FOR UNRECOGNISED ARGUMENTS
		throw new unrecognisedArgumentException ("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: " + unrecognisedArgumentNames);
    }
	
	public void checkForInvalidArguments() {
		String invalidArguments = "";
        //CHECK FOR INVALID ARGUMENTS
		throw new invlalidArgumentException("\nUsage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: " + invalidArguments + "\nThe following datatypes should be supported: int, float, boolean, and String, which is the default value if type is left unspecified.");
	}*/
    //MESSAGES
    public void showHelp() {
        System.out.println("\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box");
    }
    //EXCEPTIONS
    public class invlalidArgumentException extends RuntimeException {
        public invlalidArgumentException (String message) {
			super (message);
        }
    }
	
    public class missingArgumentException extends RuntimeException {
        public missingArgumentException (String message) {
			super (message);
        }
    }
	
    public class unrecognisedArgumentException extends RuntimeException {
        public unrecognisedArgumentException (String message) {
			super (message);
        }	
    }
    
    public class unknownSpecifiedArgumentException extends RuntimeException {
        public unknownSpecifiedArgumentException (String message) {
			super ("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unknown arguments: ");// + unknownArguments);
        }	
    }
	
	//TEMPORARY METHOD FOR READING CMD AND EXCEPTION HANDLING
	public void readInput() {
		String argument = "";
		String name = "";
        for(int i=0; i<userInput.size(); i++) {
			//CHECK FOR HELP
            if(userInput.get(i).contains("--help") || userInput.get(i).contains("-h")) {
                showHelp();
				userInput.set(i, "");
			}
			//CHECK FOR OPTIONAL ARGUMENT LONG NAME
			else if(userInput.get(i).startsWith("--")) {
				argument = userInput.get(i).replace("--", "");
				OptionalArgument temp = new OptionalArgument(argument);
				temp = optionalArguments.get(argument);
				temp.setValue(userInput.get(i+1));
				optionalArguments.put(argument, temp);
				userInput.set(i, "");
				userInput.set(i+1, "");
			}
			//CHECK FOR OPTIONAL ARGUMENT SHORT NAME
			else if(userInput.get(i).contains("-") && !userInput.get(i).contains("--")) {
				argument = userInput.get(i).replace("-", "");
				if(optionalArgumentShortNames.get(argument) != null) {
					name = optionalArgumentShortNames.get(argument);
					OptionalArgument temp = new OptionalArgument(name);
					temp = optionalArguments.get(name);
					temp.setValue(userInput.get(i+1));
					optionalArguments.put(name, temp);
					userInput.set(i, "");
					userInput.set(i+1, "");
					}
					
				else {
					throw new missingArgumentException("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unknown arguments: " + userInput.get(i));
					}
			}
			else if (userInput.get(i) != "") {
				argument = userInput.get(i).replace("--", "");
				PositionalArgument temp = new PositionalArgument(argument);
				temp = positionalArguments.get(argument);
				temp.setValue(userInput.get(i+1));
				positionalArguments.put(argument, temp);
				userInput.set(i, "");
			}
		}
	}
	
	public void printRemainingInput() {
        for(int i=0; i<userInput.size(); i++) {
			System.out.println(userInput.get(i));
		}
	}
    //MAIN
    public static void main(String args[]) {
        ArgumentParser p = new ArgumentParser();
	}
}

/*
TO DO:
Generics
Errors/Exceptions, UnknownSpecifiedArgumentException Handling
Short Names
Flags/Booleans
*/