package edu.jsu.mcis;

import java.util.Scanner;
import java.util.ArrayList;


class argParser {

	 ArrayList<String> arguments;
	 
	 public argParser(){
	 	 arguments=new ArrayList<String>();
	 }

	public void addArgument(String s){
		arguments.add(s);
	}
	
	public int getSize(){
		return arguments.size();
	}
}

