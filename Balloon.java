package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import java.util.Random;
import javalib.colors.*;

public class Balloon {

    static Random r = new Random();
    static int x = r.nextInt();
    static Posn position = new Posn(x, 0);

    Balloon(Posn position) {
        this.position = position;
    }

    public static Boolean hitGroundHuh() {
        return position.y == 600;
    }

    public Balloon moveBalloonDown() {
        Posn position2 = new Posn(position.x, position.y + 10);
        return new Balloon(position2);
    }

    public WorldImage drawBalloon() {
        return new OvalImage(new Posn(this.position.x, this.position.y),
                5, 7, new Red());
    }

}
