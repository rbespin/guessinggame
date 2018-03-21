
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

public class GuessGui extends Application{
   private static GridPane pane;
   private static BorderPane mainPane;
   private static Rectangle rectangle;
   private static HBox hBox;
   private static Text hBoxText;
   private static Guess newGame;
   private static int guess;
   private static int upperLimit;
   private static int randomNumber;

   @Override
      public void start(Stage primaryStage) throws IOException{
         pane = new GridPane();
         pane.setAlignment(Pos.CENTER);
         pane.setPadding(new Insets(11.5, 20, 13.5, 20));
         pane.setStyle("-fx-background-color: rgb(0,0,0);");
         // Set the spacing between the Tiles
         pane.setHgap(15); 
         pane.setVgap(15);


         mainPane = new BorderPane();
         mainPane.setCenter(pane);
         Scene scene = new Scene(mainPane);

         rectangle = new Rectangle(0,0,400,400);
         pane.add(rectangle, 0, 0);

         HBox hBox = new HBox();
         Text hBoxText = new Text();
         hBoxText.setFont(Font.font("Arial", 20));
         hBoxText.setFill(Color.WHITE);
         hBoxText.setText("Your Guessing range is: 0 - 100");
         hBox.getChildren().add(hBoxText);
         hBox.setAlignment(Pos.CENTER);
         hBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
         hBox.setStyle("-fx-background-color: rgb(0,0,0)");

         mainPane.setTop(hBox);

         GridPane.setHalignment(rectangle, HPos.CENTER);

         newGame = new Guess();
         newGame.gameSet();
         int guess = newGame.getGuess();
         int upperLimit = newGame.getUpperBound();
         Random random = new Random();
         int randomNumber = random.nextInt(newGame.getUpperBound() + 1)
            + newGame.getLowerBound();
         callPlay();



         /*       Random random = new Random();
                  int randomNumber = random.nextInt(newGame.getUpperBound() + 1)
                  + newGame.getLowerBound();
                  newGame.recursiveGuess(randomNumber); */




         primaryStage.setTitle("Guessing Game");
         primaryStage.setScene(scene);
         primaryStage.show();



      }

   private void callPlay(){
      guess =  newGame.getGuess();
      upperLimit = newGame.getUpperBound();
      System.out.println("callplay is called");
      HBox hBox = new HBox();
      Text hBoxText = new Text();
      hBoxText.setFont(Font.font("Arial", 20));
      hBoxText.setFill(Color.WHITE);
      hBoxText.setText("Your Guessing range is: 0 - " + newGame.getUpperBound());
      hBox.getChildren().add(hBoxText);
      hBox.setAlignment(Pos.CENTER);
      hBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      hBox.setStyle("-fx-background-color: rgb(0,0,0)");
      mainPane.setTop(hBox);

      Text guessText = new Text();
      guessText.setFont(Font.font("Arial", 90));
      guessText.setFill(Color.BLACK);
      guessText.setText(Integer.toString(newGame.getGuess()));


      //add isGameOver() if game is over, add congratulatory pane
      if(newGame.getGuess() == randomNumber){
         Rectangle rectangle2 = new Rectangle(0,0,400,400);
         rectangle2.setFill(Color.BLACK);
         pane.add(rectangle2, 0, 0);
         Text guessText2 = new Text();
         guessText2.setFont(Font.font("Arial", 90));
         guessText2.setFill(Color.WHITE);
         guessText2.setText("The correct number was: " + 
               Integer.toString(newGame.getGuess()));
         pane.add(guessText2, 0, 0);
         GridPane.setHalignment(guessText2, HPos.CENTER);
         return;
      } 

      pane.add(guessText, 0, 0);
      GridPane.setHalignment(guessText, HPos.CENTER);
      rectangle.setFill(Color.WHITE);

   }
   //instance methods

}
/*public class GuessTheNumber{
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
  } */
