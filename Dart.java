package game1;

public class Dart {
    
    Posn position;
    
    Dart(Posn position){
        this.position = position;
    }
    
    public Dart moveDartUp(){
        return new Dart(position.x, position.y+10);
    }
    
    public Boolean hitBalloonHuh(Dart d){
        return d.position == Balloon.position;
    }
    
    public Boolean dartHitTopHuh(Dart d) {
        return d.position.y == 0;
    }
    
}
