   import java.awt.image.BufferedImage;
   import java.io.IOException;
   import java.io.File;

   import javax.imageio.ImageIO;
   import javax.swing.JFileChooser;
   import javax.swing.SwingUtilities;

/**
 * Breaks images into several different 1024x1024 images (as well as any remainder).
 * 
 * @author Allen - Messed with by Chris to make it read a file from its arguments.
 * 
 */
   public class IBMain {
   
   /**
    * @param args
    */
      public static void main(String[] args) {
         String path = "";
      	int size = 1024;
			
         try {
            path = args[0];
				size =  Integer.parseInt(args[1]);
         } 
            catch ( ArrayIndexOutOfBoundsException e ) 
            {
               System.out.println("Make sure you have an image filename as the first argument,\nand the size of a side as the second.");
               System.exit(1);
            }
      	
         File f = new File(path);
      
         BufferedImage img = null;
      
         try {
            img = ImageIO.read(f);
         }	            
            catch (IOException e) {
               System.out.println("Problem reading file.");          
               System.exit(1);
            }
      	
         path = path.substring(path.lastIndexOf('/') + 1);
               	
         ImageSlicer imgSlicer;
         imgSlicer = new ImageSlicer(img, path);
         imgSlicer.slice(size, size);	
      }
   }
