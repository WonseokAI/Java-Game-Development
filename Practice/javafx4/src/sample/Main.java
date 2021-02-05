package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        // Image를 사용하기 위한 class : ImageView
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(300);
        iv.setFitWidth(300);
        iv.setPreserveRatio(true); // 원본 사이즈 유지 : True
        iv.setRotate(90);

        pane.getChildren().add(iv);

        stage.setScene(scene);
        stage.show();

    }

    Image image = new Image("file:ybob.jpg");

    StackPane pane = new StackPane();
    Scene scene = new Scene(pane, 500, 500);

    public static void main(String[] args) {
        launch(args);
    }
}
