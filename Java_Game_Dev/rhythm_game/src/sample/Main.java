package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    private Image screenImage;
    private GraphicsContext screenGraphic;

    private Image introBackground;

    @Override
    public void start(Stage stage) throws Exception{

        stage.setTitle("Dynamiuc Beat");
        stage.setMinWidth(SCREEN_WIDTH);
        stage.setMinHeight(SCREEN_HEIGHT);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
