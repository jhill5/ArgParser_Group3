package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class ArgumentParserTest {
	private ArgumentParser p;
	
	@Before
	public void startUp()
	{
		p = new ArgumentParser();
	}
	
	@Test
	public void testCheckUnrecognized() {
		
	}
	
	@Test
	public void testGetValue() {
		p.addPositionalArgument("length");
		p.addPositionalArgumentValue("length", "7", "INTEGER");
		assertEquals("7",p.getPositionalArgument("length"));
		
	}
	
	@Test
	public void testCheckMissingWidthAndHeight() {
		
	}
	
	@Test
	public void testCheckMissingHeight() {
		
	}
	
	@Test
	public void testIfUserEntersThreeArguments() {
		
	}
	
	@Test
	public void testIfNotEnoughArguments() {
		
	}
	
	@Test
	public void testIfTooManyArguments() {
		
	}
	
	@Test
	public void testUnrecognisedNames() {
		
	}
	
	@Test
	public void testInvalidArgument() {
		
	}
	
	@Test
	public void testHelpMessage() {
	
	}
	
	@Test
	public void testInvalidMessage1() {
		
	}
	
	@Test
	public void testInvlidMessage2() {
	
	}
	
	@Test
	public void testMissingMessage() {

	}
	
	@Test
	public void testUnrecognisedMessage() {
		
	}
	
	@Test
	public void testGetOptionalArgument() {
		
	}
	
	@Test
	public void testGetOptionalArgumentValue() {
		
	}
	
	@Test
	public void testGetOptionalArgumentShortName() {
		
	}
	
	@Test
	public void testGetOptionalArgumentDataType() {
		
	}
	
	@Test
	public void testGetType() {
		
	}
	
	@Test
	public void testMixOptionalArgumentsWithPositionalArguments() {
		
	}
}