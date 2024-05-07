package Work10;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ButtonTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(),500,400);

        primaryStage.setTitle("Experiment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private BorderPane getPane(){
        BorderPane pane = new BorderPane();
        Group group = new Group();

        TextField textField = new TextField();
        textField.setLayoutX(50);
        textField.setLayoutY(0);
        textField.setMinSize(500,50);


        Label label1 = new Label("left");
        label1.setLayoutX(100);
        label1.setLayoutY(80);
        label1.setMinSize(100,200);
        label1.setStyle("-fx-border-color: red; -fx-fill:null;");

        Label label2 = new Label("Right");
        label2.setLayoutX(400);
        label2.setLayoutY(80);
        label2.setMinSize(100,200);
        label2.setStyle("-fx-border-color:red;");

        Button flow1 = new Button("flow1");
        flow1.setLayoutX(100);
        flow1.setLayoutY(300);
        flow1.setMinSize(100,50);
        flow1.setStyle("-fx-stroke: black; -fx-fill: null;");

        Button flow2 = new Button("flow2");
        flow2.setLayoutX(250);
        flow2.setLayoutY(300);
        flow2.setMinSize(100,50);
        flow2.setStyle("-fx-stroke: black; -fx-fill: null;");

        Button flow3 = new Button("flow3");
        flow3.setLayoutX(400);
        flow3.setLayoutY(300);
        flow3.setMinSize(100,50);
        flow3.setStyle("-fx-stroke: black; -fx-fill: null;");

        Button number1 = new Button("1");
        number1.setLayoutX(240);
        number1.setLayoutY(100);
        number1.setMinSize(50,50);

        Button number2 = new Button("2");
        number2.setLayoutX(300);
        number2.setLayoutY(100);
        number2.setMinSize(50,50);

        Button number3 = new Button("3");
        number3.setLayoutX(240);
        number3.setLayoutY(160);
        number3.setMinSize(50,50);

        Button number4 = new Button("4");
        number4.setLayoutX(300);
        number4.setLayoutY(160);
        number4.setMinSize(50,50);

        Button number5 = new Button("5");
        number5.setLayoutX(240);
        number5.setLayoutY(220);
        number5.setMinSize(50,50);

        Button number6 = new Button("6");
        number6.setLayoutX(300);
        number6.setLayoutY(220);
        number6.setMinSize(50,50);

        group.getChildren().addAll(textField,label2,flow1,flow2,flow3,number1,number2,number3,number4,number5,number6,label1);
        pane.setCenter(group);
        return pane;
    }
}
