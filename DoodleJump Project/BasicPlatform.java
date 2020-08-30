/**
 * Alan Wandke
 * a stationary platform that will doodler will bounce off of
 */
public class BasicPlatform extends Platform
{

    public BasicPlatform(int x,int y)
    {
       super(x,y,"images/Platform.png");

       hitX = 11;
       hitY = 9;
       hitWidth = 50;
       hitHeight = 9;

    }

    public BasicPlatform(){
        super(0,0,"images/Platform.png");
    }

}
