package ara.javaBasics.Java.com;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample_Iterator {
	public static void main(String args[]){
	    ArrayList<String> products = new ArrayList<String>();
	    products.add("Chercher tech");
	    products.add("Google");
	    products.add("Bing");

	    Iterator<String> it = products.iterator();

	    while(it.hasNext()) {
	      String obj =  it.next();
	      System.out.println("Value : " +obj);
	      }
	    System.out.println("Value : " +products.get(1));  
	  }

}
