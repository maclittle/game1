package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Balloon {
    
    Posn position;
    
    Balloon(Posn position){
        this.position = position;
    }
    
    public Boolean hitGroundHuh(){
        return this.position.y == 800;
    }
    
    public Balloon moveBalloonDown(){
        Posn downsy = new Posn(position.x, position.y+10);
        return new Balloon(downsy);
    }
    
    public void removeBalloon(Balloon b){
        
    }
    
}
