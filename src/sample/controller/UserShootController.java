package sample.controller;

import sample.drawers.ShipDrawer;
import sample.model.Ship;
import sample.model.Square;
import sample.view.EndOfGameMessage;
import sample.drawers.ShootDrawer;
import sample.view.fieldView.ShootFieldView;

/**
 * Created by Александр on 30.10.2014.
 */
public class UserShootController extends ShootController {

    private ShootDrawer drawer;
    private ComputerController opponent;
    private ShootFieldView enemyField;

    public UserShootController(ShootFieldView enemyField){
        this.enemyField = enemyField;
        drawer = new ShootDrawer(enemyField);
    }
    public void setOpponent(ComputerController opponent) {
        this.opponent = opponent;
    }
    public void shot(int posX, int posY) {
        if(!opponent.isDefeat()) {
            //System.out.println("No Defeat");
            switch (opponent.applyEnemyShoot(posX, posY)) {
                case MISS:
                    drawer.drawMiss(posX, posY);
                    opponent.shot(this);
                    break;
                case DAMAGED:
                    drawer.drawDamagedShip(posX, posY);
                    break;
                case KILLED:
                    drawer.drawDamagedShip(posX, posY);
                    drawDestroyedShip(posX, posY);

                    break;

            }
        } else {
            new EndOfGameMessage("You win!");
        }
    }

    private void drawDestroyedShip(int posX, int posY) {
        Ship destroyedShip = opponent.field.getShipBySquare(new Square(posX, posY));
        new ShipDrawer(enemyField).drawShipContour(destroyedShip);
        for(Square one :destroyedShip.getSquares()){
            drawer.drawMiss(one.getPosX() + 1, one.getPosY());
            drawer.drawMiss(one.getPosX() - 1, one.getPosY());
            drawer.drawMiss(one.getPosX(), one.getPosY() + 1);
            drawer.drawMiss(one.getPosX(), one.getPosY() - 1);
            drawer.drawMiss(one.getPosX() + 1, one.getPosY() + 1);
            drawer.drawMiss(one.getPosX() - 1, one.getPosY() - 1);
            drawer.drawMiss(one.getPosX() + 1, one.getPosY() - 1);
            drawer.drawMiss(one.getPosX() - 1, one.getPosY() + 1);
        }
        for(Square one :destroyedShip.getSquares()) {
            drawer.drawDamagedShip(one.getPosX(),one.getPosY());
        }
    }
}
