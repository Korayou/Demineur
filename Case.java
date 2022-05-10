import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {
	//	Definition d'attributs
	private Grille grille;
	private int entourage;
	private boolean visible;
	private boolean minee;
	private boolean reperee;
	private boolean deminee;
	private ListenerCase listener;

	//	Définition du constructeur
	public Case(Grille grille, Dimension caseSize) {
		super();
		//	Initialisation des attributs 
		this.visible=false;
		this.reperee=false;		
		this.deminee=false;
		this.grille=grille;
		
		//	On place un listener sur notre case pour qu'elle réagisse aux clicks du joueur
		this.listener = new ListenerCase();
		this.addMouseListener(this.listener);
		
		//	Mise en page de la case et couleur par défaut
		this.setSize(caseSize);
		GridLayout unique = new GridLayout(1,1);
		this.setLayout(unique);
		this.setBackground(new Color(70, 70, 70));
	}

	//	Méthode qui permet de montrer la case, et de la considérer comme déminée
	public void setVisible(){
		
		if (this.visible==false){
			this.visible = true;
			this.deminee = true;

			// On affiche une mine si la case est minée, sinon le nombre de mines autour d'elle
			if (this.minee == true) {
				this.setBackground(new Color(236, 0, 140));
			} else {
				this.setBackground(new Color(80, 80, 80));
				if (this.entourage > 0) {
					this.add(new Entourage(this.entourage, this.getSize()));
				}
			}
			// Mise à jour de l'affichage de la case
			this.updateUI();
			if (this.getEntourage() == 0) {
				this.grille.setEntourageVisible(this);
			}
			this.grille.verifVictoire();
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
			this.deminee=true;
			this.grille.verifVictoire();
		}
		this.grille.MinesLeft();
	}

	//	Methode pour dire si la case est marquée ou non
	public boolean getReperee(){
		return this.reperee;
	}

	//	Methode pour dire si la case a été déminée
	public boolean getDeminee(){
		return this.deminee;
	}
}
