import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {
	//	Definition d'attributs
	private Grille grille;
	private int entourage;
	private boolean visible;
	private boolean minee;
	private boolean reperee;

	//	Définition du constructeur
	public Case(Grille grille, Dimension caseSize) {
		super();
		//	Initialisation des attributs 
		this.visible=false;
		this.reperee=false;	
		this.grille=grille;
		
		//	On place un listener sur notre case pour qu'elle réagisse aux clicks du joueur
		this.addMouseListener(new ListenerCase());
		
		//	Mise en page de la case et couleur par défaut
		this.setSize(caseSize);
		GridLayout unique = new GridLayout(1,1);
		this.setLayout(unique);
		this.setBackground(new Color(70, 70, 70));
	}

	//	Méthode qui permet de montrer la case, et fait perdre si elle est minée
	public void setVisible(){

		// On vérfie que la case n'est pas déjà visible
		if (!this.visible){
			this.visible = true;

			// On affiche dans la case le nombre de mine adjacentes ( rien si aucune )
			if ((!this.minee)&&(!this.reperee)){
				this.setBackground(new Color(80, 80, 80));
				if (this.entourage > 0) {
					this.add(new Entourage(this.entourage, this.getSize()));
				}
				//	Cherche a afficher les cases adjacente s'il n'y a aucune mine autour
				else if (this.entourage == 0) {
					this.grille.setEntourageVisible(this);
				}
				if (this.grille.getEnJeu()){
					this.grille.verifVictoire();
				}
			}
			// 	S'il y a une mine et que c'est la première cliquée
			else if ((this.minee)&&(this.grille.getEnJeu())) {
				this.grille.setEnJeu(false);
				this.setBackground(new Color(200, 0, 0));
				this.grille.Defaite();
			}
			//	S'il y a une mine est que la partie est finie
			else if ((this.minee)&&(!this.grille.getEnJeu())) {
				this.setBackground(new Color(236, 0, 140));

			//	Sinon le nombre de mines autour d'elle
			}

			// Mise à jour de l'affichage de la case
			this.updateUI();
			
		}
	}

	//	Méthode permettant de dire si la case est cachée ou visible
	public boolean getVisible(){
		return this.visible;
	}

	//	Méthode pour déclarer la présence d'une mine sur une case
	public void setMine(){
		this.minee=true;
	}

	// Permet de dire si une case est minée
	public boolean getMine(){
		return this.minee;
	}

	//	Défini combien de mines entourent la case
	public void setEntourage(int entourage){
		this.entourage=entourage;
	}

	//	Renvoi l'entourage de la case 
	public int getEntourage(){
		return this.entourage;
	}

	//	Permet d'acceder à la grille sur laquelle est la case
	public Grille getGrille(){
		return this.grille;
	}

	//	Méthode pour savoir si le joueur pense que la case est minée
	public void setReperee(boolean reperee){
		this.reperee=reperee;
		if ((reperee)&&(minee)){
			this.grille.verifVictoire();
		}
		this.grille.MinesLeft();
	}

	//	Methode pour dire si la case est marquée ou non
	public boolean getReperee(){
		return this.reperee;
	}

	//	Methode pour montrer que la partie est gagnée
	public void setVictoire(){
		this.grille.setEnJeu(false);
		if (this.minee==true){
			removeAll();
			this.setBackground(new Color(236, 214, 0));;
			
		}
	}

	//	Methode pour savoir dans le Listener si la partie est finie ou non 
	public boolean getEnJeu(){
		
		System.out.println(this.grille.getEnJeu());
		return this.grille.getEnJeu();
	}
}
