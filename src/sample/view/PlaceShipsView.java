package sample.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.GameController;
import sample.view.fieldView.FieldView;
import sample.view.fieldView.PlaceFieldView;


/**
 * Created by Александр on 27.10.2014.
 */
public class PlaceShipsView extends HBox {
    private PlaceFieldView field;

    public PlaceShipsView(GameController controller){
        super(5);
        field = new PlaceFieldView();
        ButtonBar bar = new ButtonBar(controller);
        setMargin(field, new Insets(10, 10, 10, 10));
        this.getChildren().addAll(field, bar);
    }
    private class ButtonBar extends VBox {
        boolean vOrient = true;
        Button singleDeckShip;
        Button doubleDeckShip;
        Button tripleDeckShip;
        Button quadrupleDeckShip;
        Button reverse;
        Button startGame;
        Button clean;
        String resourceFolder;

        ButtonBar(final GameController controller){
            resourceFolder =  PlaceShipsView.class.getResource("../../img").toString();
            final ImageView reverseH = new ImageView(resourceFolder + "/reverseH.png");
            final ImageView reverseV = new ImageView(resourceFolder + "/reverseV.png");
            singleDeckShip = new Button("", new ImageView(resourceFolder + "/1.png"));
            doubleDeckShip = new Button("", new ImageView(resourceFolder + "/2.png"));
            tripleDeckShip = new Button("",new ImageView(resourceFolder + "/3.png"));
            quadrupleDeckShip = new Button("",new ImageView(resourceFolder + "/4.png"));
            reverse = new Button("",reverseH);
            clean = new Button("Clean");
            startGame = new Button("Start");
            this.getChildren().addAll(reverse, singleDeckShip, doubleDeckShip, tripleDeckShip, quadrupleDeckShip, clean, startGame);
            this.setMargin(reverse, new Insets(25, 0, 0, 0));
            this.setSpacing(5);
            singleDeckShip.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    field.controller.setLength(1);
                }
            });
            doubleDeckShip.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    field.controller.setLength(2);

                }
            });
            tripleDeckShip.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    field.controller.setLength(3);

                }
            });
            quadrupleDeckShip.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    field.controller.setLength(4);

                }
            });
            reverse.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    field.controller.changeOrientation();
                    if(vOrient) {
                        reverse.setGraphic(reverseV);
                        vOrient = false;
                    }
                    else {
                        reverse.setGraphic(reverseH);
                        vOrient = true;
                    }
                }
            });
            clean.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    field.clean();
                }
            });
            startGame.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (field.isAllShipsPlaced())
                        controller.startGame(field.controller.getField());
                }
            });
        }
    }

}
