import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Arrays;
/**
* La classe <code>Grille</code> correspond à une grille de jeu
* elle genère un tableau de case et une Bannière
* @version 1.1
* @author Kayyissa Haïssous
*/
public class Grille extends JPanel{
	/**
	* Banniere
	*/
	private Banniere banniere;
	/**
	* Dimension de la grille
	*/
    private Dimension grilleSize=new Dimension(0,0);
    /**
	* tableau des cases de la partie
	*/
	private Case[] plateau;
	/**
	* nombre de colonnes
	*/
	private int colonnes;
	/**
	* nombre de lignes
	*/
	private int lignes;
	/**
	* nombre de cases
	*/
	private int taille;
	/**
	* nombre de mines
	*/
	private int mines;
	/**
	* nombre de mines restantes à trouver
	*/
	private int minesLeft;
	/**
	* statut si la partie est en cours ou non
	*/
	private boolean enJeu;
	/**
	* fenetre de Jeu
	*/
	private FrameJeu fenetre;

	/**
	* Définition du constructeur qui correspond à une nouvelle grille de jeu
	* @param lignes nombre de lignes
	* @param colonnes nombre de colonnes
	* @param mines nombre de mines
	* @param fenetre fenetre de Jeu
	* @param menu fenetre du menu rattaché 
	*/
    public Grille(int lignes, int colonnes, int mines, FrameJeu fenetre, FrameMenu menu){
		super();
		this.colonnes=colonnes;
		this.lignes=lignes;
		this.taille=lignes*colonnes;
		this.mines=mines;
		this.minesLeft=mines;
		this.enJeu=true;
		this.fenetre=fenetre;

		// Découpage de l'espace en fonction des paramètres pour la mise en place de la grille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.grilleSize = new Dimension(((screenSize.height*3/4)/lignes)*colonnes, screenSize.height*3/4 );
		Dimension caseSize = new Dimension(this.grilleSize.height/lignes,this.grilleSize.height/lignes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
		Banniere banniere = new Banniere(mines,this.fenetre, menu, this);
		this.banniere=banniere;
		this.setLayout(damier);
        this.setSize(grilleSize);
		
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

		//	On défini l'entourage de chaque case
		SetEntourage(caseMine);

		//	On place les cases à leur état actuel dans la grille
		AfficherPlateau();

		//	On initialise le compteur de mines restantes 
		this.banniere.setMinesLeft(this.minesLeft);
    }


    /**
	* Définition du constructeur qui correspond au chargement d'une grille sauvegardé
	* @param lignes nombre de lignes
	* @param colonnes nombre de colonnes
	* @param donnees sauvegarde 
	* @param mines nombre de mines
	* @param fenetre fenetre de Jeu
	* @param menu fenetre du menu rattaché 
	*/
	public Grille (int lignes,int colonnes,SaveManager.SaveData donnees,int mines,FrameJeu fenetre, FrameMenu menu){
		super();
		this.colonnes=colonnes;
		this.lignes=lignes;
		this.taille=lignes*colonnes;
		this.mines=mines;
		this.minesLeft=mines;
		this.enJeu=true;
		this.fenetre=fenetre;

		// Découpage de l'espace en fonction des paramètres pour la mise en place de la grille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.grilleSize = new Dimension(((screenSize.height*3/4)/lignes)*colonnes, screenSize.height*3/4 );
		Dimension caseSize = new Dimension(this.grilleSize.height/lignes,this.grilleSize.height/lignes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
		Banniere banniere = new Banniere(mines,this.fenetre, menu, this);
		this.banniere=banniere;
		this.setLayout(damier);
        this.setSize(grilleSize);

		//	On initialise un plateau de cases
		GenererPlateau(caseSize);

		//	On créer un tableau pour y placer les cases minées
		int[] caseMine = new int[mines];
		int j=0;
		//	On lit maintenant les données pour fixer certains attributs et savoir où sont les mines
		for (int i=0;i<=taille-1;i++){
			if (Integer.parseInt(donnees.cases.substring(i,i+1))==1){
				plateau[i].setMine();
				caseMine[j]=i;
				j++;
			} else if (Integer.parseInt(donnees.cases.substring(i,i+1))==2){
				plateau[i].setReperee(true,1);
			} else if (Integer.parseInt(donnees.cases.substring(i,i+1))==3){
				plateau[i].setMine();
				caseMine[j]=i;
				j++;
				plateau[i].setReperee(true,1);
			}
		}
		
		//	On détermine l'entourage de chaque case
		SetEntourage(caseMine);
		

		//	On affiche les cases qui doivent être visibles
		for (int n=0;n<=taille-1;n++){
			if (Integer.parseInt(donnees.cases.substring(n,n+1))==4){
				plateau[n].setVisible();
			}
		}

		//	On affiche la grille
		AfficherPlateau();

		//	On initialise le compteur de mines restantes 
		this.banniere.setMinesLeft(this.minesLeft);
	}

	/**
	*Méthode pour Génerer le plateau
	* @param caseSize taille d'une case
	*/
	protected void GenererPlateau(Dimension caseSize){
		this.plateau= new Case[this.taille];
		for (int i=0;i<this.taille;i++){
			this.plateau[i]= new Case(this,caseSize);
		}
	}

	/**
	*Méthode pour Afficher le plateau
	*/
	protected void AfficherPlateau(){
		for (int i=0;i<this.taille;i++){
			this.add(this.plateau[i]);
  		}
	}

	/**
	*Méthode pour établir le nombre de mines autour de chaque case
	* @param caseMine tableau des cases minées
	*/
	protected void SetEntourage(int[] caseMine){
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
	}

	/**
	* Méthode pour obtenir la taille de la grille de jeu
	* @return grilleSize 
	*/
    public Dimension getGrilleSize(){
        return grilleSize;
    }


	/**
	*Méthode déterminant le nombre de mines restantes
	*/
	public void MinesLeft(){
		this.minesLeft=this.mines;
		for (int i=0;i<this.taille;i++){
			if(plateau[i].getReperee()==true){
				this.minesLeft-=1;
			}
		}
		this.banniere.setMinesLeft(this.minesLeft);
	}

	/**
	*Méthode déterminant les conditions de victoire
	*/ 
	public void verifVictoire(){
		// 	Compte le nombre de cases visibles
		int casesVisibles=0;
		for (int i=0;i<this.taille;i++){
			if(plateau[i].getVisible()==true){
				casesVisibles+=1;
			}
		}
		//	Lance la victoire si toutes les cases non minées sont révélées
		if (taille-mines==casesVisibles){
			for (int i=0;i<taille;i++){
				this.plateau[i].setVictoire();
			}
			this.banniere.setVictoire();
		}
	}

	/**
	*Méthode pour montrer la défaite
	*/ 
	public void Defaite(){
		//	Montre toutes les cases du plateau
		for (int i=0;i<this.taille;i++){
			this.plateau[i].setVisible();
		}
		this.banniere.setDefaite();
		}

	/**
	* Methode pour récupérer le plateau de jeu
	* @return copie du tableau de cases
	*/
	public Case[] getPlateau(){
		return Arrays.copyOf(this.plateau,this.taille);
	}

	/**
	*Méthode pour récupérer la taille de la grille
	* @return la taille de la grille
	*/
	public Dimension getDimensionGrille(){
		Dimension grilleSize= new Dimension(this.colonnes, this.lignes);
		return grilleSize;
	}

	/**
	*Méthode pour savoir combien de mines sont dans la grille
	* @return this.mines le nombre de mines
	*/
	public int getMines(){
		return this.mines;
	}

	/**
	*Méthode pour rendre visibles les cases autour d'un 0
	* @param panel case autour de laquelle il faut révéler les cases
	*/
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

	/**
	*Méthode qui renvoie la banniere d'état de la partie
	* @return this.banniere
	*/
	public Banniere getBanniere(){
		return this.banniere;
	}

	/**
	*Méthode qui défini si la partie est en cours ou non
	* @param enJeu statut de la partie
	*/
	public void setEnJeu(boolean enJeu){
		this.enJeu=enJeu;
	}

	/**
	*Méthode qui renvoie si la partie est en cours ou non 
	* @return statut enjeu
	*/
	public boolean getEnJeu(){
		return this.enJeu;
	}
}
