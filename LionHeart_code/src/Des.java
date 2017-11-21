
/**
 * 
 * @author belaid
 *
 */
public class Des {

	ValeurDe[] valeur_des = { ValeurDe.VIDE, ValeurDe.VIDE, ValeurDe.VIDE, ValeurDe.VIDE };
	int nbLancerDe;

	/**
	 * 
	 * @author belaid, boutant
	 */
	public void affiche() {

		for (int i = 0; i < valeur_des.length; i++)
			if (valeur_des[i] != ValeurDe.VIDE) {
				System.out.println("     De n°" + (i+1) + " = " + valeur_des[i]);
			}

	}

	// -------------------------------------------------------------------------------------------

	/**
	 * 
	 * @param NbDePieces
	 * @param typePiece
	 * @param joueur
	 * 
	 * @author boutant
	 */
	public Des(int nbDePieces, TypePiece typePiece, Joueur joueur) {

		nbLancerDe = nbLancerDe(nbDePieces, typePiece);
		System.out.println("Nombre de de(s) lancer(s) = " + nbLancerDe);
		listeValeursDes(nbLancerDe, joueur);
	}

	// -------------------------------------------------------------------------------------------

	/**
	 * Pour connaitre le resultat d'un lancer de des
	 * 
	 * @param NbLancerDe
	 * @param joueur
	 *            (pas necessaire)
	 * @return la liste des valeurs des des
	 * 
	 * @author boutant
	 */
	public void listeValeursDes(int nbLancerDe, Joueur joueur) {

		int[] de = new int[4];
		for (int i = 0; i < de.length; i++) {
			de[i] = 0;
		}
		System.out.println(joueur + " obtient les valeurs : ");
		for (int i = 0; i < nbLancerDe; i++) {
			// de[i] = 6;
			de[i] = 1 + (int) (Math.random() * 6);
			valeur_des[i] = convertion_Nombre_ValeurDe(de[i]);
		}
	}

	// ------------------------------------------------------------------------------------------

	/**
	 * A partir d'un nombre, on associe une valeur de de
	 * 
	 * @param nombre
	 *            entre 0 et 6
	 * @return la valeur_de associee
	 * 
	 * @author boutant
	 */
	private ValeurDe convertion_Nombre_ValeurDe(int nombre) {

		ValeurDe valeur_de = null;
		if ((1 <= nombre) && (nombre <= 3)) {
			valeur_de = ValeurDe.HACHE;
		} else if ((4 == nombre) || (nombre == 5)) {
			valeur_de = ValeurDe.FLECHE;
		} else if (nombre == 6) {
			valeur_de = ValeurDe.PANIQUE;
		} else if (nombre == 0) { // permet de combler le vide lorsqu'il y a des
									// des non lances
			valeur_de = ValeurDe.VIDE;
		} else {
			System.out.print(" impossible");
		}

		return valeur_de;

	}

	// -------------------------------------------------------------------------------------------

	/**
	 * Pour connaitre le nombre de des lances
	 * 
	 * @param nbDePieces
	 *            le nombre de piece(s) sur la base
	 * @param typePiece
	 *            : archer, soldat, roi...?
	 * 
	 * @return le nombre de de(s) lancer(s)
	 * 
	 * @author duong, boutant, manzano
	 **/
	private int nbLancerDe(int NbDePieces, TypePiece typePiece) {

		if (typePiece == TypePiece.ARCHER || typePiece == TypePiece.SOLDAT) {
			if (NbDePieces < 4) { // on lance autant de des que de pieces sur la
									// base qui attaque
				nbLancerDe = NbDePieces;
			} else {
				nbLancerDe = 4;
			}
			return nbLancerDe;
		}
		if (typePiece == TypePiece.ROI || typePiece == TypePiece.CAVALIER) {
			nbLancerDe = 2 * NbDePieces;
			return nbLancerDe;
		} else {
			System.out.print("Probleme typePiece");
			return 0;
		}
	}

}