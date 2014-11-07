package sample.view.fieldView;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import sample.model.Field;


/**
 * Created by Александр on 27.10.2014.
 */
public class FieldView extends BorderPane {
    public Canvas canvas;
    int firstXCord;
    private final int sizeOfSquare = 20;
    private final int size = Field.SIZE* sizeOfSquare;


    public FieldView () {
        String resourceFolder =  FieldView.class.getResource("../../../img").toString();
        ImageView letters = new ImageView(resourceFolder + "/Letters.png");
        ImageView numbers = new ImageView(resourceFolder + "/Numbers.png");
        canvas = new Canvas(size,size );
        firstXCord = (int)letters.getFitHeight();
        letters.setVisible(true);
        this.setTop(letters);
        this.setCenter(canvas);
        this.setLeft(numbers);
        printBoardWeb();

    }
    protected void printBoardWeb() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        for (int i = 0; i <= size; i += this.sizeOfSquare) {
            gc.strokeLine(i, 0, i, size);
            gc.strokeLine(0, i, size, i);
        }

    }
    protected int researchPositionOfSquareByClick(double posByClick) {
        return ((int) posByClick) / sizeOfSquare;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}