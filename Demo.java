package edu.jsu.mcis;
public class Demo {
	
	public void showDemo() {
		ArgumentParser p = new ArgumentParser();
		System.out.println("\nArgument values before command line input:");
		
		System.out.println("Value of color: " + p.getOptionalArgument("color"));
		System.out.println("Value of age: " + p.getOptionalArgument("age"));
		System.out.println("Value of weight: " + p.getOptionalArgument("weight"));
		
		System.out.println("Value of length: " + p.getPositionalArgument("length"));
		System.out.println("Value of width: " + p.getPositionalArgument("width"));
		System.out.println("Value of height: " + p.getPositionalArgument("height"));
		
		
		System.out.println("\nArgument values after command line input:");
		
		System.out.println("Value of color: " + p.getOptionalArgument("color"));
		System.out.println("Is Present: " + p.getFlag("color"));
		System.out.println("Description: " + p.getOptionalArgumentDescription("color"));
		System.out.println("Value of age: " + p.getOptionalArgument("age"));
		System.out.println("Is Present: " + p.getFlag("age"));
		System.out.println("Description: " + p.getOptionalArgumentDescription("age"));
        System.out.println("Value of weight: " + p.getOptionalArgument("weight"));
		System.out.println("Is Present: " + p.getFlag("weight"));
		System.out.println("Description: " + p.getOptionalArgumentDescription("weight"));
		
		System.out.println("Value of length: " + p.getPositionalArgumentValue("length"));
		System.out.println("Value of width: " + p.getPositionalArgumentValue("width"));
		System.out.println("Value of height: " + p.getPositionalArgumentValue("height"));
	}
}