package Widgets;
import java.awt.*;
import java.awt.event.*;
	
public class Test7_Widgets
	  extends java.applet.Applet {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {

	      Checkbox c1 = new Checkbox("Gras");      //par defaut: false
	      Checkbox c2 = new Checkbox("Italique", true);
	      Checkbox c3 = new Checkbox("Souligné");
	      Checkbox c4 = new Checkbox("Cocher si vous avez compris");
	      add(c1);
	      add(c2);
	      add(c3);
	      add(c4);

	      CheckboxItemListener cbIL;
	      cbIL = new CheckboxItemListener();

	      c1.addItemListener( cbIL );
	      c2.addItemListener( cbIL );
	      c3.addItemListener( cbIL );
	      c4.addItemListener( cbIL );
	   }
	}

	class CheckboxItemListener 
	  implements ItemListener {

	   public void itemStateChanged( ItemEvent e ) {
	      System.out.println("itemStateChanged :\n  " + e );
	   }
	}
	
