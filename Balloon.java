package game1;
import javalib.funworld.*;
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
        return new Balloon(position.x, position.y+10);
    }
    
    
    
}
