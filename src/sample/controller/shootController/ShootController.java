package sample.controller.shootController;

import sample.model.Field;
import sample.model.Ship;
import sample.model.Square;
import sample.model.states.SquareStates;

/**
 * Created by Александр on 27.10.2014.
 */
public abstract class ShootController {

    protected Field field;
    ShootController(){
        field = new Field();
    }
    ShootStates applyEnemyShoot(int x, int y){
        field.setSquareState(SquareStates.SHOOTED, x, y);
        Ship ship = field.getShipBySquare(new Square(x, y));
        if(ship == null)
            return ShootStates.MISS;
        if (ship.isDead())
            return ShootStates.KILLED;
        else
            return ShootStates.DAMAGED;
    }

    boolean isDefeat(){
        return field.isAllShipsDestroyed();

    }
    public Field getField() {
        return field;
    }
    public void setField(Field field) {
        this.field = field;
    }





}
