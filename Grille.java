import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grille extends JComponent {
    private Dimension grilleSize=new Dimension(0,0);
    private JPanel grille= new JPanel();

    // On créer La grille de jeu
    public Grille(int lignes, int colonnes, int mines){
		
		// Découpage de l'espace en fonction des paramètres pour la mise en place de la grille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.grilleSize = new Dimension(((screenSize.height*3/4)/lignes)*colonnes, screenSize.height*3/4 );
		Dimension caseSize = new Dimension(this.grilleSize.height/lignes,this.grilleSize.height/lignes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
        System.out.println("Taille des cases : "+caseSize);
        System.out.println("Taille de la Grille : "+grilleSize);
		this.grille.setLayout(damier);
        this.grille.setSize(grilleSize);


		//	Initialisation : les cases sont cachées
		boolean[] visible = new boolean[lignes*colonnes];
		for (int i=0; i<lignes*colonnes;i++){
			visible[i]=true;
		}


		//	Instalation des mines
		//	Création d'un tableau de nombres aléatoires pour savoir où les placer
		int[] caseMine = new int[mines];
		Random mine = new Random();
		for (int i=0;i<mines;i++){
			caseMine[i]=mine.nextInt(lignes*colonnes);
			// On vérifie qu'on n'a pas miné une case déjà minée
			for (int j=0;j<mines;j++){
				if (caseMine[j]==caseMine[i]){
					caseMine[i]=mine.nextInt(lignes*colonnes);
				}
			}
		}
		for (int i=0;i<mines;i++){
		System.out.println(""+caseMine[i]);
		}

		//	Comme pour savoir si une case est visible, mais pour quand elle est minée
		boolean[] minee = new boolean[lignes*colonnes];
		for (int i=0; i<lignes*colonnes;i++){
			for (int j=0;j<mines;j++){
				if (caseMine[j]==i){
					minee[i]=true;
				}
			}
		}

		// Affichage des cases
		for (int i=0;i<lignes*colonnes;i++){
			Case panel = new Case(caseSize,visible[i], minee[i]);
			this.grille.add(panel.getCase());
  		}
    }

	//	Méthode pour obtenir la taille de la grille de jeu
    public Dimension getGrilleSize() {
        return grilleSize;
    }

	//	Methode pour obtenir le panel pour l'affichage de la grille
    public JPanel getGrille() {
        return grille;
    }
}
