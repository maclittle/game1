package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import java.util.Random;
import javalib.colors.*;
import java.util.LinkedList;

public class Game1 extends World {

    Player p;
    Queue mt = new EmptyQueue();
    Queue bq = new BalloonQueue(new Balloon(), mt, 1);
    int score;
    int lives;
    int worldWidth;
    int worldHeight;

    Game1(Player player, Queue balloonQueue,
            int score, int lives, int worldWidth, int worldHeight) {
        this.p = player;
        this.bq = balloonQueue;
        this.score = score;
        this.lives = lives;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
    }

    public Game1 onKeyEvent(String key) {
        String genKey = randomInput();
        if (key.equals("left")) {
            return new Game1(p.movePlayerLeft(),
                    bq, this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else if (key.equals("right")) {
            return new Game1(p.movePlayerRight(),
                    bq, this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else {
            return this;
        }
    }

    public Game1 onMouseClicked(Posn p) {
        return this;
    }

    public World onTick() {
        return new Game1(p,
                bq.moveBalloons().remove().add(new Balloon()),
               this.score, this.lives,
                this.worldWidth, this.worldHeight);
    }

    public Boolean endHuh() {
        return (this.lives == 0);
    }

    public Game1 endOfWorld() {
        if (endHuh()) {
            new Game1(p, bq, 0, 0, 500, 600);
            new TextImage(new Posn(250, 300),
                    "GAME OVER. YOUR SCORE WAS: " + score, new White());
        } return this;
    }
   
    public WorldImage makeImage() {
        return new OverlayImages((new RectangleImage(new Posn(250, 400),
                500, 800, new Black())),
                new OverlayImages((bq.drawBalloons()),
                                (p.drawPlayer())));
    }
    
    public static String randomInput(){
        String key;
        Random r = new Random();
        int rand = r.nextInt(3);
        switch (rand) {
            case 0: key = "left";
                break;
            case 1: key = "right";
                break;
            default: key = "space";
        }
        return key;
    }
    
    
    //TESTS
    

    public static void main(String[] args) {
        int width = 500;
        int height = 600;
        Posn pPosition = new Posn(250, height - 10);
        int lives = 3;
        int score = 0;

        Player p = new Player(pPosition);
        Queue mt = new EmptyQueue();
        Queue bq = new BalloonQueue(new Balloon(), mt, 1);

        if(bq.anyHitPlayer()) {
            lives--;
        }

        if(bq.anyHitGround()){
            score++;
        }
        
        Game1 game = new Game1(p, bq, score, lives, width, height);

        game.bigBang(width, height, 0.3);
    }

}
