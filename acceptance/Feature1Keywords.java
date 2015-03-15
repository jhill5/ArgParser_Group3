import edu.jsu.mcis.*;

public class Feature1Keywords
{
	private ArgumentParser parser;
	
	public void startProgram (String args)
	{
		parser = new ArgumentParser();
		parser.addArgument("length");
		parser.addArgument("width");
		parser.addArgument("height");
		addValues(args);
	}
	
	public void startProgramMixed(String args)
	{
		parser = new ArgumentParser();
		
		parser.addArgument("pet");
		parser.addArgument("number");
		parser.addArgument("rainy");
		parser.addArgument("bathrooms");
		addValues(args);
	}
	
	public void startProgramWithOptionals(String args) {
		parser = new ArgumentParser();
		parser.addArgument("length");
		parser.addArgument("width");
		parser.addArgument("height");
		parser.addOptionalArgument("type");
		addValues(args);
	}
	
	public void startProgramWithShort(String args)
	{
		parser = new ArgumentParser();
		parser.addArgument("length");
		parser.addArgument("width");
		parser.addArgument("height");
		parser.addOptionalArgument("type");
		addValues(args);
	}

	public void addArgument(String arg)
	{
		parser.addPositionalArgument(arg);
	}
	
	public void addValues(String str)
	{
		parser.parse(str);
	}
	

	public String get(String s)
	{
		
		return parser.getPositionalArgumentValue(s.toLowerCase()).toString();
	}
}