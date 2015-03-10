package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Dart {
    
    Posn position;
    int score = 0;
    
    Dart(Posn position){
        this.position = position;
    }
    
    public Dart fireDart(){
        return new Dart(Player.position);
    }
    
    public Dart moveDartUp(){
        position = new Posn(position.x, position.y+10);
        return new Dart(position);
    }
    
    public Boolean hitBalloonHuh(Balloon b){
        score++;
        return (this.position.x == b.position.x) &&
                (this.position.y == b.position.y);
    }
    
    public Boolean dartHitTopHuh() {
        return this.position.y == 0;
    }
    
    public void removeDart(Dart d){
        if (d.dartHitTopHuh()){
           
        }
    }
}
