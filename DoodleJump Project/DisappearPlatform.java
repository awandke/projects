/**
 * Alan Wandke 
 * a stationary platform that will allow doodler to bounce on it once, then disappear
 */
public class DisappearPlatform extends Platform
{
    private boolean onetime = false;
    
    public DisappearPlatform(int x, int y)
    {
       super(x,y,"images/DisappearPlatform.jpg");
       
       hitX = 4;
       hitY = 3;
       hitWidth = 57;
       hitHeight = 14;
       
    }
    
    public void act(){
        if (!alive && !onetime){
            onetime = true;
            hitWidth = 0;
            hitHeight = 0; 
            setSprite("images/Blank.jpg");
        }
     }
    
    
}
