package ie.gmit;

import java.util.Collection;
import java.util.Map;


public class Tester {
	public static void main(String[] args) {
		
		
		
		long start = System.currentTimeMillis();
		//Codebook.getInstance();
		long stop = System.currentTimeMillis();
		/*System.out.println("Time taken = " + (stop - start) + " milliseconds.");
		start = System.currentTimeMillis();
		Codebook.getInstance();
		stop = System.currentTimeMillis();
		System.out.println("Time taken = " + (stop - start) + " milliseconds.");*/
		
		CodebookCreator cbc = new CodebookCreator();
		start = System.currentTimeMillis();
		
		cbc.getCodebooks();
			
	
		stop = System.currentTimeMillis();
		System.out.println("Time taken for CodebookCreator= " + (stop - start) + " milliseconds.");
		
		System.out.println(cbc.getCodebook().size());
		System.out.println(cbc.getCodebook().get("the"));
		System.out.println(cbc.getCodebook().get("the").size());
		System.out.println(cbc.getCodebook().get("cattle"));
		System.out.println(cbc.getCodebook().get("cattle").size());
		System.out.println(cbc.getDecodebook().size());
		

	}

}
