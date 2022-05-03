import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grille extends JPanel  {
    private Dimension grilleSize=new Dimension(0,0);
	private Case[] plateau;

    // On crée La grille de jeu
    public Grille(int lignes, int colonnes, int mines){
		
		// Découpage de l'espace en fonction des paramètres pour la mise en place de la grille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.grilleSize = new Dimension(((screenSize.height*3/4)/lignes)*colonnes, screenSize.height*3/4 );
		Dimension caseSize = new Dimension(this.grilleSize.height/lignes,this.grilleSize.height/lignes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
        System.out.println("Taille des cases : "+caseSize);
        System.out.println("Taille de la Grille : "+grilleSize);
		this.setLayout(damier);
        this.setSize(grilleSize);
		this.plateau= new Case[lignes*colonnes];


		//	Instalation des mines
		//	Création d'un tableau de nombres aléatoires pour savoir où les placer
		int[] caseMine = new int[mines];
		Random rand = new Random();
		//	On initialise les emplacements des mines
		caseMine[0] = rand.nextInt(lignes*colonnes);
		for (int i=1;i<mines;i++){
			caseMine[i] = rand.nextInt(lignes*colonnes);
			//	On vérifie que la case n'a pas déjà été minée, auquel cas on change de case
			for (int j=0;j<=(i-1);j++){
				if (caseMine[i]==caseMine[j]){
					caseMine[i] = rand.nextInt(lignes*colonnes);
					j=-1;
				}
			}
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
			//	Gestion des coins
			//	Coin supérieur droit 
			if (i==colonnes-1){
				for (int j=0;j<mines;j++){
					// Si une mine est à gauche
					if (caseMine[j]==i-1){
						entourage[i]+=1;
					}
					// Si une mine est en dessous
					if (caseMine[j]==i+colonnes){
						entourage[i]+=1;
					}
					// Si une mine est en dessous à gauche
					if (caseMine[j]==i+colonnes-1){
						entourage[i]+=1;
					}
				}
			}
			//	Coin suppérieur gauche
			else if (i==0){
				for (int j=0;j<mines;j++){
					// Si une mine est à droite
					if (caseMine[j]==i+1){
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
				}
			}
			//	Coin inférieur droit
			else if (i==lignes*colonnes-1){
				for (int j=0;j<mines;j++){
					// Si une mine est à gauche
					if (caseMine[j]==i-1){
						entourage[i]+=1;
					}
					// Si une mine est au dessus
					if (caseMine[j]==i-colonnes){
						entourage[i]+=1;
					}
					// Si une mine est au dessus à gauche
					if (caseMine[j]==i-colonnes-1){
						entourage[i]+=1;
					}
				}
			}
			// Coin inférieur gauche
			else if (i==lignes*colonnes-colonnes){
				for (int j=0;j<mines;j++){
					// Si une mine est à droite
					if (caseMine[j]==i+1){
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
				}
			}
			//	Si la mine est tout en haut
			else if (i<colonnes){
				for (int j=0;j<mines;j++){
					// Si une mine est à droite
					if (caseMine[j]==i+1){
						entourage[i]+=1;
					}
					// Si une mine est à gauche
					if (caseMine[j]==i-1){
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
			//	Si la mine est tout en bas
			else if (i>lignes*colonnes-colonnes){ // Vérifier la condition
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
				}
			}
			//	Si la mine est tout à droite
			else if (i%colonnes==colonnes-1){
				for (int j=0;j<mines;j++){
					// Si une mine est à gauche
					if (caseMine[j]==i-1){
						entourage[i]+=1;
					}
					// Si une mine est au dessus
					if (caseMine[j]==i-colonnes){
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
					// Si une mine est en dessous à gauche
					if (caseMine[j]==i+colonnes-1){
						entourage[i]+=1;
					}
				}
			}
			//	Si la mine est tout à gauche
			else if (i%colonnes==0){
				for (int j=0;j<mines;j++){
					// Si une mine est à droite
					if (caseMine[j]==i+1){
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
					// Si une mine est en dessous
					if (caseMine[j]==i+colonnes){
						entourage[i]+=1;
					}
					// Si une mine est en dessous à droite
					if (caseMine[j]==i+colonnes+1){
						entourage[i]+=1;
					}
				}
			} else {
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
		}


		//	On place les cases à leur état actuel dans la grille
		AfficherPlateau(lignes*colonnes, caseSize, entourage, minee);
    }

	//	Méthode pour Afficher le plateau
	protected void AfficherPlateau(int taille, Dimension caseSize, int[] entourage, boolean[] minee){
		for (int i=0;i<taille;i++){
			this.plateau[i]= new Case(caseSize,minee[i],entourage[i]);
			this.add(this.plateau[i].getCase());
  		}
	}

	//	Méthode pour obtenir la taille de la grille de jeu
    public Dimension getGrilleSize() {
        return grilleSize;
    }
}
