package Widgets;
import java.awt.*;
import java.awt.event.*;
	
public class Test4_Widgets 
		extends java.applet.Applet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	     String fontes[]= { 
	               "8", "10", "12", "14", "16", 
	               "18","20", "24","36","48" 
	            };

	    Choice   fontesChoice = new Choice();
	    for ( int i=0; i<fontes.length; i++ )
	       fontesChoice.add( fontes[i] );
	    fontesChoice.select( 1 );                  //jusqu'ici, c'est comme le test3

	    fontesChoice.addItemListener(
	                       new FontesChoiceItemListener() );

	    add( fontesChoice );
	  }
	}

	class FontesChoiceItemListener 
	   implements ItemListener {

	   public void itemStateChanged( ItemEvent e ) {
	     System.out.println("itemStateChanged :\n  " + e );
	     // par ex, e = java.awt.event.ItemEvent[ITEM_STATE_CHANGED,item=20,stateChange=SELECTED] on choice0
	     // seule la valeur de "item" change
	   }
	}
