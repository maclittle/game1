package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import java.util.Random;
import javalib.colors.*;

public class Balloon {

    static Random r = new Random();
    //static int x = r.nextInt();
    
    Posn position; // = new Posn(x, 0);

    Balloon() {
        int x = r.nextInt(500);
        this.position = new Posn(x, 15);
    }
    
    private Balloon(Posn p) {
        this.position = p;
    }

    public Boolean hitGroundHuh() {
        return this.position.y >= 580;
    }

    public Balloon moveBalloonDown() {
        if ((!this.hitGroundHuh())) {
            Posn position2 = new Posn(this.position.x, this.position.y + 10);
            return new Balloon(position2);
        }
        return this;
    }

    public WorldImage drawBalloon() {
        return new OvalImage(this.position,
                35, 40, new Red());
    }

}
