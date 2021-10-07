/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlcircle;

import com.sun.scenario.effect.impl.Renderer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author chris
 */
public class ControlCircle extends Application {
    
    Circle circulo = new Circle(50);
    Button enlarge = new Button();
    Button shrink = new Button();
    
    @Override
    public void start(Stage primaryStage) {
        
        enlarge.setText("Enlarge");
        shrink.setText("Shrink");
        
        circulo.setFill(WHITE);
        circulo.setStroke(BLACK);
        
        enlarge.setOnAction(new  Aumenta());
        shrink.setOnAction(new  Reduce());

        BorderPane root = new BorderPane();
        root.setCenter(circulo);
        
        HBox root2 = new HBox(enlarge, shrink);
        root2.setSpacing(5.0);
        root2.setPadding(new Insets(5.0));
        root2.setAlignment(Pos.CENTER);

        root.setBottom(root2);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class Aumenta implements EventHandler<ActionEvent>
    {
        
        @Override
        public void handle(ActionEvent e) {
            circulo.setRadius(circulo.getRadius() + 10);
        }
        
    }
    
    class Reduce implements EventHandler<ActionEvent>
    {
        
        @Override
        public void handle(ActionEvent e) {
            circulo.setRadius(circulo.getRadius() - 10);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
