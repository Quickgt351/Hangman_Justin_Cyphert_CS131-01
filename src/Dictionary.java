import java.util.*;
import java.io.*;



public class Dictionary{
	  
	   String [] words;
	
	   int dlength;
	  
	  
	   public Dictionary() throws FileNotFoundException{
	       words = readFile();
	   }
	  
	   
	   String[] readFile() throws FileNotFoundException{
	       
	           
	           String [] words = new String[200];
	           
	           Scanner sc = new Scanner(new FileReader("words.txt"));
	           int i = 0;
	           
	           while(sc.hasNext())
	           {
	               words[i++] = sc.next().trim();
	           }
	           
	           dlength = i;
	           sc.close();
	           return words;
	       
	   }
	  
	   
	   String chooseWord(){
	      
	       int indx = (int)((Math.random() * 1000) % dlength);
	       
	       return words[indx];
	   }
	}
	
	
	
	
	
	
	

