package sample.drawers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.view.fieldView.FieldView;

/**
 * Created by Александр on 31.10.2014.
 */
public class ShootDrawer {
    private final int SIZE = 20;
    private FieldView fieldView;
    public ShootDrawer(FieldView fieldView){
         this.fieldView = fieldView;
         //System.out.println(fieldView.toString());
        // drawDamagedShip(3,3);
    }
    public void drawDamagedShip(int x, int y){
        //System.out.println(fieldView.toString());
        GraphicsContext gc = fieldView.getCanvas().getGraphicsContext2D();
        gc.setStroke(Color.RED);
        int x1 = x * SIZE;
        int y1 = y * SIZE;
        int x2 = x * SIZE + SIZE;
        int y2 = y * SIZE + SIZE;
        gc.setLineWidth(2);
        gc.strokeLine(x1, y1, x2, y2);
        gc.strokeLine(x2, y1, x1, y2);
        //gc.fillRect(20, 20, 50, 50);
    }
    public void drawMiss(int x, int y){
        //System.out.println(fieldView.toString());
        GraphicsContext gc = fieldView.canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        int x1 = x * SIZE + SIZE/2;
        int y1 = y * SIZE + SIZE/2;
        gc.setLineWidth(4);
        gc.strokeLine(x1, y1, x1, y1);
        //gc.fillRect(20,20, 50, 50);
    }
}
