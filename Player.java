package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import javalib.colors.*;

public class Player {

    static Posn position = new Posn(250, 800);

    Player(Posn p) {
        this.position = p;
    }

    public Player movePlayerLeft() {
        if(this.atLeftHuh()){
        position = new Posn(position.x - 5, position.y);
        return new Player(position);
        } else return this;
    }

    public Player movePlayerRight() {
        if (this.atRightHuh()){
        position = new Posn(position.x + 5, position.y);
        return new Player(position);
        } else return this;
    }

    public Boolean atLeftHuh() {
        return this.position.x == 0;
    }

    public Boolean atRightHuh() {
        return this.position.x == 500;
    }

    public WorldImage drawPlayer() {
       return new TriangleImage(new Posn(250, 796), new Posn(248, 800),
               new Posn(252, 800), new Green());
    }
}
