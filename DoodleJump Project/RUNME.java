/**
 * Alan Wandke 
 * Kyle Zhao 
 * 
 */
import java.util.Random;
import java.util.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;

public class RUNME extends Applet implements MouseListener, KeyListener
{
   private static final int APPLET_WIDTH = 350;
   private static final int APPLET_HEIGHT = 650;
   String str = "";
   private static String typedchar;
   
   private static boolean started = false; 
   private static boolean clicked = false, typed = false;
   private static int clickx, clicky;
   
   private World w1 = new World();
   
   private Image bckgrdsprite;
   
   private Image dbImage; //used for double buffering
   private Graphics dbg;
   
   private static Doodler doodler = new Doodler(APPLET_WIDTH/2,APPLET_HEIGHT-110);
   //private Image Doodler = null;
   //private final Image basicPlatform = null;
   
   private Actor[] stage1 = 
                        {new BasicPlatform(10,0), new BasicPlatform(80,50),new BasicPlatform(190,85), new DisappearPlatform(5,105), new BasicPlatform(7,130),
                        new BasicPlatform(70,155), new BasicPlatform(120,190), new BasicPlatform(170,220), new BasicPlatform(5,260), new BasicPlatform(30,290),
                        new BasicPlatform(290,310), new BasicPlatform(290,350), new BasicPlatform(290,390), new BasicPlatform(290,430), new BasicPlatform(50,460),
                        new BasicPlatform(30,290), new BasicPlatform(150,300), new BasicPlatform(20,400),
                        new BasicPlatform(270,510), new BasicPlatform(240,550), new BasicPlatform(235,580), new BasicPlatform(30,610), new BasicPlatform(5,550),
                        new BasicPlatform(175,630), new BasicPlatform(150,-10), new Spring(155,-15), new BrokenPlatform(160,-60), new BrokenPlatform(200,-160),
                        new BrokenPlatform(10,-140), new BasicPlatform(100,-170), new BasicPlatform(170,-200), new BasicPlatform(10,-250), 
                        new BasicPlatform(270,-260), new BasicPlatform(290,-300),new BasicPlatform(100, -330), new BasicPlatform(50,-370), new BasicPlatform(150,-430), 
                        new BasicPlatform(250,-465), new BasicPlatform(50,-465),new BasicPlatform(20,-490), new BasicPlatform(170,-510), new BasicPlatform(200,-570), 
                        new BasicPlatform(260,-600), new BasicPlatform(40,-585),new SideSidePlatform(290,-640), new BasicPlatform(15,-620),new Spring(30,-625), 
                        new BasicPlatform(200,-620),new BasicPlatform(150,-700), 
                        new BasicPlatform(220,-710), new SideSidePlatform(70,-750), new BasicPlatform(110,-830),new BasicPlatform(170,-870),new BasicPlatform(10,-840), 
                        new BasicPlatform(200,-910), new UpDownPlatform(130,-1000), new UpDownPlatform(280,-960), new BasicPlatform(50,-1050), new BasicPlatform(185,-1000),
                        new BasicPlatform(10,-975), new BasicPlatform(190,-1200), new BasicPlatform(280,-1270), new BasicPlatform(170,-1260), new BrokenPlatform(270,-1150),
                        new BasicPlatform(60,-1250), new SideSidePlatform(100,-1300),new BasicPlatform(20,-1200),new BasicPlatform(50,-1150), new BasicPlatform(200,-1340), 
                        new BasicPlatform(150,-1390),new BasicPlatform(100,-1440),new BasicPlatform(100,-1490),new BasicPlatform(190,-1500), new BasicPlatform(20,-1420), 
                        new BasicPlatform(170,-1540),new BasicPlatform(260,-1480),new BrokenPlatform(200,-1590),new BasicPlatform(50,-1580),new BrokenPlatform(20,-1470),
                        new SideSidePlatform(100,-1630),new BrokenPlatform(130,-1700),new BasicPlatform(240,-1680), new BasicPlatform(260,-1760),
                        new BasicPlatform(10,-1750),new BasicPlatform(100,-1790),new BasicPlatform(50,-1820),new BasicPlatform(200,-1840),new BrokenPlatform(210,-1870),
                        new BasicPlatform(250,-1910),new BasicPlatform(50,-1930),new BasicPlatform(140,-1970),new SideSidePlatform(200,-2050),
                        new BasicPlatform(100,-2120),new BasicPlatform(70,-2190),new BasicPlatform(200,-2200),new BrokenPlatform(110,-2250),new BasicPlatform(180,-2320),
                        new BasicPlatform(200,-2260),
                        new BasicPlatform(20,-2400),new SideSidePlatform(60,-2450),new BasicPlatform(200,-2500),new BasicPlatform(220,-2540),new BasicPlatform(60,-2500),
                        new BasicPlatform(120,-2550),new BasicPlatform(220,-2580),new BasicPlatform(70,-2600)}; //finished for now, can use more variety like springs
   
