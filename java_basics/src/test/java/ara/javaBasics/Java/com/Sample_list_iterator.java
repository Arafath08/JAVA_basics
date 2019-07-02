package ara.javaBasics.Java.com;

import java.util.ArrayList;
import java.util.ListIterator;

import org.testng.annotations.Test;

public class Sample_list_iterator {

	
		@Test
		public void test(){
			ArrayList<String> fruits = new ArrayList<String>();
		    fruits.add("Chercher tech");
		    fruits.add("Google");
		    fruits.add("Bing");

		    ListIterator<String> itList = fruits.listIterator();
		    while(itList.hasNext()) {
		      String obj = itList.next();
		      System.out.println("Value : " +obj);
		    }

		    System.out.println("*********Reverse the Iteration*********");
		    while(itList.hasPrevious()) {
		      String objPrev = itList.previous();
		      System.out.println("Value : " +objPrev);
			}
	    }
}
