package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Player {

    Posn position;

    Player(Posn position) {
        this.position = position;
    }

    public Player movePlayerLeft() {
        Posn lefty = new Posn(position.x - 5, position.y);
        return new Player(lefty);
    }

    public Player movePlayerRight() {
        Posn righty = new Posn(position.x + 5, position.y);
        return new Player(righty);
    }

    public Boolean atLeftHuh() {
        return this.position.x == 0;
    }

    public Boolean atRightHuh() {
        return this.position.x == 500;
    }

}
