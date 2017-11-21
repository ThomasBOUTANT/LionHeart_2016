package Widgets;
import java.awt.*;

public class Test3_Widgets 
	   extends java.applet.Applet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
	    String fontes[]= { 			//on definit ici les choix possibles
	              "8","10","12","14","16",
	              "18", "20", "24", "36","48", "choix possible bonus", "jhfhghj"
	           };

	    Choice   fontesChoice = new Choice();          // on cree un Choice ne contenant aucun item
	    for ( int i=0; i<fontes.length; i++ )
	       fontesChoice.add( fontes[i] );         //on ajoute tous nos choix dans le Choice juste cree
	    fontesChoice.select( 8 );   //j'ai change 1 en 5 pour voir: cela renvoie donc au depart le 6eme element de la liste fontes[]

	    add( fontesChoice );      //on affiche le Choice
	  }
	
	
	/*
	 * Non utilise ici:
	 * void add( String item )
	 * rajoute la chaîne item dans la liste des items
	 * 
	 * void insert( String item, int index )
	 * rajoute la chaîne item à la position index dans la liste des items
	 * 
	 * int getItemCount()
	 * retourne le nombre d'items dans le Choice
	 * 
	 * String getItem( int index )
	 * retourne l'item d'indice index
	 * 
	 * void remove( String item )
	 * retire la première occurrence de item
	 * 
	 * void remove( int position )
	 * retire l'item de position donnée en paramètre
	 * 
	 * void removeAll()
	 * retire tous les items du coice menu           //choice
	 * 
	 * String getSelectedItem()
	 * retourne l'item sélectionné du choice
	 * 
	 * int getSelectedIndex()
	 * retourne l'indice de l'item sélectionné
	 * 
	 * void select( String str )
	 * sélectionne le premier item str
	 *  
	 * 
	 */
	
	}
