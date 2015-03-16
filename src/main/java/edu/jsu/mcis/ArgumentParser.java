package edu.jsu.mcis;

import java.util.*;
import java.io.*;

public class ArgumentParser {
	//VARIABLES
    private HashMap<String, PositionalArgument> positionalArguments = new HashMap<>();
    private HashMap<String, OptionalArgument> optionalArguments = new HashMap<>();
	private HashMap<String, String> optionalArgumentShortNames = new HashMap<>();
    public ArrayList<String> input = new ArrayList<>();
	//private enum Datatype {STRING, FLOAT, INTEGER, BOOLEAN};
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
    public void addPositionalArgumentValue(String name,String type) {
        PositionalArgument temp = new PositionalArgument(name);
        temp.setDataType(type);
        positionalArguments.put(name,temp);
    }
	
    public void addOptionalArgumentValue(String name, String value, String type) {
        OptionalArgument temp = new OptionalArgument(name);
        temp.setValue(value);
        temp.setDataType(type);
		if(type != "STRING") {
			checkForInvalidArguments(value);
		}
        optionalArguments.put(name, temp);
    }
	//GET ARGUMENT VALUES AS STRINGS
	public String getPositionalArgumentType(String name){
		PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
		return temp.getDataType();
	}
	public String getPositionalArgumentValue(String name) {
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
		return temp.getValue();
	}
	public String getOptionalArgumentValue(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		return temp.getValue();
	}
    //ADD ARGUMENT DESCRIPTION/HELP INFORMATION
    public void addOptionalArgumentDescription(String name, String info) {
        OptionalArgument temp = new OptionalArgument(name);
		temp = optionalArguments.get(name);
        temp.setInfo(info);
        optionalArguments.put(name, temp);
    }
	public void addPositionalArgumentDescription(String name, String info) {
        PositionalArgument temp = new PositionalArgument(name);
		temp = positionalArguments.get(name);
        temp.setInfo(info);
        positionalArguments.put(name, temp);
    }
    //GET ARGUMENT DESCRIPTION/HELP INFORMATION
    public String getOptionalArgumentDescription(String name) {
        OptionalArgument temp = new OptionalArgument(name);
		temp = optionalArguments.get(name);
        return temp.getInfo();
    }
	public String getPositionalArgumentDescription(String name) {
        PositionalArgument temp = new PositionalArgument(name);
		temp = positionalArguments.get(name);
        return temp.getInfo();
    }
	//SET OPTIONAL ARGUMENT FLAGS
	public void setFlag(String name, boolean flag) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		temp.setFlag(flag);
		optionalArguments.put(name, temp);
	}
	//GET OPTIONAL ARGUMENT FLAGS
	public boolean getFlag(String name) {
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
		return temp.getFlag();
	}
    //GET ARGUMENT VALUE AS OBJECTS
	@SuppressWarnings("unchecked")
    public <T> T getPositionalArgument(String name) {
		Object v = null;
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
        if(temp.type == "INTEGER")
                v = Integer.parseInt(temp.value);
                //parsePositionalArgumentInt(name);
        else if (temp.type == "FLOAT")
                v = Double.parseDouble(temp.value);
               // parsePositionalArgumentFloat(name);
        else if (temp.type == "BOOLEAN")
                v = Boolean.parseBoolean(temp.value);
                //parsePositionalArgumentBoolean(name);
		else
                v = temp.value;
        return (T) v;
    }
    
	@SuppressWarnings("unchecked")
    public <T> T getOptionalArgument(String name) {
		Object v = null;
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
        if(temp.type == "INTEGER")
                v = Integer.parseInt(temp.value);
                //parsePositionalArgumentInt(name);
        else if (temp.type == "FLOAT")
                v = Double.parseDouble(temp.value);
               // parsePositionalArgumentFloat(name);
        else if (temp.type == "BOOLEAN")
                v = Boolean.parseBoolean(temp.value);
                //parsePositionalArgumentBoolean(name);
		else
                v = temp.value;
        return (T) v;
    }
	//ARGUMENT PARSER
	public void parse(String str) {
		Scanner scan = new Scanner(str);
		String argument = "";
		String name = "";
		String index = "";
		float value;
		while(scan.hasNext())
		{
			String extra  = scan.next();
			input.add(extra);
		}
        for(int i=0; i<input.size(); i++) {
			//CHECK FOR HELP
            if(input.get(i).contains("--help") || input.get(i).contains("-h")) {
                showHelp();
				input.set(i, "");
			}
			//CHECK FOR OPTIONAL ARGUMENT LONG NAME
			else if(input.get(i).startsWith("--")) {
				argument = input.get(i).replace("--", "");
				OptionalArgument temp = new OptionalArgument(argument);
				temp = optionalArguments.get(argument);
				if(temp == null) {
					throw new UnknownArgumentException("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unknown arguments: " + argument);
				}
				temp.setFlag(true);
				temp.setValue(input.get(i+1));
				optionalArguments.put(argument, temp);
				input.set(i, "");
				input.set(i+1, "");
			}
			//CHECK FOR OPTIONAL ARGUMENT SHORT NAME
			else if(input.get(i).contains("-") && !input.get(i).contains("--")) {
				argument = input.get(i).replace("-", "");
				if(optionalArgumentShortNames.get(argument) != null) {
					name = optionalArgumentShortNames.get(argument);
					OptionalArgument temp = new OptionalArgument(name);
					temp = optionalArguments.get(name);
					temp.setFlag(true);
					temp.setValue(input.get(i+1));
					optionalArguments.put(name, temp);
					input.set(i, "");
					input.set(i+1, "");
					}
				else {
					throw new UnknownArgumentException("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unknown arguments: " + argument);
				}
			}
		}
		//CHECK FOR POSITIONAL ARGUMENTS
		int j = 0;
		ArrayList<String> names = new ArrayList<>();
		for(String arguments : positionalArguments.keySet()) {
			names.add(arguments);
		}
		for(int i=0; i<input.size(); i++) {
			if (input.get(i) != "") {
				try {
					//value = Float.parseFloat(input.get(i));
					argument = names.get(j);
					PositionalArgument temp = new PositionalArgument(argument);
					temp = positionalArguments.get(argument);
					temp.setValue(input.get(i));
					positionalArguments.put(argument, temp);
					input.set(i, "");
					j++;
				}
				catch(Exception e) {
					checkForInvalidInput(input);
				}
			}
		}
		checkForMissingArguments(input);
		checkForUnrecognisedArguments(input);
	}
	//CHECK FOR ERRORS
    public void checkForMissingArguments(ArrayList<String> s) {
        String missingArguments = "";
		for(String argument : positionalArguments.keySet()) {
			PositionalArgument temp = new PositionalArgument(argument);
			temp = positionalArguments.get(argument);
			if(temp.getValue() == "") {
				missingArguments += temp.getName() + " ";
			}
		}
		if(missingArguments != "") {
			throw new MissingArgumentException("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: missing arguments: " + missingArguments);
		}
    }
    
    public void checkForUnrecognisedArguments(ArrayList<String> s) {
        String unrecognisedArguments = "";
		float value;
		for(int i=0; i<s.size(); i++) {
			if(s.get(i) != "") {
				try {
					value = Float.parseFloat(s.get(i));
					unrecognisedArguments += s.get(i) + " ";
				} catch(Exception e) {}
			}
		}
		if(unrecognisedArguments != "") {
			throw new UnrecognisedArgumentException ("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: " + unrecognisedArguments);
		}
    }
	
	public void checkForInvalidInput(ArrayList<String> s) {
		String invalidArguments = "";
		float value;
		for(int i=0; i<s.size(); i++) {
			try {
				value = Float.parseFloat(s.get(i));
			} catch(Exception e) {
				invalidArguments += s.get(i) + " ";
			}
		}
		if(invalidArguments != "") {
			throw new InvalidArgumentException("\nUsage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: " + invalidArguments + "\nThe following datatypes should be supported: int, float, boolean, and String, which is the default value if type is left unspecified.");
		}
	}
	
	public void checkForInvalidArguments(String s) {
		boolean valid = true;
		while(true) {
			try {
				Integer.parseInt(s);
				valid = true;
				break;
			} catch (Exception e) {
				valid = false;
				try {
					Float.parseFloat(s);
					valid = true;
					break;
				} catch (Exception f) {
					valid = false;
					try {
						Boolean.parseBoolean(s);
						valid = true;
						break;
					} catch (Exception h) {
						valid = false;
					}
				}  
			}
		}
		if(!valid) {
			throw new InvalidArgumentException("\nUsage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: " + s + "\nThe following datatypes should be supported: int, float, boolean, and String, which is the default value if type is left unspecified.");
		}
	}
    //MESSAGES
    public String showHelp() {
		String help = "";
		help = "\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box";
		System.out.println(help);
		return help;
    }
    //EXCEPTIONS
}

/*
TO DO:
Make "Getters"
Unit Tests
Acceptance Tests
*/