import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grille extends JComponent {
    private Dimension grilleSize=new Dimension(0,0);
    private JPanel grille= new JPanel();

    // On crée La grille de jeu
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
		Random rand = new Random();
		//	On initialise les emplacements des mines
		for (int i=0;i<mines;i++){
			caseMine[i] = rand.nextInt(lignes*colonnes);
			//	On vérifie que la case n'a pas déjà été minée, auquel cas on change de case
			for (int j=0;j<i;j++){
				if (caseMine[i]==caseMine[j]){
					caseMine[i] = rand.nextInt(lignes*colonnes);
					j=0;
				}
			}
		}

		// Affichage console des emplacements des mines
		for (int i=0;i<mines;i++){
			System.out.println(""+caseMine[i]);
		}

		//	On place maintenant les mines sur la plateau
		boolean[] minee = new boolean[lignes*colonnes];
		for (int i=0; i<lignes*colonnes;i++){
			for (int j=0;j<mines;j++){
				if (caseMine[j]==i){
					minee[i]=true;
				}
			}
		}

		//	Connaître le nombre de mines autour de la case
		int[] entourage = new int[lignes*colonnes];
		for (int i=0;i<lignes*colonnes;i++){
			for (int j=0;j<mines;j++){
				// Si une mine est à droite
				if (caseMine[j]==i+1){
					entourage[i]+=1;
				}
				// Si une mine est à gauche
				if (caseMine[j]==i-1){
					entourage[i]+=1;
				}
				// Si une mine est au dessus
				if (caseMine[j]==i-colonnes){
					entourage[i]+=1;
				}
				// Si une mine est au dessus à droite
				if (caseMine[j]==i-colonnes+1){
					entourage[i]+=1;
				}
				// Si une mine est au dessus à gauche
				if (caseMine[j]==i-colonnes-1){
					entourage[i]+=1;
				}
				// Si une mine est en dessous
				if (caseMine[j]==i+colonnes){
					entourage[i]+=1;
				}
				// Si une mine est en dessous à droite
				if (caseMine[j]==i+colonnes+1){
					entourage[i]+=1;
				}
				// Si une mine est en dessous à gauche
				if (caseMine[j]==i+colonnes-1){
					entourage[i]+=1;
				}
			}
		}
		
		AffichePlateau(lignes*colonnes, caseSize, entourage, visible, minee);
    }

	//	Méthode pour afficher l'état des cases
	protected void AffichePlateau(int taille, Dimension caseSize, int[] entourage, boolean[] visible, boolean[] minee){
		for (int i=0;i<taille;i++){
			Case panel = new Case(caseSize,visible[i],minee[i],entourage[i]);
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
