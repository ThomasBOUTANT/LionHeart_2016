package Layout;
import java.awt.*;

public class Test1_Layout
   extends java.applet.Applet {

   /**
	 * 
	 */
	private static final long serialVersionUID = 7531975580637773118L;

public void init() {
      setLayout( new FlowLayout() );
      add( new Button("Bouton 1") );
      add( new Button("Bouton 2") );
      add( new Button("Bouton 3") );
      add( new Button("Bouton 4") );
      add( new Button("Bouton 5") );
   }
}