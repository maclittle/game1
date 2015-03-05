package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Game1 extends World {

    int lives = 3;
    int score = 0;
    int ballooncount = 0; 
    int worldWidth;
    int worldHeight;
    
    public World onKeyEvent(String key) {
        if(key.equals("left")){
            return new BalloonPop();
        } else if (key.equals("right")){
            return new BalloonPop();
        } else if (key.equals("space")){
            return new BalloonPop();
        } else
            return this;
    }
    
    
    public static void main(String[] args) {

    }
    
}
