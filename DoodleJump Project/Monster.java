/**
 * Alan and Kyle 
 * 
 */
public abstract class Monster extends Actor
{
    
    public Monster(int x, int y, String path){
        super(x,y,path);
    }
    
    public void act(){
        if (!alive){
            //RUNME.getDoodler().addVelocity(100);
            if (y<1000)
                y+=6;
        }
    }
    
}
