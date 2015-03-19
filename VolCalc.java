package edu.jsu.mcis;

import java.util.Arrays;

public class VolCalc {

    public static void main(String[] args) {
        ArgumentParser p = new ArgumentParser();
		String read = "";
		for(String arg:args){
			read += arg + " ";
		}
        p.parse(read);
		
        p.addOptionalArgument("color");
        p.addOptionalArgumentValue("color", "red", Argument.DataType.STRING);
		p.addOptionalArgumentDescription("color", "color's value is a string.");
        p.addOptionalArgument("age");
        p.addOptionalArgumentValue("age", "22", Argument.DataType.INTEGER);
		p.addOptionalArgumentDescription("age", "age's value is an integer.");
        p.addOptionalArgument("weight");
        p.addOptionalArgumentValue("weight", "160.5", Argument.DataType.FLOAT);
		p.addOptionalArgumentDescription("weight", "weight's value is a float.");
		
        p.addPositionalArgument("length");
        p.addPositionalArgument("width");
        p.addPositionalArgument("height");
		
		//DEMO
		///////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\nDefaut argument values:\n");
		
		System.out.println("Value of color: " + p.getOptionalArgument("color"));
		System.out.println("Value of age: " + p.getOptionalArgument("age"));
		System.out.println("Value of weight: " + p.getOptionalArgument("weight"));
		
		System.out.println("Value of length: " + p.getPositionalArgument("length"));
		System.out.println("Value of width: " + p.getPositionalArgument("width"));
		System.out.println("Value of height: " + p.getPositionalArgument("height"));
		
		p.parse(read);
		
		System.out.println("\nArgument values after command line input:\n");
		
		System.out.println("Value of color: " + p.getOptionalArgument("color"));
		System.out.println("Is present: " + p.getFlag("color"));
		System.out.println("Description: " + p.getOptionalArgumentDescription("color"));
		System.out.println("\nValue of age: " + p.getOptionalArgument("age"));
		System.out.println("Is present: " + p.getFlag("age"));
		System.out.println("Description: " + p.getOptionalArgumentDescription("age"));
        System.out.println("\nValue of weight: " + p.getOptionalArgument("weight"));
		System.out.println("Is present: " + p.getFlag("weight"));
		System.out.println("Description: " + p.getOptionalArgumentDescription("weight"));
		
		System.out.println("\nValue of length: " + p.getPositionalArgumentValue("length"));
		System.out.println("Value of width: " + p.getPositionalArgumentValue("width"));
		System.out.println("Value of height: " + p.getPositionalArgumentValue("height"));
		///////////////////////////////////////////////////////////////////////////////////////////////
		
        float length = Float.parseFloat(p.getPositionalArgumentValue("length"));
        float width =  Float.parseFloat(p.getPositionalArgumentValue("width"));
        float height = Float.parseFloat(p.getPositionalArgumentValue("height"));

        float volume = length * width * height;
        System.out.println("\nThe volume is " + volume);
    }
}