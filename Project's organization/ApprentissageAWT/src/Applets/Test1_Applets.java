package Applets;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Test1_Applets extends java.applet.Applet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 702434746404811104L;
String   text;
  Font     police;

  public void init() {
    System.out.println("\n init" );
    text = new String( "Dévélop. d'interfaces graph" );
    police = new Font( "Helvetica", Font.BOLD, 20 );
    setBackground(Color.blue);
  }

  public void start() { System.out.println("start"); }
  public void stop(){System.out.println("stop");}
  public void destroy() { System.out.println("destroy \n"); }

  public void paint(Graphics g) {
     System.out.println("paint");
     g.setColor(Color.white);
     g.setFont( police );
     g.drawString(text, 10, 30);
  }
}