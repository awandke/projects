/**
 * Alan Wandke 
 * A platform that moves from side to side 
 */
public class SideSidePlatform extends Platform
{
    int speed =2;
    
    public SideSidePlatform(int x, int y, int speed){
        super(x,y,"images/Moving_Platform.png");

       hitX = 1;
       hitY = 1;
       hitWidth = 56;
       hitHeight = 9;
       this.speed = speed;

    }
    
    public SideSidePlatform(int x, int y)
    {
        super(x,y,"images/Moving_Platform.png");

       hitX = 1;
       hitY = 1;
       hitWidth = 56;
       hitHeight = 9;
       speed = 1;
    }
    
    public SideSidePlatform(){
        super(0,0,"images/Moving_Platform.jpg");
    }
    
    public void act(){
  
        if (x+hitX+hitWidth>= 350 || x <=0)
           speed *=-1;     
        
           x += speed; 
    }

}
