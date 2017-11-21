import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author belaid, coispel, boutant
 *
 */
public enum IMage {

	NOIR("CASE_NOIR.png"), VIDE("CASE_VIDE.png"), 
	
	SOLDAT_OR("SOLDAT_OR.png"), SOLDAT_ARGENTE("SOLDAT_ARGENTE.png"),
	ARCHER_OR("ARCHER_OR.png"), ARCHER_ARGENTE("ARCHER_ARGENTE.png"), 
	CAVALIER_OR("CAVALIER_OR.png"), CAVALIER_ARGENTE("CAVALIER_ARGENTE.png"), 
	ROI_OR("ROI_OR.png"), ROI_ARGENTE("ROI_ARGENTE.png"), 
	
	FLECHE("FLECHE.png"), HACHE("HACHE.png"), PANIQUE("PANIQUE.png"),
	QUESTION_DE("Question_De.jpg"), HELP("HELP.png"), RULES("RULES.png"),
	
	FLECHE_BAS_BLEUE("Fleche_bas_bleue.png"), FLECHE_HAUT_BLEUE("Fleche_haut_bleue.png"), 
	FLECHE_GAUCHE_BLEUE("Fleche_gauche_bleue.png"), FLECHE_DROITE_BLEUE("Fleche_droite_bleue.png"),
	
	SILVER_FLAG("SILVER_FLAG.jpg"), GOLD_FLAG("GOLD_FLAG.jpg");
	
	
	/**
	 * 
	 */
	Image image;

	/**
	 * taille image en pixels
	 */
	private int tailleCellule = 40;

	/**
	 * 
	 * @param imageFileName
	 * 
	 * @author belaid
	 * 
	 */
	IMage(String imageFileName) {

		try {
			image = ImageIO.read(new File("ressources/" + imageFileName))
					.getScaledInstance(tailleCellule, tailleCellule,
							Image.SCALE_DEFAULT);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}