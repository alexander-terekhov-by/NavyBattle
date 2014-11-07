package sample.view.fieldView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import sample.controller.shootController.UserShootController;

/**
 * Created by Александр on 30.10.2014.
 */
public class ShootFieldView extends FieldView {
    UserShootController userController;
    //public ShootDrawer drawer;





    public ShootFieldView(){
        super();
       // drawer = new ShootDrawer(this);
        userController = new UserShootController(this);
        this.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int x = researchPositionOfSquareByClick(event.getX());
                int y =  researchPositionOfSquareByClick(event.getY());
                userController.shot(x, y);
                //drawer.drawMiss(x, y);
                //drawer.drawDamagedShip(x, y);
            }
        });
    }
    public UserShootController getController() {
        return userController;
    }
    /*public ShootDrawer getDrawer() {
        return drawer;
    }*/


}
