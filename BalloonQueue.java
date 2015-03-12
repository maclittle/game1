package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import javalib.colors.*;
import java.util.LinkedList;

public class BalloonQueue implements Queue {

    Balloon first;
    Queue rest;

    int balloonCount = 0;

    BalloonQueue(Balloon first, Queue rest, int balloonCount) {
        this.first = first;
        this.rest = rest;
        this.balloonCount = balloonCount;
    }

    public boolean isEmpty() {
        return false;
    }

    public BalloonQueue add(Balloon b) {
        if (this.queueSize() <= 3) {
            return new BalloonQueue(this.first, this.rest.add(b), balloonCount++);
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

    public Queue remove(LinkedList<Dart> ds) {
        Queue q = this;
        try {
            Dart d = ds.element();
            while (!q.isEmpty()) {
                while (!ds.isEmpty()) {
                    if ((Dart.hitBalloonHuh(first, d)) || (first.hitGroundHuh())) {
                        try {
                            return new BalloonQueue(rest.front(), rest.back(),
                                    balloonCount--);
                        } catch (EmptyException e) {
                            return new EmptyQueue();
                        }
                    } else {
                        q = q.back();
                        return q;
                    }
                }
            }
        } catch (java.util.NoSuchElementException e) {
            return q;
        }
        return q;
    }

    public int queueSize() {
        return balloonCount;
    }

    public Boolean anyHitGround() {
        if (this.front().hitGroundHuh()) {
            return true;
        } else {
            return this.back().anyHitGround();
        }
    }

    public BalloonQueue moveBalloons() {
        return new BalloonQueue(this.first.moveBalloonDown(),
                this.rest.moveBalloons(), balloonCount);
    }

    public WorldImage drawBalloons() {
        return new OverlayImages(this.first.drawBalloon(),
                this.rest.drawBalloons());
    }

}
