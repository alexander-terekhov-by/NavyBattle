package sample.controller.placeShipController;

import sample.Pair;
import sample.model.Ship;
import sample.model.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 29.10.2014.
 */
public class ShipFactory {
    private boolean hOrientation = true;
    private  int length = 1;
    public void setLength(int length) {
        this.length = length;
    }
    public void changeOrientation() {
        this.hOrientation = !hOrientation;
    }
    public Ship makeShip(Pair firstSquare) {
        int x = firstSquare.x;
        int y = firstSquare.y;
        List<Square> shipSquares = new ArrayList<Square>();
        shipSquares.add(new Square(x, y));
        for (int i = 0; i < length - 1; i++) {
            if (hOrientation)
                x++;
            else
                y++;
            shipSquares.add(new Square(x, y));

        }
        //System.out.println(new Ship(shipSquares).toString());
        return new Ship(shipSquares);
    }

}
