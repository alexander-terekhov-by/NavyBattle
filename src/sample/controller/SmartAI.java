package sample.controller;

import sample.model.Field;
import sample.model.states.SquareStates;
import sample.view.fieldView.FieldView;

import java.util.Random;

/**
 * Created by Александр on 27.10.2014.
 */
public class SmartAI extends ComputerController {
    Pair lastShootedPos;

    public SmartAI() {
        Random rand = new Random();
        lastShootedPos = new Pair(rand.nextInt(10), rand.nextInt(10));
    }



    @Override
    public Pair calculateNextPosToShot() {
        int x = calculateNextCoord(lastShootedPos.x);
        int y = calculateNextCoord(lastShootedPos.y);
        return  new Pair(x, y);
    }

    private int calculateNextCoord(int coord){
        System.out.println(coord);
        if(coord + 1 >= Field.SIZE){
            return 0;
        }
        else{
            return coord + 1;
        }
    }
}
