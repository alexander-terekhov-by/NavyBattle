package sample.model;

import sample.model.states.SquareStates;

/**
 * Created by Александр on 27.10.2014.
 */
public class Square {
    private SquareStates state;
    private int posX, posY;
    public Square(int posX, int posY) {
        this.state = SquareStates.FREE;
        this.posX = posX;
        this.posY = posY;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setState(SquareStates state) {
        this.state = state;
    }
    public SquareStates getState() {
        return state;
    }

    public boolean identical(Square sqr) {
        return sqr.getPosX() == posX && sqr.getPosY() == posY;
    }
}

