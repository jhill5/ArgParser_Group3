package edu.jsu.mcis;

//import edu.jsu.mcis.*;

import java.util.ArrayList;
import java.util.Arrays;

public class VolCalc {

	public static ArrayList<String> argumentValues = new ArrayList<>();
	
	public static void main(String[] args) {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		//p.addArgument("color");
		
		argumentValues.addAll(Arrays.asList(args));
		p.demo();
		p.manageInput();
		
		float length = p.getValue(p.argumentNames.get(0));
		float width = p.getValue(p.argumentNames.get(1));
		float height = p.getValue(p.argumentNames.get(2));

		float volume = length * width * height;
		System.out.println("The volume is " + volume);
	}
}