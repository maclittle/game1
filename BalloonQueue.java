package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import javalib.colors.*;

public class BalloonQueue implements Queue {

    Balloon first;
    Queue rest;

    int balloonCount = 0;
    static int lives = 3;

    BalloonQueue(Balloon first, Queue rest) {
        this.first = first;
        this.rest = rest;
    }

    public boolean isEmpty() {
        return false;
    }

    public Queue add(Balloon b) {
        if (this.queueSize() <= 3) {
            balloonCount++;
            return new BalloonQueue(this.first, this.rest.add(b));
        } else {
            return this;
        }
    }

    public Balloon front() {
        return this.first;
    }

    public Queue back() {
        return this.rest;
    }

    public Queue remove() {
        if (Dart.hitBalloonHuh(this.first)) {
            // fix static reference problems
            try {
                balloonCount--;
                return new BalloonQueue(rest.front(), rest.back());
            } catch (EmptyException e) {
                return new EmptyQueue();
            }
        } else if (this.first.hitGroundHuh()) {
            try {
                balloonCount--;
                lives--;
                return new BalloonQueue(rest.front(), rest.back());
            } catch (EmptyException e) {
                return new EmptyQueue();
            }
        } else {
            this.rest.remove();
            return this;
        }
    }

    public int queueSize() {
        return (1 + rest.queueSize());
    }

    public Queue moveBalloons() {
        return new BalloonQueue(this.first.moveBalloonDown(),
                this.rest.moveBalloons());
    }

    public WorldImage drawBalloons() {
        return new OverlayImages(this.first.drawBalloon(),
                this.rest.drawBalloons());
    }

}
