import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {
	//	Definition d'attributs
	private Dimension caseSize;
	private int entourage;
	private boolean visible;
	private boolean minee;
	private ListenerCase listener;

	//	Définition du constructeur
	public Case(Dimension caseSize) {
		super();
		this.visible=false;		//	Par défaut la case est cachée
		this.caseSize= caseSize;
		this.setSize(caseSize);
		
		//	On place un listener sur notre case pour qu'elle réagisse aux clicks du joueur
		this.listener = new ListenerCase();
		this.addMouseListener(this.listener);
		
		//	Mise en page de la page et couleur par défaut
		GridLayout unique = new GridLayout(1,1);
		this.setLayout(unique);
		this.setBackground(new Color(70, 70, 70));
	}

	//	Méthode qui permet de montrer la case
	public void setVisible(){
		this.visible=true;
		
		// On affiche une mine si la case est minée, sinon le nombre de mines autour d'elle
		if (this.minee == true) {
			this.setBackground(new Color(236, 0, 140));	
		} else {
			this.setBackground(new Color(80, 80, 80));
			if (this.entourage>0){
				this.add(new Entourage(this.entourage,caseSize));
			}
		}
		//	Mise à jour de l'affichage de la case
		this.updateUI();
	}

	//	Méthode permettant de savoir si la case est cachée ou visible
	public boolean getVisible(){
		return this.visible;
	}

	//	Mathode pour déclarer la présence d'une mine sur une case
	public void setMine(){
		this.minee=true;
	}

	// Permet de savoir si une case est minée
	public boolean getMine(){
		return this.minee;
	}

	//	Défini combien de mines entourent la case
	public void setEntourage(int entourage){
		this.entourage=entourage;
	}
}
