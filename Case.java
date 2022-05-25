import javax.swing.*;
import java.awt.*;

/**
* La classe <code>Case</code> genère une case de jeu
* @version 1.1
* @author Kayyissa Haïssous
*/
public class Case extends JPanel {
	/**
	* grille sur laquelle est la cas
	*/
	private Grille grille;
	/**
	* nombre de mines alentours
	*/
	private int entourage;
	/**
	* statut si la case est visible ou non
	*/
	private boolean visible;
	/**
	* si la case est minée ou non
	*/
	private boolean minee;
	/**
	* si la case est marquée par l'utilisateur ou non
	*/
	private boolean reperee;

	/**
	* Définition du constructeur qui genère une case
	* @param grille grille de jeu
	* @param caseSize taille d'une case
	*/
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

	/**
	* Méthode qui permet de montrer la case, et fait perdre si elle est minée
	*/
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

	/**
	* Méthode permettant de dire si la case est cachée ou visible
	* @return this.visible 
	*/
	public boolean getVisible(){
		return this.visible;
	}

	/**
	* Méthode pour déclarer la présence d'une mine sur une case
	*/
	public void setMine(){
		this.minee=true;
	}

	/**
	* Permet de dire si une case est minée
	* @return this.minee
	*/
	public boolean getMine(){
		return this.minee;
	}

	/**
	*Défini combien de mines entourent la case
	* @param entourage mines autour de la case
	*/
	public void setEntourage(int entourage){
		this.entourage=entourage;
	}

	/**
	*Renvoie l'entourage de la case 
	* @return this.entourage
	*/
	public int getEntourage(){
		return this.entourage;
	}

	/**
	* Permet d'acceder à la grille sur laquelle est la case
	* @return this.grille
	*/
	public Grille getGrille(){
		return this.grille;
	}

	/**
	* Méthode pour savoir si le joueur pense que la case est minée
	* @param reperee si la case est marquée ou non
	* @param marquage quel est le marquage sur la case (0 si aucun)
	*/
	public void setReperee(boolean reperee, int marquage){
		this.reperee=reperee;
		if (marquage==1){
			this.add(new Etoile(this.getSize()), BorderLayout.CENTER);
		}
		if (marquage==2){
			this.add(new Doute(this.getSize()), BorderLayout.CENTER);
		}
		this.grille.MinesLeft();
	}

	/**
	* Methode pour dire si la case est marquée ou non
	* @return this.reperee
	*/
	public boolean getReperee(){
		return this.reperee;
	}

	/**
	* Methode pour montrer que la partie est gagnée
	*/
	public void setVictoire(){
		this.grille.setEnJeu(false);
		if (this.minee==true){
			removeAll();
			this.setBackground(new Color(236, 214, 0));;
			this.updateUI();
		}
	}

	/**
	* Methode pour savoir si la partie est finie ou non
	* @return this.grille.getEnJeu()
	*/ 
	public boolean getEnJeu(){
		return this.grille.getEnJeu();
	}

	/**
	* redéfinition du toString pour sauvegarder les cases
	*/ 
	@Override
	public String toString(){
    	int value=0;
    	if (this.minee){
      		value+=1;
    	}
    	if (this.reperee){
      		value+=2;
    	}
     	if (this.visible){
      		value+=4;
    	}
    	return Integer.toString(value);
	}
}
