package Work10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Caculate extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        GridPane pane = new GridPane();
//        pane.setAlignment(Pos.CENTER);
//        pane.setPadding(new Insets(11,12,13,14));
//        pane.setVgap(5);
//        pane.setHgap(5);
//        pane.add(new TextField(),0,0);
//        pane.add(new Button("7"),0,1);
//        pane.add(new Button("8"),1,1);
//        pane.add(new Button("9"),2,1);
//        pane.add(new Button("*"),3,1);

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(15,15,15,15));
        pane.setHgap(15);
        pane.setVgap(15);
        pane.getChildren().addAll(new TextField(),new Button("7"),new Button("8"),new Button("9"),new Button("*")
                                ,new Button("4"),new Button("5"),new Button("6"),new Button("/")
                                ,new Button("1"),new Button("2"),new Button("3"),new Button("C")
                                ,new Button("0"),new Button("+"),new Button("-"),new Button("="));

        Scene scene = new Scene(pane,200,250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
