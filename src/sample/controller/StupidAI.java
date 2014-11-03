package sample.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Александр on 27.10.2014.
 */
public class StupidAI extends ComputerController {
    List<Pair> squaresToShoot;


    public StupidAI() {
        super();
        squaresToShoot = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                squaresToShoot.add(new Pair(i, j));
        }
    }

    @Override
    protected Pair calculateNextPosToShot() {
        Random rand = new Random();
        int pos = rand.nextInt(squaresToShoot.size());
        Pair squareToShoot = squaresToShoot.get(pos);
        squaresToShoot.remove(pos);
        return squareToShoot;
    }

}