   private Actor[] stage2 = 
                        {new BasicPlatform(10,-50),new BasicPlatform(90,-70),new DisappearPlatform(50,-160),new SideSidePlatform(190,-210),new SideSidePlatform(20,-260),
                        new BasicPlatform(200,-300),new BasicPlatform(240,-340),new BasicPlatform(170,-370),new BrokenPlatform(140,-410),new BrokenPlatform(140,-440),
                        new BasicPlatform(50,-320),new SideSidePlatform(190,-490),new BasicPlatform(60,-570),new BasicPlatform(20,-640),new Spring(45,-645), 
                        new SideSideMonster(160,-850,2),new BasicPlatform(200,-920),new BasicPlatform(250,-970),new BasicPlatform(170,-1020),new BasicPlatform(190,-1070),
                        new BasicPlatform(40,-1160),new BrokenPlatform(30,-1200),new SideSidePlatform(90,-1260,-1),new SideSidePlatform(170,-1330),new SideSidePlatform(20,-1400),
                        new BasicPlatform(10,-1470),new BasicPlatform(70,-1520),new BrokenPlatform(30,-1560),new BasicPlatform(160,-1630),new SideSidePlatform(200,-1690),
                        new BrokenPlatform(260,-1780),new DisappearPlatform(270,-1750),new BasicPlatform(250,-1830),new BasicPlatform(250,-1950),new BasicPlatform(0,-1820),
                        new BasicPlatform(5,-2000),new UpDownPlatform(115,-1900,-1),new UpDownPlatform(180,-1970),new BasicPlatform(140,-2150),new BasicPlatform(230,-2300),
                        new BasicPlatform(232,-2330),new BrokenPlatform(230,-2360),new BasicPlatform(50,-2280),
                        new BasicPlatform(160,-2400),new BasicPlatform(100,-2450),new BrokenPlatform(5,-2480),
                        new BasicPlatform(200,-2450),new BasicPlatform(260,-2500),new BrokenPlatform(260,-2600),new BasicPlatform(60,-2600),new BasicPlatform(80,-2670),
                        new BasicPlatform(150,-2800),new BasicPlatform(220,-2720),new BasicPlatform(180,-2750),new BasicPlatform(20,-2800),
                        new BasicPlatform(40,-2860),new BasicMonster(40,-3000),new BasicPlatform(190,-2930),new BasicPlatform(230,-2970),new BasicPlatform(150,-3050),
                        new BrokenPlatform(180,-3100),new BrokenPlatform(270,-3090),new BasicPlatform(60,-3100),new SideSidePlatform(260,-3150,2),
                        new SideSidePlatform(50,-3200,-2)};
   
   private Actor[] stage3 =
                        {new SideSidePlatform(20,-70,-1),new SideSidePlatform(100,-140),new SideSidePlatform(200,-200),new SideSidePlatform(250,-260,2),
                        new SideSidePlatform(160,-320,2),new SideSidePlatform(100,-390,-2),new SideSidePlatform(200,-460,-3),new SideSidePlatform(5,-540,3),
                        new SideSidePlatform(200,-620,4),new SideSidePlatform(150,-710,-4),new SideSidePlatform(20,-800,7),new SideSidePlatform(20,-850,-1),
                        new SideSidePlatform(100,-910),new DisappearPlatform(270,-920),new SideSidePlatform(200,-1080,3),new SideSidePlatform(250,-1130,2),
                        new SideSidePlatform(160,-1200,2),new DisappearPlatform(100,-1220),new SideSidePlatform(100,-1290,-2),new SideSidePlatform(200,-1320,-3),
                        new SideSidePlatform(5,-1350,-3), new SideSideMonster(100,-1400,3),new SideSideMonster(160,-1410,4),new SideSideMonster(200,-1440,-4),
                        new SideSideMonster(160,-1400,-4),new SideSideMonster(270,-1500,3),new SideSideMonster(300,-1450,-4),
                        new BasicPlatform(80,-1500),new BasicPlatform(120,-1500),new BasicPlatform(200,-1500),new BasicPlatform(10,-1500),
                        new BasicPlatform(260,-1500),new BasicPlatform(300,-1500),new DisappearPlatform(150,-1590),new DisappearPlatform(150,-1680),
                        new DisappearPlatform(150,-1770),new DisappearPlatform(150,-1860),new BasicMonster(100,-1900), new BasicMonster(230,-2030),
                        new BasicMonster(100,-2160),new BasicMonster(230,-2290),new BasicMonster(100,-2410),new BasicMonster(10,-2690),
                        new BasicMonster(250,-2830),new BasicMonster(170,-2970),new BasicMonster(50,-3110),new BasicMonster(120,-3250),new BasicPlatform(100,-2550)};
 
