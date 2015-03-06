package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Dart {
    
    Posn position;
    
    Dart(Posn position){
        this.position = position;
    }
    
    public Dart moveDartUp(){
        Posn uppy = new Posn(position.x, position.y+10);
        return new Dart(uppy);
    }
    
    public Boolean hitBalloonHuh(Dart d){
        return (d.position.x == Balloon.position.x) &&
                (d.position.y == Balloon.position.y);
    }
    
    public Boolean dartHitTopHuh(Dart d) {
        return d.position.y == 0;
    }
    
    public void removeDart(Dart d){
        
    }
}
