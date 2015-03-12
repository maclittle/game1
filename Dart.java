package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import javalib.colors.*;
import java.util.LinkedList;

public class Dart {

    Posn position;
    int score = 0;
    LinkedList<Dart> darts;

    Dart(Posn position) {
        this.position = position;
    }

    public static LinkedList<Dart> fireDart(LinkedList<Dart> d) {
        Dart fired = new Dart(Player.position);
        d.addLast(fired);
        return d;
    }

    public Dart moveDartUp() {
        position = new Posn(position.x, position.y + 10);
        return new Dart(position);
    }

    public static void moveAllDarts(LinkedList<Dart> d) {
        while (!d.isEmpty()) {
            for (int i = 0; i < d.size(); i++) {
                d.get(i).moveDartUp();
            }
        }
    }

    public Boolean hitBalloonHuh(Balloon b) {
        score++;
        return (this.position.x == b.position.x)
                && (this.position.y == b.position.y);
    }

    public Boolean dartHitTopHuh() {
        return this.position.y == 0;
    }

    public static LinkedList<Dart> removeDart(LinkedList<Dart> ds, Queue bq) {
        while (!bq.isEmpty()) {
            try {
                Balloon firstBl = bq.front();
                Dart firstD = ds.element();
                if ((firstD.dartHitTopHuh()) || firstD.hitBalloonHuh(firstBl)) {
                    ds.remove(firstD);
                    bq = bq.back();
                }
            } catch (EmptyException e) {
                return ds;
            } catch (java.util.NoSuchElementException e) {
                return ds;
            }
        }
        return ds;
    }

    public WorldImage drawDart() {
        return new RectangleImage(new Posn(this.position.x, this.position.y),
                1, 4, new White());
    }

    public void drawDarts() {
        while (!darts.isEmpty()) {
            for (int i = 0; i < darts.size(); i++) {
                darts.get(i).drawDart();
            }
        }
    }
}
