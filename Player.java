package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Player {

    static Posn position = new Posn(250, 800);

    Player(Posn p) {
        this.position = p;
    }

    public Player movePlayerLeft() {
        position = new Posn(position.x - 5, position.y);
        return new Player(position);
    }

    public Player movePlayerRight() {
        position = new Posn(position.x + 5, position.y);
        return new Player(position);
    }

    public Boolean atLeftHuh() {
        return this.position.x == 0;
    }

    public Boolean atRightHuh() {
        return this.position.x == 500;
    }

    public WorldImage drawPlayer() {
       
    }
}
