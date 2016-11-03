package csvToArff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

	
	public static ArrayList<ArrayList<String>> csv = new ArrayList<ArrayList<String>>();
	
	public static LinkedHashMap<String, ArrayList<String>> attributes = new LinkedHashMap<String,ArrayList<String>>();
	
	public static void main(String args[]){
		
		CSVParser parser = new CSVParser("/Users/ross/Downloads/uk-500.csv",",", false);
		parser.clearEmpties();
		csv = parser.getCSV();
		setAttributeKeys();
		System.out.println(attributes);
		
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
	
	
	
}
