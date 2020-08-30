/**
 * Alan Wandke 
 * springs will give the doodler lots of upward velocity,
 * they will appear on platforms and are smaller 
 */
public class Spring extends Actor
{
    private boolean used = false;
    private Platform p; 
    
    public Spring (int x, int y)
    {
        super (x,y,"Images/Spring.jpg");  
      
        hitX =0;
        hitY = 0;
        hitWidth = 20;
        hitHeight = 18;
    }
    

    
}
