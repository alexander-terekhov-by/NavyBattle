package sample.drawers;

import sample.model.Field;
import sample.model.Ship;
import sample.view.fieldView.FieldView;

import java.util.List;

/**
 * Created by Александр on 31.10.2014.
 */
public class FieldDrawer {
    private FieldView fieldView;
    private ShipDrawer shipDrawer;
    public FieldDrawer(FieldView fieldView) {
        this.fieldView = fieldView;
        this.shipDrawer = new ShipDrawer(fieldView);
    }
    public void drawField(Field field){
        List<Ship> ships = field.getShips();
        for(Ship one: ships){
            shipDrawer.drawShip(one);
        }

    }
}
