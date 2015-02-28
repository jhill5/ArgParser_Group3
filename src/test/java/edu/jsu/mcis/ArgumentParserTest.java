package edu.jsu.mcis;
import edu.jsu.mcis.ArgumentParser;

import org.junit.*;
import static org.junit.Assert.*;

public class ArgumentParserTest {

	@Test
	public void testParser() {
		String s = "7 5 2";
        String[] numArgs = s.split(" ");
        int[] intArray = new int[numArgs.length];
        for (int i=0; i<numArgs.length; i++) {
            intArray[i] = Integer.parseInt(numArgs[i].trim());
        }
		assertEquals(7, intArray[0]);
		assertEquals(5, intArray[1]);
		assertEquals(2, intArray[2]);
	}
	
	@Test
	public void testCheckUnrecognized() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		p.addArgument("idk");
		p.argumentValues.add("2 4 6 4");
		p.manageInput();
		assertEquals("4", p.checkForUnrecognisedValues());
	
        //assertEquals(" 1 2 3", p.checkForUnrecognisedValues());
	}
	
	@Test
	public void testAddArgument() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		assertEquals("length", p.addArgument("length"));
	}
	
	@Test
	public void testGetValue() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		p.argumentValues.add("7");
		p.argumentValues.add("5");
		p.argumentValues.add("2");
		p.manageInput();
		assertEquals(7, p.getValue("length"));
		assertEquals(5, p.getValue("width"));
		assertEquals(2, p.getValue("height"));
		
	}
	

	@Test
	public void testManageInput() {
		assertTrue(true);
	}

	@Test
	public void testGetNumberOfArguments() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("7");
		p.addArgument("5");
		p.addArgument("2");
		assertEquals(3, p.getArgumentNumbers());
	}
	
	@Test
	public void testCheckMissingWidthAndHeight() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("height");
		
		assertEquals("width, height", p.checkForMissingArguments());
	}
	
	@Test
	public void testCheckMissingHeight() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("6");
		p.addArgument("7");
		assertEquals("height", p.checkForMissingArguments());
	}
	
	@Test
	public void testIfUserEntersThreeArguments() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		assertEquals(3, p.getArgumentNumbers());
	}
	
	@Test
	public void testIfNotEnoughArguments() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		assertNotEquals(3, p.getArgumentNumbers());
	}
	
	@Test
	public void testIfTooManyArguments() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		p.addArgument("color");
		assertNotEquals(3, p.getArgumentNumbers());
	}
	
	@Test
	public void testUnrecognisedNames() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		p.addArgument("color");
		assertEquals(" color" , p.checkForUnrecognisedArguments());
	}
	
	@Test
	public void testHelpMessage() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box" , p.showHelp());
	}
	
	@Test
	public void testInvalidMessage() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: " , p.invalidErrorI());
	}
	
	@Test
	public void testMissingMessage() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: missing arguments: ", p.missingError());
	}
	
	@Test
	public void testUnrecognisedMessage() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: " , p.unrecognisedError());
	}
	
	@Test
	public void testUnrecognisedNamesError() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height \nVolumeCalculator.Java: error: unrecognised arguments: ", p.unrecognisedNamesError());
	}
}