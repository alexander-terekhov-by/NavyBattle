package sample.model;

import sample.model.states.SquareStates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 27.10.2014.
 */
public class Field {
    private Square [][] field;
    public static final int  SIZE = 10;
    private List<Ship> ships;


    public Field(){

        makeField();
        ships = new ArrayList<>();
    }
    private void makeField(){
        field = new Square[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            field[i] = new Square[SIZE];
        }
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
            {
                field[i][j]  = new Square(i, j);
            }
    }
    public List<Ship> getShips() {
        return ships;
    }
   /* public boolean checkAllShootedSquares(){
        for(Square [] line :field){
            for ( Square one: line)
                if(one.getState() != SquareStates.SHOOTED)
                    return false;
        }
        return  true;
    }*/
    public boolean isAllShipsDestroyed(){
        for(Ship ship : ships)
                if (!ship.isDead()) {
                    //System.out.println(ship.toString());
                    return false;
                }
        return  true;
    }
    public void setSquareState(SquareStates state, int posX, int posY){
        field[posX][posY].setState(state);
        Ship ship;
        if((ship = getShipBySquare(field[posX][posY])) != null)
            ship.setSquareState(field[posX][posY]);
    }
    public void addShip(Ship ship){
        ships.add(ship);
    }
    public SquareStates getSquareState(int x, int y){
        return field[x][y].getState();
    }
    public Ship getShipBySquare(Square square){
        for(Ship ship : ships)
            for(Square shipSquare : ship.getSquares()) {
                if (square.identical(shipSquare))
                return ship;
            }
        return null;
    }

    @Override
     public String toString() {
        String fieldStr = "";
        for(Ship ship : ships)
            fieldStr += ship.toString() + "\n";
        for(int i = 0; i < SIZE; i++) {
            fieldStr += "|";
            for (int j = 0; j < SIZE; j++) {
                if (getShipBySquare(field[j][i]) != null)
                    fieldStr += "\u25A0";
                else
                    fieldStr += "\u0387";
                fieldStr += "|";
            }
            fieldStr += "\n";
        }
        return  fieldStr;
    }

    public String toStringSq() {
        String fieldStr = "";

        for(int i = 0; i < SIZE; i++) {
            fieldStr += "|";
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i].getState() == SquareStates.FREE)
                    fieldStr += "\u0387";
                else
                    fieldStr += "x";
                fieldStr += "|";
            }
            fieldStr += "\n";
        }
        return  fieldStr;
    }

}


