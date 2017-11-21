package Widgets;
import java.awt.*;
import java.awt.event.*;

public class Test12_Widgets
  extends java.applet.Applet {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void init() {
      TextArea  ta= new TextArea( "", 4, 35, 
                      TextArea.SCROLLBARS_VERTICAL_ONLY );
      ta.addTextListener( new TextAreaTextListener() );
      add(ta);
   }
}

class TextAreaTextListener 
  implements TextListener {

   public void textValueChanged( TextEvent e ) {
      System.out.println("textValueChanged :\n  " + e );
      TextArea  composantTexte= (TextArea)e.getSource();
      String  texte= composantTexte.getText();
      System.out.println(texte);
   }
}

