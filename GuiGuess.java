import java.util.*;
import java.io.*;
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;


public class GuiGuess extends Application{

   private TextField tfUpperLimit = new TextField();
   private TextField tfGuess = new TextField();
   private TextField tfBoundaries = new TextField();
   private Button btGuess = new Button("Enter");
   private Button btExit = new Button("Quit");
   private Button btPlayAgain = new Button("Play Again");
   private Guess gameGuess;
   private int count;
   private int count2;

   @Override
      public void start(Stage primaryStage){
         BorderPane masterPane = new BorderPane();



         //UI
         GridPane gridPaneTop = new GridPane();

         gridPaneTop.setPadding(new Insets(25,10,10,10));
         gridPaneTop.setHgap(10);
         gridPaneTop.setVgap(10);
         gridPaneTop.add(new Label("Enter Upper Boundary for guessing:"), 0,0);
         gridPaneTop.add(tfUpperLimit, 0,1);
         gridPaneTop.add(new Label("Enter Your guess:"), 0, 2);
         gridPaneTop.add(tfGuess,0,3);
         HBox hbox3 = new HBox();
         hbox3.setSpacing(15);
         hbox3.setAlignment(Pos.CENTER);
         hbox3.getChildren().addAll(btGuess, btExit);
         gridPaneTop.add(hbox3, 0,5);

         masterPane.setLeft(gridPaneTop);

         GridPane gridPaneCenter = new GridPane();
         Rectangle centerRectangle = new Rectangle(500,300);
         centerRectangle.setFill(Color.BLACK);
         gridPaneCenter.add(centerRectangle,0,0);
         gridPaneCenter.setValignment(centerRectangle,VPos.CENTER);
         gridPaneCenter.setHalignment(centerRectangle,HPos.CENTER);
         gridPaneCenter.setAlignment(Pos.CENTER);
         gridPaneTop.setAlignment(Pos.TOP_LEFT); 
         masterPane.setCenter(gridPaneCenter);

         Scene scene = new Scene(masterPane, 1000, 500);
         primaryStage.setTitle("Guessing Game");
         primaryStage.setScene(scene);
         primaryStage.show();


         btExit.setOnAction(e ->{
            primaryStage.close();
         });


         btGuess.setOnAction(e ->{

               // try{
               if(count == 0){
               count++;
               gameGuess = generateGame();
               }
               if(Integer.parseInt(tfGuess.getText()) == gameGuess.getGameNumber()){
               GridPane gridPaneTop3 = new GridPane();
               gridPaneTop3.setPadding(new Insets(25,10,10,10));
               gridPaneTop3.setHgap(10);
               gridPaneTop3.setVgap(10);
               gridPaneTop3.add(new Label("You guessed correctly! " + gameGuess.getGameNumber()), 0, 1);
               gridPaneTop3.add(btExit, 0, 8); 
               centerRectangle.setFill(Color.RED);
               masterPane.setLeft(gridPaneTop3);

               HBox hbox2 = new HBox();
               // hbox2.setPadding(new Insets(0,15,0,15));
               hbox2.setSpacing(15);
               hbox2.setAlignment(Pos.CENTER);
               hbox2.getChildren().add(btExit);
               gridPaneTop3.add(hbox2, 0,8);



               Rectangle winCover = new Rectangle(500,300);
               winCover.setFill(Color.MEDIUMSPRINGGREEN);
               gridPaneCenter.add(winCover,0,0);
               gridPaneCenter.setValignment(winCover,VPos.CENTER);
               gridPaneCenter.setHalignment(winCover,HPos.CENTER);
               gridPaneCenter.setAlignment(Pos.CENTER);
               gridPaneTop.setAlignment(Pos.TOP_LEFT); 

               Rectangle arrowCover = new Rectangle(80,500);
               arrowCover.setFill(Color.rgb(245,245,245));
               GridPane arrowCoverPane = new GridPane();
               arrowCoverPane.add(arrowCover, 0, 0);
               masterPane.setRight(arrowCoverPane);

               Text winText = new Text();
               winText.setTextAlignment(TextAlignment.CENTER);
               winText.setFill(Color.BLACK);
               winText.setFont(Font.font("Times New Roman",FontWeight.BOLD, 80));
               winText.setText(" " + gameGuess.getGameNumber());
               gridPaneCenter.add(winText,0,0);

               gridPaneCenter.setHalignment(winText,HPos.CENTER);


               }
               else{ 
                  Random random = new Random();
                  GridPane gridPaneTop2 = new GridPane();
                  gridPaneTop2.setPadding(new Insets(25,10,10,10));
                  gridPaneTop2.setHgap(10);
                  gridPaneTop2.setVgap(10);
                  gridPaneTop2.add(new Label("Incorrect guess, try again!"), 0, 1);
                  gridPaneTop2.add(new Label("Enter Your guess:"), 0, 2);
                  gridPaneTop2.add(tfGuess,0,3);
                  gridPaneTop2.add(new Label("Your Boundaries are: 0 - " + 
                           gameGuess.getUpperBound()), 0, 6);

                  HBox hbox2 = new HBox();
                  hbox2.setPadding(new Insets(0,15,0,15));
                  hbox2.setSpacing(15);
                  hbox2.setAlignment(Pos.CENTER);
                  hbox2.getChildren().addAll(btGuess, btExit);
                  gridPaneTop2.add(hbox2, 0,5);




                  centerRectangle.setFill(Color.BLACK);
                  Rectangle numberCover = new Rectangle(200,200);
                  gridPaneCenter.add(numberCover,0,0);
                  gridPaneCenter.setHalignment(numberCover, HPos.CENTER);
                  Text guessText = new Text();
                  guessText.setTextAlignment(TextAlignment.CENTER);
                  guessText.setFill(Color.WHITE);
                  guessText.setFont(Font.font("Times New Roman",FontWeight.BOLD, 80));
                  guessText.setText(" " + tfGuess.getText() + " ");
                  gridPaneCenter.add(guessText,0,0);
                  //  gridPaneCenter.add(guessText,0,0);
                  gridPaneCenter.setHalignment(guessText,HPos.CENTER);

                  masterPane.setLeft(gridPaneTop2);

                  GridPane arrowPane = new GridPane();
                  Rectangle arrowLayout = new Rectangle(80,500);
                  arrowLayout.setFill(Color.rgb(245,245,245));
                  GridPane arrowGridPane = new GridPane();

                  arrowPane.add(arrowLayout, 0,0);
                  Polygon arrowShape = new Polygon();
                  if (Double.parseDouble(tfGuess.getText()) > 
                        gameGuess.getGameNumber()){
                     arrowShape.getPoints().addAll(new Double[] {
                           85.0, 0.0,
                           115.0, 0.0,
                           115.0, 60.0,
                           85.0, 60.0,
                           85.0, 0.0,
                           85.0, 60.0,
                           70.0, 60.0, 
                           100.0, 90.0,
                           130.0, 60.0, 
                           85.0, 60.0});
                  }
                  else if(Double.parseDouble(tfGuess.getText()) < 
                        gameGuess.getGameNumber()){
                     arrowShape.getPoints().addAll(new Double[] {
                           100.0,30.0, 
                           70.0, 60.0,
                           130.0, 60.0,
                           100.0,30.0,
                           70.0,60.0,
                           85.0, 60.0,
                           85.0, 120.0,
                           115.0, 120.0,
                           115.0, 60.0}); 
                  }
                  if(Math.abs((Double.parseDouble(tfGuess.getText()) - 
                              gameGuess.getGameNumber())) >= 10){
                     arrowShape.setFill(Color.BLUE);
                  }
                  else if(Math.abs((Double.parseDouble(tfGuess.getText()) -
                              gameGuess.getGameNumber())) <= 5){
                     arrowShape.setFill(Color.RED);
                  }

                  else if(Math.abs((Double.parseDouble(tfGuess.getText()) - 
                              gameGuess.getGameNumber())) <= 10){
                     arrowShape.setFill(Color.BLACK);
                  }

                  arrowPane.add(arrowShape,0,0);
                  arrowGridPane.add(arrowPane,0,0);

                  arrowGridPane.setValignment(arrowPane,VPos.CENTER);
                  arrowGridPane.setHalignment(arrowPane,HPos.CENTER);

                  arrowPane.setValignment(arrowShape,VPos.CENTER);
                  arrowPane.setHalignment(arrowShape,HPos.CENTER);


                  arrowPane.setValignment(arrowLayout,VPos.CENTER);
                  arrowPane.setHalignment(arrowLayout,HPos.CENTER);


                  masterPane.setRight(arrowGridPane);
               }



         });



         //properties for UI
         tfGuess.setAlignment(Pos.BOTTOM_LEFT);
         tfUpperLimit.setAlignment(Pos.BOTTOM_LEFT);
         tfBoundaries.setAlignment(Pos.BOTTOM_LEFT);


         }


         private Guess generateGame(){
            int guess = Integer.parseInt(tfGuess.getText());
            int upperBound = Integer.parseInt(tfUpperLimit.getText());
            tfBoundaries.setText("0 - " + upperBound);
            Guess gameGuess = new Guess(guess, 0, upperBound);
            count++;
            return gameGuess;

         }

         private void Reset(){
            count = 0;
            TextField tfUpperLimit = new TextField();
            TextField tfGuess = new TextField();
            TextField tfBoundaries = new TextField();
            Button btGuess = new Button("Enter");
            Button btExit = new Button("Quit");
            Button btPlayAgain = new Button("Play Again");
            Guess gameGuess = null;


         }

      }

