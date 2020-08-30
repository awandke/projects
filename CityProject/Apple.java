
/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Apple implements Runnable
{
    // instance variables - replace the example below with your own
    String name;
    private int time;
    Random r = new Random();

    /**
     * Constructor for objects of class Apple
     */
    public Apple(String s)
    {
        // initialise instance variables
        name =s;
        time = r.nextInt(999);
    }

    /**
     * An example of a method - replace this comment with your own
     * MUST WRITE RUN FOR THE RUNNABLE INTERFACE
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void run()
    {
        try{
            System.out.printf("%s is sleeping for %d\n",name,time);
            Thread.sleep(time);
            System.out.printf("%s is done\n",name);
        }catch (Exception e){}
  
    }
}
