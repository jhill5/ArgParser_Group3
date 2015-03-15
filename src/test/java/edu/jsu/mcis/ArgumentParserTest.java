package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class ArgumentParserTest {
	private ArgumentParser p;
	
	@Before
	public void startUp()
	{
		p = new ArgumentParser();
	}
	
	@Test
	public void testGetDescriptionOfOptArgument() {
		p.addOptionalArgument("Type");
		p.addOptionalArgumentDescription("Type","Please input a type!");
		assertEquals("Please input a type!",p.getOptionalArgumentDescription("Type"));
	}
	
	@Test
	public void testGetValue() {
		p.addPositionalArgument("length");
		p.addPositionalArgumentValue("length", "7", "INTEGER");
		assertEquals("7",p.getPositionalArgument("length"));
	}
	
	@Test
	public void testCheckForMissing() {
		p.addPositionalArgument("length");
		p.addPositionalArgument("width");
		p.addPositionalArgument("height");
		try{
			p.parse("7 5");
		}catch
		(MissingArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testInvalidArgumentException(){
		p.addPositionalArgument("length");
		p.addPositionalArgument("width");
		p.addPositionalArgument("height");
		try{
			p.parse("7 5 2 4");
		}catch
		(InvalidArgumentException e){
			assertTrue(true);
		}
	}
	@Test
	public void testCheckForInvalidArguments(){
		try{
			p.addOptionalArgumentValue("Type","sphere","null");
		}catch(InvalidArgumentException e)
		{
			assertTrue(true);
		}
	}
	@Test
	public void testCheckForUnrecognisedArguments(){
		p.addPositionalArgument("length");
		p.addPositionalArgumentValue("length", "INTEGER");
		try{
			p.parse("7");
		}catch(UnrecognisedArgumentException e){
			assertTrue(true);
		}
	}
	
}