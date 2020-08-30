
import java.awt.*;
import javax.swing.*;

/**
 * Class Startingpoint -
 * Demo of Applets and Runnable
 *
 * @author (Bucky and me)
 * @version (1.0)
 */

public class Startingpoint extends JApplet implements Runnable// new stuff
{
    // instance variables - replace the example below with your own
    private int x = 0;
    private int y = 0;
    private int dx = 1;
    private int dy = 2;
    private int radius = 20;

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first
     * time that the start method is called.
     */
    //@Override
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do
        // not allow access to the AWT system event queue which JApplets do
        // on startup to check access. May not be necessary with your browser.
        //JRootPane rootPane = this.getRootPane();
        //rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

        // provide any initialisation necessary for your JApplet
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * should start its execution. It is called after the init method and
     * each time the JApplet is revisited in a Web page.
     */
    //@Override
    public void start()
    {
        //sets up the Thread
        Thread thread = new Thread(this);
        thread.start();
       
    }
    //@Override
    public void run()
    {
        //thread information
       

    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed.
     */
    //@Override
    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed
    }

    /**
     * Paint method for applet.
     *
     * @param  g   the Graphics object for this applet
     */
    //@Override
    public void paint(Graphics g)
    {

       

    }


    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy.
     */
   // @Override
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }


    /**
     * Returns information about this applet.
     * An applet should override this method to return a String containing
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }


    /**
     * Returns parameter information about this JApplet.
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings
     * describing these parameters.
     * Each element of the array should be a set of three Strings containing
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                 {"firstParameter",    "1-10",    "description of first parameter"},
                 {"status", "boolean", "description of second parameter"},
                 {"images",   "url",     "description of third parameter"}
        };
        return paramInfo;
    }
}
