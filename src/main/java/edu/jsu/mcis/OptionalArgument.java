package edu.jsu.mcis;

public class OptionalArgument extends Argument{
	public String shortName = "";
	public boolean present = false;
	
	public OptionalArgument (String n) {
		name = n;
	}
	public void setFlag(boolean f) {
		present = f;
	}
	public boolean getFlag() {
		return present;
	}
}