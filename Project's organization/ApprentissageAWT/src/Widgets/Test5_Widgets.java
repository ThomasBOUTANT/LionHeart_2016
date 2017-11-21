package Widgets;
import java.awt.*;

public class Test5_Widgets 
	   extends java.applet.Applet {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void init() {

	        String[] items = {
	            "Grenoble", "Paris", "Lyon", "Nice",
	            "Evry", "Marseille", "Lille", "Orléans"
	        };

	        /*
	         * List( int rows, boolean multipleMode )
permet de créer une liste de rows lignes visibles.
si multipleMode est true alors la liste permet de sélectionner plusieurs items 
	         */
	        
	       List l = new List( 4, true );      //List(,) remplace Choice()
	       for (int i=0; i<items.length; i++)
	            l.add( items[i] );
	       l.select( 4 );
	       add(l);
	    }
		
		
		/*
		 * Non utilisé ici:
		 * 
		 * 
		 * List( )
permet de créer une liste
A la création, aucune ligne n'est visible.
Par défaut la liste ne permet de sélectionner qu'un seul item

List( int rows )
permet de créer une liste de rows lignes visibles.
Par défaut la liste ne permet de sélectionner qu'un seul item


void add( String item )
void addItem( String item )
rajoute l'item à la fin de la liste

void add( String item, int index )
void addItem( String item, int index )
rajoute l'item à la position index dans la liste des items. Si index vaut -1 ou est supérieur au nombre d'items alors l'item est rajouté à la fin de la liste

int getItemCount()
retourne le nombre d'items dans la liste

String getItem( int index )
retourne l'item d'indice index

String[] getItems()
retourne la liste des items

void replaceItem( String newValue, int index )
remplace l'item de position index avec la valeur newValue

void removeAll()
retire tous les items de la liste

void remove( String item )
retire la première occurrence de item

void remove( int position )
retire l'item de position donnée en paramètre

int getSelectedIndex()
retourne l'indice de l'item sélectionné ou -1 si aucun item n'est sélectionné ou plusieurs items sont sélectionnés.

int[] getSelectedIndexes()
retourne les indices des items sélectionnés

String getSelectedItem()
retourne l'item sélectionné ou null

String[] getSelectedItems()
retourne la liste des items sélectionnés

void select( int index )
sélectionne l'item de position index

void deselect( int index )
dé-sélectionne l'item de position index
Si cet item n'est pas sélectionné ou si l'index est hors bornes alors l'opération est ignorée.

boolean isIndexSelected( int index )
informe si l'item donné par son indice est sélectionné

int getRows()
retourne le nombre de lignes visibles dans la liste

boolean isMultipleMode()
informe si la liste permet la sélection multiple

void setMultipleMode( boolean b )
pour permettre ou non la sélection multiple

void makeVisible( int index )
rend visible l'item donné par son indice

public int getVisibleIndex()
retourne l'indice du dernier item rendu visible par la méthode makeVisible()
		 */
		
		
		
	}