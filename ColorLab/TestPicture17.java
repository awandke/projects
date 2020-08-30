
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**/
     //String fileName = FileChooser.pickAFile();
     //Picture pictObj = new Picture(fileName);
     //pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     Picture anotherpic = new Picture("images/robot.jpg");
     
     ferris1.explore();
     anotherpic.explore();
     
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
/*
    pixels[17].setColor(Color.red);
    spot.setColor(new Color(25,252,252));
    pixels[1000].setColor(Color.blue);
      
    
    ferris1.explore();
/*
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    //for (Pixel spot : pixels)
   // System.out.println( spot );


   //for each loops. aspot is a single pixel in pixels array 
   for (Pixel aspot : pixels){
       if (aspot.getX()%2==0)
            aspot.setRed(255);
       if (aspot.getY()%2==0)
            aspot.setBlue(255);
        
    }
    
  /* 
  //make it 50% lighter
  int r,g,b;  
  for (Pixel aspot : pixels){
        r = aspot.getRed();
        g = aspot.getGreen();
        b = aspot.getBlue();
        aspot.setRed((int)(r*1.5));
        aspot.setGreen((int)(g*1.5));
        aspot.setBlue((int)(b*1.5));
    }
    ferris1.explore();
 /**/
 //this creates a negative, opposite of the pixels
 int r,g,b;  
  for (Pixel aspot : pixels){
        r = aspot.getRed();
        g = aspot.getGreen();
        b = aspot.getBlue();
        aspot.setRed((int)(255-r));
        aspot.setGreen((int)(255-g));
        aspot.setBlue((int)(255-b));
    }
    ferris1.explore();
 
  /**/
 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg");

    /**/
  }//main
}//class
