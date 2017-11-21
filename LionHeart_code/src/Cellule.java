import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author belaid, boutant
 *
 */
public class Cellule extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton bouton;

	JLabel label;

	TypeCellule typeCellule;

	Plateau plateau;
	
	/**
	 * 
	 */
	int nbDePieces;

	/**
	 * 
	 */
	Orientation orientation;
	 
	// ---------------------------------------------------------------------------------------------

	
	
	/**
	 * 
	 * @param typeCellule
	 * @param plateau
	 * 
	 * @author belaid, boutant
	 */
	public Cellule(TypeCellule typeCellule, Plateau plateau, int positionX, int positionY) {

		this.typeCellule = typeCellule;
		this.plateau = plateau;
		this.positionX = positionX;
		this.positionY = positionY;
		this.nbDePieces = typeCellule.getNbDePieces() ;
		this.orientation = typeCellule.getOrientation() ;
		
		if (typeCellule.equals(TypeCellule.NOIR)) {
			label = new JLabel();
			label.setIcon(new ImageIcon(typeCellule.image));
			add(label);
			return;
		}

		else if (typeCellule.equals(TypeCellule.VIDE) || typeCellule.equals(TypeCellule.HELP)
				|| typeCellule.equals(TypeCellule.RULES) || typeCellule.equals(TypeCellule.FLECHE_HAUT_BLEUE)
				|| typeCellule.equals(TypeCellule.FLECHE_BAS_BLEUE)
				|| typeCellule.equals(TypeCellule.FLECHE_GAUCHE_BLEUE)
				|| typeCellule.equals(TypeCellule.FLECHE_DROITE_BLEUE)) {
			bouton = new JButton();
			bouton.setIcon(new ImageIcon(typeCellule.image));
			add(bouton);
		}

		else if (typeCellule.equals(TypeCellule.HACHE) || typeCellule.equals(TypeCellule.FLECHE)
				|| typeCellule.equals(TypeCellule.PANIQUE) || typeCellule.equals(TypeCellule.QUESTION_DE)) {
			label = new JLabel();
			label.setIcon(new ImageIcon(typeCellule.image));
			add(label);
			return;
		}
		
		else if (typeCellule.equals(TypeCellule.SILVER_FLAG)) {
			label = new JLabel(" " + plateau.getPA_ARGENT());
			label.setIcon(new ImageIcon(typeCellule.image));
			add(label);
			return;
		}
		else if (typeCellule.equals(TypeCellule.GOLD_FLAG)) {
			label = new JLabel(" " + plateau.getPA_OR());
			label.setIcon(new ImageIcon(typeCellule.image));
			add(label);
			return;
		}

		else {
			setLayout(new BorderLayout(0, 0));
			label = new JLabel(typeCellule.getTexte());

			bouton = new JButton();
			bouton.setIcon(new ImageIcon(typeCellule.image));

			add(BorderLayout.NORTH, label);
			add(BorderLayout.CENTER, bouton);
		}

		bouton.addActionListener(new NotreActionListener());
	}

	// --------------------------------------------------------------------------------------------


	/**
	 * 
	 */
	int positionX;

	/**
	 * 
	 */
	int positionY;

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setPositionXY(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * 
	 * @author belaid
	 *
	 */
	class NotreActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// System.out.println("actionPerformed :\n " + e);
			plateau.cliqued(positionX, positionY);
		}
	}

}