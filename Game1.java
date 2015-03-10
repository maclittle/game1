package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class Game1 extends World {

    Player player;
    BalloonQueue balloonQueue;
    int score;
    int lives;
    int worldWidth;
    int worldHeight;
    String endMessage = "GAME OVER. YOUR SCORE WAS: ";
    
    Game1(Player p, BalloonQueue bq, int score, int lives, int worldWidth,
            int worldHeight){
        this.player = p;
        this.balloonQueue = bq;
        this.score = score;
        this.lives = lives;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
    }
    
    public World onKeyEvent(String key) {
        if(key.equals("left")){
            return new World(this.p.movePlayerLeft(),
            bq);
        } else if (key.equals("right")){
            return new World(this.p.movePlayerRight(),
            bq);
        } else if (key.equals("space")){
            return new World(p, bq);
        } else
            return this;
    }
    
    public World onMouseClicked(Posn p){
        return this;
    }
    
    public World onTick(){
        return World.bq.moveBalloons();
        return World.bq.add(Balloon.position);
        return World.bq.remove();
        return World.bq.drawBalloons();
        
        
    }
    
    public World endOfWorld(String s){
        if (BalloonQueue.lives == 0){
            
        } else return this;
    }
    
    public WorldImage makeImage(){
        
    }
    
    public static void main(String[] args) {
        World.bigBang();
    }
    
}
