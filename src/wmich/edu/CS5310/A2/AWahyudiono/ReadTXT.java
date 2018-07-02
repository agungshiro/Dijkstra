package wmich.edu.CS5310.A2.AWahyudiono;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * ReadTXT Files and convert to adjacency matrix
 * @author agung
 *
 */

public class ReadTXT {
	
	private String filePath;
	private int lineNumb; //Size
	private float[][] cost;
	
	/**
	 * Constructor
	 * @param file
	 * @throws IOException
	 */
	public ReadTXT(String file) throws IOException {
		
		this.filePath = file;
		
		this.lineNumb = countLine(file);
		
		cost = new float[this.lineNumb][this.lineNumb];
		
		// Open the file 
		FileInputStream fstream = new FileInputStream(filePath);
		InputStreamReader istream = new InputStreamReader(fstream);
		BufferedReader breader = new BufferedReader(istream);
		String strline;
		int arrIndex = 0;
		
		
		while((strline = breader.readLine()) != null) {
			
			String[] arr = strline.split(" ");
			
			int ci = -1;
			for(int i = 0; i < arr.length; i++) {
				if(i != 0 && i%2 != 0) {
					ci = Integer.parseInt(arr[i])-1;
				} else if (i != 0 && i%2 == 0) {
					this.cost[arrIndex][ci] = Float.parseFloat(arr[i]);
				}
			}
			
			arrIndex++;
		}
		
	}
	
	/**
	 * Line Counter, to define the size of cost matrix
	 * @param filepath
	 * @return int line number
	 * @throws IOException
	 */
	private int countLine(String filepath) throws IOException {
		File file = new File(filepath);
		LineNumberReader lineRead = new LineNumberReader(new FileReader(file));
		lineRead.skip(Long.MAX_VALUE);
		int lineNumb = lineRead.getLineNumber();
		lineRead.close();
		return lineNumb;
	}
	
	/**
	 * Cost Getter
	 * @return
	 */
	public float[][] getCost() {
		return this.cost;
	}

}
