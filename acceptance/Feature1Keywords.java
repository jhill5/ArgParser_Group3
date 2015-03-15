import edu.jsu.mcis.*;

public class Feature1Keywords
{
	private ArgumentParser parser;
	
	public void startProgram (String args)
	{
		parser = new ArgumentParser();
		parser.addPositionalArgument("length");
		parser.addPositionalArgument("width");
		parser.addPositionalArgument("height");
		addValues(args);
	}
	
	public void startProgramMixed(String args)
	{
		parser = new ArgumentParser();
		parser.addPositionalArgument("pet");
		parser.addPositionalArgument("number");
		parser.addPositionalArgument("rainy");
		parser.addPositionalArgument("bathrooms");
		addValues(args);
	}
	
	public void startProgramWithOptionals(String args) {
		parser = new ArgumentParser();
		parser.addPositionalArgument("length");
		parser.addPositionalArgument("width");
		parser.addPositionalArgument("height");
		parser.addOptionalArgument("type");
		addValues(args);
	}
	
	public void startProgramWithShort(String args)
	{
		parser = new ArgumentParser();
		parser.addPositionalArgument("length");
		parser.addPositionalArgument("width");
		parser.addPositionalArgument("height");
		parser.addOptionalArgument("type");
		addValues(args);
	}
	
	public void addValues(String str)
	{
		parser.parse(str);
	}
	

	public String Get(String s)
	{
		
		return parser.getPositionalArgumentValue(s);
	}
}