package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // stage > scene > container > node(글씨)

        Label text = new Label();
        text.setText(Integer.toString(num)); // setText안에는 string만 올 수 있어서 toString을 사용한다.
        text.setStyle("-fx-font-size: 30; -fx-text-fill:red; -fx-background-color: yellow; -fx-border-color: black;"); // text의 style 설정하는 방법

        Button button = new Button();
        button.setText("Add");
        button.setStyle("-fx-font-size:15;"); // font size 키우면 button도 같이 커진다.
        button.setOnAction(e-> {
            num++;
            text.setText(Integer.toString(num)); // update
        });

        // Pane pane = new Pane(); // container의 한 종류
        StackPane pane = new StackPane(); // container의 한 종류
        pane.getChildren().addAll(text, button); // addAll을 사용하면 넣고 싶은 것들을 나열하면 된다.
        //pane.getChildren().add(button); container속에 node를 집어 넣을 때는 getchildren
        StackPane.setAlignment(button, Pos.BOTTOM_CENTER); // node 위치 정하는 방법


        Scene scene = new Scene(pane, 800, 500);
        stage.setScene(scene);
        stage.setTitle("javafx practice");

        //stage.setResizable(false); false로 하면 사용자가 창의 크기를 바꾸지 못한다.
        stage.show(); // 보여주려면 show를 해야 한다.

    }

    // local 변수는 lambda 식 안에서 바뀔 수 없다. 그러므로 여기에 선언했다.
    int num = 0;

    public static void main(String[] args) {
        launch(args);
    }
}
