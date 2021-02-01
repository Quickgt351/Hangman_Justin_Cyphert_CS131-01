import java.io.IOException;


public class Application {
   public static void main(String [] args) throws IOException{
       
       Hangman hm = new Hangman();
       
       hm.loadWL();  //Loads win-loss from winloss.txt
       
       hm.playGame();//Runs the game
      
       hm.writeWL(); //  Writes win-loss to file winloss.txt
   }
}