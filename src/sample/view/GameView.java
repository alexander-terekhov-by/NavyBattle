package sample.view;

import javafx.scene.layout.HBox;
import sample.controller.ShootController;
import sample.controller.UserShootController;
import sample.view.fieldView.FieldView;
import sample.view.fieldView.ShootFieldView;

/**
 * Created by Александр on 30.10.2014.
 */
public class GameView extends HBox {
    private FieldView userField;
    private ShootFieldView enemyField;
    //ShootController enemyController;

    public FieldView getUserField() {
        return userField;
    }

    public ShootFieldView getEnemyField() {
        return enemyField;
    }


    public GameView(){
        super(20);
        userField = new FieldView();
        enemyField = new ShootFieldView();
        this.getChildren().addAll( userField,  enemyField);

        //enemyController = new
    }
}
