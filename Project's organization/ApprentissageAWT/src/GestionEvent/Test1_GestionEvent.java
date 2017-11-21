package GestionEvent;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;

class Dessin {

  private int posX, posY;

  public Dessin( int posX, int posY ) {
     this.posX= posX;  this.posY= posY;
  }
  public void setPosition(int posX,int posY) {
    this.posX= posX;  this.posY= posY;
  }
  public void draw( Graphics g) {
    g.fillRect( posX, posY, 10, 10 );
  }
}

// Ecouteur
class DessinActions
  implements MouseListener, 
             MouseMotionListener {

  private Applet     composant;
  private Dessin     dessin;

  public DessinActions( Applet composant, 
                        Dessin dessin) {
    this.composant= composant;
    this.dessin= dessin;
  }

  // implémentation des méthodes de MouseListner
  public void mousePressed( MouseEvent evt ) {
    composant.showStatus("mousePressed");
  }
  public void mouseReleased( MouseEvent evt ) {
    composant.showStatus("mouseReleased");
  }
  public void mouseClicked( MouseEvent evt ) {
    dessin.setPosition(evt.getX(),evt.getY());
    composant.repaint();
  }
  public void mouseEntered( MouseEvent evt ) {
    composant.showStatus("mouseEntered");
  }
  public void mouseExited( MouseEvent evt ) {
    composant.showStatus("mouseExited");
  }

  // implémentation des méthodes de MouseMotionListner
  public void mouseDragged( MouseEvent evt ) {
    composant.showStatus("mouseDragged");
  }
  public void mouseMoved( MouseEvent evt ) {
    composant.showStatus("Position :" +
            evt.getX() + " , " + evt.getY());
  }
}

public class Test1_GestionEvent 
     extends Applet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 5082257720226469815L;
private DessinActions  dessinActions;
  private Dessin         dessin;

  public void init() {
    dessin= new Dessin(0,0);
    dessinActions= new DessinActions( this,
                                      dessin );

    // enregistrement de l'Ecouteur
    addMouseListener( dessinActions );
    addMouseMotionListener( dessinActions );
  }

  public void paint( Graphics g ) {
    dessin.draw(g);
  }
}