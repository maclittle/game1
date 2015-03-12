package game1;
import java.awt.Color;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import javalib.colors.*;

public class Player {

    static Posn position;

    Player(Posn p) {
        this.position = p;
    }

    public Player movePlayerLeft() {
        if(!this.atLeftHuh()){
        position = new Posn(position.x - 5, position.y);
        return new Player(position);
        } else return this;
    }

    public Player movePlayerRight() {
        if (!this.atRightHuh()){
        position = new Posn(position.x + 5, position.y);
        return new Player(position);
        } else return this;
    }

    public Boolean atLeftHuh() {
        return this.position.x == 10;
    }

    public Boolean atRightHuh() {
        return this.position.x == 490;
    }

    public  WorldImage drawPlayer() {
        return new RectangleImage((this.position), 15, 20, new Green());
    }
}
