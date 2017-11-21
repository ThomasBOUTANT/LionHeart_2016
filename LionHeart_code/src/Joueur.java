/**
 * 
 * @author boutant, belaid
 *
 */

public enum Joueur {

	joueurOr(Couleur.OR), joueurArgent(Couleur.ARGENT);

	Couleur couleur;

	Joueur(Couleur couleur) {
		this.couleur = couleur;
	}

}