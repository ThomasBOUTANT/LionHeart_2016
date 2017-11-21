
/**
 * gere l'ensemble des evenements lies a l'action ATTAQUER
 * 
 * @author boutant
 *
 */
public class Attaque {

	int taillePlateau = Plateau.taillePlateau;

	/**
	 * Pour savoir si on peut attaquer une base ennemie
	 * 
	 * 
	 * @param i1
	 * @param j1
	 *            : (i1,j1) : position de la base/cellule qui attaque
	 * @param i2
	 * @param j2
	 *            : (i2,j2) : position de la base ennemie
	 * @param typePiece
	 *            : archer, soldat, roi...
	 * @param orientation
	 *            : celle de la base qui attaque
	 * @return
	 * 
	 * @author boutant, manzano
	 */
	public boolean attaquePossible(int i1, int j1, int i2, int j2, TypePiece typePiece, Orientation orientation) {
		if (typePiece == TypePiece.ARCHER) {
			// un archer peut attaquer dans une zone 3x3 devant lui
			if (orientation == Orientation.NORD) {
				if ((i1 - 3 <= i2) && (i2 <= i1 - 1) && (j1 - 1 <= j2) && (j2 <= j1 + 1)) {
					return true;
				}
			} else if (orientation == Orientation.EST) {
				if ((i1 - 1 <= i2) && (i2 <= i1 + 1) && (j1 + 1 <= j2) && (j2 <= j1 + 3)) {
					return true;
				}
			} else if (orientation == Orientation.SUD) {
				if ((i1 + 1 <= i2) && (i2 <= i1 + 3) && (j1 - 1 <= j2) && (j2 <= j1 + 1)) {
					return true;
				}
			} else if (orientation == Orientation.OUEST) {
				if ((i1 - 1 <= i2) && (i2 <= i1 + 1) && (j1 - 3 <= j2) && (j2 <= j1 - 1)) {
					return true;
				}
			}
		} else if (typePiece == TypePiece.ROI || typePiece == TypePiece.CAVALIER || typePiece == TypePiece.SOLDAT) {
			// SOLDAT, CAVALIER et ROI attaquent la case directement en face d'eux
			if (orientation == Orientation.NORD) {
				if ((i1 - 1 == i2) && (j1 == j2)) {
					return true;
				}
			} else if (orientation == Orientation.EST) {
				if ((i1 == i2) && (j1 + 1 == j2)) {
					return true;
				}
			} else if (orientation == Orientation.SUD) {
				if ((i1 + 1 == i2) && (j1 == j2)) {
					return true;
				}
			} else if (orientation == Orientation.OUEST) {
				if ((i1 == i2) && (j1 - 1 == j2)) {
					return true;
				}
			}
		}
		return false;

	};
	

	
	int compteurHache ;
	int compteurFleche ;
	int compteurPanique ;
	int compteurVide ;
	int pdd = 0;
	
	/**
	 * Pour connaitre le nombre de degats resultant de l'attaque
	 * 
	 * @param nbLancerDe
	 * @param valeurDes
	 * @param typePiece0
	 * @return le nombre de PDD (Point de Degats)
	 * 
	 * @author boutant, manzano
	 */
	public int degats(ValeurDe[] valeurDes, TypePiece typePiece0) {
		pdd = 0;
		
		compteurHache = 0;
		compteurFleche = 0;
		compteurPanique = 0;
		compteurVide = 0;
		
		for (int i = 0; i < valeurDes.length; i++) {
			if (valeurDes[i] == ValeurDe.FLECHE) {
				compteurFleche++;
			}
			if (valeurDes[i] == ValeurDe.HACHE) {
				compteurHache++;
			}
			if (valeurDes[i] == ValeurDe.PANIQUE) {
				compteurPanique++;
			}
			if (valeurDes[i] == ValeurDe.VIDE) {
				compteurVide++;
			}
		}
		if (typePiece0 == TypePiece.ARCHER) {
			pdd = compteurFleche;
		} else if (typePiece0 == TypePiece.ROI || typePiece0 == TypePiece.CAVALIER || typePiece0 == TypePiece.SOLDAT) {
			pdd = compteurHache;
		} else {
			System.out.print("Y a un petit probleme !");
		}
		return pdd;
	};

