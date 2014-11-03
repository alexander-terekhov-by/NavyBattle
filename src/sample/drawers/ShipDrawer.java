package sample.drawers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.model.Ship;
import sample.model.Square;
import sample.view.fieldView.FieldView;

import java.util.List;

/**
 * Created by Александр on 27.10.2014.
 */
public class ShipDrawer {
    private final int  size = 20;
    FieldView fieldView;
    public ShipDrawer(FieldView fieldView ){
        this.fieldView = fieldView;
    }
    public void drawShip(Ship ship) {
                GraphicsContext gc = fieldView.canvas.getGraphicsContext2D();
                gc.setFill(Color.DIMGRAY);
                gc.setLineWidth(1);
                List<Square> shipSquares = ship.getSquares();
                for (Square one : shipSquares)
                    gc.fillRect(one.getPosX() * size, one.getPosY() * size, size, size);
    }
    public void drawShipContour(Ship ship){
        GraphicsContext gc = fieldView.canvas.getGraphicsContext2D();
        gc.setStroke(Color.DARKRED);
        gc.setLineWidth(2);
        List<Square> shipSquares = ship.getSquares();
        for (Square one : shipSquares)
            gc.strokeRect(one.getPosX() * size, one.getPosY() * size, size, size);

    }
}
