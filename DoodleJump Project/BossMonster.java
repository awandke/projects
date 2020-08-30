/**
 * Alan Wandke 
 * a monster will multiple lives - larger too 
 */
public class BossMonster extends Monster
{
    int lives = 8;
    
    
    public BossMonster(int x, int y)
    {
        super(x,y,"images/BossMonster.png");
        
        hitX = 5;
        hitWidth = 96;
        hitY = 5;
        hitHeight = 55;
        
        
    }
    
    public void act(){
        if (lives<=0){
            super.death();
            if(y<1000)
                y+=6;
        }
    
    }
    
    public void death (){
        lives--;
    }
    
    public void loseLives(int amt){
        lives -= amt;
    }

}
