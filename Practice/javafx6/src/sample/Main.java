package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // stage > scene > container > node

        // 그림 그릴 수 있게 하는 도구
        gc = canvas.getGraphicsContext2D();
        // 선의 색 정하기
        gc.setStroke(Color.BLACK);
        // 선의 굵기 정하기
        gc.setLineWidth(1);

        pane.getChildren().addAll(canvas, grid);
        // 처음 색깔을 검정으로 설정
        cp.setValue(Color.BLACK);
        // cp가 선택 되었을 때,
        cp.setOnAction(e->{
            gc.setStroke(cp.getValue());
        });
        //pane.setStyle("-fx-background-color: yellow;");

        slider.setMin(1);
        slider.setMax(100);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        // 값을 계속 듣고 있다가, 값이 바뀌면 람다식 안의 코드를 실행.
        slider.valueProperty().addListener(e->{
            double value = slider.getValue();
            String str = String.format("%.1f", value); // value 값을 소수점 1자리 까지만 표현
            label.setText(str);
            gc.setLineWidth(value);
        });

        // grid에 slider와 label 추가
        grid.addRow(0, cp, slider, label);
        grid.setHgap(20);
        grid.setAlignment(Pos.TOP_CENTER);
        // 위쪽 여백만 20을 준다.
        grid.setPadding(new Insets(20, 0, 0, 0));

        scene.setOnMousePressed(e->{
            // 마우스를 누른 순간부터 선을 그리기 시작하겠다.
            gc.beginPath();
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();
        });
        // 마우스를 누르고 있을 때, 계속 점을 찍는다.
        scene.setOnMouseDragged(e->{
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();

        });

        stage.setScene(scene);
        stage.show();

    }

    Label label = new Label("1.0");
    // 도화지
    Canvas canvas = new Canvas(800, 500);
    GraphicsContext gc;
    ColorPicker cp = new ColorPicker();
    Slider slider = new Slider();
    GridPane grid = new GridPane();

    StackPane pane = new StackPane();
    Scene scene = new Scene(pane, 800, 500);


    public static void main(String[] args) {

        launch(args);
    }
}
