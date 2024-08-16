import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnoGameFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("UNO Game with JavaFX");

        Label label = new Label("JavaFX integration example");

        VBox vbox = new VBox(label);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
