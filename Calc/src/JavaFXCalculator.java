import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class JavaFXCalculator extends Application {
   private Text memoryDisplay;
   private TextField tfDisplay;    // display textfield
   // For computation
   private double result = 0.0;      // Result of computation
   private double memoryValue = 0.0;
   private String inStr = "0";  // Input number as String
   // Previous operator: ' '(nothing), '+', '-', '*', '/', '='
   private char lastOperator = ' ';

   // Event handler for all the 16 Buttons
   EventHandler<ActionEvent> handler = evt -> {
      String currentBtnLabel = ((Button)evt.getSource()).getText();
      switch (currentBtnLabel) {
         // Number buttons
         case "0": case "1": case "2": case "3": case "4":
         case "5": case "6": case "7": case "8": case "9":
            if (inStr.equals("0")) {
               inStr = currentBtnLabel;  // no leading zero
            } else {
               inStr += currentBtnLabel; // append input digit
            }
            tfDisplay.setText(inStr);
            // Clear buffer if last operator is '='
            if (lastOperator == '=') {
               result = 0;
               lastOperator = ' ';
            }
            break;

         // Operator buttons: '+', '-', 'x', '/' and '='
         case "+":
            compute();
            lastOperator = '+';
            break;
         case "-":
            compute();
            lastOperator = '-';
            break;
         case "x":
            compute();
            lastOperator = '*';
            break;
         case "\u00F7":
            compute();
            lastOperator = '\u00F7';
            break;
         case "=":
            compute();
            lastOperator = '=';
            break;
         case "\u2198":
        	 if (inStr.length() == 1) {
        		 inStr.equals("0");
        	 }else {
        		 inStr = inStr.substring(0, inStr.length() - 1);
        	 }
        	 tfDisplay.setText(inStr);
        	 break;
         case "^":
        	 compute();
        	 lastOperator = '^';
        	 break;
         case "\u221A":
        	 if (lastOperator != '=') {
        		 result = Double.parseDouble(inStr);
        	 }
        	 result = Math.sqrt(result);
        	 inStr = Double.toString(result);
        	 tfDisplay.setText(inStr);
        	 lastOperator = '\u221A';
        	 break;
         // Clear button
         case "C":
            result = 0;
            inStr = "0";
            lastOperator = ' ';
            tfDisplay.setText("0");
            break;
         case "M+":
        	 if (lastOperator != '=') {
        		 memoryValue += Double.parseDouble(inStr);
        	 } else {
        		 memoryValue += result;
        	 }
        	 memoryDisplay.setText("Memory = " + memoryValue);
        	 lastOperator = ' ';
        	 break;
         case "M-":
        	 if (lastOperator != '=') {
        		 memoryValue -= Double.parseDouble(inStr);
        	 } else {
        		 memoryValue -= result;
        	 }
        	 memoryDisplay.setText("Memory = " + memoryValue);
        	 lastOperator = ' ';
        	 break;
         case "MR":
        	 inStr = String.valueOf(memoryValue);
        	 lastOperator = ' ';
        	 break;
         case "MC":
        	 memoryValue = 0.0;
        	 memoryDisplay.setText("Memory is " + memoryValue);
        	 lastOperator = ' ';
        	 break;
      }
   };

   // User pushes '+', '-', '*', '/' or '=' button.
   // Perform computation on the previous result and the current input number,
   // based on the previous operator.
   private void compute() {
      int inNum = Integer.parseInt(inStr);
      inStr = "0";
      if (lastOperator == ' ') {
         result = inNum;
      } else if (lastOperator == '+') {
         result += inNum;
      } else if (lastOperator == '-') {
         result -= inNum;
      } else if (lastOperator == '*') {
         result *= inNum;
      } else if (lastOperator == '\u00F7') {
         result /= inNum;
      } else if (lastOperator == '^') {
          result = Math.pow(result, inNum);
      } else if (lastOperator == '\u221A') {
          result = Math.sqrt(inNum);
      } else if (lastOperator == '=') {
         // Keep the result for the next operation
      }
      tfDisplay.setText(result + "");
   }

   // Setup the UI
   @Override
   public void start(Stage primaryStage) {
	  Button[] btns = new Button[24];          // 16 buttons
	  String[] btnLabels = {  // Labels of 16 buttons
	     "7", "8", "9", "+",
	     "4", "5", "6", "-",
	     "1", "2", "3", "x",
	     ".", "0", "=", "\u00F7",
	     "C", "\u2190", "^", "\u221A",
	     "M+", "M-", "MR", "MC"
	   };
	  memoryDisplay = new Text("Memory = 0.0");
      // Setup the Display TextField
      tfDisplay = new TextField("0");
      tfDisplay.setEditable(false);
      tfDisplay.setAlignment(Pos.CENTER_RIGHT);

      // Setup a GridPane for 4x4 Buttons
      int numCols = 4;
      GridPane paneButton = new GridPane();
      paneButton.setPadding(new Insets(15, 0, 15, 0));  // top, right, bottom, left
      paneButton.setVgap(5);  // Vertical gap between nodes
      paneButton.setHgap(5);  // Horizontal gap between nodes
      // Setup 4 columns of equal width, fill parent
      ColumnConstraints[] columns = new ColumnConstraints[numCols];
      for (int i = 0; i < numCols; ++i) {
         columns[i] = new ColumnConstraints();
         columns[i].setHgrow(Priority.ALWAYS) ;  // Allow column to grow
         columns[i].setFillWidth(true);  // Ask nodes to fill space for column
         paneButton.getColumnConstraints().add(columns[i]);
      }

      // Setup 16 Buttons and add to GridPane; and event handler
      for (int i = 0; i < btns.length; ++i) {
         btns[i] = new Button(btnLabels[i]);
         btns[i].setOnAction(handler);  // Register event handler
         btns[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);  // full-width
         paneButton.add(btns[i], i % numCols, i / numCols);  // control, col, row
         
         switch(btnLabels[i]) {
         case "M+": case "M-": case "MR": case "MC":
         	btns[i].setStyle("-fx-color: blue");
         }
         switch(btnLabels[i]) {
         case "+": case "-": case "x": case "\u221A": case "=": case "^": case "\u00F7": case "C": case "\u2190": case "1": case "2": case "3":case "4": case "5": case "6":case "7": case "8": case "9": case "0": case ".":
         	btns[i].setStyle("-fx-color: red");
         }
      }

      // Setup up the scene graph rooted at a BorderPane (of 5 zones)
      BorderPane root = new BorderPane();
      root.setPadding(new Insets(15, 15, 15, 15));  // top, right, bottom, left
      root.setTop(tfDisplay);     // Top zone contains the TextField
      root.setCenter(paneButton); // Center zone contains the GridPane of Buttons
      memoryDisplay = new Text("Memory = 0");
      root.setBottom(memoryDisplay);

      // Set up scene and stage
      primaryStage.setScene(new Scene(root, 350, 325));
      primaryStage.setTitle("JavaFX Calculator");
      primaryStage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}