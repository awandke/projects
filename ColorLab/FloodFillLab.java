/**
 * Alan Wandke 
 * 11/1/18 
 * Flood Fill Lab
 * Replace portions a a picture with a different color 
 */
import java.awt.*;
import java.util.*;
import java.util.List;
public class FloodFillLab
{
   public static void main (String[] args){
       Picture arrow = new Picture("images/arrow2.jpg");
       Picture map = new Picture("images/map.jpg");
       
       Pixel[] arrowpixels = arrow.getPixels();
       Pixel[] mappiexels = map.getPixels();
       
       //step 1: change the arrowettes picture
       int r,g,b,x,y;
       Pixel left,right,above,below;
       arrow.explore();
       for (Pixel spot:arrowpixels){
           x = spot.getX();
           y = spot.getY();
           r = spot.getRed();
           

           if (r<10){
               if (x!=0 && x!=243 && y!=0 && y !=617){
                   left = new Pixel(arrow,x-1,y);
                   above = new Pixel(arrow,x,y-1);
                   right = new Pixel(arrow,x+1,y);
                   below = new Pixel(arrow,x,y+1);}
               
               if ((left.getRed()>100)||(right.getRed()>100)||(above.getRed()>100)||(below.getRed()>100))
               {}
               else{
                   spot.setRed(255);
                   spot.setGreen(255);
                   spot.setBlue(255);
                }

            }
       
       
            map.explore();

    
   
        }
}
}