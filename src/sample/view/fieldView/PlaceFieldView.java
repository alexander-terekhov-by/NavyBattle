package sample.view.fieldView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import sample.Pair;
import sample.controller.placeShipController.UserShipPlacer;

/**
 * Created by Александр on 30.10.2014.
 */
public class PlaceFieldView extends FieldView {
    public UserShipPlacer controller;
    private boolean allShipsPlaced = false;

    public boolean isAllShipsPlaced() {
        return allShipsPlaced;
    }

    public void setAllShipsPlaced(boolean allShipsPlaced) {
        this.allShipsPlaced = allShipsPlaced;
    }


    public PlaceFieldView() {
        super();
        controller = new UserShipPlacer(this);
        this.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int x = researchPositionOfSquareByClick(event.getX());
                int y =  researchPositionOfSquareByClick(event.getY());
                controller.makeShip(new Pair(x, y));
            }
        });

    }
    public void clean(){
        printBoardWeb();
        controller = new UserShipPlacer(this);
    }
}
