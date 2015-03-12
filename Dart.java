package game1;

import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;
import javalib.colors.*;
import java.util.LinkedList;

public class Dart {

    Posn position;
    LinkedList<Dart> darts;

    Dart(Posn position) {
        this.position = position;
    }

    public static LinkedList<Dart> fireDart(LinkedList<Dart> d) {
        Dart fired = new Dart(Player.position);
        d.addFirst(fired);
        return d;
    }

    public Dart moveDartUp() {
        position = new Posn(position.x, position.y + 15);
        return new Dart(position);
    }

    public static LinkedList<Dart> moveAllDarts(LinkedList<Dart> d) {
        while (!d.isEmpty()) {
            for (int i = 0; i < d.size(); i++) {
                d.get(i).moveDartUp();
            }
        }
        return d;
    }

    public static Boolean hitBalloonHuh(Balloon b, Dart d) {
        return (d.position.x == b.position.x)
                && (d.position.y == b.position.y);
    }

    public static Boolean anyHitBalloon(Queue bq, LinkedList<Dart> ds) {
        try {
            for (Dart d : ds) {
                while (!bq.isEmpty()) {
                    if (hitBalloonHuh(bq.front(), d)) {
                        return true;
                    } else {
                        return anyHitBalloon(bq.back(), ds);
                    }
                }
            }
        } catch (EmptyException e) {
            return false;
        } return false;
    }

    public Boolean dartHitTopHuh() {
        return this.position.y == 0;
    }

    public static LinkedList<Dart> removeDart(LinkedList<Dart> ds, Queue bq) {
        while (!bq.isEmpty()) {
            try {
                Balloon firstBl = bq.front();
                Dart firstD = ds.element();
                if ((firstD.dartHitTopHuh())
                        || firstD.hitBalloonHuh(firstBl, firstD)) {
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
                2, 6, new White());
    }

    public static WorldImage drawDarts(LinkedList<Dart> darts) {
        while (!darts.isEmpty()) {
            for (Dart d: darts) {
                return d.drawDart();
            }
        }
        return new RectangleImage(new Posn(800, 800), 1, 1, new Black());
    }

}
