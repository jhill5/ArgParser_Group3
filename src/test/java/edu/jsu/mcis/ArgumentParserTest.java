package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class ArgumentParserTest{
	@Test 
	public void testGetNumberOfArguments(){
		ArgumentParser parser = new ArgumentParser();
		parser.addArgument("length");
		assertEquals(1,parser.getSize());
		parser.addArgument("width");
		assertEquals(2,parser.getSize());
		parser.addArgument("height");
		assertEquals(3,parser.getSize());
	}
}