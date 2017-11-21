package Image;
import java.awt.Graphics;
import java.awt.Image;

public class Test2_Image
     extends java.applet.Applet {

   /**
	 * 
	 */
	private static final long serialVersionUID = -149629160085090399L;
Image  image;

   public void init() {
      image= getImage( getDocumentBase(), 
                      "~/Images/ex.png" );
   }

   public void paint( Graphics g ) {
      g.drawImage( image,0,0,getBackground(),
                   this );
   }

   public boolean imageUpdate( 
           Image image,int infoFlags,
           int x,int y,int width,int height ) {

      showStatus("Chargement de l'image ...");
      return super.imageUpdate( image,
                   infoFlags,x,y,width,height);
   }
}