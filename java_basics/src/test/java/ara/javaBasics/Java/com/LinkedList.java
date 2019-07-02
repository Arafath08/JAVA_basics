package ara.javaBasics.Java.com;

import java.util.Iterator;

public class LinkedList {

	
	public static void main(String[] args) {
		
		//LinkedList<String> LL= new LinkedList<String>();
		java.util.LinkedList<String> LL= new java.util.LinkedList<String>();
		
		//add
		LL.add("Test");
		LL.add("Test1");
		LL.add("Test3");
		LL.add("Test4");
		
		//print
		System.out.println("Content of Linked:" +LL);
		
		//addFirst
		LL.addFirst("Arafath");
		//addLast
		LL.addLast("Meeran");
		System.out.println("Content of Linked:" +LL);
	
		//get 
		System.out.println(LL.get(0));
		
		//Set
		LL.set(0,"ARAFA");
		System.out.println(LL.get(0));
		
		//remove
		LL.removeFirst();
		LL.removeLast();
		System.out.println("Content of Linked:" +LL);
		
		//remove through Index
		LL.remove(1);
		System.out.println("Content of Linked:" +LL);
		
		//How to Print values in Linked List
		//1. for loop
		System.out.println("**********for loop***************");
		int i;
		for( i = 0;i<LL.size();i++) {
		System.out.println(LL.get(i));	
		}
		
		//2.Advance for loop
		System.out.println("**********Advance for loop***************");
		for(String str:LL) {
			System.out.println(str);
		}
		
		//iterator
		
		System.out.println("**********iterator***************");
		Iterator<String>it=LL.iterator();
		while(it.hasNext()){
			System.out.println(it.next());	
		}
		
		//While loop
		System.out.println("**********While loop***************");
		int i1 = 0;
		while(LL.size()>i1) {
			System.out.println(LL.get(i1));
			i1++;
		}
		
	
		
		
		
		
		
		
		
	}

	


}
