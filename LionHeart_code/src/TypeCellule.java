import java.awt.Image;

/**
 * 
 * @author belaid, boutant, coispel
 *
 */
public class TypeCellule {

	static TypeCellule NOIR = new TypeCellule(-1);
	static TypeCellule VIDE = new TypeCellule(0);
	static TypeCellule HACHE = new TypeCellule(-2);
	static TypeCellule FLECHE = new TypeCellule(-3);
	static TypeCellule PANIQUE = new TypeCellule(-4);
	static TypeCellule QUESTION_DE = new TypeCellule(-5);
	static TypeCellule HELP = new TypeCellule(-6);
	static TypeCellule RULES = new TypeCellule(-7);
	static TypeCellule FLECHE_BAS_BLEUE = new TypeCellule(-8);
	static TypeCellule FLECHE_HAUT_BLEUE = new TypeCellule(-9);
	static TypeCellule FLECHE_GAUCHE_BLEUE = new TypeCellule(-10);
	static TypeCellule FLECHE_DROITE_BLEUE = new TypeCellule(-11);
	static TypeCellule SILVER_FLAG = new TypeCellule(-12);
	static TypeCellule GOLD_FLAG = new TypeCellule(-13);

	// SOLDAT_OR
	static TypeCellule SOLDAT_OR_1_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 1, Orientation.NORD);
	static TypeCellule SOLDAT_OR_1_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 1, Orientation.SUD);
	static TypeCellule SOLDAT_OR_1_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 1, Orientation.OUEST);
	static TypeCellule SOLDAT_OR_1_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 1, Orientation.EST);
	static TypeCellule SOLDAT_OR_2_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 2, Orientation.NORD);
	static TypeCellule SOLDAT_OR_2_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 2, Orientation.SUD);
	static TypeCellule SOLDAT_OR_2_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 2, Orientation.OUEST);
	static TypeCellule SOLDAT_OR_2_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 2, Orientation.EST);
	static TypeCellule SOLDAT_OR_3_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 3, Orientation.NORD);
	static TypeCellule SOLDAT_OR_3_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 3, Orientation.SUD);
	static TypeCellule SOLDAT_OR_3_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 3, Orientation.OUEST);
	static TypeCellule SOLDAT_OR_3_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 3, Orientation.EST);
	static TypeCellule SOLDAT_OR_4_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 4, Orientation.NORD);
	static TypeCellule SOLDAT_OR_4_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 4, Orientation.SUD);
	static TypeCellule SOLDAT_OR_4_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 4, Orientation.OUEST);
	static TypeCellule SOLDAT_OR_4_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.OR, 4, Orientation.EST);

	// SOLDAT_ARGENT
	static TypeCellule SOLDAT_ARGENT_1_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 1, Orientation.NORD);
	static TypeCellule SOLDAT_ARGENT_1_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 1, Orientation.SUD);
	static TypeCellule SOLDAT_ARGENT_1_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 1, Orientation.OUEST);
	static TypeCellule SOLDAT_ARGENT_1_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 1, Orientation.EST);
	static TypeCellule SOLDAT_ARGENT_2_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 2, Orientation.NORD);
	static TypeCellule SOLDAT_ARGENT_2_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 2, Orientation.SUD);
	static TypeCellule SOLDAT_ARGENT_2_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 2, Orientation.OUEST);
	static TypeCellule SOLDAT_ARGENT_2_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 2, Orientation.EST);
	static TypeCellule SOLDAT_ARGENT_3_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 3, Orientation.NORD);
	static TypeCellule SOLDAT_ARGENT_3_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 3, Orientation.SUD);
	static TypeCellule SOLDAT_ARGENT_3_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 3, Orientation.OUEST);
	static TypeCellule SOLDAT_ARGENT_3_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 3, Orientation.EST);
	static TypeCellule SOLDAT_ARGENT_4_NORD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 4, Orientation.NORD);
	static TypeCellule SOLDAT_ARGENT_4_SUD = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 4, Orientation.SUD);
	static TypeCellule SOLDAT_ARGENT_4_OUEST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 4, Orientation.OUEST);
	static TypeCellule SOLDAT_ARGENT_4_EST = new TypeCellule(TypePiece.SOLDAT, Couleur.ARGENT, 4, Orientation.EST);

	// ARCHER_OR
	static TypeCellule ARCHER_OR_1_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 1, Orientation.NORD);
	static TypeCellule ARCHER_OR_1_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 1, Orientation.SUD);
	static TypeCellule ARCHER_OR_1_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 1, Orientation.OUEST);
	static TypeCellule ARCHER_OR_1_EST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 1, Orientation.EST);
	static TypeCellule ARCHER_OR_2_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 2, Orientation.NORD);
	static TypeCellule ARCHER_OR_2_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 2, Orientation.SUD);
	static TypeCellule ARCHER_OR_2_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 2, Orientation.OUEST);
	static TypeCellule ARCHER_OR_2_EST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 2, Orientation.EST);
	static TypeCellule ARCHER_OR_3_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 3, Orientation.NORD);
	static TypeCellule ARCHER_OR_3_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 3, Orientation.SUD);
	static TypeCellule ARCHER_OR_3_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 3, Orientation.OUEST);
	static TypeCellule ARCHER_OR_3_EST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 3, Orientation.EST);
	static TypeCellule ARCHER_OR_4_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 4, Orientation.NORD);
	static TypeCellule ARCHER_OR_4_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 4, Orientation.SUD);
	static TypeCellule ARCHER_OR_4_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 4, Orientation.OUEST);
	static TypeCellule ARCHER_OR_4_EST = new TypeCellule(TypePiece.ARCHER, Couleur.OR, 4, Orientation.EST);

	// ARCHER_ARGENT
	static TypeCellule ARCHER_ARGENT_1_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 1, Orientation.NORD);
	static TypeCellule ARCHER_ARGENT_1_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 1, Orientation.SUD);
	static TypeCellule ARCHER_ARGENT_1_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 1, Orientation.OUEST);
	static TypeCellule ARCHER_ARGENT_1_EST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 1, Orientation.EST);
	static TypeCellule ARCHER_ARGENT_2_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 2, Orientation.NORD);
	static TypeCellule ARCHER_ARGENT_2_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 2, Orientation.SUD);
	static TypeCellule ARCHER_ARGENT_2_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 2, Orientation.OUEST);
	static TypeCellule ARCHER_ARGENT_2_EST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 2, Orientation.EST);
	static TypeCellule ARCHER_ARGENT_3_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 3, Orientation.NORD);
	static TypeCellule ARCHER_ARGENT_3_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 3, Orientation.SUD);
	static TypeCellule ARCHER_ARGENT_3_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 3, Orientation.OUEST);
	static TypeCellule ARCHER_ARGENT_3_EST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 3, Orientation.EST);
	static TypeCellule ARCHER_ARGENT_4_NORD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 4, Orientation.NORD);
	static TypeCellule ARCHER_ARGENT_4_SUD = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 4, Orientation.SUD);
	static TypeCellule ARCHER_ARGENT_4_OUEST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 4, Orientation.OUEST);
	static TypeCellule ARCHER_ARGENT_4_EST = new TypeCellule(TypePiece.ARCHER, Couleur.ARGENT, 4, Orientation.EST);

	// CAVALIER_OR
	static TypeCellule CAVALIER_OR_1_NORD = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 1, Orientation.NORD);
	static TypeCellule CAVALIER_OR_1_SUD = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 1, Orientation.SUD);
	static TypeCellule CAVALIER_OR_1_OUEST = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 1, Orientation.OUEST);
	static TypeCellule CAVALIER_OR_1_EST = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 1, Orientation.EST);
	static TypeCellule CAVALIER_OR_2_NORD = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 2, Orientation.NORD);
	static TypeCellule CAVALIER_OR_2_SUD = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 2, Orientation.SUD);
	static TypeCellule CAVALIER_OR_2_OUEST = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 2, Orientation.OUEST);
	static TypeCellule CAVALIER_OR_2_EST = new TypeCellule(TypePiece.CAVALIER, Couleur.OR, 2, Orientation.EST);

	// CAVALIER_ARGENT
	static TypeCellule CAVALIER_ARGENT_1_NORD = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 1, Orientation.NORD);
	static TypeCellule CAVALIER_ARGENT_1_SUD = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 1, Orientation.SUD);
	static TypeCellule CAVALIER_ARGENT_1_OUEST = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 1, Orientation.OUEST);
	static TypeCellule CAVALIER_ARGENT_1_EST = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 1, Orientation.EST);
	static TypeCellule CAVALIER_ARGENT_2_NORD = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 2, Orientation.NORD);
	static TypeCellule CAVALIER_ARGENT_2_SUD = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 2, Orientation.SUD);
	static TypeCellule CAVALIER_ARGENT_2_OUEST = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 2, Orientation.OUEST);
	static TypeCellule CAVALIER_ARGENT_2_EST = new TypeCellule(TypePiece.CAVALIER, Couleur.ARGENT, 2, Orientation.EST);

	// ROI_OR
	static TypeCellule ROI_OR_1_NORD = new TypeCellule(TypePiece.ROI, Couleur.OR, 1, Orientation.NORD);
	static TypeCellule ROI_OR_1_SUD = new TypeCellule(TypePiece.ROI, Couleur.OR, 1, Orientation.SUD);
	static TypeCellule ROI_OR_1_OUEST = new TypeCellule(TypePiece.ROI, Couleur.OR, 1, Orientation.OUEST);
	static TypeCellule ROI_OR_1_EST = new TypeCellule(TypePiece.ROI, Couleur.OR, 1, Orientation.EST);

	// ROI_ARGENT
	static TypeCellule ROI_ARGENT_1_NORD = new TypeCellule(TypePiece.ROI, Couleur.ARGENT, 1, Orientation.NORD);
	static TypeCellule ROI_ARGENT_1_SUD = new TypeCellule(TypePiece.ROI, Couleur.ARGENT, 1, Orientation.SUD);
	static TypeCellule ROI_ARGENT_1_OUEST = new TypeCellule(TypePiece.ROI, Couleur.ARGENT, 1, Orientation.OUEST);
	static TypeCellule ROI_ARGENT_1_EST = new TypeCellule(TypePiece.ROI, Couleur.ARGENT, 1, Orientation.EST);

	/**
	 * 
	 */
	TypePiece typePiece;

	/**
	 * 
	 */
	Couleur couleur;

	/**
	 * 
	 */
	private int nbDePieces;

	/**
	 * 
	 */
	private Orientation orientation;

	public int getNbDePieces() {
		return nbDePieces;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * 
	 */
	Image image;

	/**
	 * 
	 * @param typePiece
	 * @param couleur
	 * @param nbDePieces
	 * @param orientation
	 * 
	 * @author belaid
	 */
	public TypeCellule(TypePiece typePiece, Couleur couleur, int nbDePieces, Orientation orientation) {

		this.typePiece = typePiece;
		this.couleur = couleur;
		this.nbDePieces = nbDePieces;
		this.orientation = orientation;

		switch (typePiece) {

		case SOLDAT:
			image = couleur.equals(Couleur.OR) ? IMage.SOLDAT_OR.image : IMage.SOLDAT_ARGENTE.image;
			break;

		case ARCHER:
			image = couleur.equals(Couleur.OR) ? IMage.ARCHER_OR.image : IMage.ARCHER_ARGENTE.image;
			break;

		case CAVALIER:
			image = couleur.equals(Couleur.OR) ? IMage.CAVALIER_OR.image : IMage.CAVALIER_ARGENTE.image;
			break;

		case ROI:
			image = couleur.equals(Couleur.OR) ? IMage.ROI_OR.image : IMage.ROI_ARGENTE.image;
			break;
		}
	}

	/**
	 * 
	 * @param nbDePieces
	 * 
	 * @author belaid, boutant
	 */
	public TypeCellule(int nbDePieces) {

		this.nbDePieces = nbDePieces;
		switch (nbDePieces) {
		case 0:
			image = IMage.VIDE.image;
			break;
		case -1:
			image = IMage.NOIR.image;
			break;
		case -2:
			image = IMage.HACHE.image;
			break;
		case -3:
			image = IMage.FLECHE.image;
			break;
		case -4:
			image = IMage.PANIQUE.image;
			break;
		case -5:
			image = IMage.QUESTION_DE.image;
			break;
		case -6:
			image = IMage.HELP.image;
			break;
		case -7:
			image = IMage.RULES.image;
			break;
		case -8:
			image = IMage.FLECHE_BAS_BLEUE.image;
			break;
		case -9:
			image = IMage.FLECHE_HAUT_BLEUE.image;
			break;
		case -10:
			image = IMage.FLECHE_GAUCHE_BLEUE.image;
			break;
		case -11:
			image = IMage.FLECHE_DROITE_BLEUE.image;
			break;
		case -12:
			image = IMage.SILVER_FLAG.image;
			break;
		case -13:
			image = IMage.GOLD_FLAG.image;
			break;
		}

	}

	// -------------------------------------------------------------------------------------------

	/**
	 * 
	 * @return le texte \E0 afficher en haut de la cellule au dessus de l'image
	 * 
	 * @author belaid
	 */
	public String getTexte() {

		return getNbDePieces() + " " + getOrientation();
	}

}