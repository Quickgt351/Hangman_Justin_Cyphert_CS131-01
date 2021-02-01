


import java.util.*;
import java.io.*;



public class Hangman{
   
   Dictionary dict;
   
   int wins, looses;
  
   /**
    * 
    * @throws FileNotFoundException checks and initializes Dictionary
    */
   public Hangman() throws FileNotFoundException{
       dict = new Dictionary();      
   }
  /**
   * 
   * @throws  Checks for winloss text file
   */
   
   public void loadWL() throws FileNotFoundException{
       
           Scanner sc = new Scanner(new FileReader("winloss.txt"));
           String [] wl = sc.next().trim().split(",");
           wins = Integer.parseInt(wl[0]);
           looses = Integer.parseInt(wl[1]);
           sc.close();
       }
       
   /**
    * 
    * @throws  Checks to see if the file is written to winloss Text field
    */
  
   
   public void writeWL() throws IOException{
       
           BufferedWriter br = new BufferedWriter(new FileWriter("winloss.txt"));
           br.write(wins + "," + looses);
           br.close();
     
   }
  /**
   * 
   * @param Starts a loop until either N is entered when asked the guesscount is 0 or the correct word is guessed
   */
   public void playGame() throws IOException{
           
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               
               while(true){
      
                   System.out.print("Do you want to play ? (y / n): ");
                   String ch = br.readLine();
                   if(!ch.equals("y"))
                       break;
    /**
     * Gets a random word from the dictionary, and sets up a new string for the guessed word.  Sets the guess count to 6  
     */
                   
                   String word = dict.chooseWord();
                   int wl = word.length();
                  
                   char [] guess = new char[wl];
                   int i;
                  
                   
                   int guesscount = 6;
                   char c;
                   boolean found;
                  
                   
                   for(i = 0; i < wl; i++){
                       guess[i] = '-';
                   }
                  
                   
                   while(guesscount > 0){
                       System.out.println();
                       
                       for(i = 0; i < wl; i++)
                           System.out.print(guess[i]);
                       System.out.println();
                      
                       
                       System.out.printf("You have " +guesscount );
                       System.out.print(" Incorrect guesses left ");
                       
                       
                       ch = br.readLine();
                       if(ch.length() != 1){
                           
                           System.out.println("Invalid Entry");
                       }
                       else{
                           c = ch.charAt(0);
                           found = false;
                          
                           for(i = 0; i < wl; i++){
                               if(word.charAt(i) == c && guess[i] == '-'){
                                   
                                   guess[i] = c;
                                   found = true;
                               }
                           }
                          
                           if(!found){
                               
                               guesscount--;
                           }
                       }
                      
                 
                       found = false;
                       for(i = 0; i < wl; i++){
                           if(guess[i] == '-'){
                               found = true;
                               break;
                           }
                       }
                      
                       
                       if(!found)
                           break;
                   }
                  
                   
                   if(guesscount == 0){
                	   System.out.println();
                       System.out.println("You are out of guesses! You lost!");
                   
                       looses++;
                   }
                   else{
                       
                       System.out.println();
                       for(i = 0; i < wl; i++)
                       System.out.print(guess[i]);
                       System.out.println();
                       System.out.println("\nYou won!");
                       wins++;
                       System.out.println();
                   }
                   System.out.println();
                   System.out.printf("You have "+wins);
                   System.out.printf(" Wins and " +looses);
                   System.out.println(" looses:");
                   System.out.println();
                   
               }
              
           
       }
}