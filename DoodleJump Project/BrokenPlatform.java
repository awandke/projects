/**
 * Alan Wandke 
 * a platform that will break instead of giving doodler upward velocity
 */
public class BrokenPlatform extends Platform
{
    
    
    public BrokenPlatform(int x, int y)
    {
        super(x,y,"images/BrokenPlatform.png");
        
        hitY = 4;
        hitX = 3;
        hitWidth = 57;
        hitHeight = 14;
        
        
    }
    
    public void act(){
        if (!alive){
            setSprite("Images/DeadPlatform.png");
            if (y<1000)
                y+=6;
            }
    }
    


}
