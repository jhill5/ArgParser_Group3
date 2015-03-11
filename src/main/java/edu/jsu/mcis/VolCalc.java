//package APR;

import java.util.Arrays;

public class VolCalc {

    public static void main(String[] args) {
        ArgumentParser p = new ArgumentParser();
        p.userInput.addAll(Arrays.asList(args));
        
        p.addOptionalArgument("color");
        p.addOptionalArgumentValue("color", "red", "STRING");
        System.out.println(p.getOptionalArgumentValue("color"));
        p.addOptionalArgument("age");
        p.addOptionalArgumentValue("age", "22", "INTEGER");
        System.out.println(p.getOptionalArgumentValue("age"));
        p.addOptionalArgument("weight");
        p.addOptionalArgumentValue("weight", "160.5", "FLOAT");
        System.out.println(p.getOptionalArgumentValue("weight"));
        p.addPositionalArgument("length");
        p.addPositionalArgumentValue("length", "7", "INTEGER");
        System.out.println(p.getPositionalArgumentValue("length"));
        p.addPositionalArgument("width");
        p.addPositionalArgumentValue("width", "5", "INTEGER");
        System.out.println(p.getPositionalArgumentValue("width"));
        p.addPositionalArgument("height");
        p.addPositionalArgumentValue("height", "2", "INTEGER");
        System.out.println(p.getPositionalArgumentValue("height"));
        
        
        Demo d = new Demo();
        //d.printPositionalArgumentInfo("length");
        //d.printOptionalArgumentInfo("color");

        //float length = p.getPositionalArgumentValue("length");
        //float width = p.getPositionalArgumentValue("width");
        //float height = p.getPositionalArgumentValue("height");

        //float volume = length * width * height;
        //System.out.println("The volume is " + volume);
    }
}
