package Layout;
import java.awt.*;

public class Test2_Layout
   extends java.applet.Applet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1832211325037866979L;

public void init() {
      setLayout( new BorderLayout(0,3) );
      add( "North",  new Button("Nord") );
      add( "South",  new Button("Sud") );
      add( "West",   new Button("Ouest") );
      add( "East",   new Button("Est") );
      add( "Center", new Button("Centre") );
   }
}