/**
 * Alan Wandke 
 * Kyle Zhao 
 */
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public abstract class Actor implements Runnable
{
    protected int x =0, y=0;
    protected int hitX = 0, hitY = 0, hitHeight = 0, hitWidth = 0;
    private String path;
    protected boolean alive = true;
    protected Image sprite;
    
    private static ArrayList<Actor> actors = new ArrayList<>();
    private static ArrayList<Bullet> bullets = new ArrayList<>();
    
    public Actor (String path){
        setSprite(path);
    }
    
    public Actor(int x, int y, String path){
        this.x = x;
        this.y=y;
        this.path = path; 
        setSprite(path);
        
        if (!(this instanceof Doodler) && !(this instanceof Bullet))
            actors.add(this);
    }
    
    public void setSprite(String path){
        try{
            sprite = ImageIO.read(new File(path));
        }catch (IOException e){}
    }
    
    public void draw(Graphics page){
        page.drawImage(sprite,x,y,null);
    }
    
    public void act(){}
    
    public void death(){
        alive = false;
    }
    
      public boolean isAlive(){
        return alive;
    }
    
    public void run(){
        for (Actor a: getActors()){
                a.act();
            }
    
    }
    
    public static ArrayList<Actor> getActors(){
        return actors;
    }
    
    public static ArrayList<Bullet> getBullets(){
        return bullets;
    }
    
    public static void addBullet(){
        bullets.add(new Bullet());
    }
    
    public String getPath()
    {
        return path;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void updateHeight()
    {
        
    }
    
    public void addHeight(int y){
        this.y-=y;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getHitX(){
        return hitX;
    }
    
    public int getHitY(){
        return hitY;
    }
    
    public int getHitWidth(){
        return hitWidth;
    }
    
    public int getHitHeight(){
        return hitHeight;
    }
    
}
