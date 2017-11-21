package Widgets;

import java.awt.*;

public class Test1_Widgets
	   extends java.applet.Applet {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	     setBackground( Color.black );
	     Label l1= new Label("un Label à gauche" /*,Label.LEFT*/);
	     l1.setBackground( Color.red );

	     Label l2= new Label("un Label centré", Label.CENTER);    //Label.CENTER est un "int"? (cf formation)
	     l2.setBackground( Color.green );

	     Label l3= new Label("un Label à droite",Label.RIGHT);
	     l3.setBackground( Color.blue );
	     l3.setFont( new Font("Courier", Font.BOLD, 16) );

	     Label l4= new Label("un Label en bas à gauche?je sais pas , bcp trop long, pa d'inspi",Label.LEFT);
	     l4.setBackground( Color.yellow );
	     l4.setFont( new Font("Courier", Font.BOLD, 25) );
	     
	     Label l5= new Label("réponse: non",Label.RIGHT);
	     l5.setBackground( Color.pink );
	     l5.setFont( new Font("Courier", Font.BOLD, 4) );
	     
	     add(l1);
	     add(l2);
	     add(l3);
	     add(l4);
	     add(l5);
	     
	     /*
	      * Non utilise ici:
	      *int getAlignment()
	      *void setAlignment( int alignment )
	      *récupère / fixe la valeur de l'alignement
	      *
	      *String getText()
	      *void setText( String text )
	      *récupère / fixe la valeur du texte
	      */
	     
	     
	   }
	}
	
