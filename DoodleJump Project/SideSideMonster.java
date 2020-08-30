/**
 * Alan Wandke 
 * a monster that moves side to side
 */
public class SideSideMonster extends Monster
{
    int speed;
    
    public SideSideMonster(int x, int y, int speed)
    {
        super(x,y,"Images/RightSideSideMonster2.png");
        
        this.speed = speed;
        
        hitX = 6;
        hitY = 7;
        hitWidth = 45;
        hitHeight = 49;
        
    }
    
    public SideSideMonster(int x, int y)
    {
        super(x,y,"Images/RightSideSideMonster2.png");
        
        this.speed = 1;
        
        hitX = 6;
        hitY = 7;
        hitWidth = 45;
        hitHeight = 49;
    }
    
    public void act(){
        super.act();
        if (alive){
            if (x+hitX>= 350 || x <=0)
            {
               if (speed>0)
                setSprite("Images/LeftSideSideMonster.png");
               else
                setSprite("Images/RightSideSideMonster2.png");
               speed *=-1;     
            }
               x += speed; 
            }
    }

}
