//********************************************************************
//  LineUp.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a graphical object.
//********************************************************************

import java.util.Random;
import java.applet.Applet;
import java.awt.*;

public class LineUp2 extends Applet
{
   private final int APPLET_WIDTH = 400;
   private final int APPLET_HEIGHT = 150;
   private final int HEIGHT_MIN = 100;
   private final int VARIANCE = 40;

   private StickFigure2 figure1,figure2,figure3,figure4;
   Random generator = new Random();

   //-----------------------------------------------------------------
   //  Creates several stick figures with varying characteristics.
   //like a constructor for applets, runs once
   //-----------------------------------------------------------------
   public void init ()
   {
      int h1,h2,h3,h4;  // heights of stick figures

      h1 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h2 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h3 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h4 = HEIGHT_MIN + generator.nextInt(VARIANCE);

      figure1 = new StickFigure2 (50, 150, Color.red, h1);
      figure2 = new StickFigure2(100, 150, Color.blue, h2);
      figure3 = new StickFigure2 (150, 150, Color.green, h3);
      figure4 = new StickFigure2 (200, 150, Color.yellow, h4);
      
      Thread t1 = new Thread(figure1);
      t1.start();
      Thread t2 = new Thread(figure2);
      t2.start();

      setBackground (Color.black);
      setSize (APPLET_WIDTH, APPLET_HEIGHT);
   }

   //-----------------------------------------------------------------
   //  Paints the stick figures on the applet.
   //-----------------------------------------------------------------
   public void paint (Graphics page)
   {

      figure1.draw (page);
      figure2.draw (page);
      figure3.draw (page);
      figure4.draw (page);
      
     
      
      /*
      int newHeight = HEIGHT_MIN+generator.nextInt(VARIANCE);
      figure1.setHeight(newHeight);
      */
      try{
        //pause the program for a quarter sec in miliseconds
        Thread.sleep(250);
        }
        catch(InterruptedException e){}
      repaint();
      

   }
}