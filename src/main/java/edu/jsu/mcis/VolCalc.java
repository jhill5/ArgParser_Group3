package edu.jsu.mcis;

import java.util.Arrays;

public class VolCalc {

    public static void main(String[] args) {
        ArgumentParser p = new ArgumentParser();
        p.userInput.addAll(Arrays.asList(args));
        
		System.out.println("Argument values before command line input:");//DEMO
		
        p.addOptionalArgument("color");
        p.addOptionalArgumentValue("color", "red", "STRING");
		System.out.println("Value of color: " + p.getOptionalArgument("color"));//DEMO
        p.addOptionalArgument("age");
        p.addOptionalArgumentValue("age", "22", "INTEGER");
		System.out.println("Value of age: " + p.getOptionalArgument("age"));//DEMO
        p.addOptionalArgument("weight");
        p.addOptionalArgumentValue("weight", "160.5", "FLOAT");
		System.out.println("Value of weight: " + p.getOptionalArgument("weight"));//DEMO
        p.addPositionalArgument("length");
        //p.addPositionalArgumentValue("length", "7", "INTEGER");
		System.out.println("Value of length: " + p.getPositionalArgument("length"));//DEMO
        p.addPositionalArgument("width");
        //p.addPositionalArgumentValue("width", "5", "INTEGER");
		System.out.println("Value of width: " + p.getPositionalArgument("width"));//DEMO
        p.addPositionalArgument("height");
        //p.addPositionalArgumentValue("height", "2", "INTEGER");
		System.out.println("Value of height: " + p.getPositionalArgument("height"));//DEMO
		
		p.readInput();
		//p.printRemainingInput();
		
        /*float length = p.getPositionalArgument("length");
        float width =  p.getPositionalArgument("width");
        float height = p.getPositionalArgument("height");

        float volume = length * width * height;
        System.out.println("The volume is " + volume);*/
		
		//DEMO
		System.out.println("\nArgument values after command line input:");
		
		System.out.println("Value of color: " + p.getOptionalArgument("color"));
		p.addOptionalArgumentDescription("color", "This is color's description.");
		//System.out.println(p.getOptionalArgumentDescription("color"));
		System.out.println("Value of age: " + p.getOptionalArgument("age"));
		p.addOptionalArgumentDescription("age", "This is age's description.");
		//System.out.println(p.getOptionalArgumentDescription("color"));
        System.out.println("Value of weight: " + p.getOptionalArgument("weight"));
		p.addOptionalArgumentDescription("weight", "This is weight's description.");
		//System.out.println(p.getOptionalArgumentDescription("color"));
		
		System.out.println("Value of length: " + p.getPositionalArgument("length"));
		System.out.println("Value of width: " + p.getPositionalArgument("width"));
		System.out.println("Value of height: " + p.getPositionalArgument("height"));
        
        //d.printPositionalArgumentInfo("length");
        //d.printOptionalArgumentInfo("color");
    }
}
