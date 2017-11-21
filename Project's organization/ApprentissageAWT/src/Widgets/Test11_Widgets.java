package Widgets;
import java.awt.*;
public class Test11_Widgets 
	   extends java.applet.Applet {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	      TextArea  ta= new TextArea( "", 4, 35, 
	                     TextArea.SCROLLBARS_VERTICAL_ONLY );   //cela peut etre pratique pour un 'chat'
	      add(ta);
	   }
	}

