//https://way2java.com/awt-events/java-applet-tutorial-mouselistener-mouseevent-mouse-input-example/
// this is used as a model for the eventual applet
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
 
public class AppletMouseListener extends Applet implements MouseListener
{
  String str="";
                       // init() in place of frame constructor
  public void init()
  {
    addMouseListener(this);
  }
                       // override all the 5 abstract methods of MouesListener
  public void mousePressed(MouseEvent e)
  {
    str = "You pressed mouse" + e.getX() + e.getY();
    repaint();
  }
  public void mouseReleased(MouseEvent e)
  {
    str = "You released mouse" + e.getX() + e.getY();
    repaint();
  }  
  public void mouseClicked(MouseEvent e)
  {
    str = "You clicked mouse" + e.getX() + e.getY();
    repaint();
  }  
  public void mouseEntered(MouseEvent e)
  {
    str = "Mouse entered frame" + e.getX() + e.getY();
    repaint();
  }  
  public void mouseExited(MouseEvent e)
  {
    str = "Mouse existed frame" + e.getX() + e.getY();
    repaint();
  }
                       // write paint() method to draw on applet window
  public void paint(Graphics g)
  {
    g.drawString(str, 75, 150); 
  }
}