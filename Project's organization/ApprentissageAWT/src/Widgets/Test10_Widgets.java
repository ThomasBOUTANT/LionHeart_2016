package Widgets;
import java.awt.*;
import java.awt.event.*;
	
public class Test10_Widgets
	  extends java.applet.Applet {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	      TextField  tf1, tf2;
	      tf1 = new TextField( "un TextField" );
	      tf2 = new TextField(20);
	      tf2.setEchoChar( '*' );                  //jusqu'ici, rien ne change

	      TextFieldActionListener  tfAL;
	      tfAL= new TextFieldActionListener();

	      TextFieldTextListener  tfTL;  
	      tfTL= new TextFieldTextListener();

	      tf1.addActionListener( tfAL );
	      tf1.addTextListener( tfTL );
	      tf2.addActionListener( tfAL );
	      tf2.addTextListener( tfTL );

	      add(tf1); add(tf2);
	    }
	}

	class TextFieldActionListener 
	  implements ActionListener {

	  public void actionPerformed( ActionEvent e ) {
	    System.out.println("actionPerformed :\n  " + e );
	    TextField  composantTexte= (TextField)e.getSource();
	    String  texte= composantTexte.getText();
	    System.out.println(texte);
	  }
	}

	class TextFieldTextListener 
	  implements TextListener {

	  public void textValueChanged( TextEvent e ) {
	    System.out.println("textValueChanged :\n  " + e );
	  }
	}
