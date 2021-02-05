package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // stage > scene > container > node

        //Label label1 = new Label("Hello");
        //Label label2 = new Label("World");

        //grid.addColumn(0, label1, label2);    // Grid 세로 정렬
        //grid.addRow(0, label1, label2 );      // Grid 가로 정렬
        //grid.setHgap(10);                       // label 사이에 가로 공간 넣기
        //grid.setVgap(10);                       // label 사이에 세로 공간 넣기
        //grid.setAlignment(Pos.CENTER);

//        for (int y = 0; y < 10; y++){
//            for (int x = 0; x < 10; x++){
//                Label label = new Label();
//                label.setStyle("-fx-border-color: black; -fx-font-size: 15");
//                label.setText(" ("+x+","+y+") ");
//                grid.addRow(y, label);
//            }
//        }

        Label label1 = new Label("A");
        Label label2 = new Label("B");
        Label label3 = new Label("C");

        label1.setStyle("-fx-border-color: black; -fx-font-size: 30");
        label2.setStyle("-fx-border-color: black; -fx-font-size: 30");
        label3.setStyle("-fx-border-color: black; -fx-font-size: 30");

        grid.add(label1, 0, 0, 1, 1); // span은 얼마나 차지하느냐를 나타냄
        grid.add(label2, 0, 1, 1, 1);
        grid.add(label3, 1, 1, 1, 1);

        grid.setAlignment(Pos.CENTER);

        stage.setScene(scene);
        stage.show();
    }

    GridPane grid = new GridPane();
    Scene scene = new Scene(grid, 400, 400);

    public static void main(String[] args) {

        launch(args);
    }
}
