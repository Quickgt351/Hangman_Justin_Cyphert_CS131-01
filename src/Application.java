




import java.io.IOException;
/**
 * 
 * @author Justin Cyphert
 * 
 * CS-131-01 
 * 
 * Hangman game
 *
 *
 *
 *Creates the hangman object loads the win loss file, executes the play Game method and 
 *writes to the win Loss file
 *
 *
 */


public class Application {
   public static void main(String [] args) throws IOException{

       Hangman hm = new Hangman();
       
       hm.loadWL();  
       
       hm.playGame();
      
       hm.writeWL(); 
   }
}