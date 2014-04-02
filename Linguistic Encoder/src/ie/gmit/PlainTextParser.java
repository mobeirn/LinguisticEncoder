package ie.gmit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class PlainTextParser extends Parser {
	private Collection<String> wordCollection = new ArrayList<String>();
	
	
	public PlainTextParser(){	
	}
	
	public Collection<String> parse() throws Exception{
		String file = (new ConfigReader().getPlainText());
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;//each line read from the file
			String lines = null;//all the lines added together
			StringBuilder sb = new StringBuilder();
			
			while ((line = br.readLine())!=null) {//Iterate over each line in the buffer until it is empty
				sb.append(line);//use the StringBuilder to add each line
				lines = sb.toString();//convert to a String
				
				/*strip leading and trailing whitespace, then use a regex to remove all characters which are not letters or spaces, 
				 *then change to lower case, divide into individual words and add to String array*/
			}
			
			
			
			lines = lines.trim().replaceAll("[^a-zA-Z ]", "").toLowerCase();
			Scanner scan = new Scanner(lines);
			while (scan.hasNext()) {
				wordCollection.add(scan.next());
			}
			scan.close();
			br.close();//keep things tidy
		} catch (Exception e) {
			e.printStackTrace();
			}
		return wordCollection;
	}

}
