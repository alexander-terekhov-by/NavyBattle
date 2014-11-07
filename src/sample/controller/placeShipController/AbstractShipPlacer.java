package sample.controller.placeShipController;

import sample.Pair;
import sample.controller.placeShipController.ShipCounter;
import sample.controller.placeShipController.ShipFactory;
import sample.model.Field;
import sample.model.Ship;
import sample.model.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 29.10.2014.
 */
public abstract class AbstractShipPlacer {
    Field field;
    private List<Ship> placedShips;
    ShipCounter shipCounter;
    ShipFactory factory;

    public AbstractShipPlacer(){
        field = new Field();
        placedShips = new ArrayList<>();
        shipCounter = new ShipCounter();
        factory = new ShipFactory();

    }
    public void clean(){
        field = new Field();

    }
    private boolean checkPossibilityToAddShip(Ship ship){
        return (checkShipPlacedDistantFromOther(ship) & checkShipPlacedInField(ship)) ;
    }
    private boolean checkShipPlacedDistantFromOther(Ship ship){
        if (placedShips.size() == 0)
            return  true;
        for(Square squareFromShip: ship.getSquares()) {
            for (Ship otherShip : placedShips){
                for (Square otherShipSquare: otherShip.getSquares()){
                    if(isSquaresAreNeighbours(squareFromShip, otherShipSquare)) {
                        //System.out.println("Neighbours");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean isSquaresAreNeighbours(Square one, Square two){
        int posXOfOne = one.getPosX();
        int posYOfOne = one.getPosY();
        int posXOfTwo = two.getPosX();
        int posYOfTwo = two.getPosY();
        //System.out.println(posXOfOne + " | " + posYOfOne );
        return isCoordinatesAreNeighbours(posXOfOne, posXOfTwo) && isCoordinatesAreNeighbours(posYOfOne, posYOfTwo);

    }
    private boolean isCoordinatesAreNeighbours(int one, int two){
        return (one == two) || (one == two - 1) || (one == two + 1);
    }
    private boolean checkShipPlacedInField(Ship ship){
        for(Square one: ship.getSquares())
            if (one.getPosX() > Field.SIZE - 1 || one.getPosY() >  Field.SIZE - 1) {
                //System.out.println("Out of field");
                return false;
            }

        return  true;
    }
    public boolean addShip(Ship ship){
        if(checkPossibilityToAddShip(ship)) {
            placedShips.add(ship);
            field.addShip(ship);
            shipCounter.decreaseShipCounter(ship.getLength());
            return true;
        }
        return false;
    }
    public void makeShip(Pair firstSquare){
        Ship ship = factory.makeShip(firstSquare);
        if(shipCounter.checkNumberOfShipsPossibility(ship.getLength())) {
            addShip(ship);
            //System.out.println(ship.toString());
        }
    }
    public void setLength(int length){
        factory.setLength(length);
    }
    public void changeOrientation(){
        factory.changeOrientation();
    }
    public Field getField(){
        return field;
    }


}


