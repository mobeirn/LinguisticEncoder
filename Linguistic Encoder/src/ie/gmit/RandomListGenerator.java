package ie.gmit;


import java.util.*;
import java.text.NumberFormat;  

public class RandomListGenerator {
	private Random randomer = new Random();
	NumberFormat format=NumberFormat.getInstance();
	private int listSize = new ConfigReader().getListSize();//from config.xml. Determines size of number list
	private int upperlimit = new ConfigReader().getUpperLimit();//determines upper limit of random numbers. For 1 - 99999, should be 100000
	
	
	public RandomListGenerator() {
		super();
	}
	
	public Collection<String> numberlist(){
		//originally used arraylist with uniqueness check, changed to hashset, approx 250 times faster
		Collection<String> numbers = new HashSet<String>();//to guarantee uniqueness
		
		while (numbers.size() < listSize) {//to guarantee exact number of words as listSize
			String number = String.format("%05d",randomer.nextInt(upperlimit));//pads numbers to 5 digits
			numbers.add(number);//add to list
		}
		return numbers;
	}

}
