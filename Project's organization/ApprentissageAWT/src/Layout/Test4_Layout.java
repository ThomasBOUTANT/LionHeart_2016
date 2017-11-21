package Layout;

import java.awt.*;

public class Test4_Layout
  extends java.applet.Applet {

  /**
	 * 
	 */
	private static final long serialVersionUID = -7610177458893637343L;

public void init() {
    ZoneDessin zone;
    zone= new ZoneDessin( getSize().width/2,
                          getSize().height/2 );
     add( zone );
   }
}

class ZoneDessin 
  extends Canvas {

  /**
	 * 
	 */
	private static final long serialVersionUID = -1022605037975343346L;

public ZoneDessin(int largeur, int hauteur) {
      // super();
      setSize( largeur, hauteur );
   }

  public void paint(Graphics g) {
    g.drawRect( 0, 0, getSize().width-1,
                      getSize().height-1 );
   }
}
