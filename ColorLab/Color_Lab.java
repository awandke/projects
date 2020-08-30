/**
 * Alan Wandke 
 * 10/26/18
 * Picture Color Lab
 * Alters a Picture in a variety of ways 
 */
import java.awt.*;
import java.util.*;
import java.util.List;

public class Color_Lab
{
    public static void main(String []args){
        int r,g,b;
        Scanner in = new Scanner(System.in);
        
        //create all the pictures
        Picture original = new Picture ("images/seal.jpg");
        Picture maxred = new Picture ("images/seal.jpg");
        Picture negative = new Picture ("images/seal.jpg");
        Picture adjustcolor = new Picture ("images/seal.jpg");
        Picture grayscale = new Picture ("images/seal.jpg");
        Picture lighten = new Picture ("images/seal.jpg");
        Picture changecolor = new Picture ("images/seal.jpg");
        Picture blueify = new Picture ("images/seal.jpg");
        Picture colorify = new Picture ("images/seal.jpg");
        Picture swap2 = new Picture ("images/seal.jpg");
        Picture swap3 = new Picture ("images/seal.jpg");
        
        //create all the arrays 
        //Pixel[] maxredpixels = maxred.getPixels();
        Pixel[] negativepixels = negative.getPixels();
        //Pixel[] adjustcolorpixels = adjustcolor.getPixels();
        Pixel[] grayscalepixels = grayscale.getPixels();
        Pixel[] lightenpixels = lighten.getPixels();
        Pixel[] changecolorpixels = changecolor.getPixels();
        Pixel[] blueifypixels = blueify.getPixels();
        //Pixel[] colorifypixels = colorify.getPixels();
        Pixel[] swap2pixels = swap2.getPixels();
        Pixel[] swap3pixels = swap3.getPixels();
        
        original.explore();
        /*
        //sets the red for all pixels to 255
        for (Pixel spot :maxredpixels){
            spot.setRed(255);
        }
        maxred.explore();
        /**/
        
        //sets each color to 255-that color to create a negative image 
        for (Pixel spot: negativepixels){
            r = spot.getRed();
            g = spot.getGreen();
            b = spot.getBlue();
            spot.setRed(255-r);
            spot.setGreen(255-g);
            spot.setBlue(255-b);
        }
        negative.explore();
        
        /*
        //adjust color 
        Double changer,changeg,changeb;
        System.out.print("enter three doulbes to adjust r g b");
        changer = in.nextDouble();
        changeg = in.nextDouble();
        changeb = in.nextDouble();
        
        //adjusts each pixel by the desired amount
        for (Pixel spot:adjustcolorpixels){
            r = spot.getRed();
            g = spot.getGreen();
            b = spot.getBlue(); 
            spot.setRed((int)(r*changer));
            spot.setGreen((int)(g*changeg));
            spot.setBlue((int)(b*changeb));
        }
        adjustcolor.explore();
        /**/
        
        //grayscale 
        for (Pixel spot:grayscalepixels){
            r = spot.getRed();
            g = spot.getGreen();
            b = spot.getBlue(); 
            r = (int)((r+b+g)/3);
            spot.setRed(r);
            spot.setGreen(r);
            spot.setBlue(r);
        }
        grayscale.explore();
        
        /*
        //lighten or darken
        
        for (Pixel spot:lightenpixels){
            r = spot.getRed(); 
            g = spot.getGreen();
            b = spot.getBlue();
            Color rgb = new Color(r,b,g);
            Color bright = rgb.brighter();
            spot.setRed(bright.getRed());
            spot.setGreen(bright.getGreen());
            spot.setBlue(bright.getBlue());
        }    
        lighten.explore();
        /**/
        
        //change colors 
        System.out.print("enter three numbers, amount to change r,g,b by");
        r = in.nextInt();
        g = in.nextInt();
        b = in.nextInt();
        
        for (Pixel spot:changecolorpixels){
            spot.setRed(spot.getRed()+r);
            spot.setGreen(spot.getGreen()+g);
            spot.setBlue(spot.getBlue()+b);
        }
        changecolor.explore();
        /**/
        for (Pixel spot:blueifypixels){
            r = spot.getRed(); 
            g = spot.getGreen();
            b = spot.getBlue();
            if (r>55 && r<102 && g>40 && g<82 && b>50 &&b <86){
                spot.setRed(r-50);
                spot.setGreen(g-50);
                spot.setBlue(b+50);
            
            }
        }
        blueify.explore();
        /*
        
        //colorify
        for (Pixel spot:colorifypixels){
            r = spot.getRed(); 
            g = spot.getGreen();
            b = spot.getBlue();
            if (r>3 && r<23 && g>3 && g<23 && b>3 &&b <23 && Math.abs(r-g)<=3 && Math.abs(r-b)<=3){
                spot.setRed(255);
                spot.setGreen(0);
                spot.setBlue(255);
        
        
            }
        }
        colorify.explore();
        /**/
        //swap 2
        for(Pixel spot:swap2pixels){
            r = spot.getRed(); 
            g = spot.getGreen();
            b = spot.getBlue();
            spot.setRed(g);
            spot.setGreen(r);
        
        }
        swap2.explore();
        
        //swap 3
        for(Pixel spot:swap3pixels){
            r = spot.getRed(); 
            g = spot.getGreen();
            b = spot.getBlue();
            spot.setRed(b);
            spot.setGreen(r);
            spot.setBlue(g);
        }
        swap3.explore();
        /**/
}
}

