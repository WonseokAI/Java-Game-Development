package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        // stage > scene > container > node
        MenuBar menuBar = new MenuBar();

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu source = new Menu("Source");

        Menu source2 = new Menu("Source2");

        source.getItems().add(source2);

        MenuItem i1 = new Menu("One");
        MenuItem i2 = new Menu("Two");

        source2.getItems().addAll(i1, i2);

        menuBar.getMenus().add(file);
        menuBar.getMenus().add(edit);
        menuBar.getMenus().add(source);


        // check 표시되는 메뉴 아이템
        CheckMenuItem item2 = new CheckMenuItem("Always On Top");
        item2.setOnAction(e->{
            System.out.println("item2 clicked");
        });
        // item2.isSelected();
        MenuItem item1 = new MenuItem("IsChecked?");
        // 단축키 설정
        item1.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        // 버튼 Action 설정
        item1.setOnAction(e->{
            if(item2.isSelected()) {
                System.out.println("It is selected");
            }else{
                System.out.println("It is not selected");
            }
        });


        file.getItems().add(item1);
        file.getItems().add(item2);


        StackPane pane = new StackPane();
        pane.getChildren().add(menuBar);

        StackPane.setAlignment(menuBar, Pos.TOP_CENTER);

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setTitle("MenuBar");
        stage.setWidth(825);
        stage.setHeight(550);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
