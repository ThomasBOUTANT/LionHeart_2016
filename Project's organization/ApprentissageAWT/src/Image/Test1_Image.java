package Image;
import java.awt.Graphics;
import java.awt.Image;

public class Test1_Image
     extends java.applet.Applet {

   /**
	 * 
	 */
	private static final long serialVersionUID = 3214740649739996048L;
Image  image;

   public void init() {
      image= getImage( getDocumentBase(), "~/Images/ex.png" );
   }

   public void paint( Graphics g ) {
     g.drawImage( image,0,0,getBackground(),
                  this);

     int larg = image.getWidth(this);
     int haut = image.getHeight(this) + 40;
     int x = getSize().width - larg;
     int y = getSize().height - haut;
     g.drawImage( image,x,y,larg,haut, 
                 getBackground(), this );
   }
}