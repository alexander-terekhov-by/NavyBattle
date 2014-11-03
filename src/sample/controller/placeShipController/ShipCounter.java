package sample.controller.placeShipController;

/**
 * Created by Александр on 28.10.2014.
 */
public class ShipCounter {
    private  int countOfSingleDeckShip = 4;
    private  int countOfDoubleDeckShip = 3;
    private  int countOfTripleDeckShip = 2;
    private  int countOfQuadrupleDeckShip = 1;

    void decreaseShipCounter(int length){
        switch ( length) {
            case 1:
                countOfSingleDeckShip--;
                break;
            case 2:
                countOfDoubleDeckShip--;
                break;
            case 3:
                countOfTripleDeckShip--;
                break;
            case 4:
                countOfQuadrupleDeckShip--;
                break;
        }
    }
    boolean  checkNumberOfShipsPossibility(int length){

        switch (length) {
            case 1:
                return countOfSingleDeckShip != 0;

            case 2:
                return countOfDoubleDeckShip != 0;

            case 3:
                return countOfTripleDeckShip != 0;

            case 4:
                return countOfQuadrupleDeckShip != 0;
            default:
                return  true;

        }

    }
    boolean  areAllShipsPlaced() {
        return countOfSingleDeckShip + countOfDoubleDeckShip + countOfTripleDeckShip + countOfQuadrupleDeckShip == 0;
    }

}
