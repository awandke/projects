/**
 * Write a description of class World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;

public class World implements Runnable 
{
    
    public World(){
        
    }  
    
    public void updatePos(){
        if (RUNME.getDoodler().getY()<260){
            int startY = RUNME.getDoodler().getY();
            for (Actor a: Actor.getActors()){
                
                    a.addHeight(-1*RUNME.getDoodler().getVelocity());
                    RUNME.getDoodler().setY(260);
                
                
                
            }
            
        }
        for ( Actor a: Actor.getActors())
            a.act();
        
    }
    
    public void run(){
        while (true){
            updatePos();
           
        
            try{
                    Thread.sleep(10);
                }
                catch(InterruptedException e){}
                
        
            }
}
    
}
