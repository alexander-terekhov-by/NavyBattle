package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.view.ChooseAIMenu;

/**
 * Created by Александр on 02.11.2014.
 */
public class EndOfGameMessage {
    public EndOfGameMessage(String message) {
        Stage primaryStage = new Stage();
        VBox root = new VBox();
        Label label = new Label(message);
        label.setFont(Font.font("sans-serif", 20));
        primaryStage.setResizable(false);
        primaryStage.setTitle("");
        root.getChildren().add(label);
        primaryStage.setScene(new Scene(root, 150, 100));
        primaryStage.show();
    }
}
