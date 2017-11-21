package Widgets;
import java.awt.TextField;

public class Test9_Widgets
	  extends java.applet.Applet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	    TextField tf1, tf2, tf3, tf4, tf5, tf6;
	    tf1= new TextField();
	    tf2= new TextField("un TextField");
	    tf3= new TextField(20);
	    tf4= new TextField("un TextField2",30);
	    tf3.setEchoChar('*');
	    tf5= new TextField(30);
	    tf6= new TextField(10);
	    tf6.setEchoChar('a');
	    add(tf1); add(tf2); add(tf3); add(tf4); add(tf5);add(tf6);
	  }
}