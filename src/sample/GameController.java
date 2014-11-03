package sample;

import sample.controller.ComputerController;
import sample.controller.StupidAI;
import sample.controller.UserShootController;
import sample.controller.placeShipController.ComputerShipPlacer;
import sample.controller.placeShipController.UserShipPlacer;
import sample.drawers.FieldDrawer;
import sample.model.Field;
import sample.view.GameView;
import sample.view.PlaceShipsView;
import sample.view.fieldView.ShootFieldView;

/**
 * Created by Александр on 01.11.2014.
 */
public class GameController {
    Main mainFrame;
    ComputerController AI;
    UserShootController userShootController;
    GameController(Main mainFrame){
        this.mainFrame = mainFrame;
    }
    public void placeShips(){
        mainFrame.setNextView(new PlaceShipsView(this));
    }
    public  void prepareToStart(ComputerController AI){
        this.AI = AI;
        placeShips();
        ComputerShipPlacer placer = new ComputerShipPlacer();
        placer.placeShips();
        AI.setField(placer.getField());
    }
    public void startGame(Field field){
        GameView gameView = new GameView();
        mainFrame.setNextView(gameView);
        FieldDrawer drawer = new FieldDrawer(gameView.getUserField());
        //FieldDrawer drawerN = new FieldDrawer(gameView.getEnemyField());
        drawer.drawField(field);
        //drawerN.drawField(AI.getField());
        AI.setFieldView(gameView.getUserField());
        userShootController = gameView.getEnemyField().getController();
        userShootController.setField(field);
        userShootController.setOpponent(AI);
    }
}
