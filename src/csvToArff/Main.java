package csvToArff;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	
	public static ArrayList<ArrayList<String>> csv = new ArrayList<ArrayList<String>>();
	
	public static HashMap<String, ArrayList<String>> attributes = new HashMap<String,ArrayList<String>>();
	
	public static void main(String args[]){
		
		CSVParser parser = new CSVParser(args[0],",", false);
		parser.clearEmpties();
		csv = parser.getCSV();
		
		
	}
	
	
	
	public static void setAttributeKeys(){
		ArrayList<String> header = csv.get(0);
		
		
		for(String cursor : header){
			attributes.put(cursor, new ArrayList<String>());
		}
	}
	
	
	
}