	/**
	 * Le statut Panique est un cas particulier resultant d'un lancer de de(s)
	 * 
	 * @param typeCellule
	 *            : la cellule qui subit le panique
	 * @param i
	 * @param j
	 *            : (i,j) la position de la cellule sur le plateau
	 * @param plateau
	 *            pour connaitre les positions des autres pieces
	 * 
	 * @author boutant, manzano
	 */
	public void panique(TypeCellule typeCellule, int i, int j, Cellule[][] plateau) {

		TypePiece typePiece0 = typeCellule.typePiece;
		Couleur couleur0 = typeCellule.couleur;
		Orientation orientation0 = typeCellule.getOrientation();

		if (typePiece0 != TypePiece.ROI) {
			// Pour toutes les pieces autres que le roi;
			// Le roi ne paniquant pas, il ne se passe rien

			// oriente NORD
			if (orientation0 == Orientation.NORD) {
				orientation0 = Orientation.SUD;
				// ... et veut maintenant avancer d'une case
				if (plateau[i + 1][j].typeCellule == TypeCellule.NOIR) {
					// Correspond au cas ou la cellule sort des cases jouables du plateau
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					// la cellule devient donc vide : elle meurt (se cogne contre un mur)
					return;
				} else if (plateau[i + 1][j].typeCellule == TypeCellule.VIDE) {
					// Correspond au cas ou la cellule peut avancer
					plateau[i + 1][j].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i][j].nbDePieces, orientation0);
					plateau[i+1][j].orientation = orientation0; 
					plateau[i+1][j].nbDePieces = plateau[i][j].nbDePieces;
					// la cellule (i+1 , j) prend le contenu de la cellule (i,j)
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					// la cellule (i,j) devient vide
					return;
				} else if (((plateau[i + 1][j].typeCellule).couleur != couleur0)
						|| (((plateau[i + 1][j].typeCellule).typePiece == TypePiece.ROI) && ((plateau[i + 1][j].typeCellule).couleur == couleur0))) {
					// Si la cellule devant est ennemie ou que c'est un roi
					// allie, la cellule (i,j) meure
					System.out.println("Une unite vous bloque la route ! ");
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					// la cellule devient donc vide
					return;
				} else { // propagation du panique
					System.out.println("La Panique se propage !! ");
					TypeCellule typeCellule1 = plateau[i + 1][j].typeCellule;
					typeCellule1 = new TypeCellule(typeCellule1.typePiece, typeCellule1.couleur, plateau[i+1][j].nbDePieces, Orientation.NORD);
					panique(typeCellule1, i + 1, j, plateau);
					// Appel de panique , pour l'utiliser de maniere recursive
					// sur la cellule adjacente selon l'orientation
					plateau[i + 1][j].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i][j].nbDePieces, orientation0);
					plateau[i+1][j].orientation = orientation0;
					plateau[i+1][j].nbDePieces = plateau[i][j].nbDePieces;
					plateau[i][j].typeCellule = TypeCellule.VIDE;
				}
			}

			// oriente SUD
			if (orientation0 == Orientation.SUD) {
				orientation0 = Orientation.NORD;
				if (plateau[i - 1][j].typeCellule == TypeCellule.NOIR) {
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else if (plateau[i - 1][j].typeCellule == TypeCellule.VIDE) {
					plateau[i - 1][j].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i-1][j].nbDePieces, orientation0);
					plateau[i-1][j].orientation = orientation0;
					plateau[i-1][j].nbDePieces = plateau[i][j].nbDePieces;

					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
					
				} else if (((plateau[i - 1][j].typeCellule).couleur != couleur0)
						|| (((plateau[i - 1][j].typeCellule).typePiece == TypePiece.ROI) && ((plateau[i - 1][j].typeCellule).couleur == couleur0))) {
					System.out.println("Une unite vous bloque la route ! ");
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else {
					TypeCellule typeCellule1 = plateau[i - 1][j].typeCellule;
					System.out.println("La Panique se propage !! ");
					typeCellule1 = new TypeCellule(typeCellule1.typePiece, typeCellule1.couleur, plateau[i-1][j].nbDePieces, Orientation.SUD);
					panique(typeCellule1, i - 1, j, plateau);
					plateau[i - 1][j].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i][j].nbDePieces, orientation0);
					plateau[i-1][j].orientation = orientation0;
					plateau[i-1][j].nbDePieces = plateau[i][j].nbDePieces;
					
					plateau[i][j].typeCellule = TypeCellule.VIDE;
				}
			}

			// oriente OUEST
			if (orientation0 == Orientation.OUEST) {
				orientation0 = Orientation.EST;
				if (plateau[i][j + 1].typeCellule == TypeCellule.NOIR) {
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else if (plateau[i][j + 1].typeCellule == TypeCellule.VIDE) {
					plateau[i][j+1].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i][j+1].nbDePieces, orientation0);
					plateau[i][j+1].orientation = orientation0;
					plateau[i][j+1].nbDePieces = plateau[i][j].nbDePieces;

					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else if (((plateau[i][j + 1].typeCellule).couleur != couleur0)
						|| (((plateau[i][j + 1].typeCellule).typePiece == TypePiece.ROI) && ((plateau[i][j + 1].typeCellule).couleur == couleur0))) {
					System.out.println("Une unite vous bloque la route ! ");
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else {
					System.out.println("La Panique se propage !! ");
					TypeCellule typeCellule1 = plateau[i][j + 1].typeCellule;

					typeCellule1 = new TypeCellule(typeCellule1.typePiece, typeCellule1.couleur, plateau[i][j+1].nbDePieces, Orientation.OUEST);
					panique(typeCellule1, i, j + 1, plateau);
					plateau[i][j+1].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i][j].nbDePieces, orientation0);
					plateau[i][j+1].orientation = orientation0;
					plateau[i][j+1].nbDePieces = plateau[i][j].nbDePieces;
					plateau[i][j].typeCellule = TypeCellule.VIDE;
				}
			}

			// oriente EST
			if (orientation0 == Orientation.EST) { // Meme chose pour une autre
													// orientation
				orientation0 = Orientation.OUEST;
				if (plateau[i][j - 1].typeCellule == TypeCellule.NOIR) {
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else if (plateau[i][j - 1].typeCellule == TypeCellule.VIDE) {
					plateau[i][j - 1].typeCellule = typeCellule;
					plateau[i][j-1].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i][j-1].nbDePieces, orientation0);
					plateau[i][j-1].orientation = orientation0;
					plateau[i][j-1].nbDePieces = plateau[i][j].nbDePieces;
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else if ((plateau[i][j-1].typeCellule).couleur != couleur0
						|| ((plateau[i][j - 1].typeCellule).typePiece == TypePiece.ROI) && ((plateau[i][j - 1].typeCellule).couleur == couleur0)) {
					System.out.println("Une unite vous bloque la route ! ");
					plateau[i][j].typeCellule = TypeCellule.VIDE;
					return;
				} else {
					System.out.println("La Panique se propage !! ");
					TypeCellule typeCellule1 = plateau[i][j - 1].typeCellule;
					
					typeCellule1 = new TypeCellule(typeCellule1.typePiece, typeCellule1.couleur, plateau[i][j-1].nbDePieces, Orientation.EST);
					panique(typeCellule1, i, j - 1, plateau);
					plateau[i][j-1].typeCellule = new TypeCellule(typeCellule.typePiece, typeCellule.couleur, plateau[i][j].nbDePieces, orientation0);
					plateau[i][j-1].orientation = orientation0;
					plateau[i][j-1].nbDePieces = plateau[i][j].nbDePieces;
					
					plateau[i][j].typeCellule= TypeCellule.VIDE;
				}
			}
		}
		else {
			System.out.println("Un ROI ne panique jamais. Vous avez de la chance !");
		}
	}

	/**
	 * Pour savoir si toutes les pieces d'une base ont ete tuees
	 * 
	 * 
	 * @param PDD
	 *            : degats infliges par l'ennemi
	 * @param NbDePieces
	 *            : nb de pieces sur la base
	 * @param typePiece
	 *            : archers, cavaliers...
	 * @return si oui ou non la cellule a ete detruite
	 * 
	 * @author boutant, manzano
	 */
	public boolean mortCellule(int pdd, int nbDePieces, TypePiece typePiece) {
		if (typePiece == TypePiece.ARCHER || typePiece == TypePiece.SOLDAT) {
			if (nbDePieces - pdd <= 0) {
				return true;
			} else
				return false;
		} else if (typePiece == TypePiece.CAVALIER || typePiece == TypePiece.ROI) {
			if (2 * nbDePieces - pdd <= 0) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	/**
	 * Pour savoir combien il reste de pieces apres une attaque
	 * 
	 * @param PDD
	 * @param NbDePieces
	 * @param typePiece
	 * @return
	 * 
	 * @author boutant
	 */
	public int nbPiecesRestantes(int pdd, int nbDePieces, TypePiece typePiece) {
		int nbPiecesRestantes = 0;
		if (typePiece == TypePiece.ARCHER || typePiece == TypePiece.SOLDAT) {
			nbPiecesRestantes = nbDePieces - pdd;
		} else if (typePiece == TypePiece.CAVALIER || typePiece == TypePiece.ROI) {
			int nbPiecesRestantes0 = 2 * nbDePieces - pdd;
			if (nbPiecesRestantes0 == 4 || nbPiecesRestantes0 == 3) {
				nbPiecesRestantes = 2;
			} else if (nbPiecesRestantes0 == 2 || nbPiecesRestantes0 == 1) {
				nbPiecesRestantes = 1;
			}
		}
		return nbPiecesRestantes;
	}

	/**
	 * Pour savoir si un joueur a gagne
	 * 
	 * @param plateau
	 * @return si oui ou non un joueur a gagne
	 * 
	 * @author boutant, manzano
	 */
	public boolean testvictoire(Cellule[][] plateau) {

		int CompteurOr = 0; // SOLDAT, ARCHER, CAVALIER
		int CompteurArgent = 0;
		int CompteurRoiOr = 0;
		int CompteurRoiArgent = 0;
		Couleur couleur = null;
		TypePiece typePiece = null;

		System.out.println("Quelqu'un a-t-il gagne ?");

		for (int i = 1; i < taillePlateau - 2; i++) {
			for (int m = 1; m < taillePlateau - 1; m++) {
				if (plateau[i][m].typeCellule != TypeCellule.VIDE) {
					couleur = (plateau[i][m].typeCellule).couleur;
					typePiece = (plateau[i][m].typeCellule).typePiece;

					switch (couleur) {

					case OR:
						if (typePiece == TypePiece.ROI) {
							CompteurRoiOr++;
						} else {
							CompteurOr++;
						}
						break;

					case ARGENT:
						if (typePiece == TypePiece.ROI) {
							CompteurRoiArgent++;
						} else {
							CompteurArgent++;
						}
						break;
					}
				}

			}
		}
		System.out.println("     Il reste " + CompteurOr + " unites OR (sans compter le ROI).");
		System.out.println("     Il reste " + CompteurArgent + " unites ARGENT (sans compter le ROI).");
		System.out.println(" ");
		System.out.println("     Concernant les ROIs : ");
		System.out.println("         - il en reste " + CompteurRoiOr + " pour " + Joueur.joueurOr);
		System.out.println("         - il en reste " + CompteurRoiArgent + " pour " + Joueur.joueurArgent);
		System.out.println(" ");
		if (CompteurRoiOr == 0 || CompteurOr == 0) {
			System.out.println("Reponse : OUUUUUUUIIIIIIIIIIIII !!!!!!! Quelqu'un a gagne !!");
			System.out.println("     --> Victoire du joueur ARGENT ! Bravo !!");
			System.out.println(" ");
			return true;
		}
		if (CompteurRoiArgent == 0 || CompteurArgent == 0) {
			System.out.println("Reponse : OUUUUUUUIIIIIIIIIIIII !!!!!!! Quelqu'un a gagne !!");
			System.out.println("     --> Victoire du joueur OR ! Bravo !!");
			System.out.println(" ");
			return true;
		} 
		else
			System.out.println("Reponse : non... Personne n'a encore gagne. Le jeu continue.");
			return false;
	}

	/**
	 * Pour savoir si on attaque ou on panique
	 * 
	 * @param valeurDes
	 *            : si que des "PANIQUE", on panique, sinon on attaque
	 * @return si oui ou non on panique
	 * 
	 * @author boutant
	 */
	public boolean testPanique(ValeurDe[] valeurDes) {
		for (int i = 0; i < valeurDes.length; i++) {
			if (valeurDes[i] != ValeurDe.PANIQUE && valeurDes[i] != ValeurDe.VIDE ) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param i1
	 * @param j1
	 * @param degats
	 * @param typeCellule1
	 * @param plateau
	 * 
	 * @author boutant
	 */
	public void attaquer(int i1, int j1, int degats, TypeCellule typeCellule1, Cellule[][] plateau) {

		TypePiece typePiece1 = (plateau[i1][j1].typeCellule).typePiece;
		int nbPiece1 = plateau[i1][j1].nbDePieces;
		Attaque attaque = new Attaque();

		if (attaque.mortCellule(degats, nbPiece1, typePiece1)) {
			plateau[i1][j1].typeCellule = TypeCellule.VIDE;
		} else {
			plateau[i1][j1].nbDePieces = nbPiecesRestantes(degats, nbPiece1, typePiece1);
		}

	}

}