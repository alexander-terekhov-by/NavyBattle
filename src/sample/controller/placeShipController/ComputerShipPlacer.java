package sample.controller.placeShipController;

import sample.Pair;

import java.util.Random;

/**
 * Created by Александр on 29.10.2014.
 */
public class ComputerShipPlacer extends AbstractShipPlacer {
    public ComputerShipPlacer() {
        super();
    }

    public void placeShips(){
        Random rand = new Random();
        for (int length = 4; length > 0; length-- ) {
            while( shipCounter.checkNumberOfShipsPossibility(length)) {
                if(rand.nextInt() % 2 == 0)
                    changeOrientation();
                setLength(length);
                makeShip(new Pair(rand.nextInt(10), rand.nextInt(10)));
            }
        }
        //System.out.println(field.toString());

    }


}
