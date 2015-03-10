package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Balloon {
    
    static int x = Math.Random();
    static Posn position = new Posn(x, 0);
    
    /// to do: random x position generator, starting position
    
    Balloon(Posn position){
        this.position = position;
    }
    
    public static Boolean hitGroundHuh(){
        return position.y == 800;
    }
    
    public Balloon moveBalloonDown(){
        Posn position = new Posn(position.x, position.y+10);
        return new Balloon(position);
    }
    
}
