import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grille extends JPanel  {
	private EtatPartie banniere;
    private Dimension grilleSize=new Dimension(0,0);
	private Case[] plateau;
	private int taille;
	private int mines;

    // Définition du constructeur qui correspond à une grille de jeu
    public Grille(EtatPartie banniere,int lignes, int colonnes, int mines){
		
		// Découpage de l'espace en fonction des paramètres pour la mise en place de la grille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.grilleSize = new Dimension(((screenSize.height*3/4)/lignes)*colonnes, screenSize.height*3/4 );
		Dimension caseSize = new Dimension(this.grilleSize.height/lignes,this.grilleSize.height/lignes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
        System.out.println("Taille des cases : "+caseSize);
        System.out.println("Taille de la Grille : "+grilleSize);
		this.setLayout(damier);
        this.setSize(grilleSize);
		this.taille=lignes*colonnes;
		this.mines=mines;
		this.banniere=banniere;
		// On génère le plateau contenant les cases
		GenererPlateau(taille, caseSize);


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
			if ((i>colonnes)&&(i%colonnes!=colonnes-1)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i-colonnes+1){
						entourage+=1;
					}
				}
			}
			//	Mine au dessus à gauche
			if ((i>colonnes)&&(i%colonnes!=0)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i-colonnes-1){
						entourage+=1;
					}
				}
			}
			//  Mine en dessous à droite
			if ((i<=taille-colonnes)&&(i%colonnes!=colonnes-1)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i+colonnes+1){
						entourage+=1;
					}
				}
			}
			//  Mine en bas à gauche
			if ((i!=taille-colonnes)&&(i%colonnes!=0)){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i+colonnes-1){
						entourage+=1;
					}
				}
			}
			//	Mine au dessus
			if (i>colonnes){
				for (int j=0;j<mines;j++){
					if (caseMine[j]==i-colonnes){
						entourage+=1;
					}
				}
			}
			//	Mine en dessous
			if (i<=taille-colonnes){
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
		AfficherPlateau(taille);
    }

	//	Méthode pour Génerer le plateau
	protected void GenererPlateau(int taille, Dimension caseSize){
		this.plateau= new Case[taille];
		for (int i=0;i<taille;i++){
			this.plateau[i]= new Case(this,caseSize);
		}
	}

	//	Méthode pour Afficher le plateau
	protected void AfficherPlateau(int taille){
		for (int i=0;i<taille;i++){
			this.add(this.plateau[i]);
  		}
	}

	//	Méthode pour obtenir la taille de la grille de jeu
    public Dimension getGrilleSize(){
        return grilleSize;
    }

	//	Méthode pour déterminer le nombre de mines restantes
	public void MinesLeft(){
		int minesLeft=this.mines;
		for (int i=0;i<taille;i++){
			//System.out.println("case repéree ? == "+plateau[i].getReperee());
			if(plateau[i].getReperee()==true){
				minesLeft-=1;
			}
		}
		this.banniere.setMinesLeft(minesLeft);
	}
}
