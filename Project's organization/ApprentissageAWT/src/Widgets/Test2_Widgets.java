package Widgets;
import java.awt.*;
import java.awt.event.*;
	
public class Test2_Widgets 
	  extends java.applet.Applet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	    Button b = new Button( "Cliquer ici" );
	    add(b);
	    b.addActionListener( new OkActionListener() );
	  }
	}

/*
 * Non utilise:
 * String getLabel()
 * void setLabel( String label )
 * récupère / fixe le texte du bouton
 */

	class OkActionListener 
	  implements ActionListener {              // cf gestion des evenements

	  public void actionPerformed( ActionEvent e ) {

	    System.out.println("actionPerformedblabla :\n  " + e );    //ajout de "blabla" pour savoir ce que ca fait
	    // ok par exemple, e =  java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=Cliquer ici,when=1458770524193,modifiers=Button1] on button0

	    Button  bouton= (Button)e.getSource();

	    if (bouton.getLabel().equals("Ok"))
	       bouton.setLabel("Bravo: tu as cliqué sur un bouton! :)");
	    else
	       bouton.setLabel("Ok");         //c'est important que cela soit le meme "ok"
	    
	    
	    
	    
	    
	  }
	}
