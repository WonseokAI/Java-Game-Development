package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        Label lName = new Label("Username: ");
        Label lPassword = new Label("Password: ");
        Label lMessage = new Label();

        TextField tfName = new TextField();
        PasswordField tfPassword = new PasswordField();

        Button button = new Button("Login");
        button.prefHeightProperty().bind(tfName.heightProperty().add(tfPassword.heightProperty()));
        button.setOnAction(e->{
            lMessage.setStyle("-fx-text-fill: red;");
            String name = tfName.getText();
            String password = tfPassword.getText();
            if(name.equals("")){
                lMessage.setText("Please enter your name");
            } else if (password.equals("")){
                lMessage.setText("Please enter your password");
            } else if (!name.equals("Wonseok") || !password.equals("password")){
                lMessage.setText(("Invalid name or pass word"));
            } else{
                lMessage.setStyle("-fx-text-fill:green;");
                lMessage.setText("Successfully logged in!");
            }
        });

        GridPane grid = new GridPane();
        grid.addRow(0, lName, tfName);
        grid.addRow(1, lPassword, tfPassword);
        grid.add(button, 2, 0, 1, 2);
        grid.add(lMessage, 0, 2, 3, 1);
        grid.setAlignment(Pos.CENTER);

        pane.getChildren().add(grid);


        stage.setScene(scene);
        stage.show();
    }

    StackPane pane = new StackPane();
    Scene scene = new Scene(pane, 800, 500);

    public static void main(String[] args) {
        launch(args);
    }
}
