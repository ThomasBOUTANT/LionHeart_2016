package Layout;

import java.awt.*;

public class Test3_Layout
   extends java.applet.Applet {

   /**
	 * 
	 */
	private static final long serialVersionUID = -2419009188972233770L;

public void init() {
      setLayout( new GridLayout(3,0) );
      add( new Button("Bouton 1") );
      add( new Button("Bouton 2") );
      add( new Button("Bouton 3") );
      add( new Button("Bouton 4") );
      add( new Button("Bouton 5") );
   }
}