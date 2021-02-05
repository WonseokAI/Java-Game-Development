package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // stage > scene > container > node

        // button 크기와 container 크기 자동 조절하기
        Button button1 = new Button();
        button1.setText("Button");
        button1.prefWidthProperty().bind(pane.widthProperty());   // pane의 가로 길이와 button1의 가로 길이를 일치 시켰다.
        button1.prefHeightProperty().bind(pane.heightProperty()); // pane의 세로 길이와 button1의 세로 길이를 일치 시켰다.

        Button button2 = new Button();
        button2.setText("Test");
        // button의 최소 사이즈 정하기
//        button2.setMinWidth(50);
//        button2.setMinHeight(100);
//        button2.setMinSize(50, 100);
        // button의 최대 사이즈 정하기
//        button2.setMaxWidth(50);
//        button2.setMaxHeight(100);
//        button2.setMaxSize(50, 100);
        button2.prefWidthProperty().bind(pane.widthProperty());
        button2.prefHeightProperty().bind(pane.heightProperty());

        grid.addRow(0, button1, button2);

        pane.getChildren().add(grid);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    GridPane grid = new GridPane();
    StackPane pane = new StackPane();
    Scene scene = new Scene(pane, 100, 100);

    public static void main(String[] args) {

        launch(args);
    }
}
