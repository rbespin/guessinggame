
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

public class FlashCard extends Application{

   /*   public static void main(String[] args) throws IOException{
        CardGetter.saveQuestion("TestInputQuestion.md", "TestOutputQuestion.md");

        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("UserInput");
        String userInput = "$#";
        while (!(userInput.equals("22"))){
        userInput = scanner.next();
        if(userInput.equals("endinput")){
        continue;
        }
        printWriter.print(userInput + " ");
        }
        printWriter.close(); 


        }  */
   @Override
      public void start(Stage primaryStage) throws IOException{
         GridPane pane = new GridPane();
         pane.setAlignment(Pos.CENTER);
         pane.setPadding(new Insets(11.5, 20, 13.5, 20));
         pane.setStyle("-fx-background-color: rgb(187, 173, 160)");
         // Set the spacing between the Tiles
         pane.setHgap(15); 
         pane.setVgap(15);

         BorderPane mainPane = new BorderPane();

         Scene scene = new Scene(mainPane);
         primaryStage.setTitle("Flash Cards");
         primaryStage.setScene(scene);

         Scanner scanner = new Scanner(System.in);
         PrintWriter printWriter = new PrintWriter("UserInput");
         String userInput = "$#";
         Text textRectangle = new Text();
         textRectangle.setFont(Font.font("Arial", 20));
         textRectangle.setFill(Color.BLACK);
         String userInputStrings = " ";

         /*         while (!(userInput.equals("22"))){
                    userInput = scanner.nextLine();
                    if(userInput.equals("22")){
                    System.out.println("done accepting commands");
                    continue;
                    }
                    StringBuilder sb = new StringBuilder(userInput);
                    int i = 0;
                    while((i = sb.indexOf(" ", i+30))!= -1){
                    sb.replace(i,i+1, "\n");
                    }
         //   String parsedStr = userInput.replaceAll("(.{50})", "$1\n");
         userInputStrings = userInputStrings + "\n" + sb;

         textRectangle.setText(userInputStrings);
         printWriter.print(userInput + " ");
         }
         printWriter.close();  */

         System.out.println("Please enter a file to load, and a file to save to. If the" 
               + "output file is not created yet, it will be saved to what you enter");
         String userInputFile = scanner.next();
         String userOutputFile = scanner.next();

         Text textRectangle2 = new Text();
         textRectangle2.setFont(Font.font("Arial", 20));
         textRectangle2.setFill(Color.BLACK);


         CardGetter.saveQuestion(userInputFile, userOutputFile);
         String userInputStrings2 = " ";

         File myFile = new File(userOutputFile);

         Scanner scanner2 = new Scanner(myFile);
         while(scanner2.hasNext()){
            StringBuilder sb = new StringBuilder(scanner2.nextLine());
            int i = 0;
            while((i = sb.indexOf(" ", i+50))!= -1){
               sb.replace(i,i+1, "\n");
            }
            userInputStrings = userInputStrings + "\n" + sb;
            textRectangle.setText(userInputStrings);
         }



         System.out.println("please enter flash card answer");
         String userInputFile2 = scanner.next();
         File myFile2 = new File(userInputFile2);

         Scanner scanner3 = new Scanner(myFile2);
         while(scanner3.hasNext()){
            StringBuilder sb2 = new StringBuilder(scanner3.nextLine());
            int i = 0;
            while((i = sb2.indexOf(" ", i+50))!= -1){
               sb2.replace(i,i+1, "\n");
            }
            userInputStrings2 = userInputStrings2 + "\n" + sb2;
            textRectangle2.setText(userInputStrings2);
         }





         ScrollPane scrollPane = new ScrollPane(pane);
         //         scrollPane.setStyle("-fx-background-insets: 0; -fx-padding: 0;");
         scrollPane.setStyle("-fx-background-insets: 0; -fx-padding: 0;");
         //     scrollPane.setFitToWidth(true);
         scrollPane.addEventFilter(ScrollEvent.SCROLL,new EventHandler<ScrollEvent>() {
               @Override
               public void handle(ScrollEvent event) {
               if (event.getDeltaX() != 0) {
               event.consume();
               }
               }
               });
         //   scrollPane.setBackground(new Background(new BackgroundFill(
         //     Color.TRANSPARENT, null, null)));
         GridPane.setHgrow(textRectangle, Priority.ALWAYS);
         GridPane.setVgrow(textRectangle, Priority.ALWAYS);
         GridPane.setHgrow(textRectangle2, Priority.ALWAYS);
GridPane.setVgrow(textRectangle2, Priority.ALWAYS);
         Rectangle rectangle = new Rectangle(0,0,300,300);
         Rectangle lowerRectangle = new Rectangle(0,0,300,300);
              rectangle.setFill(Color.rgb(187,173,160));
              lowerRectangle.setFill(Color.rgb(187,173,160));

         pane.add(rectangle, 0, 0);
         pane.add(textRectangle,0,0);
         pane.add(lowerRectangle, 0, 1);
         pane.add(textRectangle2, 0, 1);

         HBox hBox = new HBox();
         Text hBoxText = new Text();
         hBoxText.setFont(Font.font("Arial", 20));
         hBoxText.setFill(Color.BLACK);
         hBoxText.setText("Title of Flash Card thing");
         hBox.getChildren().add(hBoxText);
         hBox.setAlignment(Pos.CENTER);
         hBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
         hBox.setStyle("-fx-background-color: rgb(147, 143, 120)");

         mainPane.setTop(hBox);

         GridPane.setHalignment(textRectangle, HPos.CENTER);
         GridPane.setHalignment(textRectangle2, HPos.CENTER);

         mainPane.setCenter(scrollPane);

         primaryStage.show();

      }



}

