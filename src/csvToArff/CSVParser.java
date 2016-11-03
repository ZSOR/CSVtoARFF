package csvToArff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

	private String csvFile;
	private BufferedReader br = null;
	private String line = "";
	private String cvsSplitBy;
	private ArrayList<ArrayList<String>> csv;
	private int index;

	public CSVParser(String filename, String splitby, Boolean header) {
		this.index = 0;
		this.csvFile = filename;
		this.cvsSplitBy = splitby;
		csv = new ArrayList<ArrayList<String>>();

		try {
			br = new BufferedReader(new FileReader(this.csvFile));

			while ((line = br.readLine()) != null) {
				String[] temp = line.split(cvsSplitBy);
				ArrayList<String> entries = new ArrayList<String>();

				for (String item : temp) {
					entries.add(item);
				}

				csv.add(entries);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (header) {
			this.csv.remove(0);
		}

	}

	public List<String> getNext() {

		if (index < this.csv.size()) {
			List<String> temp = this.csv.get(this.index);

			this.index++;

			return temp;
		} else
			return null;
	}

	
	
	public ArrayList<ArrayList<String>> getCSV(){
		return this.csv;
	}
	
	
	public ArrayList<String> getIndex(int index) {

		return this.csv.get(index);
	}
	
	
	public void clearEmpties(){
		
		for(int i = 0; i <csv.size(); i++){
			if (csv.get(i).isEmpty()){
				csv.remove(i);
			}
		}
		
		
	}

}
