package ie.gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerTester {
	

	public static void main(String[] args) {
		ScannerTester scantest = new ScannerTester();
		
		try {
			scantest.parse("commonEnglishWords.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void parse(String file) throws IOException, FileNotFoundException {//file may not be found
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;//each line read from the file
			String lines = null;//all the lines added together
			StringBuilder sb = new StringBuilder();
			
			
			while ((line = br.readLine())!=null) {//Iterate over each line in the buffer until it is empty
				sb.append(line);//use the StringBuilder to add each line
				lines = sb.toString().trim().replaceAll("[^a-zA-Z ]", "").toLowerCase();//convert to a String

				
				/*strip leading and trailing whitespace, then use a regex to remove all characters which are not letters or spaces, 
				 *then change to lower case, divide into individual words and add to String array*/
			}
			Scanner scanFile = new Scanner(lines);
			while (scanFile.hasNextLine()) {
				System.out.println(scanFile.next());
				
			}
			br.close();//keep things tidy
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
