package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import java.util.Random;
import javalib.colors.*;


public class Game1 extends World {

    Player p;
    Queue bq;
    int score;
    int lives;
    int worldWidth;
    int worldHeight;
    String endMessage = "GAME OVER. YOUR SCORE WAS: ";

    Game1(Player player, Queue balloonQueue, int score, int lives,
            int worldWidth, int worldHeight) {
        this.p = player;
        this.bq = balloonQueue;
        this.score = score;
        this.lives = lives;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
    }

    public Game1 onKeyEvent(String key) {
        if (key.equals("left")) {
            return new Game1(this.p.movePlayerLeft(),
                    bq, this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else if (key.equals("right")) {
            return new Game1(this.p.movePlayerRight(),
                    bq, this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else if (key.equals("space")) {
            // ADD IN FIREDART
            return new Game1(this.p, bq, this.score, this.lives,
                    this.worldWidth, this.worldHeight);
        } else {
            return this;
        }
    }

    public Game1 onMouseClicked(Posn p) {
        return this;
    }

    public World onTick() {
       if (!endHuh()){
        bq.moveBalloons();
        bq.add(new Balloon(Balloon.position));
        bq.remove();
        bq.drawBalloons();
        // add movedarts, removedarts
       }
        return this;
    }

    public Boolean endHuh(){
        return (this.lives == 0);
    }
    
    public Game1 endOfWorld(String s) {
        if (endHuh()) {
            return this;
            /// IMPLEMENT, change the above
        } else return this;
    }

    public WorldImage makeImage() {
        return new OverlayImages(Player.drawPlayer(),
        new OverlayImages(BalloonQueue.drawBalloons(),
        new OverlayImages((new RectangleImage(new Posn(0,0),
                500, 800, new Black())),
                Dart.drawDart())));
        //change above to draw all darts, fix static/nonstatic problems
    }

    public static void main(String[] args) {
        int width = 500;
        int height = 800;

        Player p = new Player(Player.position);
        Queue bq = new EmptyQueue();

        Game1 game = new Game1(p, bq, 0, 3, 500, 800);

        game.bigBang(width, height, 0.4);
    }

}
