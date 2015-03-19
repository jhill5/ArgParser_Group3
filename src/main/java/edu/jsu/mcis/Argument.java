package edu.jsu.mcis;

import java.util.*;

public class Argument {
	
	protected String name = "";
	protected String value = "";
	protected String info = "";
	protected DataType type = DataType.STRING;
	protected enum DataType {INTEGER, STRING, FLOAT, INT, BOOLEAN};
	private ArrayList <String> choices = new ArrayList<>();
	
	String getName(){
		return name;
	}
	
	void setValue(String v){
		value = v;
	}
	
	String getValue(){
		return value;
	}
	
	void setInfo(String i){
		info = i;
	}
	
	String getInfo(){
		return info;
	}
	
	void setDataType(DataType d) {
		type = d;
	}
	
	DataType getDataType() {
		return type;
	}
	void getChoice(String c){
		choices.add(c);
	}
	void getChoices(){
		for(int i =0; i <choices.size();i++){
			System.out.println(choices.get(i));
		}
	}
}