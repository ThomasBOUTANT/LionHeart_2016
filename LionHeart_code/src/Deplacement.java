
public class Deplacement {

	/**
	 * Pour savoir si on peut se deplacer jusqu'a une certaine case
	 * 
	 * @param (i0,j0) position de la base/cellule avant deplacement
	 * @param (i,j) position de la case visee par le deplacement
	 * @param typePiece correspond a archer, soldat, roi...
	 * @param orientation de la base qui veut se deplacer
	 * 
	 * @return si oui ou non on peut se deplacer jusqu'a la cas visee
	 * 
	 * @author manzano, boutant, coispel
	 * 
	 * 
	 **/
	public boolean deplacementPossible(int i0, int j0, int i1, int j1, TypePiece typePiece,
			Orientation orientation, Cellule[][] plateau)  {
		if (typePiece == TypePiece.ARCHER || typePiece == TypePiece.SOLDAT) {
			if (orientation == Orientation.NORD) {
				return ((i1 == i0 - 1) && (j1 == j0) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE));
			} else if (orientation == Orientation.SUD) {
				return ((i1 == i0 + 1) && (j1 == j0) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE));
			} else if (orientation == Orientation.OUEST) {
				return ((i1 == i0) && (j1 == j0 - 1) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE));
			} else if (orientation == Orientation.EST) {
				return ((i1 == i0) && (j1 == j0 + 1) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE));
			}
			
			
		} else if (typePiece == TypePiece.ROI || typePiece == TypePiece.CAVALIER) {
			// on effectue un test de deplacement sur la ligne
			if (orientation == Orientation.NORD) {
				if ((j1 == j0) && (i1 < i0) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE)) {
					for (int w = 1; w <= i0 - i1; w++) {
						System.out.println("test de deplacement : sur la case ( " + (i0-w) + ", " + j0 + " ), il y a : " + plateau[i0-w][j0]);
						// ici apparait la notion "d'obstacle"
						if (plateau[i0-w][j1].typeCellule != TypeCellule.VIDE) {
							return false;
						}
					}
					return true;
					}
				}
			else if (orientation == Orientation.SUD) {
				if ((j1 == j0) && (i1 > i0) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE)) {
					for (int w = 1; w <= i1 - i0; w++) {
						System.out.println("test de deplacement : sur la case ( " + (i0+w) + ", " + j0 + " ), il y a : " + plateau[i0+w][j0]);
						// ici apparait la notion "d'obstacle"
						if (plateau[i0+w][j0].typeCellule != TypeCellule.VIDE) {
							return false;
						}
					}
					return true;
					}
				}
			else if (orientation == Orientation.OUEST) {
				if ((i1 == i0) && (j1 < j0) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE)) {
					for (int w = 1; w <= j0 - j1; w++) {
						System.out.println("test de deplacement : sur la case ( " + i0 + ", " + (j0-w) + " ), il y a : " + plateau[i0][j0-w]);
						// ici apparait la notion "d'obstacle"
						if (plateau[i0][j0 - w].typeCellule != TypeCellule.VIDE) {
							return false;
						}
					}
					return true;
					}
				}
			else if (orientation == Orientation.EST) {
				if ((j1 > j0) && (i1== i0) && (plateau[i1][j1].typeCellule == TypeCellule.VIDE)) {
					for (int z = 1; z <= j1 - j0; z++) {
						System.out.println("test de deplacement : sur la case ( " + i0 + ", " + (j0+z) + " ), il y a : " + plateau[i0][j0+z]);
						// ici apparait la notion "d'obstacle"
						if (plateau[i0][j0 + z].typeCellule != TypeCellule.VIDE) {
							return false;
						}
					}
					return true;
					}
				}
		}
		return false;
	}
}
