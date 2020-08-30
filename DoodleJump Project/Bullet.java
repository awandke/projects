/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.net.*;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Bullet extends Actor 
{
    protected Image sprite;
    private Doodler doodler = RUNME.getDoodler();
    private  int startX = doodler.getX() + doodler.getHitX() + doodler.getHitWidth()/2;
    private int startY = doodler.getY();
    private int velocity = 8;
    private double angle;
    
    public Bullet(int x, int y)
    {
       super(x,y,"Images/Bullet.jpg");
       
    }
    public Bullet(){
        super(RUNME.getDoodler().getX() + RUNME.getDoodler().getHitX() + RUNME.getDoodler().getHitWidth()/2,
            RUNME.getDoodler().getY(),"Images/Bullet.jpg");
        
        
            
            angle = Math.atan(Math.abs(y-RUNME.getClickY())/(RUNME.getClickX()-x));
        if (angle <0)
            angle += Math.PI;
        else if (angle == 0){
            if (RUNME.getClickX() > x)
                angle =0;
            else 
                angle = Math.PI;
            }
             
        
        hitWidth = 13;
        hitHeight = 13;
            
    }
    
    public void checkCollision(){
        ArrayList<Actor> actors = Actor.getActors();
        for (Actor a: actors){
            if (a instanceof Monster){
                int bulTop = y;
                int bulBot = y+hitY;
                int bulLeft = x;
                int bulRight = x + hitX;
                
                int monTop = a.getY()+ a.getHitY();
                int monBot = monTop + a.getHitHeight();
                int monLeft = a.getX() + a.getHitX();
                int monRight = monLeft + a.getHitWidth();
                
                if (((bulTop >monTop && bulTop < monBot) || (bulBot >monTop && bulBot < monBot))
                && (((bulLeft > monLeft)&&(bulLeft < monRight))||((bulRight > monLeft)&&(bulRight < monRight)))){
                    a.death();
                    this.remove();
                }
            }
        }
       
        
        
    }
    
    public void act()
    {

        checkCollision();
        if (x>-15 && x< 375 && y >-100){
            x+= Math.cos(angle)*velocity;
            y-= Math.abs(Math.sin(angle)*velocity);
        }
        else 
            this.remove();
            
        
        
    }
    
    public void remove(){
        Actor.getBullets().remove(this);
    }
 
    }
    


