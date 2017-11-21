package Widgets;
import java.awt.*;
import java.awt.event.*;
	
public class Test6_Widgets
	  extends java.applet.Applet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	    String[] items ={ 
	              "Grenoble", "Paris", "Lyon", "Nice",
	              "Evry", "Marseille","Lille", "Orléans"
	    };

	    List l = new List( 4, true );
	    for (int i=0; i<items.length; i++)
	       l.add( items[i] );
	    l.select( 4 );                       //jusqu'ici, rien ne change

	    l.addActionListener(
	            new ListActionListner());
	    l.addItemListener( 
	            new ListItemListener() );

	    add(l);
	  }
	}

	class ListActionListner 
	   implements ActionListener {

	  public void actionPerformed(ActionEvent e) {
	    System.out.println("actionPerformed :\n"+e);      //lorsque je teste, je n'ai aucun message "actionPerformed"
	  }
	}

	class ListItemListener 
	   implements ItemListener {

	  public void itemStateChanged( ItemEvent e ){
	    System.out.println("itemStateChanged :\n"+e);    //2 valeurs peuvent changer: "item" et "stateChange"
	  }
	}
