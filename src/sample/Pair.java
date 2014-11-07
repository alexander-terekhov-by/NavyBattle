package sample;

/**
 * Created by Александр on 27.10.2014.
 */
public class Pair {
    public int x;
    public int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pair){
            if(((Pair) obj).x == this.x && ((Pair) obj).y == this.y)
            return true;
        }

        return false;
    }
}
