package edu.jsu.mcis;

import edu.jsu.mcis.ArgumentParser;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ArgumentParserTest {

	@Test
	public void testParser() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("7", "5", "2");
        p.parse();
		assertEquals(7, p.intArray[0]);
		assertEquals(5, p.intArray[1]);
		assertEquals(2, p.intArray[2]);
	}
	
	@Test
	public void testCheckUnrecognized() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("7", "5", "2", "1", "2", "3");
		p.parse();
        p.checkUnrecognised();
        assertEquals(" 1 2 3", p.unrecognisedArguments);
	}
	
	@Test
	public void testAddArgument() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		assertEquals("length", p.argumentNames.get(0));
	}
	
	@Test
	public void testGetValue() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.argvalue1 = 7;
		p.addArgument("width");
		p.argvalue2 = 5;
		p.addArgument("height");
		p.argvalue3 = 2;
		assertEquals(7, p.getValue("length"));
		assertEquals(5, p.getValue("width"));
		assertEquals(2, p.getValue("height"));
		
	}
	
	@Test
	public void testCheckMissingWidthAndHeight() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("7");
		p.checkMissing();
		assertEquals("width, height", p.missingArguments);
	}
	
	@Test
	public void testCheckMissingHeight() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("7", "5");
		p.checkMissing();
		assertEquals("height", p.missingArguments);
	}
	
	@Test
	public void testIfUserEntersThreeArguments() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		assertEquals(3, p.argumentNames.size());
	}
	
	@Test
	public void testIfNotEnoughArguments() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		assert(3 > p.argumentNames.size());
	}
	
	@Test
	public void testIfTooManyArguments() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		p.addArgument("color");
		assert(3 < p.argumentNames.size());
	}
	
	@Test
	public void testUnrecognisedNames() {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		p.addArgument("color");
		p.checkUnrecognisedNames();
		assertEquals(" color" , p.unrecognisedArgumentNames);
	}
	
	@Test
	public void testInvalidArgument() {
		p.argumentValues = Arrays.asList("7", "cheese", "5", "2");
		assertEquals("cheese", p.unrecognisedArguments);
	}
	
	@Test
	public void testHelpMessage() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box" , p.showHelp());
	}
	
	@Test
	public void testInvalidMessage1() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nUsage: Java VolumeCalculator length width height\nVolumeCalculator.Java: error: argument width: invalid float value: " , p.invalidErrorI());
	}
	
	@Test
	public void testInvlidMessage2() {
		ArgumentParser p = new ArgumentParser();
		assertEquals("\nThe following datatypes should be supported: int, float, boolean, and String, which is the default value if type is left unspecified.", p.invalidErrorF);
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
	public void testGetOptionalArgument() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("--color");
		p.checkForOptionalArguments();
		assertEquals(p.name , "color");
	}
	
	@Test
	public void testGetOptionalArgumentValue() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("--color red");
		p.checkForOptionalArguments();
		assertEquals("red", p.name.value);
	}
	
	@Test
	public void testGetOptionalArgumentShortName() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("--color");
		p.checkForOptionalArguments();
		assertEquals("-c", p.name.shortName);
	}
	
	@Test
	public void testGetOptionalArgumentDataType() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("--color red");
		p.checkForOptionalArguments(ArgumentParser.STRING, p.type.name);
	}
	
	@Test
	public void testGetType() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("--type sphere");
		p.checkForType();
		assertEquals("sphere", p.type);
	}
	
	@Test
	public void testMixOptionalArgumentsWithPositionalArguments() {
		ArgumentParser p = new ArgumentParser();
		p.argumentValues = Arrays.asList("7", "--color", "red", "5", "--gender", "male", "2", "--alive", "true");
		p.checkForOptionalArguments();
		p.parse();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		assertEquals(7, p.getValue("length"));
		assertEquals(5, p.getValue("width"));
		assertEquals(2, p.getValue("height"));
	}
}