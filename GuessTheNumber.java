import java.awt.*;
import java.util.*;

public class GuessTheNumber{
   public static void play(){
      Guess newGame = new Guess();
      newGame.gameSet();
      Random random = new Random();

      int randomNumber = random.nextInt(newGame.getUpperBound() + 1) + newGame.getLowerBound();

      newGame.recursiveGuess(randomNumber);
   }

   public static void main(String[] args){

      System.out.println("Welcome to GuessTheNumber!");
      System.out.println("If after your first guess you give up, enter -1 to give up");

      play();

      System.out.println("Play Again?" + " (y/n)");

      Scanner input = new Scanner(System.in);

      String continue1 = input.next();
      while(continue1.equals("y")){
         play();
         System.out.println("Play Again?" + " (y/n)");
         continue1 = input.next();
      }

   }
}



