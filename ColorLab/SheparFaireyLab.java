
/**
 * Alan Wandke
 * 10/30/18
 * shephard fairy lab 
 * will convert a picture into 4 colors 
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        int r,g,b; 
        
        //change with selfie picture
         Picture me = new Picture("images/selfie.jpg");
         Picture me1 = new Picture("images/selfie.jpg");
         Picture me2 = new Picture("images/selfie.jpg");
         me.explore();
         
         Pixel[]mepixels = me.getPixels();
         Pixel[]me1pixels = me1.getPixels();
         Pixel[]me2pixels = me2.getPixels();
         
         /**
          * method 1 change
          * rgb(240, 250, 240) off white
          * rgb(57, 119, 206) light blue
          * rgb(234, 25, 25) red
          * rgb(27, 107, 150) dark blue
          */
         for (Pixel spot:mepixels){
                r = spot.getRed();
                g = spot.getGreen();
                b = spot.getBlue();
                r = (int)((r+g+b)/3);
                spot.setRed(r);
                spot.setGreen(r);
                spot.setBlue(r);
                
            } 
         for (Pixel spot:mepixels){
                r = spot.getRed();   
                if (r<(255/4)){
                    spot.setRed(27);
                    spot.setGreen(107);
                    spot.setBlue(150);
                }
                else if(r<(255/2)){
                    spot.setRed(234);
                    spot.setGreen(25);
                    spot.setBlue(25);
                }
                else if (r<(255*.75)){
                    spot.setRed(112);
                    spot.setGreen(150);
                    spot.setBlue(158);
                }
                else{
                    spot.setRed(240);
                    spot.setGreen(250);
                    spot.setBlue(240);
                }
            }        
            
            
            
            me.explore();
         /**
          * method 2 change
          */
         int max=0,min=255;
         for (Pixel spot:me1pixels){
                r = spot.getRed();
                g = spot.getGreen();
                b = spot.getBlue();
                r = (int)((r+g+b)/3);
                
                spot.setRed(r+25);
                spot.setGreen(r+25);
                spot.setBlue(r+25);
                if(r>max)
                    max=r;
                if (r<min)
                    min=r;
            }
         for (Pixel spot:me1pixels){
                 r = spot.getRed();   
                 if (r<(min+(max-min)/4)){
                    spot.setRed(27);
                    spot.setGreen(107);
                    spot.setBlue(150);
                }
                else if(r<(min+(max-min)/2)){
                    spot.setRed(234);
                    spot.setGreen(25);
                    spot.setBlue(25);
                }
                else if (r<(min+(max-min)*.75)){
                    spot.setRed(112);
                    spot.setGreen(150);
                    spot.setBlue(158);
                }
                else{
                    spot.setRed(240);
                    spot.setGreen(250);
                    spot.setBlue(240);
                }
            
            }   
         me1.explore();
        
         
         /**
          * custom color palette
          * rgb(48, 130, 29) dark green
          * rgb(88, 176, 226) light blue
          * rgb(160, 224, 127) light green
          * rgb(237, 234, 158) tanish yellow 
          */
         max=0;min=255;
         for (Pixel spot:me2pixels){
                r = spot.getRed();
                g = spot.getGreen();
                b = spot.getBlue();
                r = (int)((r+g+b)/3);
                
                spot.setRed(r+15);
                spot.setGreen(r+15);
                spot.setBlue(r+15);
                if(r>max)
                    max=r;
                if (r<min)
                    min=r;
            }
         for (Pixel spot:me2pixels){
                 r = spot.getRed();   
                 if (r<(min+(max-min)/4)){
                    spot.setRed(48);
                    spot.setGreen(130);
                    spot.setBlue(29);
                }
                else if(r<(min+(max-min)/2)){
                    spot.setRed(88);
                    spot.setGreen(176);
                    spot.setBlue(226);
                }
                else if (r<(min+(max-min)*.75)){
                    spot.setRed(160);
                    spot.setGreen(224);
                    spot.setBlue(127);
                }
                else{
                    spot.setRed(237);
                    spot.setGreen(235);
                    spot.setBlue(158);
                }
            
            }   
         me2.explore();

       /**/  
       me.write("images/shepard1.jpg");
       me1.write("images/shepard2.jpg");
       me2.write("images/thecoolone.jpg");
    }//main       
}//class
