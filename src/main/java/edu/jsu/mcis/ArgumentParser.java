//package APR;

import java.util.ArrayList;
import java.util.HashMap;

public class ArgumentParser {
	//VARIABLES
    public HashMap<String, PositionalArgument> positionalArguments = new HashMap<>();
    public HashMap<String, OptionalArgument> optionalArguments = new HashMap<>();
    public ArrayList<String> userInput = new ArrayList<>();
	private enum Datatype {STRING, DOUBLE, FLOAT, INTEGER, BOOLEAN};
    //ADD ARGUMENTS
    public void addPositionalArgument(String arg) {
        positionalArguments.put(arg, new PositionalArgument(arg));
    }
    
    public void addOptionalArgument(String arg) {
        optionalArguments.put(arg, new OptionalArgument(arg));
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
    public <T> T getPositionalArgumentValue(String name) {  	//NEEDDS TO BE GENERIC
		Object n = null;
        PositionalArgument temp = new PositionalArgument(name);
        temp = positionalArguments.get(name);
        if(null != temp.type) switch (temp.type) {
            case "INTEGER":
                n = Integer.parseInt(temp.value);
            case "FLOAT":
                n = Float.parseFloat(temp.value);
            case "DOUBLE":
                n = Double.parseDouble(temp.value);
            case "BOOLEAN":
                n = Boolean.parseBoolean(temp.value);
            case "STRING":
                n = temp.value;
        }
        return (T) n;
    }
    
    public Object getOptionalArgumentValue(String name) {        //NEEDS TO BE GENERIC
        OptionalArgument temp = new OptionalArgument(name);
        temp = optionalArguments.get(name);
        switch (temp.type) {
            case "INTEGER":
                return Integer.parseInt(temp.value);
            case "FLOAT":
                return Float.parseFloat(temp.value);
            case "DOUBLE":
                return Double.parseDouble(temp.value);
            case "BOOLEAN":
                return Boolean.parseBoolean(temp.value);
            case "STRING":
                return temp.value;
        }
        return null;
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
    //POSITIONAL ARGUMENT OBJECT
    public class PositionalArgument {
        public String name = "";
        public String value = "";
        public String info = "";
        public String type = "";
		public Datatype dataType;
        
        public PositionalArgument (String n) {
            name = n;
        }
        String getName(){
            return name;
        }
        void setValue(String v){
            value = v;
        }
        String getValue(){
            return value;
        }
        void setInfo(String i){
            info = i;
        }
        String getInfo(){
            return info;
        }
        void setDataType(String d) {
            type = d;
        }
        String getDataType() {
            return type;
        }
    }
    //OPTIONAL ARGUMENT OBJECT
    public class OptionalArgument {
        public String name = "";
        public String shortName = "";
        public String value = "";
		public String info = "";
        public String type = "";
		public Datatype dataType;
        
        public OptionalArgument (String n) {
            name = n;
        }
        String getName(){
            return name;
        }
        void setValue(String v){
            value = v;
        }
        String getValue(){
            return value;
        }
        void setInfo(String i){
            info = i;
        }
        String getInfo(){
            return info;
        }
        void setShortName(String s) {
            shortName = s;
        }
        String getShortName() {
            return shortName;
        }
        void setDataType(String d) {
            type = d;
        }
        String getDataType() {
            return type;
        }
    }
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
    //MAIN
    /*public static void main(String args[]) {
        ArgumentParser p = new ArgumentParser();
        for(int i=0; i<p.userInput.size(); i++) {// 
            if(p.userInput.get(i).contains("--help") || p.userInput.get(i).contains("-h")) {
                p.showHelp();
            }
        }
    }*/
}

/*
TO DO:
Generics
Errors/Exceptions, UnknownSpecifiedArgumentException Handling
Short Names
Flags/Booleans
*/