package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // stage > scene > container > node

        Rectangle rec = new Rectangle(100, 100, Color.BLUE);
        // StackPane에 node를 넣으면 항상 노드가 가운데로 정렬된다.
        // Pane은 그냥 (0,0)부터 배치한다.
        // setLayout은 Pane에서 사용해야 효과가 있다(StackPane에선 효과가 없다).
        // setLayout은 Container를 중심으로 (0,0)이 형성된다.
        rec.setLayoutX(100);
        rec.setLayoutY(100);
        // setTranslate는 setLayout을 기준으로 (0,0)이 형성된다.
        rec.setTranslateX(100);
        rec.setTranslateY(100);

        /*
        * 결국 setLayout은 가장 처음에 노드의 좌표를 정하고 움직일 계획이 없을 때 사용하고,
        * setTranslate는 나중에 노드의 좌표를 바꾸고 싶을 때 사용하자.
        * */

        Rectangle rec2 = new Rectangle(100, 100, Color.TRANSPARENT);
        rec2.setStroke(Color.RED);
        rec2.setTranslateX(100);
        rec2.setTranslateY(100);

//        scene.setOnMouseMoved(e->{
//            rec.setTranslateX(e.getSceneX());
//            rec.setTranslateY(e.getSceneY());
//        });

        // 결국에 객체가 어디에 속해 있느냐에 따라서 위치가 결정된다 -> 상대적인 위치를 가진다.

        root.getChildren().addAll(rec, rec2);

        stage.setScene(scene);
        stage.show();
    }

    StackPane pane = new StackPane();
    // 원하는 좌표에 노드를 배치하기에 Pane에 StackPane보다 더 좋다.
    Pane root = new Pane();
    Scene scene = new Scene(root, 800, 500);

    public static void main(String[] args) {
        launch(args);
    }
}
