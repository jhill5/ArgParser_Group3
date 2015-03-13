package edu.jsu.mcis;

 import java.util.*; 
 
 public class OptionalArgument {
        public String name = "";
        public String shortName = "";
        public String value = "";
		public String info = "";
        public String type = "";
		//public Datatype dataType;
        
        public OptionalArgument (String n) {
            name = n;
        }
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
        void setShortName(String s) {
            shortName = s;
        }
        String getShortName() {
            return shortName;
        }
        void setDataType(String d) {
            type = d;
        }
        String getDataType() {
            return type;
        }
    }