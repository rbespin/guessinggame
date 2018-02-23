import java.awt.*;

import java.util.*;

public class Guess{

   private int guess;
   private int lowerBound;
   private int upperBound;

   public Guess(){
      this.lowerBound = 0;
      this.upperBound = 0;
      Random random = new Random();
      this.guess = 0;
   }

   public Guess(int guess){
      this();
      this.setGuess(guess);
   }

   public Guess(int guess, int lowerBound, int upperBound){
      this.setGuess(guess);
      this.setLowerBound(lowerBound);
      this.setUpperBound(upperBound);
   }

   public void setGuess(int guess){
      this.guess = guess;
   }

   public int getGuess(){
      return this.guess;
   }

   public void setLowerBound(int lowerBound){
      this.lowerBound = lowerBound;
   }

   public int getLowerBound(){
      return this.lowerBound;
   }

   public void setUpperBound(int upperBound){
      this.upperBound = upperBound;
   }

   public int getUpperBound(){
      return this.upperBound;
   }
   public  void ensureBounds(int lowerBound, int upperBound){
      Scanner input = new Scanner(System.in);
      if(upperBound <= lowerBound){
         System.out.println("Your upper bound is less than or equal to your lower bound, " + 
               this.getLowerBound() + ", " + "please enter a new upper bound: ");
         upperBound = input.nextInt();
         this.setUpperBound(upperBound);
         ensureBounds(lowerBound, upperBound);
      }
   }

   public  void ensureGuess(int lowerBound, int upperBound, int guess){
      Scanner input = new Scanner(System.in);
      if(this.getGuess() == -1){
         return;
      }


      if(guess < lowerBound){
         System.out.println("Your guess is less than your lower bound, " + this.getLowerBound() +
               ", " + "please enter a new guess: ");
         guess = input.nextInt();
         this.setGuess(guess);
         ensureGuess(lowerBound, upperBound, guess);
      }
      else if(guess > upperBound){
         System.out.println("Your guess is greater than your upper bound, " + this.getUpperBound() + 
               ", " + "please enter a new guess: ");
         guess = input.nextInt();
         ensureGuess(lowerBound, upperBound, guess);
      }
   }
   public void recursiveGuess(int guess){
      Scanner input = new Scanner(System.in);

      if(this.getGuess() == -1){
         System.out.println("Quitting.");
         System.out.println("The number to guess was: " + guess);
         return;
      }
      if(this.getGuess() == guess){
         System.out.println("Congratulations! You guessed correctly! The number was: " + 
               guess);
      }
      else if(this.getGuess() != guess){
         if(Math.abs(this.getGuess() - guess) > 100){
            System.out.println("Cold. Guess again: ");
         }
         else if(Math.abs(this.getGuess() - guess) > 50){
            System.out.println("You're very far away, but closer, guess again: ");
         }
         else if(Math.abs(this.getGuess() - guess) > 25){
            System.out.println("You're getting closer, guess again: ");
         }
         else if(Math.abs(this.getGuess() - guess) > 10){
            System.out.println("You're CLOSE, but guess again: ");
         }
         else if(Math.abs(this.getGuess() - guess) < 3){
            System.out.println("You're RED HOT! Guess again: ");
         }
         else{
            System.out.println("You're very very CLOSE, but guess again: ");
         }
         int newGuess = input.nextInt();
         this.setGuess(newGuess);
         this.ensureGuess(this.getLowerBound(), this.getUpperBound(), this.getGuess());
         recursiveGuess(guess);
      }
   }


   public void gameSet(){

      System.out.println();
      Scanner input = new Scanner(System.in);
      System.out.println("Please enter an upper number to guess from: ");
      int lowerBound = 0;
      System.out.println();
      System.out.println("Upper Bound: ");
      int upperBound = input.nextInt();
      System.out.println();

      System.out.println("Your bounds are from the numbers: 0-" + upperBound);
      System.out.println();
      System.out.println("Please make a guess between 0-" + upperBound);
      System.out.println();
      System.out.println("Please enter your guess: ");
      int guess = input.nextInt();
      System.out.println();
      Guess player = new Guess(guess, lowerBound, upperBound);
      player.ensureBounds(player.getLowerBound(), player.getUpperBound());
      player.ensureGuess(player.getLowerBound(), player.getUpperBound(), player.getGuess());
      this.setLowerBound(player.getLowerBound());
      this.setUpperBound(player.getUpperBound());
      this.setGuess(player.getGuess());
      System.out.println(this.toString());
   }

   public void play(){
      Guess newGame = new Guess();
      newGame.gameSet();
      Random random = new Random();

      int randomNumber = random.nextInt(newGame.getUpperBound() + 1);
      newGame.recursiveGuess(randomNumber);
   }




   @Override
      public String toString(){
         return "Your guess is: " + this.getGuess() + ", " + 
            "Your lower bound is: " + this.getLowerBound() + ", " + 
            "Your upper bound is: " + this.getUpperBound();
      }
}


