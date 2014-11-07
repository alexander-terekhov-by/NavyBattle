package sample.controller.placeShipController;

import sample.drawers.ShipDrawer;
import sample.model.Ship;
import sample.view.fieldView.PlaceFieldView;

/**
 * Created by Александр on 29.10.2014.
 */
public class UserShipPlacer extends AbstractShipPlacer {
    ShipDrawer drawer;
    PlaceFieldView fieldView;
    public UserShipPlacer(PlaceFieldView fieldView) {
        super();
        this.fieldView = fieldView;
        drawer = new ShipDrawer(fieldView);
    }
    public boolean addShip(Ship ship){
            boolean wasPlaced = super.addShip(ship);
            if (wasPlaced) {
                drawer.drawShip(ship);
                areAllShipsPlaced();
            }
            return wasPlaced;
        }
    public void clean(){
        super.clean();
    }
    public void areAllShipsPlaced(){
        fieldView.setAllShipsPlaced(shipCounter.areAllShipsPlaced());
    }
}
