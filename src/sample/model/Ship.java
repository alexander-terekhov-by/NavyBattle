package sample.model;


import sample.model.states.SquareStates;


import java.util.List;

/**
 * Created by Александр on 27.10.2014.
 */
public class Ship {
    private List<Square> squares;

    public Ship(List<Square> squares){
        this.squares = squares;


    }
    public boolean isDead(){
        for(Square one: squares) {
            if (one.getState() == SquareStates.FREE) {
                return false;
            }
        }
        return true;
    }
    public void setSquareState(Square a) {
        for(Square square: squares){
            if(a.identical(square))
                square.setState(a.getState());
        }
    }
    public int getLength(){
        return  squares.size();
    }
    public List<Square> getSquares() {
        return squares;
    }
    public String toString(){
        String res = squares.size() + ": { ";
        for (Square one : squares)
            res += "[" + one.getPosX() + ", " + one.getPosY() +"]";
        res +=" }";
        return res;
    }
}
