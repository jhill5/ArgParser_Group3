package edu.jsu.mcis;

public class OptionalArgument {
	public String name = "";
	public String shortName = "";
	public String value = "";
	public String info = "";
	public String type = "";
	public boolean present = false;
	//public Datatype dataType;
	
	public OptionalArgument (String n) {
		name = n;
	}
	public String getName(){
		return name;
	}
	public void setValue(String v){
		value = v;
	}
	public String getValue(){
		return value;
	}
	public void setInfo(String i){
		info = i;
	}
	public String getInfo(){
		return info;
	}
	public void setShortName(String s) {
		shortName = s;
	}
	public String getShortName() {
		return shortName;
	}
	public void setDataType(String d) {
		type = d;
	}
	public String getDataType() {
		return type;
	}
	public void setFlag(boolean f) {
		present = f;
	}
	public boolean getFlag() {
		return present;
	}
}