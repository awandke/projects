/**
 * Alan Wandke 
 * a platform that will move up and down 
 */
public class UpDownPlatform extends Platform
{
    int speed;
    int pivot; 
    
    public UpDownPlatform(int x, int y, int speed)
    {
        super(x,y,"images/UpDownPlatform.png");
        this.speed = speed;
        pivot = y;
        
        hitX = 1;
        hitY = 1;
        hitWidth = 57;
        hitHeight = 14;
        
    }
    
    public UpDownPlatform(int x, int y)
    {
        super(x,y,"images/UpDownPlatform.png");
        speed = 1;
        pivot = y;
        
        hitX = 1;
        hitY = 1;
        hitWidth = 57;
        hitHeight = 14;
    }
    
    public void act(){
        
        if (pivot > y + 100 || pivot < y-100)
           speed *=-1;     
        
           y -= speed; 
        
    }

    public void addHeight(int y){
        this.y-=y;
        pivot-=y;
    }
    
}