   private Actor[] stage4 = {new DisappearPlatform(30,-20),new DisappearPlatform(200,-80),new DisappearPlatform(170,-150),new DisappearPlatform(100,-220),
                            new DisappearPlatform(80,-290),new DisappearPlatform(45,-360),new BrokenPlatform(40,-380),new DisappearPlatform(90,-430),
                            new DisappearPlatform(190,-500),new DisappearPlatform(240,-570),new BrokenPlatform(10,-570),new DisappearPlatform(140,-640),
                            new DisappearPlatform(40,-710),new DisappearPlatform(100,-780),new DisappearPlatform(200,-850),new DisappearPlatform(170,-920),
                            new DisappearPlatform(10,-990),new DisappearPlatform(40,-1040),new DisappearPlatform(80,-1110),new DisappearPlatform(140,-1280),
                            new DisappearPlatform(200,-1450)};

   private ArrayList<Actor> level;
   //private Spring s1 = new Spring (190,85);
   
   
   public void init ()
   {      
      Thread t1 = new Thread(doodler);
      t1.start();
      
      Thread t2 = new Thread(w1);
      t2.start();
      
      addMouseListener(this);
      addKeyListener(this);
      //setBackground (Color color);
      
      setSize (APPLET_WIDTH, APPLET_HEIGHT);
      
      for (Actor b: stage2)
      {
          b.addHeight(4*APPLET_HEIGHT);
        }
      
      for (Actor c: stage3)
      {
          c.addHeight(9*APPLET_HEIGHT);
        }
      
      for (Actor d: stage4)
      {
          d.addHeight(14*APPLET_HEIGHT);
        }
          try{
              bckgrdsprite = ImageIO.read(new File("Images/Start.jpg"));
            }
            catch(IOException e){} 
      
   }

   public void paint (Graphics page)
   {  
    if(!started){
        
        page.drawImage(bckgrdsprite,0,0,this);
        
        if (clicked){
            started = true;
                try{
              bckgrdsprite = ImageIO.read(new File("Images/Background.png"));
            }
            catch(IOException e){} 
        }
    }
    else{ 
          page.drawImage(bckgrdsprite,0,0,this);
          for (Actor a: stage1){
              a.draw(page);
          }
          for (Actor b: stage2){
              b.draw(page);
            }
          for (Actor c:stage3){
              c.draw(page);
            }
          for (Bullet b: Actor.getBullets()){
              b.draw(page);
            }
          for(Actor d:stage4) 
          {
            d.draw(page);
            }
            //s1.draw(page);
          
     
          doodler.draw(page);
          
          //page.drawString(doodler.getX() +"    "+ doodler.getY() + "     " + doodler.getVelocity(),70,70);
          //page.drawString(""+Actor.getBullets().size(),70,70);
          
          if (!doodler.isAlive()){
              try{
                  bckgrdsprite = ImageIO.read(new File("Images/GameOver.jpg"));
            }
            catch(IOException e){} 
             
            
            }
        
    }
      
      try{
        //pause the program for a quarter sec in miliseconds
        Thread.sleep(20);
        }
        catch(InterruptedException e){}
      repaint();
      
    }
   
   /*
   public void addStage(){
       if (level.get(level.size()-1).getY() > 250){
           level.addAll(makeStage1());  
       }
   }
   
   /**
    * This code is from: http://www.jguru.com/article/client-side/double-buffering.html
    */
   public void update (Graphics g)
   {
        dbImage = createImage (this.getSize().width, this.getSize().height);
        dbg = dbImage.getGraphics ();
        // initialize buffer
        if (dbImage == null)
        {}
        
        // clear screen in background
        dbg.setColor (getBackground ());
        dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
        
        // draw elements in background
        dbg.setColor (getForeground());
        paint (dbg);
        
        // draw image on the screen
        g.drawImage (dbImage, 0, 0, this);
    }
   
   
   
   
   
