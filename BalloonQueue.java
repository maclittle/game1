package game1;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import tester.*;


public class BalloonQueue implements Queue {
 
    Balloon first;
    Queue rest;
    
    BalloonQueue(Balloon first, Queue rest){
        this.first = first;
        this.rest = rest;
    }
    
    public boolean isEmpty(){
        return this.first == ();
    }
    
    public Queue add(Balloon b){
        if (this.queueSize() <= 3) {
        return new BalloonQueue(this.first, this.rest.add(b));
        } else return this;
    }
    
    public Queue remove(){
        return new BalloonQueue(rest.front(), this.rest.rest); 
    }
    
    public Balloon front(){
        return this.first;
    }
    
    public Queue back(){
        return this.rest;
    }
    
    public int queueSize(){
        return (1 + rest.queueSize());
    }
    
    public Queue moveBalloons(){
        
    }
    
    public WorldImage drawBalloons(){
        
    }
    
    
}
