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
    static Queue mt = new EmptyQueue();
    static Queue bq = new BalloonQueue(new Balloon(), mt, 1);
    static int score;
    static int lives;
    int worldWidth;
    int worldHeight;
    static Random r = new Random();

    Game1(Player player, Queue balloonQueue, int score,
            int lives, int worldWidth, int worldHeight) {
        this.p = player;
        this.bq = balloonQueue;
        this.score = score;
        this.lives = lives;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
    }

    public Game1 onKeyEvent(String key) {
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
    
    public int hitPlayer(){
        if (bq.anyHitPlayer()) {
                lives = lives - 1;
            } return lives;
    }
    
    
    public static int hitGround(){
        if (bq.anyHitGround()) {
                score= score+1;
            } return score;
    }
    
    public Game1 onTick() {
        if (endHuh()) {
            return new Game1(p,
                    mt,
                    this.score, 0,
                    this.worldWidth, this.worldHeight);
        } else {
            if(bq.anyHitGround()){
            return new Game1(p,
                    bq.moveBalloons().remove().add(new Balloon()),
                    score+1, hitPlayer(),
                    this.worldWidth, this.worldHeight);
            } else return new Game1(p,
                    bq.moveBalloons().remove().add(new Balloon()),
                    score, hitPlayer(),
                    this.worldWidth, this.worldHeight);
        }
    }

    public static Boolean endHuh() {
        return (lives <= 0);
    }

    public WorldImage makeImage() {
        if (!endHuh()) {
            return new OverlayImages((new RectangleImage(new Posn(250, 400),
                    500, 800, new Black())),
                    new OverlayImages((bq.drawBalloons()),
                            (p.drawPlayer())));
        } else {
            return new OverlayImages((new RectangleImage(new Posn(250, 400),
                    500, 800, new Black())),
                    new TextImage(new Posn(250, 300),
                            "GAME OVER. YOUR SCORE WAS: " + score,
                            new White()));
        }
    }

    public static String[] randomInput(int size) {
        String[] keys = new String[size];
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            int rand = r.nextInt();
            if (rand % 2 == 0) {
                keys[i] = "left";
            } else {
                keys[i] = "right";
            }
        }
        return keys;
    }

    public static Game1 startAgain() {
        return new Game1(new Player((new Posn(250, 590))),
                mt, 0, 3, 500, 600);
    }

    //TESTS
    
    // Creates a random game state with a random score, life number, and player
    public static Game1 randomGame() {
        int x = r.nextInt(500);
        Player randomP = new Player(new Posn(x, 590));
        int rScore = r.nextInt(101);
        int rLives = r.nextInt(4);

        return new Game1(randomP, bq, rScore, rLives, 500, 600);
    }

    // Tests whether the game is over when lives equal 0
    public static Boolean endTest(Game1 g) {
        if (g.lives <= 0) {
            return (g.endHuh());
        } else {
            return true;
        }
    }
    
    // Tests whether the player location is ever out of the frame
    public static Boolean playerBoundsTest(Game1 g){
        return !((g.p.position.x<0) || (g.p.position.x>500));
    }
    
    //Given that a balloon hits the ground, tests whether the score is greater
    //than 0
    public static Boolean scoreTest(Game1 g){
        if(g.bq.anyHitGround()){
            return (g.score>0);
        } else return true;
    }
    
    // Given that a balloon has hit the player, tests whether the player has
    // lost a life
    public static Boolean collideTest(Game1 g){
        if(g.bq.anyHitPlayer()){
            if(g.lives == 3){
                return lives==2;
            } else if (g.lives==2){
                return lives==1;
            } else if(g.lives==1){
                return lives==0;
            } else return false;
        } else return true;
    }

    public static void main(String[] args) {
        int width = 500;
        int height = 600;
        Posn pPosition = new Posn(250, height - 10);
        int lives = 3;
        int score = 0;
        Player p = new Player(pPosition);
        Queue mt = new EmptyQueue();
        Queue bq = new BalloonQueue(new Balloon(), mt, 1);

     
        Game1 game = new Game1(p, bq, score, lives, width, height);

        // Creates a random game state with random balloons and player position
        // by having the game play itself up to a certain point
            String[] keys = randomInput(800);
            for (int s = 0; s < keys.length * 2; s++) {
                if (s % 2 == 1) {
                    game = game.onKeyEvent(keys[s / 2]);
                } else {
                    game = game.onTick();
                }
            }

        //Runs endTest on 100 different games
        for (int x = 0; x < 100; x++) {
            Game1 rGame = randomGame();
            if (!endTest(rGame)) {
                System.out.println("endTest has failed");

            }
        }
        
        //Runs playerBoundsTest on 100 different games
        for (int x = 0; x < 100; x++) {
            Game1 rGame = randomGame();
            if (!playerBoundsTest(rGame)) {
                System.out.println("playerBoundsTest has failed");

            }
        }
        
        //Runs scoreTest on 100 different games
        for (int x = 0; x < 100; x++) {
            Game1 rGame = randomGame();
            if (!scoreTest(rGame)) {
                System.out.println("scoreTest has failed");

            }
        }
        
        //Runs collideTest on 100 different games
        for (int x = 0; x < 100; x++) {
            Game1 rGame = randomGame();
            if (!collideTest(rGame)) {
                System.out.println("collideTest has failed");

            }
        }

        //Single Instance Tests
        if (startAgain().endHuh()) {
            System.out.println("New game should not be in end state");
        }
        
        //Tests whether hitGroundHuh detects a balloon hitting the ground
        Posn posB = new Posn(40, 600);
        Balloon b = new Balloon(posB);
        System.out.println((b.hitGroundHuh())+ " should be true");
        
        game.bigBang(width, height, 0.3);
    }

}
