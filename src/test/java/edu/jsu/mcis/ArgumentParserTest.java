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
	public void testGetDescriptionOfPotArgument() {
		p.addPositionalArgument("length");
		p.addPositionalArgumentDescription("length","Please input a number of length!");
		assertEquals("Please input a number of length!",p.getPositionalArgumentDescription("length"));
	}
	
	@Test
	public void testGetValue() {
		p.addPositionalArgument("length");
		p.addPositionalArgumentValue("length", "7", "INTEGER");
		assertEquals(7,p.getPositionalArgument("length"));
	}
	@Test
	public void testGetValues() {
		p.addPositionalArgument("length");
		p.addPositionalArgument("width");
		p.addPositionalArgument("cat");
		p.addPositionalArgument("rain");
		p.addPositionalArgumentValue("length", "7", "INTEGER");
		p.addPositionalArgumentValue("width", "5.2", "FLOAT");
		p.addPositionalArgumentValue("cat", "white cat", "STRING");
		p.addPositionalArgumentValue("rain", "true", "BOOLEAN");
		assertEquals(7,p.getPositionalArgument("length"));
		assertEquals(5.2,p.getPositionalArgument("width"));
		assertEquals("white cat",p.getPositionalArgument("cat"));
		assertEquals(true,p.getPositionalArgument("rain"));
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
			p.addOptionalArgumentValue("Type","5.2","FLOAT");
			p.addOptionalArgumentValue("color","red","STRING");
			p.addOptionalArgumentValue("art","3","INTEGER");
			p.addOptionalArgumentValue("shape","true","BOOLEAN");
			p.addOptionalArgumentValue("symbol","???","DOUBLE");
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
	@Test 
	public void testHelpInfomation(){
		p.parse("--help");
		assertEquals("\nUsage: Java VolumeCalculator length width height\nCalculate the volume of a box.\n\nPositional arguments:\nlength: the length of the box\nwidth: the width of the box\nheight: the height of the box",p.showHelp());
	}
	
	@Test
	public void testGetArgumentValue(){
		p.addPositionalArgument("length");
		p.addPositionalArgumentValue("length","7","STRING");
		assertEquals("7",p.getPositionalArgumentValue("length"));
	}
	@Test
	public void testOptionalValue(){
		p.addOptionalArgument("type");
		p.addOptionalArgumentValue("type","box","STRING");
		assertEquals("box",p.getOptionalArgumentValue("type"));
	}
	
	@Test
	public void testGetTheFlag(){
		p.addOptionalArgument("type");
		p.setFlag("type",true);
		assertEquals(true,p.getFlag("type"));
	}
	
	@Test
	public void testGetOptionalArgument(){
		p.addOptionalArgumentValue("type","5.2","FLOAT");
		p.addOptionalArgumentValue("color","red","STRING");
		p.addOptionalArgumentValue("art","3","INTEGER");
		p.addOptionalArgumentValue("shape","true","BOOLEAN");
		assertEquals(5.2,p.getOptionalArgument("type"));
		assertEquals("red",p.getOptionalArgument("color"));
		assertEquals(3,p.getOptionalArgument("art"));
		assertEquals(true,p.getOptionalArgument("shape"));
	}
	
	@Test
	public void testContainOptionalArgument(){
		p.addOptionalArgument("type");
		p.addOptionalArgumentValue("type","5.2","FLOAT");
		p.parse("--type box -t sphere");
	}
	
	@Test 
	public void testGetArgumentDataType(){
		p.addPositionalArgument("length");
		p.addPositionalArgumentValue("length","7","STRING");
		assertEquals("STRING",p.getPositionalArgumentType("length"));
	}
	
	@Test
	public void testUnknowType(){
		p.addOptionalArgument("type");
		p.addOptionalArgumentValue("type","5.2","FLOAT");
		try{
			p.parse("--shape box -s sphere");
		}catch(UnknownArgumentException e)
		{
			assertTrue(true);
		}
	}
}