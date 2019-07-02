package ara.javaBasics.Java.com;

import java.io.FileReader;

public class Readfile_usingfilereader{
	//https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

	// Java Program to illustrate reading from 
	// FileReader using FileReader 
	 
	
	
	public static void main(String[] args) throws Exception 
	{ 
		// pass the path to the file as a parameter 
		FileReader fr = 
		new FileReader("C:\\SELENIUM\\readfile\\readfile.txt"); 

		int i; 
		while ((i=fr.read()) != -1) 
		System.out.print((char) i); 
	} 
	} 

	

