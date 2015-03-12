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
    Queue bq;
    LinkedList<Dart> darts;
    int score;
    int lives;
    int worldWidth;
    int worldHeight;
    String endMessage = "GAME OVER. YOUR SCORE WAS: ";

    Game1(Player player, Queue balloonQueue, LinkedList<Dart> darts,
            int score, int lives, int worldWidth, int worldHeight) {
        this.p = player;
        this.bq = balloonQueue;
        this.darts = darts;
        this.score = score;
        this.lives = lives;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
    }

    public Game1 onKeyEvent(String key) {
        if (key.equals("left")) {
            return new Game1(p.movePlayerLeft(),
                    bq, darts, this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else if (key.equals("right")) {
            return new Game1(p.movePlayerRight(),
                    bq, darts, this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else if (key.equals("space")) {
            return new Game1(this.p, bq, Dart.fireDart(darts), this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else {
            return this;
        }
    }

    public Game1 onMouseClicked(Posn p) {
        return this;
    }

    public World onTick() {
      // if (!endHuh()){
        bq.moveBalloons();
        bq.add(new Balloon(Balloon.position));
        bq.remove(darts);
        bq.drawBalloons();
        Dart.moveAllDarts(darts);
        Dart.removeDart(darts, bq);
      // }
        return this;
    }

    public Boolean endHuh(){
        return (this.lives == 0);
    }
    
//    public Game1 endOfWorld(String s) {
//        if (endHuh()) {
//            return this;
//            /// IMPLEMENT, change the above
//        } else return this;
//    }

    public WorldImage makeImage() {
        return new OverlayImages((new RectangleImage(new Posn(250,400),
                500, 800, new Black())),
                new OverlayImages((bq.drawBalloons()),
                (p.drawPlayer())));
        //return p.drawPlayer();
    }

    public static void main(String[] args) {
        int width = 500;
        int height = 600;
        Posn pPosition = new Posn(250, height-10);

        Player p = new Player(pPosition);
        Queue mt = new EmptyQueue();
        Queue bq = new BalloonQueue(new Balloon(Balloon.position), mt);
        LinkedList<Dart> darts = new LinkedList<Dart>();
        
        Game1 game = new Game1(p, bq, darts, 0, 0, width, height);

        game.bigBang(width, height, 0.3);
    }

}
