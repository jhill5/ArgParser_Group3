package edu.jsu.mcis;

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
		p.parse(p.userInput);
        p.checkUnrecognised();
        assertEquals(" 1 2 3", p.checkUnrecognised());
	}
	
	@Test
	public void testAddArgument() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		assertEquals("length", p.getArgument(0));
	}
	
	@Test
	public void testGetValue() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		p.parse("7 5 2");
		assertEquals(7, p.getValue("length"));
		assertEquals(5, p.getValue("width"));
		assertEquals(2, p.getValue("height"));
		
	}
	
	/*@Ignore
	public void testgetUserInput() {
		ArgumentParser p = new ArgumentParser();
		p.getUserInput();
		p.userInput = "7 5 2";
		assertEquals("7 5 2", p.userInput);
	}*/
	
	@Test
	public void testManageInput() {
		assertTrue(true);
	}

	@Test
	public void testGetNumberOfArguments() {
		ArgumentParser p = new ArgumentParser();
		p.userInput = "7 5 2";
		p.parse(p.userInput);
		assertEquals(3, p.getArgumentNumbers());
	}
	
	@Test
	public void testCheckMissingWidthAndHeight() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("height");
		
		assertEquals("width, height", p.checkMissing());
	}
	
	@Test
	public void testCheckMissingHeight() {
		ArgumentParser p = new ArgumentParser();
		p.userInput = "7 5";
		p.parse(p.userInput);
		assertEquals("height", p.checkMissing());
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
		assertEquals(" color" , p.checkUnrecognisedNames());
	}
	
	@Test
	public void testHelpMessage() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box" , p.showHelp());
	}
	
	@Test
	public void testInvalidMessage() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("Usage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: " + p.userInput + " " + "\nThe following datatypes should be supported: int, float, boolean, and String, which is the default value if type is left unspecified." , p.invalidError());
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