
/**
 * Write a description of class AppleRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThreadRunner
{
   
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args)
    {
        // put your code here
        Thread t1 = new Thread(new Apple("one"));
        Thread t2 = new Thread(new Apple("two"));
        Thread t3 = new Thread(new Apple("three"));
        t1.start();
        t2.start();
        t3.start();
    }
}
