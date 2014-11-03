package sample.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import sample.GameController;
import sample.controller.SmartAI;
import sample.controller.StupidAI;

/**
 * Created by Александр on 31.10.2014.
 */
public class ChooseAIMenu extends HBox {
    Button stupidAI;
    Button smartAI;

    public ChooseAIMenu(final GameController gameController){

        //setAlignment(Pos.BASELINE_CENTER);
        stupidAI = new Button("Easy computer");
        smartAI = new Button("Hard computer");
        smartAI.setMinSize(100, 40);
        stupidAI.setMinSize(100, 40);

        VBox box = new VBox(stupidAI, smartAI);
        box.setSpacing(10);
        this.setMargin(box, new Insets(20, 20, 20, 20));
        stupidAI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameController.prepareToStart(new StupidAI());


            }
        });
        smartAI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                gameController.prepareToStart(new SmartAI());

            }
        });
        this.getChildren().addAll(box);
    }
}
