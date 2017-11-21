import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

/**
 * 
 * dans Plateau est implemente la logique de jeu
 * 
 * @author belaid, boutant
 */
public class Plateau extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * nombre de lignes et de colonnes
	 */
	static int taillePlateau = 11;

	/**
	 * matrice de cellules, chaque cellule definissant un typeCellule
	 */
	Cellule[][] plateau = new Cellule[taillePlateau][taillePlateau];

	/**
	 * identite du joueur autorise a jouer dans ce tour par defaut : joueurOr
	 * 
	 * @author boutant
	 */
	Joueur joueurQuiJoue = Joueur.joueurOr;

	// --------------------------------------------------------------------------------------------

	/**
	 * @author belaid, boutant (les tests)
	 */
	public Plateau() {

		initPlateau();
		//initPlateauTestPanique1();
		// initPlateauTestPanique2();
		// initPlateauTestTotal();
		// initPlateauTestHelpArcher();
		affichePlateau();
	}

	// --------------------------------------------------------------------------------------------

	/**
	 * @author belaid
	 */
	public void affichePlateau() {

		setLayout(new GridLayout(taillePlateau, taillePlateau, 0, 0));

		for (int i = 0; i < taillePlateau; i++) {
			for (int j = 0; j < taillePlateau; j++) {
				add(new Cellule(plateau[i][j].typeCellule, this, i, j));
			}
		}
	}

	/**
	 * permet de mettre a jour l'affichage de la cellule en position (i,j)
	 * 
	 * @author belaid, boutant
	 * 
	 * @param i
	 * @param j
	 */
	public void updateCellulePlateau(int i, int j) {
		Component c = getComponent(i * taillePlateau + j);
		remove(c);
		if (plateau[i][j].typeCellule == TypeCellule.VIDE) {
			add(new Cellule(plateau[i][j].typeCellule, this, i, j), i * taillePlateau + j);
		} else {
			TypeCellule typeCellule0 = new TypeCellule((plateau[i][j].typeCellule).typePiece,
					(plateau[i][j].typeCellule).couleur, plateau[i][j].nbDePieces, plateau[i][j].orientation);
			add(new Cellule(typeCellule0, this, i, j), i * taillePlateau + j);
		}
		validate();
	}

	/**
	 * 
	 * update des cellules au centre du plateau
	 * 
	 * @author boutant
	 */
	public void updatePlateau() {
		for (int i = 1; i < taillePlateau - 2; i++) {
			for (int j = 1; j < taillePlateau - 1; j++) {
				updateCellulePlateau(i, j);
			}
		}
	}

	/**
	 * permet de mettre a jour l'affichage d'une cellule "decorative" en
	 * position (i,j)
	 * 
	 * @author boutant
	 * 
	 * @param i
	 * @param j
	 */
	public void updateCelluleDeco(int i, int j) {
		Component c = getComponent(i * taillePlateau + j);
		remove(c);
		add(new Cellule(plateau[i][j].typeCellule, this, i, j), i * taillePlateau + j);
		validate();
	}

	// -------------------------------------------------------------------------------------------

	/**
	 * Plateau vide
	 * 
	 * @author belaid, boutant
	 */
	public void initPlateauVide() {

		for (int i = 0; i < taillePlateau; i++) {
			for (int j = 0; j < taillePlateau; j++) {
				plateau[i][j] = new Cellule(TypeCellule.VIDE, this, i, j);
			}
		}

		// on definit les bords du plateau (cases noires)
		for (int i = 0; i < taillePlateau; i++) {
			plateau[0][i] = new Cellule(TypeCellule.NOIR, this, 0, i);
			plateau[taillePlateau - 2][i] = new Cellule(TypeCellule.NOIR, this, taillePlateau - 2, i);
			plateau[i][0] = new Cellule(TypeCellule.NOIR, this, i, 0);
			plateau[i][taillePlateau - 1] = new Cellule(TypeCellule.NOIR, this, i, taillePlateau - 1);
		}
		
		plateau[taillePlateau - 1][1] = new Cellule(TypeCellule.HELP, this, taillePlateau - 1, 1);
		plateau[taillePlateau - 1][2] = new Cellule(TypeCellule.NOIR, this, taillePlateau - 1, 2);
		plateau[taillePlateau - 1][3] = new Cellule(TypeCellule.QUESTION_DE, this, taillePlateau - 1, 3);
		plateau[taillePlateau - 1][4] = new Cellule(TypeCellule.QUESTION_DE, this, taillePlateau - 1, 4);
		plateau[taillePlateau - 1][5] = new Cellule(TypeCellule.FLECHE_BAS_BLEUE, this, taillePlateau - 1, 5);
		plateau[taillePlateau - 1][6] = new Cellule(TypeCellule.QUESTION_DE, this, taillePlateau - 1, 6);
		plateau[taillePlateau - 1][7] = new Cellule(TypeCellule.QUESTION_DE, this, taillePlateau - 1, 7);
		plateau[taillePlateau - 1][8] = new Cellule(TypeCellule.NOIR, this, taillePlateau - 1, 8);
		plateau[taillePlateau - 1][9] = new Cellule(TypeCellule.RULES, this, taillePlateau - 1, 9);

		plateau[5][0] = new Cellule(TypeCellule.FLECHE_GAUCHE_BLEUE, this, 5, 0);
		plateau[0][5] = new Cellule(TypeCellule.FLECHE_HAUT_BLEUE, this, 0, 5);
		plateau[5][taillePlateau - 1] = new Cellule(TypeCellule.FLECHE_DROITE_BLEUE, this, 5, taillePlateau - 1);

		plateau[0][10] = new Cellule(TypeCellule.SILVER_FLAG, this, 0, 10);
		plateau[0][0] = new Cellule(TypeCellule.GOLD_FLAG, this, 0, 0);

	}

	// ------------------------------------------------------------------------------------------

	/**
	 * @author belaid
	 */
	public void initPlateau() {

		initPlateauVide();

		plateau[1][3] = new Cellule(TypeCellule.ARCHER_ARGENT_4_SUD, this, 1, 3);
		plateau[1][4] = new Cellule(TypeCellule.CAVALIER_ARGENT_2_SUD, this, 1, 4);
		plateau[1][5] = new Cellule(TypeCellule.ROI_ARGENT_1_SUD, this, 1, 5);
		plateau[1][6] = new Cellule(TypeCellule.CAVALIER_ARGENT_2_SUD, this, 1, 6);
		plateau[1][7] = new Cellule(TypeCellule.ARCHER_ARGENT_4_SUD, this, 1, 7);
		for (int s = 3; s < 8; s++) {
			plateau[2][s] = new Cellule(TypeCellule.SOLDAT_ARGENT_4_SUD, this, 2, s);
		}

		for (int s = 3; s < 8; s++) {
			plateau[taillePlateau - 4][s] = new Cellule(TypeCellule.SOLDAT_OR_4_NORD, this, taillePlateau - 4, s);
		}

		plateau[taillePlateau - 3][3] = new Cellule(TypeCellule.ARCHER_OR_4_NORD, this, taillePlateau - 3, 3);
		plateau[taillePlateau - 3][4] = new Cellule(TypeCellule.CAVALIER_OR_2_NORD, this, taillePlateau - 3, 4);
		plateau[taillePlateau - 3][5] = new Cellule(TypeCellule.ROI_OR_1_NORD, this, taillePlateau - 3, 5);
		plateau[taillePlateau - 3][6] = new Cellule(TypeCellule.CAVALIER_OR_2_NORD, this, taillePlateau - 3, 6);
		plateau[taillePlateau - 3][7] = new Cellule(TypeCellule.ARCHER_OR_4_NORD, this, taillePlateau - 3, 7);
	}

	/**
	 * cas particulier du Panique sert pour les tests
	 * Test 1
	 * @author boutant
	 */
	public void initPlateauTestPanique1() {

		initPlateauVide();

		// Ajout pour test Panique
		// Mettre de[i] = 6 dans la classe De()
		plateau[1][1] = new Cellule(TypeCellule.ARCHER_OR_3_EST, this, 1, 1);
		plateau[1][2] = new Cellule(TypeCellule.CAVALIER_ARGENT_1_SUD, this, 1, 2);
		plateau[1][9] = new Cellule(TypeCellule.SOLDAT_OR_3_EST, this, 1, 9);
		plateau[1][8] = new Cellule(TypeCellule.ARCHER_OR_2_OUEST, this, 1, 8);
		plateau[1][7] = new Cellule(TypeCellule.ARCHER_ARGENT_4_SUD, this, 1, 7);

		plateau[2][2] = new Cellule(TypeCellule.ARCHER_ARGENT_4_EST, this, 2, 2);
		plateau[2][3] = new Cellule(TypeCellule.ROI_OR_1_SUD, this, 2, 3);
		plateau[2][8] = new Cellule(TypeCellule.SOLDAT_ARGENT_2_OUEST, this, 2, 8);
		plateau[2][7] = new Cellule(TypeCellule.ARCHER_OR_4_SUD, this, 2, 7);

		plateau[3][3] = new Cellule(TypeCellule.ARCHER_OR_4_EST, this, 3, 3);
		plateau[3][4] = new Cellule(TypeCellule.SOLDAT_ARGENT_4_SUD, this, 3, 4);
		plateau[3][2] = new Cellule(TypeCellule.CAVALIER_OR_1_SUD, this, 3, 2);
		plateau[4][6] = new Cellule(TypeCellule.SOLDAT_OR_2_OUEST, this, 4, 6);
		plateau[4][5] = new Cellule(TypeCellule.ROI_ARGENT_1_SUD, this, 4, 5);
		plateau[4][7] = new Cellule(TypeCellule.SOLDAT_OR_1_NORD, this, 4, 7);
		plateau[4][8] = new Cellule(TypeCellule.SOLDAT_OR_4_EST, this, 4, 8);

		plateau[5][1] = new Cellule(TypeCellule.ROI_ARGENT_1_EST, this, 5, 1);
		plateau[5][2] = new Cellule(TypeCellule.CAVALIER_OR_1_SUD, this, 5, 2);
		plateau[5][3] = new Cellule(TypeCellule.CAVALIER_OR_1_NORD, this, 5, 3);
		plateau[6][5] = new Cellule(TypeCellule.ROI_OR_1_OUEST, this, 6, 5);
		plateau[6][6] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_OUEST, this, 6, 6);
		plateau[6][7] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_SUD, this, 6, 7);
		plateau[6][8] = new Cellule(TypeCellule.ROI_ARGENT_1_EST, this, 6, 8);

		plateau[7][1] = new Cellule(TypeCellule.ROI_ARGENT_1_EST, this, 7, 1);
		plateau[7][2] = new Cellule(TypeCellule.CAVALIER_OR_1_OUEST, this, 7, 2);
		plateau[7][3] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_NORD, this, 7, 3);

		plateau[8][4] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_EST, this, 8, 4);
		plateau[8][5] = new Cellule(TypeCellule.SOLDAT_OR_2_OUEST, this, 8, 5);
		plateau[8][6] = new Cellule(TypeCellule.ARCHER_OR_3_EST, this, 8, 6);
		plateau[8][7] = new Cellule(TypeCellule.CAVALIER_OR_1_SUD, this, 8, 7);
		plateau[8][8] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_EST, this, 8, 8);

	}
	
	/**
	 * cas particulier du Panique sert pour les tests
	 * Test 2
	 * @author boutant
	 */
	public void initPlateauTestPanique2() {

		initPlateauVide();

		// Ajout pour test Panique
		// Mettre de[i] = 6 dans la classe De()
		plateau[1][1] = new Cellule(TypeCellule.ARCHER_OR_3_SUD, this, 1, 1);
		plateau[2][1] = new Cellule(TypeCellule.CAVALIER_ARGENT_1_NORD, this, 2, 1);
		plateau[6][1] = new Cellule(TypeCellule.SOLDAT_OR_3_EST, this, 6, 1);
		plateau[7][1] = new Cellule(TypeCellule.ARCHER_OR_2_SUD, this, 7, 1);
		plateau[8][1] = new Cellule(TypeCellule.ARCHER_ARGENT_4_NORD, this, 8, 1);

		plateau[2][2] = new Cellule(TypeCellule.ARCHER_ARGENT_4_EST, this, 2, 2);
		plateau[3][2] = new Cellule(TypeCellule.ROI_OR_1_NORD, this, 3, 2);
		plateau[7][2] = new Cellule(TypeCellule.SOLDAT_ARGENT_2_OUEST, this, 7, 2);
		plateau[6][2] = new Cellule(TypeCellule.ARCHER_OR_4_SUD, this, 6, 2);

		plateau[3][3] = new Cellule(TypeCellule.ARCHER_OR_4_SUD, this, 3, 3);
		plateau[4][3] = new Cellule(TypeCellule.SOLDAT_ARGENT_4_SUD, this, 4, 3);
		plateau[2][3] = new Cellule(TypeCellule.CAVALIER_OR_1_NORD, this, 2, 3);
		plateau[3][4] = new Cellule(TypeCellule.SOLDAT_OR_2_OUEST, this, 3, 4);
		plateau[4][4] = new Cellule(TypeCellule.ROI_ARGENT_1_SUD, this, 4, 4);
		plateau[5][4] = new Cellule(TypeCellule.SOLDAT_OR_1_NORD, this, 5, 4);
		plateau[6][4] = new Cellule(TypeCellule.SOLDAT_OR_4_EST, this, 6, 4);

		plateau[1][5] = new Cellule(TypeCellule.ROI_ARGENT_1_EST, this, 1, 5);
		plateau[2][5] = new Cellule(TypeCellule.CAVALIER_OR_2_NORD, this, 2, 5);
		plateau[3][5] = new Cellule(TypeCellule.CAVALIER_OR_1_NORD, this, 3, 5);
		plateau[4][6] = new Cellule(TypeCellule.ROI_OR_1_SUD, this, 4, 6);
		plateau[5][6] = new Cellule(TypeCellule.SOLDAT_ARGENT_3_NORD, this, 5, 6);
		plateau[6][6] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_SUD, this, 6, 6);
		plateau[7][6] = new Cellule(TypeCellule.ROI_ARGENT_1_EST, this, 7, 6);

		plateau[1][7] = new Cellule(TypeCellule.ROI_OR_1_EST, this, 1, 7);
		plateau[2][7] = new Cellule(TypeCellule.CAVALIER_OR_1_SUD, this, 2, 7);
		plateau[3][7] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_NORD, this, 3, 7);

		plateau[2][8] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_OUEST, this, 2, 8);
		plateau[3][8] = new Cellule(TypeCellule.SOLDAT_OR_2_OUEST, this, 3, 8);
		plateau[4][8] = new Cellule(TypeCellule.ARCHER_OR_3_NORD, this, 4, 8);
		plateau[5][8] = new Cellule(TypeCellule.CAVALIER_OR_1_SUD, this, 5, 8);
		plateau[6][8] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_NORD, this, 6, 8);

	}
	
	/**
	 * 
	 * 
	 * @author boutant
	 */
	public void initPlateauTestTotal() {

		initPlateauVide();

		
		for (int i = 1; i < taillePlateau - 1; i++ ){
			plateau[1][i] = new Cellule(TypeCellule.CAVALIER_ARGENT_1_SUD, this, 1, i);
			plateau[2][i] = new Cellule(TypeCellule.ARCHER_ARGENT_1_SUD, this, 2, i);
			plateau[3][i] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_SUD, this, 3, i);
			plateau[4][i] = new Cellule(TypeCellule.SOLDAT_ARGENT_1_SUD, this, 4, i);
			
			plateau[5][i] = new Cellule(TypeCellule.SOLDAT_OR_1_NORD, this, 5, i);
			plateau[6][i] = new Cellule(TypeCellule.SOLDAT_OR_1_NORD, this, 6, i);
			plateau[7][i] = new Cellule(TypeCellule.ARCHER_OR_1_NORD, this, 7, i);
			plateau[8][i] = new Cellule(TypeCellule.CAVALIER_OR_1_NORD, this, 8, i);
			
		}
		plateau[1][5] = new Cellule(TypeCellule.ROI_ARGENT_1_SUD, this, 1, 5);
		plateau[8][5] = new Cellule(TypeCellule.ROI_OR_1_NORD, this, 8, 5);
		

	}
	
	/**
	 * test du HELP pour les ARCHER
	 * 
	 * @author boutant
	 */
	public void initPlateauTestHelpArcher() {

		initPlateauVide();

		for (int i = 2; i < taillePlateau - 3; i++ ){
			plateau[2][i] = new Cellule(TypeCellule.ARCHER_OR_4_NORD, this, 2, i);
			plateau[i][2] = new Cellule(TypeCellule.ARCHER_OR_1_OUEST, this, i, 2);
			plateau[taillePlateau - 4][i] = new Cellule(TypeCellule.ARCHER_OR_2_SUD, this, taillePlateau - 4, i);
			plateau[i][taillePlateau - 3] = new Cellule(TypeCellule.ARCHER_OR_3_EST, this, i, taillePlateau - 3);
		}
		for (int i = 3; i < taillePlateau - 4; i++ ){
			plateau[3][i] = new Cellule(TypeCellule.ARCHER_ARGENT_4_NORD, this, 3, i);
			plateau[i][3] = new Cellule(TypeCellule.ARCHER_ARGENT_1_OUEST, this, i, 3);
			plateau[taillePlateau - 5][i] = new Cellule(TypeCellule.ARCHER_ARGENT_2_SUD, this, taillePlateau - 5, i);
			plateau[i][taillePlateau - 4] = new Cellule(TypeCellule.ARCHER_ARGENT_3_EST, this, i, taillePlateau - 4);
		}
		
		for (int i = 4; i < 6; i++ ){
			plateau[4][i] = new Cellule(TypeCellule.ARCHER_OR_4_NORD, this, 4, i);
			plateau[i][4] = new Cellule(TypeCellule.ARCHER_OR_1_OUEST, this, i, 4);
			plateau[5][i] = new Cellule(TypeCellule.ARCHER_OR_2_SUD, this, 5, i);
			plateau[i][6] = new Cellule(TypeCellule.ARCHER_OR_3_EST, this, i, 6);
		}
		
		plateau[1][1] = new Cellule(TypeCellule.ROI_OR_1_SUD, this, 1, 1);
		plateau[1][taillePlateau - 2] = new Cellule(TypeCellule.ROI_OR_1_SUD, this, 1, 1);
		plateau[taillePlateau - 3][1] = new Cellule(TypeCellule.ROI_ARGENT_1_NORD, this, taillePlateau - 3, 1);
		plateau[taillePlateau - 3][taillePlateau - 2] = new Cellule(TypeCellule.ROI_ARGENT_1_NORD, this, taillePlateau - 3, taillePlateau - 2);

	}
	// ----------------------------------------------------------------------------------------------------------------------

	boolean firstClick = true;
	int oldI0, oldJ0;
	int i0, j0;
	int i1, j1;
	Orientation orientation0 = null;
	TypePiece typePiece0 = null;
	Couleur couleur0 = null;
	int nbPiece0;

	Orientation orientation1 = null;
	TypePiece typePiece1 = null;
	Couleur couleur1 = null;
	int nbPiece1;

	/**
	 * compteur des nombres de Points d'Action permet de gerer les priorites de
	 * jeu
	 * 
	 * @author boutant
	 */
	int pa = 2;
	int pa_Or = 2;
	int pa_Argent = 0;

	/**
	 * enregistre la nature de la derniere action effectuee
	 * 
	 * @author boutant
	 */
	Action derniere_action;

	/**
	 * Toute la logique du jeu
	 * 
	 * si pa == 1 ou pa == 2:
	 * 
	 * I--- si 1er click, on note la position (i0, j0), et si on clique sur :
	 * 
	 * I.1... une case vide, fleches directionnelles: on reset le 1er click
	 * I.2... la case undo : on demande si on veut annuler la derniere action +
	 * reset I.3... la case quit : en fait, recommencer la partie / abandon +
	 * reset I.4... une case avec des pieces : I.4.a)........si pieces couleur
	 * differente que joueurQuiJoue, on reset le 1er click I.4.b)........si
	 * pieces meme couleur, on passe au 2eme click
	 * 
	 * II-- si 2eme click, on note position (i1, j1), et si on clique sur:
	 * II.1.. une case vide : DEPLACER ? II.2.. la case undo: on demande si on
	 * veut annuler la derniere action + reset II.3.. la case quit : en fait,
	 * recommencer la partie / abandon + reset II.4.. une case avec des pieces :
	 * II.4.a).......si pieces couleur differente que joueurQuiJoue, ATTAQUER ?
	 * II.4.b).......si pieces meme couleur , reset II.5.. une fleche
	 * directionnelle : TOURNER ?
	 * 
	 * si pa == 0 : .... changement de joueurQuiJoue
	 * 
	 * 
	 * @param i
	 * @param j
	 * 
	 * @author boutant, manzano, coispel, duong
	 */
	void cliqued(int i, int j) {

		if (joueurQuiJoue == Joueur.joueurOr) {
			pa = pa_Or;
		} else {
			pa = pa_Argent;
		}

		System.out.println("Tour de : " + joueurQuiJoue + " et PA = " + pa);

		plateau[10][3] = new Cellule(TypeCellule.QUESTION_DE, this, 10, 3);
		plateau[10][4] = new Cellule(TypeCellule.QUESTION_DE, this, 10, 4);
		plateau[10][6] = new Cellule(TypeCellule.QUESTION_DE, this, 10, 6);
		plateau[10][7] = new Cellule(TypeCellule.QUESTION_DE, this, 10, 7);
		updateCelluleDeco(10, 3);
		updateCelluleDeco(10, 4);
		updateCelluleDeco(10, 6);
		updateCelluleDeco(10, 7);

		if (pa == 1 || pa == 2) {
			if (firstClick) {
				System.out.println("");
				System.out.println("------------------------------1er click-----------------------------------------");
				System.out.println("");
				oldI0 = i0;
				oldJ0 = j0;
				i0 = i;
				j0 = j;
				// System.out.println("Case cliquee : (i0,j0) = ( " + i0 + ", " + j0 + " )");

				if ((plateau[i0][j0].typeCellule == TypeCellule.VIDE)
						|| (plateau[i0][j0].typeCellule == TypeCellule.FLECHE_HAUT_BLEUE)
						|| (plateau[i0][j0].typeCellule == TypeCellule.FLECHE_BAS_BLEUE)
						|| (plateau[i0][j0].typeCellule == TypeCellule.FLECHE_GAUCHE_BLEUE)
						|| (plateau[i0][j0].typeCellule == TypeCellule.FLECHE_DROITE_BLEUE)) {
					firstClick = !firstClick;
					System.out.println(joueurQuiJoue + " : cliquez sur vos pieces! Retour au 1er click");
					System.out.println("      ////////////////////////////////////////////////////////");
					System.out.println("");
				}

				else if (plateau[i0][j0].typeCellule == TypeCellule.HELP) {
					// Montre les possibilites d'action
					System.out.println("Vous venez de cliquer sur la case Help. ");
					System.out
							.println("Selectionnez une de vos unites (de couleur = " + joueurQuiJoue.couleur + "),  ");
					System.out.println("  et cliquez a nouveau ici afin de connaitre vos possibilites ");
					System.out.println("Vous etes " + joueurQuiJoue + " et il vous reste " + pa + " action(s).");
					firstClick = !firstClick;
					System.out.println("      ////////////////////////////////////////////////////////");
					System.out.println("");
				}

				else if (plateau[i0][j0].typeCellule == TypeCellule.RULES) {
					// On affiche les regles
					System.out.println(" Vous trouverez dans le fichier ci-joint les regles du jeu ");

					Desktop d = Desktop.getDesktop();
					try {
						d.open(new File("ressources/Regles_du_jeu.pdf"));
					} catch (IOException e) {
						// catch genere automatiquement
						e.printStackTrace();
					}
					firstClick = !firstClick;
					System.out.println("      ////////////////////////////////////////////////////////");
					System.out.println("");
				} 
				else {
					couleur0 = (plateau[i0][j0].typeCellule).couleur;
					if (couleur0 == joueurQuiJoue.couleur) {
						orientation0 = plateau[i0][j0].orientation;
						nbPiece0 = plateau[i0][j0].nbDePieces;
						typePiece0 = (plateau[i0][j0].typeCellule).typePiece;
						System.out.println(joueurQuiJoue + " joue avec " + typePiece0 + ", " + couleur0 + ", "
								+ nbPiece0 + ", " + orientation0);
						System.out.println("");
						System.out.println("..................................................................");
						System.out.println("");
					} 
					else {
						System.out.println(" Vous ne pouvez agir qu'avec vos pieces!");
						System.out.println(
								" Vous etes " + joueurQuiJoue + " donc votre couleur est " + joueurQuiJoue.couleur);
						firstClick = !firstClick;
						System.out.println("      ////////////////////////////////////////////////////////");
						System.out.println("");
					}
				}

				firstClick = !firstClick;
			}

			else {

				i1 = i;
				j1 = j;
				System.out.println("");
				System.out.println("------------------------------2eme click-----------------------------------------");
				System.out.println("");

				// System.out.println("1er click = ( " + i0 + ", " + j0 + " ) / 2eme click = ( " + i1 + ", " + j1 + " )");

				/*
				 * on gere l'action : DEPLACER
				 */
				if (plateau[i1][j1].typeCellule == TypeCellule.VIDE) {
					System.out.println("Test de Deplacement :");
					Deplacement deplacement = new Deplacement();
					if (deplacement.deplacementPossible(i0, j0, i1, j1, (plateau[i0][j0].typeCellule).typePiece,
							plateau[i0][j0].orientation, plateau)) {
						System.out.println("-> Deplacement possible: on agit !");
						plateau[i1][j1].typeCellule = plateau[i0][j0].typeCellule;
						plateau[i1][j1].nbDePieces = plateau[i0][j0].nbDePieces;
						plateau[i1][j1].orientation = plateau[i0][j0].orientation;

						plateau[i0][j0] = new Cellule(TypeCellule.VIDE, this, i0, j0);

						System.out.println("plateau[i1][j1] est devenu : " + (plateau[i1][j1].typeCellule).typePiece
								+ " , " + (plateau[i1][j1].typeCellule).couleur + " , " + plateau[i1][j1].nbDePieces
								+ " , " + plateau[i1][j1].orientation);

						updateCellulePlateau(i0, j0);
						updateCellulePlateau(i1, j1);

						derniere_action = Action.Deplacer;
						pa--;
						System.out.println("Deplacement effectue et retour au 1er click");
						firstClick = !firstClick;
					} else {
						System.out.println("-> Deplacement impossible : retour au 1er click ");
						firstClick = !firstClick;
					}
				}

				else if (plateau[i1][j1].typeCellule == TypeCellule.HELP) {
					// On regarde les possibilites
					System.out.println("Voici ce que vous pouvez faire :");
					System.out.println("");
					System.out.println(
							"    - ORIENTER : Vous pouvez changer l'orientation de cette unite en cliquant sur les fleches directionnelles bleues");
					Deplacement deplacement = new Deplacement();
					Attaque attaque = new Attaque();
					if (plateau[i0][j0].typeCellule.typePiece == TypePiece.ARCHER) {
						if (plateau[i0][j0].orientation == Orientation.NORD) {
							if (deplacement.deplacementPossible(i0, j0, i0 - 1, j0,
									(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers le Nord");
							}

							for (int i2 = i0 - 3; i2 <= i0 - 1; i2++) {
								for (int j2 = j0 - 1; j2 <= j0 + 1; j2++) {
									if (attaque.attaquePossible(i0, j0, i2, j2, typePiece0, orientation0) 
											&& i2 > 0 && j2 > 0 && i2 < taillePlateau - 2 && j2 < taillePlateau - 1 
											&& (plateau[i0][j0].typeCellule).couleur != (plateau[i2][j2].typeCellule).couleur
											&& plateau[i2][j2].typeCellule != TypeCellule.VIDE) {
										System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
												+ (plateau[i2][j2].typeCellule).typePiece
												+ " au Nord de votre position en " + i2 + "," + j2);
									}
								}
							}
						}

						else if (plateau[i0][j0].orientation == Orientation.SUD) {
							if (deplacement.deplacementPossible(i0, j0, i0 + 1, j0,
									(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers le Sud");
							}

							for (int i2 = i0 + 1; i2 <= i0 + 3; i2++) {
								for (int j2 = j0 - 1; j2 <= j0 + 1; j2++) {
									if (attaque.attaquePossible(i0, j0, i2, j2, typePiece0, orientation0) && i2 > 0
											&& j2 > 0 && i2 < taillePlateau - 2 && j2 < taillePlateau - 1  
											&& (plateau[i0][j0].typeCellule).couleur != (plateau[i2][j2].typeCellule).couleur
											&& plateau[i2][j2].typeCellule != TypeCellule.VIDE) {
										System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
												+ (plateau[i2][j2].typeCellule).typePiece
												+ " au Sud de votre position en " + i2 + "," + j2);
									}
								}
							}
						}

						else if (plateau[i0][j0].orientation == Orientation.OUEST) {
							if (deplacement.deplacementPossible(i0, j0, i0, j0 - 1,
									(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers l'Ouest");
							}

							for (int i2 = i0 - 1; i2 <= i0 + 1; i2++) {
								for (int j2 = j0 - 3; j2 <= j0 - 1; j2++) {
									if (attaque.attaquePossible(i0, j0, i2, j2, typePiece0, orientation0) && i2 > 0
											&& j2 > 0 && i2 < taillePlateau - 2 && j2 < taillePlateau - 1 
											&& (plateau[i0][j0].typeCellule).couleur != (plateau[i2][j2].typeCellule).couleur
											&& plateau[i2][j2].typeCellule != TypeCellule.VIDE) {
										System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
												+ (plateau[i2][j2].typeCellule).typePiece
												+ " a l'Ouest de votre position en " + i2 + "," + j2);
									}
								}
							}
						}

						else if (plateau[i0][j0].orientation == Orientation.EST) {
							if (deplacement.deplacementPossible(i0, j0, i0, j0 + 1,
									(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers l'Est");
							}

							for (int i2 = i0 - 1; i2 <= i0 + 1; i2++) {
								for (int j2 = j0 + 1; j2 <= j0 + 3; j2++) {
									if (attaque.attaquePossible(i0, j0, i2, j2, typePiece0, orientation0) && i2 > 0
											&& j2 > 0 && i2 < taillePlateau - 2 && j2 < taillePlateau - 1 
											&& (plateau[i0][j0].typeCellule).couleur != (plateau[i2][j2].typeCellule).couleur
											&& plateau[i2][j2].typeCellule != TypeCellule.VIDE) {
										System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
												+ (plateau[i2][j2].typeCellule).typePiece
												+ " a l'Ouest de votre position en " + i2 + "," + j2);
									}
								}
							}
						}

					} else {
						if (plateau[i0][j0].orientation == Orientation.NORD && plateau[i0 - 1][j0].typeCellule != TypeCellule.NOIR) {
							if (deplacement.deplacementPossible(i0, j0, i0 - 1, j0,	(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers le Nord");
							}
							if (attaque.attaquePossible(i0, j0, i0 - 1, j0, typePiece0, orientation0)
									&& (plateau[i0][j0].typeCellule).couleur != (plateau[i0
											- 1][j0].typeCellule).couleur
									&& plateau[i0 - 1][j0].typeCellule != TypeCellule.VIDE) {
								System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
										+ (plateau[i0 - 1][j0].typeCellule).typePiece + " au Nord de votre position en "
										+ (i0 - 1) + "," + j0);
							}
						}
						if (plateau[i0][j0].orientation == Orientation.SUD && plateau[i0 + 1][j0].typeCellule != TypeCellule.NOIR) {
							if (deplacement.deplacementPossible(i0, j0, i0 + 1, j0,
									(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers le Sud");
							}
							if (attaque.attaquePossible(i0, j0, i0 + 1, j0, typePiece0, orientation0)
									&& (plateau[i0][j0].typeCellule).couleur != (plateau[i0
											+ 1][j0].typeCellule).couleur
									&& plateau[i0 + 1][j0].typeCellule != TypeCellule.VIDE) {
								System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
										+ (plateau[i0 + 1][j0].typeCellule).typePiece + " au Sud de votre position");
							}
						}
						if (plateau[i0][j0].orientation == Orientation.OUEST && plateau[i0][j0 -1].typeCellule != TypeCellule.NOIR) {
							if (deplacement.deplacementPossible(i0, j0, i0, j0 - 1,
									(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers l'Ouest");
							}
							if (attaque.attaquePossible(i0, j0, i0, j0 - 1, typePiece0, orientation0)
									&& (plateau[i0][j0].typeCellule).couleur != (plateau[i0][j0
											- 1].typeCellule).couleur
									&& plateau[i0][j0 - 1].typeCellule != TypeCellule.VIDE) {
								System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
										+ (plateau[i0][j0 - 1].typeCellule).typePiece
										+ " a  l'Ouest de votre position");
							}
						}
						if (plateau[i0][j0].orientation == Orientation.EST && plateau[i0][j0 + 1].typeCellule != TypeCellule.NOIR ) {
							if (deplacement.deplacementPossible(i0, j0, i0, j0 + 1,
									(plateau[i0][j0].typeCellule).typePiece, plateau[i0][j0].orientation, plateau)) {
								System.out.println("    - DEPLACER : Vous pouver deplacer cette unite vers l'Est");
							}
							if (attaque.attaquePossible(i0, j0, i0, j0 + 1, typePiece0, orientation0)
									&& (plateau[i0][j0].typeCellule).couleur != (plateau[i0][j0
											+ 1].typeCellule).couleur
									&& plateau[i0][j0 + 1].typeCellule != TypeCellule.VIDE) {
								System.out.println("    - ATTAQUER : Vous pouver attaquer l'unite de "
										+ (plateau[i0][j0 + 1].typeCellule).typePiece + " a  l'Est de votre position");
							}
						}
					}
				System.out.println("RAPPEL :vous ne pouvez pas attaquer 2 fois de suite avec la meme cellule.");
					System.out.println("Vous etes " + joueurQuiJoue + " et il vous reste " + pa + " action(s).");

					// firstClick = !firstClick;
				}

				else if (plateau[i1][j1].typeCellule == TypeCellule.RULES) {
					System.out.println(" Vous trouverez dans le fichier ci-joint les regles du jeu ");

					Desktop d = Desktop.getDesktop();
					try {
						d.open(new File("ressources/Regles_du_jeu.pdf"));
					} catch (IOException e) {
						// Bloc catch généré automatiquement
						e.printStackTrace();
					}
					firstClick = !firstClick;
				}

				/*
				 * on gere l'action ORIENTER
				 */
				else if (plateau[i1][j1].typeCellule == TypeCellule.FLECHE_HAUT_BLEUE) {
					if (orientation0 != Orientation.NORD) {
						System.out.println("Orientation de depart = " + orientation0);
						plateau[i0][j0].typeCellule = new TypeCellule((plateau[i0][j0].typeCellule).typePiece,
								(plateau[i0][j0].typeCellule).couleur, plateau[i0][j0].nbDePieces, Orientation.NORD);
						plateau[i0][j0].orientation = Orientation.NORD;
						updateCellulePlateau(i0, j0);
						derniere_action = Action.Tourner;
						pa--;
					} else {
						firstClick = !firstClick;
					}
					System.out.println("Nouvelle orientation = " + plateau[i0][j0].orientation);
					firstClick = !firstClick;

				} else if (plateau[i1][j1].typeCellule == TypeCellule.FLECHE_BAS_BLEUE) {
					if (orientation0 != Orientation.SUD) {
						System.out.println("Orientation de depart = " + orientation0);
						plateau[i0][j0].typeCellule = new TypeCellule((plateau[i0][j0].typeCellule).typePiece,
								(plateau[i0][j0].typeCellule).couleur, plateau[i0][j0].nbDePieces, Orientation.SUD);
						plateau[i0][j0].orientation = Orientation.SUD;
						updateCellulePlateau(i0, j0);
						derniere_action = Action.Tourner;
						pa--;
					} else {
						firstClick = !firstClick;
					}

					System.out.println("Nouvelle orientation = " + plateau[i0][j0].orientation);
					firstClick = !firstClick;

				} else if (plateau[i1][j1].typeCellule == TypeCellule.FLECHE_GAUCHE_BLEUE) {
					if (orientation0 != Orientation.OUEST) {
						System.out.println("Orientation de depart = " + orientation0);
						plateau[i0][j0].typeCellule = new TypeCellule((plateau[i0][j0].typeCellule).typePiece,
								(plateau[i0][j0].typeCellule).couleur, plateau[i0][j0].nbDePieces, Orientation.OUEST);
						plateau[i0][j0].orientation = Orientation.OUEST;
						updateCellulePlateau(i0, j0);
						derniere_action = Action.Tourner;
						pa--;
					} else {
						firstClick = !firstClick;
					}
					System.out.println("Nouvelle orientation = " + plateau[i0][j0].orientation);
					firstClick = !firstClick;

				} else if (plateau[i1][j1].typeCellule == TypeCellule.FLECHE_DROITE_BLEUE) {
					if (orientation0 != Orientation.EST) {
						System.out.println("Orientation de depart = " + orientation0);
						plateau[i0][j0].typeCellule = new TypeCellule((plateau[i0][j0].typeCellule).typePiece,
								(plateau[i0][j0].typeCellule).couleur, plateau[i0][j0].nbDePieces, Orientation.EST);
						plateau[i0][j0].orientation = Orientation.EST;
						updateCellulePlateau(i0, j0);
						derniere_action = Action.Tourner;
						pa--;
					} else {
						firstClick = !firstClick;
					}
					System.out.println("Nouvelle orientation = " + plateau[i0][j0].orientation);
					firstClick = !firstClick;
				}

				else {
					typePiece0 = (plateau[i0][j0].typeCellule).typePiece;
					couleur1 = (plateau[i1][j1].typeCellule).couleur;
					nbPiece0 = plateau[i0][j0].nbDePieces;

					/*
					 * on gere l'action : ATTAQUER
					 */
					if (couleur1 != couleur0) {
						System.out.println("Test d'attaque : ");
						Attaque attaque = new Attaque();
						if ((attaque.attaquePossible(i0, j0, i1, j1, typePiece0, orientation0))
								&& !((i0 == oldI0) && (j0 == oldJ0) && (derniere_action == Action.Attaquer))) {
							System.out.println("   -> Attaque possible : on effectue un lancer de des : ");

							Des lancerDes = new Des(nbPiece0, typePiece0, joueurQuiJoue);
							lancerDes.affiche();

							ValeurDe[] valeurDes = lancerDes.valeur_des;

							for (int k = 0; k < 2; k++) {
								switch (valeurDes[k]) {
								case HACHE:
									plateau[10][3 + k] = new Cellule(TypeCellule.HACHE, this, 10, 3 + k);
									break;
								case FLECHE:
									plateau[10][3 + k] = new Cellule(TypeCellule.FLECHE, this, 10, 3 + k);
									break;
								case PANIQUE:
									plateau[10][3 + k] = new Cellule(TypeCellule.PANIQUE, this, 10, 3 + k);
									break;
								case VIDE:
									plateau[10][3 + k] = new Cellule(TypeCellule.QUESTION_DE, this, 10, 3 + k);
								}
							}

							for (int m = 2; m < 4; m++) {
								switch (valeurDes[m]) {
								case HACHE:
									plateau[10][4 + m] = new Cellule(TypeCellule.HACHE, this, 10, 4 + m);
									break;
								case FLECHE:
									plateau[10][4 + m] = new Cellule(TypeCellule.FLECHE, this, 10, 4 + m);
									break;
								case PANIQUE:
									plateau[10][4 + m] = new Cellule(TypeCellule.PANIQUE, this, 10, 4 + m);
									break;
								case VIDE:
									plateau[10][4 + m] = new Cellule(TypeCellule.QUESTION_DE, this, 10, 4 + m);
								}
							}


							if (attaque.testPanique(valeurDes)) {
								System.out.println("PAAAAAAAAAAAANIIIIIIIIIIIQUE !! ... Dommage !");
								attaque.panique(plateau[i0][j0].typeCellule, i0, j0, plateau);
								updatePlateau();

							} else {

								int degats = attaque.degats(valeurDes, typePiece0);
								
								if ( ((plateau[i1][j1].typeCellule).typePiece == TypePiece.ROI || (plateau[i1][j1].typeCellule).typePiece == TypePiece.CAVALIER) && (lancerDes.nbLancerDe == 1) && (attaque.pdd == 1)){
									Des lancerDes2 = new Des(nbPiece0, typePiece0, joueurQuiJoue);
									System.out.println("Deuxieme lancer de des (cas exceptionnel)");
									ValeurDe[] valeurDes2 = lancerDes2.valeur_des;
									switch (valeurDes2[0]) {
									case HACHE:
										plateau[10][4] = new Cellule(TypeCellule.HACHE, this, 10, 4);
										break;
									case FLECHE:
										plateau[10][4] = new Cellule(TypeCellule.FLECHE, this, 10, 4);
										break;
									case PANIQUE:
										plateau[10][4] = new Cellule(TypeCellule.PANIQUE, this, 10, 4);
										break;
									default:
										break;
									}
									valeurDes[1] = valeurDes2[0];
									int degats2 = attaque.degats(valeurDes, typePiece0);
									degats = degats2;
								}
								attaque.attaquer(i1, j1, degats, plateau[i1][j1].typeCellule, plateau);
								updateCellulePlateau(i1, j1);

							}
							updateCelluleDeco(10, 3);
							updateCelluleDeco(10, 4);
							updateCelluleDeco(10, 6);
							updateCelluleDeco(10, 7);
							derniere_action = Action.Attaquer;
							pa--;
							if (attaque.testvictoire(plateau)) {
								pa_Or = -1;
								pa_Argent = -1;
								pa = -1;
							}
							firstClick = !firstClick;
						}

						else {
							System.out.println("  -> ATTAQUE impossible. Reporter vous au bouton HELP si vous n'en comprenez pas la raison.");
							System.out.println("  Retour au 1er click");
							firstClick = !firstClick;
						}
					} else {
						System.out.println("  -> ACTION impossible. Reporter vous au bouton HELP si vous n'en comprenez pas la raison.");
						System.out.println("  Retour au 1er click");
						firstClick = !firstClick;

					}
				}

				System.out.println("///////////////////////////////////////////////////////////////////////");
				System.out.println("");
			}

		}
		if (joueurQuiJoue == Joueur.joueurOr) {
			pa_Or = pa;
		} else {
			pa_Argent = pa;
		}

		if ((pa == 0) && !(pa_Or == -1 && pa_Argent == -1)) {

			if (joueurQuiJoue == Joueur.joueurOr) {
				joueurQuiJoue = Joueur.joueurArgent;
				pa_Argent = 2;
			} else {
				joueurQuiJoue = Joueur.joueurOr;
				pa_Or = 2;
			}
			System.out.println("//////////////////////////////////////////////////////////////////");
			System.out.println("//////////////////////////////////////////////////////////////////");
			System.out.println("");
			System.out.println("");
			System.out.println("Changement de joueur : Tour de " + joueurQuiJoue);
			System.out.println("");
			System.out.println("//////////////////////////////////////////////////////////////////");
			System.out.println("//////////////////////////////////////////////////////////////////");
		}
		updateCelluleDeco(0, 10);
		updateCelluleDeco(0, 0);
	}

	public int getPA_OR() {
		return pa_Or;
	}

	public int getPA_ARGENT() {
		return pa_Argent;
	}

}
