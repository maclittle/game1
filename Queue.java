package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;

public interface Queue {

    public boolean isEmpty();
    public Queue add(Balloon b);
    public Queue remove();
    public Balloon front() throws EmptyException;
    public Queue back();
    public int queueSize();
    public Queue moveBalloons();
    public WorldImage drawBalloons();
}
