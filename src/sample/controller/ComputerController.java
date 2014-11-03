package sample.controller;


import sample.view.EndOfGameMessage;
import sample.drawers.ShootDrawer;
import sample.model.states.SquareStates;
import sample.view.fieldView.FieldView;

/**
 * Created by Александр on 27.10.2014.
 */
public abstract class ComputerController extends ShootController {
    ShootDrawer drawer;
    FieldView fieldView;
    public ComputerController() {


    }
    public void setFieldView(FieldView fieldView) {
        this.fieldView = fieldView;
        drawer = new ShootDrawer(fieldView);
    }
    public void shot(ShootController destination){
        if(!destination.isDefeat()) {
            Pair squareToShoot = calculateNextPosToShot();
            destination.applyEnemyShoot(squareToShoot.x, squareToShoot.y);
            switch (destination.applyEnemyShoot(squareToShoot.x, squareToShoot.y)) {
                case MISS:
                    drawer.drawMiss(squareToShoot.x, squareToShoot.y);
                    break;
                case DAMAGED:
                    shot(destination);
                    drawer.drawDamagedShip(squareToShoot.x, squareToShoot.y);
                    break;
                case KILLED:
                    drawer.drawDamagedShip(squareToShoot.x, squareToShoot.y);
                    break;
            }
        }
        else
        {
            new EndOfGameMessage("Computer win!");
        }

    }
    abstract protected Pair calculateNextPosToShot();
    SquareStates getSquareState(int x, int y){
        return field.getSquareState(x, y);
    }
}
