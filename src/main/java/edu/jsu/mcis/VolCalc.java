import java.util.Arrays;

public class VolCalc {
	public static void main(String[] args) {
		ArgumentParser p = new ArgumentParser();
		p.addArgument("length");
		p.addArgument("width");
		p.addArgument("height");
		//p.addArgument("color");
                
		p.argumentValues.addAll(Arrays.asList(args));
		p.parse();
		p.manageInput();
		p.printArguments();
		
		float length = p.getValue("length");
		float width = p.getValue("width");
		float height = p.getValue("height");

		float volume = length * width * height;
		System.out.println("The volume is " + volume);
	}
}