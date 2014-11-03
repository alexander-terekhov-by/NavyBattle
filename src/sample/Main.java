package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controller.placeShipController.ComputerShipPlacer;
import sample.view.ChooseAIMenu;
import sample.view.GameView;
import sample.view.PlaceShipsView;

public class Main extends Application {
    BorderPane root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = new BorderPane();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Navy battle");
        root.getChildren().add(new ChooseAIMenu(new GameController(this)));
        primaryStage.setScene(new Scene(root, 500, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void setNextView(Pane view) {
        root.getChildren().removeAll(root.getChildren());
        root.getChildren().add(view);

    }
}
