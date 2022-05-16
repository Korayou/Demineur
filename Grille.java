import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grille extends JPanel  {
	private EtatPartie banniere;
    private Dimension grilleSize=new Dimension(0,0);
	private Case[] plateau;
	private int lignes;
	private int colonnes;
	private int taille;
	private int mines;
	private int minesLeft;

    // Définition du constructeur qui correspond à une grille de jeu
    public Grille(EtatPartie banniere,int lignes, int colonnes, int mines){
		
		// Découpage de l'espace en fonction des paramètres pour la mise en place de la grille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.grilleSize = new Dimension(((screenSize.height*3/4)/lignes)*colonnes, screenSize.height*3/4 );
		Dimension caseSize = new Dimension(this.grilleSize.height/lignes,this.grilleSize.height/lignes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
		this.setLayout(damier);
        this.setSize(grilleSize);
		this.lignes=lignes;
		this.colonnes=colonnes;
		this.taille=lignes*colonnes;
		this.mines=mines;
		this.banniere=banniere;
		// On génère le plateau contenant les cases
		GenererPlateau(caseSize);


		//	Instalation des mines
		//	Création d'un tableau de nombres aléatoires pour savoir où les placer
		int[] caseMine = new int[mines];
		Random rand = new Random();
		//	On initialise les emplacements des mines
		caseMine[0] = rand.nextInt(taille);
		for (int i=1;i<mines;i++){
			caseMine[i] = rand.nextInt(taille);
			//	On vérifie que la case n'a pas déjà été minée, auquel cas on change de case
			for (int j=0;j<=(i-1);j++){
				if (caseMine[i]==caseMine[j]){
					caseMine[i] = rand.nextInt(taille);
					j=-1;
				}
			}
		}

		//	On place maintenant les mines sur la plateau en fixant la variable minee des cases à true
		for (int i=0; i<taille;i++){
			for (int j=0;j<mines;j++){
				if (caseMine[j]==i){
					plateau[i].setMine();
				}
			}
		}

		//	On cherche à connaître le nombre de mines autour de chaque case
		for (int i=0;i<taille;i++){
			int entourage = 0;
			//  On vérifie pour chaque case qu'elle n'est pas déjà à l'extrémité du plateau où on cherche une case
			//	Mine au dessus à droite
			if ((i>=colonnes)&&(i%colonnes!=colonnes-1)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i-colonnes+1){
						entourage+=1;
					}
				}
			}
			//	Mine au dessus à gauche
			if ((i>=colonnes)&&(i%colonnes!=0)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i-colonnes-1){
						entourage+=1;
					}
				}
			}
			//  Mine en dessous à droite
			if ((i<taille-colonnes)&&(i%colonnes!=colonnes-1)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i+colonnes+1){
						entourage+=1;
					}
				}
			}
			//  Mine en bas à gauche
			if ((i<taille-colonnes)&&(i%colonnes!=0)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i+colonnes-1){
						entourage+=1;
					}
				}
			}
			//	Mine au dessus
			if (i>=colonnes){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i-colonnes){
						entourage+=1;
					}
				}
			}
			//	Mine en dessous
			if (i<taille-colonnes){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i+colonnes){
						entourage+=1;
					}
				}
			}
			//	Mine à droite
			if (i%colonnes!=colonnes-1){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i+1){
						entourage+=1;
					}
				}
			}
			//	Mine à gauche
			if (i%colonnes!=0){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i-1){
						entourage+=1;
					}
				}
			}
			plateau[i].setEntourage(entourage);
		}


		//	On place les cases à leur état actuel dans la grille
		AfficherPlateau();
    }

	//	Méthode pour Génerer le plateau
	protected void GenererPlateau(Dimension caseSize){
		this.plateau= new Case[this.taille];
		for (int i=0;i<this.taille;i++){
			this.plateau[i]= new Case(this,caseSize);
		}
	}

	//	Méthode pour Afficher le plateau
	protected void AfficherPlateau(){
		for (int i=0;i<this.taille;i++){
			this.add(this.plateau[i]);
  		}
	}

	//	Méthode pour montrer toutes les cases à la fin de la partie
	public void setAllVisible(){
		for (int i=0;i<this.taille;i++){
			this.plateau[i].setVisible();
  		}
	}

	//	Méthode pour obtenir la taille de la grille de jeu
    public Dimension getGrilleSize(){
        return grilleSize;
    }

	//	Méthode pour déterminer le nombre de mines restantes
	public void MinesLeft(){
		this.minesLeft=this.mines;
		for (int i=0;i<this.taille;i++){
			if(plateau[i].getReperee()==true){
				this.minesLeft-=1;
			}
		}
		this.banniere.setMinesLeft(this.minesLeft);
	}

	// 	Méthode déterminant les conditions de victoire
	public void verifVictoire(){
		int casesVisibles=0;
		for (int i=0;i<this.taille;i++){
			if(plateau[i].getVisible()==true){
				casesVisibles+=1;
			}
		}
		//	Lance la victoire si les conditions sont remplies
		if (taille-mines==casesVisibles){
			for (int i=0;i<taille;i++){
				this.plateau[i].setVictoire();
			}
		}
	}

	//	Methode pour récupérer le plateau de jeu
	public Case[] getPlateau(){
		return this.plateau;
	}

	//	Méthode pour rendre visibles les cases autour d'un 0
	public void setEntourageVisible(Case panel){
		for(int i=0; i<this.taille;i++){
			if (plateau[i]==panel){
				//	Mine au dessus à droite
				if ((i>=colonnes)&&(i%colonnes!=colonnes-1)){
					for (int j=0;j<mines;j++){
						plateau[i-colonnes+1].setVisible();
					}
				}
				//	Mine au dessus à gauche
				if ((i>=colonnes)&&(i%colonnes!=0)){
					for (int j=0;j<mines;j++){
						plateau[i-colonnes-1].setVisible();
					}
				}
				//  Mine en dessous à droite
				if ((i<taille-colonnes)&&(i%colonnes!=colonnes-1)){
					for (int j=0;j<mines;j++){
						plateau[i+colonnes+1].setVisible();
					}
				}
				//  Mine en bas à gauche
				if ((i<taille-colonnes)&&(i%colonnes!=0)){
					for (int j=0;j<mines;j++){
						plateau[i+colonnes-1].setVisible();
					}
				}
				//	Mine au dessus
				if (i>=colonnes){
					for (int j=0;j<mines;j++){
						plateau[i-colonnes].setVisible();
					}
				}
				//	Mine en dessous
				if (i<taille-colonnes){
					for (int j=0;j<mines;j++){
						plateau[i+colonnes].setVisible();
					}
				}
				//	Mine à droite
				if (i%colonnes!=colonnes-1){
					for (int j=0;j<mines;j++){
						plateau[i+1].setVisible();
					}
				}
				//	Mine à gauche
				if (i%colonnes!=0){
					for (int j=0;j<mines;j++){
						plateau[i-1].setVisible();
					}
				}
			}
		}
	}
}
