package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public class BalloonQueue implements Queue {

    Balloon first;
    Queue rest;

    int balloonCount = 0;
    static int lives = 3;

    BalloonQueue(Balloon first, Queue rest) {
        this.first = first;
        this.rest = rest;
    }

//    public boolean isEmpty() {
//        return this.first == ();
//    }
    public Queue add(Balloon b) {
        if (this.queueSize() <= 3) {
            balloonCount++;
            return new BalloonQueue(this.first, this.rest.add(b));
        } else {
            return this;
        }
    }

    public Queue front() {
        return this.first;
    }

    public Queue back() {
        return this.rest;
    }

    public Queue remove() {
        for (/*each balloon in the queue, if the dart hits*/ ) {
            if (Dart.hitBalloonHuh(this)) {
                balloonCount--;
                return new BalloonQueue(rest.front(), rest.back());
            } else if (Balloon.hitGroundHuh()) {
                balloonCount--;
                lives--;
                return new BalloonQueue(rest.front(), rest.back());
            } else {
                return this;
            }
        }
    }

    public int queueSize() {
        return (1 + rest.queueSize());
    }

    public Queue moveBalloons() {
        for (int i = 0; i < this.queueSize(); i++) 
        /*each balloon in the queue*/{
            this.moveBalloonDown();
        }
    }

    public WorldImage drawBalloons() {
        /*each balloon in the queue, draw it at posn, same thing*/
        for(){
         new OvalImage(this.position, 5, 7, Color.RED);   
        }
    }

}
