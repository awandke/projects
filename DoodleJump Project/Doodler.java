
/**
 * Alan Wandke 
 * Kyle Zhao 
 * represents the main charater: a doodler that can shoot at stuff 
 */
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class Doodler extends Actor implements Runnable
{
    private int velocity = 11; 
    private boolean recentShot = false;
    //private int x,y;  
    private static int count =0;
   
    
    public Doodler(int x, int y)
    {
        super(x,y,"Images/RightDoodler.png");
        hitX = 6;
        hitY = 6;
        hitHeight = 45;
        hitWidth = 29;
       // this.x = x;
        //this.y = y;
        //setSprite("images/doodler.jpg");
    }
    
    public void shoot()
    {
            Actor.addBullet();
            
    }

    public void addVelocity(int change){
        velocity += change;
    }
    
    public void addX(int change){
        x+=change;
    }
    
    public void addY(int change){
        y-= change;
    }
    
    public void setY(int val){
        y=val;
    }
    
    public void move(){
        if (RUNME.getTypedStatus())
        {
            if (RUNME.getTypedChar().equals("a"))
            {
                x-=5;
                setSprite("Images/LeftDoodler.png");
            }
            else if (RUNME.getTypedChar().equals("d"))
            {
                x+=5;
                setSprite("Images/RightDoodler.png");
            }
        }
        
        if(RUNME.getClicked()){
            if (!recentShot){
                shoot();
               
                recentShot = true;
            }
            
            if (count%10 ==0)
                recentShot= false;
            //velocity++;
        }
        
        if ((x + hitX + hitWidth/2) <= 0)
            x+=350;
        if ((x + hitX + hitWidth/2) >= 350)
            x-=350;
        
        y-=velocity;
        if (velocity >-8 && count % 4 ==0)
            velocity--;
        
        if (y>620)
            death();
        count++;
    }
    
    public void draw(Graphics page){
        page.drawImage(sprite,x,y,null);
        
    }
    
    public void checkCollision(){
        ArrayList<Actor> actors = Actor.getActors();
        for (Actor a: actors){
            if (a instanceof Platform){
                int platStartX = a.getX()+a.getHitX(); 
                int platStartY = a.getY() + a.getHitY();
                int platEndX = platStartX + a.getHitWidth();
                int platEndY = platStartY + a.getHitHeight();
                
                int doodlerLeft = x+hitX;
                int doodlerRight = x+hitX+hitWidth;
                int doodlerY =  y+hitY+hitHeight;
                if (velocity <0 && ((platStartX<doodlerLeft && doodlerLeft < platEndX) || 
                    (platStartX < doodlerRight && doodlerRight < platEndX)) 
                     &&( platStartY < doodlerY && doodlerY< platEndY)){
                     if (a instanceof BrokenPlatform)
                         a.death(); 
                     else if (a instanceof DisappearPlatform){
                         velocity = 10;
                         a.death();
                        }
                     else 
                         velocity = 10; 
                }
            }
                    
            else if (a instanceof Monster){
                int doodlerTop = y+hitY;
                int doodlerBottom = y+hitY+hitHeight;
                int doodlerLeft = x+hitX;
                int doodlerRight = x+hitX+hitWidth;
                
                int monsterTop = a.getY()+ a.getHitY();
                int monsterBottom = monsterTop + a.getHitHeight();
                int monsterLeft = a.getX() + a.getHitX();
                int monsterRight = monsterLeft + a.getHitWidth();
                
                
                
                if ((doodlerLeft > monsterLeft && doodlerLeft<monsterRight) || 
                (doodlerRight > monsterLeft && doodlerRight < monsterRight)){
                
                    if (velocity<0 && (doodlerBottom < monsterTop+3 && doodlerBottom > monsterTop-6)){//top of monster 
                        velocity = 11;
                        a.death();
                        if (a instanceof BossMonster){
                            ((BossMonster)a).loseLives(15);
                        }
                    }
                    
                    if (doodlerTop >= monsterBottom-10 && doodlerTop <= monsterBottom+10){//bottom of monster       
                        if (a.alive)
                            death();
                    }
                }
                
            }
            else if (a instanceof Spring){
                int doodlerBottom = y+hitY+hitHeight;
                int doodlerLeft = x+hitX;
                int doodlerRight = x+hitX+hitWidth;
                
                int sTop = a.getY();
                int sBot = sTop + a.getHitHeight();
                int sLeft = a.getX();
                int sRight = a.getX() + a.getHitWidth();
                
                if (velocity<0 && (doodlerBottom < sBot && doodlerBottom > sTop) && 
                ((sRight < doodlerRight && sRight > doodlerLeft) || (sLeft < doodlerRight && sLeft > doodlerLeft))){
                    velocity = 17;
                    a.setSprite("images/UsedSpring.jpg");
                    a.addHeight(10);
                }
                
            }
            else 
                return; 
        }

    }
    
    public int getVelocity(){
        return velocity;
    }
    
    public void run(){
        while(true){
            for (int i = Actor.getBullets().size()-1; i>=0;i--)
                Actor.getBullets().get(i).act();
            
            if (alive){
                checkCollision();
                move();}
            else if (!alive && y<1000){
                if (velocity > -8)
                    velocity --;
                y-= velocity;
            }
            
            try{
                    Thread.sleep(10);
                }
                catch(InterruptedException e){}
            
        }
    
    }
    
}