   public static Doodler getDoodler(){
       return doodler;
    }
   
   
    //MOUSELISTENER METHODS
    //---------------------
    public void mousePressed(MouseEvent e)
    {
        str = "You pressed mouse" + e.getX() + e.getY();
        clicked = true;
        clickx = e.getX();
        clicky = e.getY();
        repaint();
    }
    public void mouseReleased(MouseEvent e)
    {
        str = "You released mouse" + e.getX() + e.getY();
        clicked = false;
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
    //associated with MouseListener
    public static boolean getClicked()
    {
       return clicked;
    }
    
    public static int getClickX()
    {
        return clickx;
    }
    
    public static int getClickY()
    {
        return clicky;
    }
    //KEYLISTENER METHODS: IMPORTANT TO NOTE! KEYLISTENER ONLY WORKS IF USER HAS CLICKED ON APPLET SCREEN BEFORE
    //-------------------
    public void keyPressed(KeyEvent e)
    {
        typedchar = ""+e.getKeyChar();
        typed = true;
        repaint();
    }
    public void keyReleased(KeyEvent e)
    {
        typed = false;
        repaint();
    }
    public void keyTyped(KeyEvent e)
    {
        repaint();
    }
    
    public static boolean getTypedStatus()
    {
        return typed;
    }
    public static String getTypedChar()
    {
        return typedchar;
    }
    
    //STAGE METHODS ---------------------
   
    public ArrayList<Actor> makeStage1(){
         ArrayList<Actor> hi = new ArrayList<Actor> (
         Arrays.asList(
                        new BasicPlatform(10,0), new BasicPlatform(80,50), new BasicPlatform(190,85), new BasicPlatform(5,105), new BasicPlatform(7,130),
                        new BasicPlatform(70,155), new BasicPlatform(120,190), new BasicPlatform(170,220), new BasicPlatform(5,260), new BasicPlatform(30,290),
                        new BasicPlatform(290,310), new BasicPlatform(290,350), new BasicPlatform(290,390), new BasicPlatform(290,430), new BasicPlatform(50,460),
                        new BasicPlatform(30,290), new BasicPlatform(150,300), new BasicPlatform(20,400),
                        new BasicPlatform(270,510), new BasicPlatform(240,550), new BasicPlatform(235,580), new BasicPlatform(30,610), new BasicPlatform(5,550),
                        new BasicPlatform(175,630), new BasicPlatform(150,-10), new BrokenPlatform(160,-60), //significantly bigger than BasicPlatform
                        new BrokenPlatform(10,-140), new BasicPlatform(100,-170), new BasicPlatform(170,-200), new BasicPlatform(10,-250), 
                        new BasicPlatform(270,-260), new BasicPlatform(290,-300),new BasicPlatform(100, -330), new BasicPlatform(50,-370), new BasicPlatform(150,-430), 
                        new BasicPlatform(250,-465), new BasicPlatform(50,-465),new BasicPlatform(20,-490), new BasicPlatform(170,-510), new BasicPlatform(200,-570), 
                        new BasicPlatform(260,-600), new BasicPlatform(40,-585),new SideSidePlatform(300,-640), new BasicPlatform(15,-620), new BasicPlatform(200,-620),
                        new BasicPlatform(150,-700), 
                        new BasicPlatform(220,-710), new SideSidePlatform(70,-750), new BasicPlatform(110,-830),new BasicPlatform(170,-870),new BasicPlatform(10,-840), 
                        new BasicPlatform(200,-910), new UpDownPlatform(130,-1000), new UpDownPlatform(280,-960), new BasicPlatform(50,-1050), new BasicPlatform(185,-1000),
                        new BasicPlatform(10,-975), new BasicPlatform(190,-1200), new BasicPlatform(280,-1270), new BasicPlatform(170,-1260), new BrokenPlatform(270,-1150),
                        new BasicPlatform(60,-1250), new SideSidePlatform(100,-1300),new BasicPlatform(20,-1200),new BasicPlatform(50,-1150), new BasicPlatform(200,-1340), 
                        new BasicPlatform(150,-1390),new BasicPlatform(100,-1440),new BasicPlatform(100,-1490),new BasicPlatform(190,-1500), new BasicPlatform(20,-1420), 
                        new BasicPlatform(170,-1540),new BasicPlatform(260,-1480),new BrokenPlatform(200,-1590),new BasicPlatform(50,-1580),new BrokenPlatform(20,-1470),
                        new SideSidePlatform(100,-1630),new BrokenPlatform(130,-1700),new BasicPlatform(240,-1680), new BasicPlatform(260,-1760),
                        new BasicPlatform(10,-1750),new BasicPlatform(100,-1790),new BasicPlatform(50,-1820),new BasicPlatform(200,-1840),new BrokenPlatform(210,-1870),
                        new BasicPlatform(250,-1910),new BasicPlatform(50,-1930),new BasicPlatform(140,-1970),new SideSidePlatform(200,-2050),
                        new BasicPlatform(100,-2120),new BasicPlatform(70,-2190),new BasicPlatform(200,-2200),new BrokenPlatform(110,-2250),new BasicPlatform(180,-2320),
                        new BasicPlatform(200,-2260),
                        new BasicPlatform(20,-2400),new SideSidePlatform(60,-2450),new BasicPlatform(200,-2500),new BasicPlatform(220,-2540),new BasicPlatform(60,-2500),
                        new BasicPlatform(120,-2550),new BasicPlatform(70,-2600),new BasicPlatform(220,-2580)));
         return hi;
    }
}   
