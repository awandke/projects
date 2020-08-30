/**
 * Alan Wandke
 * constructs a stationary monster 
 */
public class BasicMonster extends Monster
{
    
    public BasicMonster(int x, int y)
    {
       super(x,y,"images/Monster.jpg");

       hitX = 11;
       hitY = 8;
       hitWidth = 39;
       hitHeight = 26;
    }
    
    public BasicMonster()
    {
        super(0,0,"images/Monster.jpg");
        
        
    }
}
