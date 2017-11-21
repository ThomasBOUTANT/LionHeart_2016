package Widgets;
import java.awt.*;

public class Test8_Widgets
	  extends java.applet.Applet {   //une seule case peut etre cochee

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {

	    CheckboxGroup cbg = new CheckboxGroup();
	    add( new Checkbox("toujours",cbg,true) );    
	    add( new Checkbox("m'avertir",cbg,true) );   //j'ai change false en true pour voir ce que ca faisait. resultat : "toujours" est decochee

	    Checkbox cb = new Checkbox("jamais");
	    add(cb);

	    cb.setCheckboxGroup( cbg );
	  }
	}