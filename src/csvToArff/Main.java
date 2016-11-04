package csvToArff;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {

	
	public static ArrayList<ArrayList<String>> csv = new ArrayList<ArrayList<String>>();
	
	public static LinkedHashMap<String, ArrayList<String>> attributes = new LinkedHashMap<String,ArrayList<String>>();
	
	public static void main(String args[]){
		
		CSVParser parser = new CSVParser("/Users/ross/Downloads/uk-500.csv",",", false);
		parser.clearEmpties();
		csv = parser.getCSV();
		setAttributeKeys();

	}
	
	
	
	public static void setAttributeKeys(){
		ArrayList<String> header = csv.get(0);
		csv.remove(0); //Stops the headers being included in the values list
		
		
		for(int i = 0; i < header.size(); i++){
			ArrayList<String> values = new ArrayList<String>();
			for(ArrayList<String> line : csv){
				values.add(line.get(i));
			}
			attributes.put(header.get(i), values);
		}
		
		
		
		 
		
		
		
	}
	
	

	public static String typeFinder(ArrayList<String >test){
		
		int string = 0;
		int doub = 0;
		int integer = 0;
		int bool = 0;
		
		for(String cursor : test){
			
			
			if(cursor.toLowerCase() == "true" || cursor.toLowerCase() == "false"){
				bool++;
			}
			try{
				Double.valueOf(cursor);
				doub++;
			}catch(Exception e){
				string++;
			}
			try{ 
				Integer.valueOf(cursor);
				integer++;
			}catch(Exception e){
				string++;
			}
		
		}
		
		if(bool > 0 && integer == 0 && doub  == 0){
			return "boolean";
		}
		
		if(integer > 0 && string == 0){
			return "Integer";
		}
		if(doub > 0 && doub == string){ // since the string will be added when the integer is tried the values will be the same 
			return "double";
		}
		else{ 
			System.out.println(integer);
			System.out.println(string);
			return "String";
		}
		
	}
	
	
}
