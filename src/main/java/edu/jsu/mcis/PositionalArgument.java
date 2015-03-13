package edu.jsu.mcis;

import java.util.*;

public class PositionalArgument {
        public String name = "";
        public String value = "";
        public String info = "";
        public String type = "";
		//public Datatype dataType;
        
        public PositionalArgument (String n) {
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
        void setDataType(String d) {
            type = d;
        }
        String getDataType() {
            return type;
        }
    }