/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplodebotoes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author alessandrovivas
 */
public class ArrayToggleButtonGridPane extends Application {
   
    @Override
    public void start(Stage primaryStage) {
          // cria Layout Grid Pane
       GridPane gridPane = new GridPane();
            
       // cria um arrray de button
       ToggleButton[][] btn = new ToggleButton[5][5];
              
        
       //dois loops para adicionar os buttons ao layout
        for(int i=0; i<btn.length; i++){
                for(int j=0; j<btn.length;j++){
                      
                        //Initializing 2D buttons with values i,j
                        btn[i][j] = new ToggleButton(""+i+","+""+j);
                        btn[i][j].setPrefSize(50, 50);
                        gridPane.add(btn[i][j], i, j); 
                        }
        }
       
        Scene scene = new Scene(gridPane);
       
        primaryStage.setTitle("ToggleButton e GridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
