import javax.swing.*;
import java.awt.*;

public class Banniere extends JPanel {
	private FrameJeu fenetre;
	//	Définition du constructeur
	public Banniere(int mines, FrameJeu fenetre) {
		super();
		this.fenetre=fenetre;

        //  On défini un style à la bannière
		this.setBackground( new Color(0, 236, 96));

		// TODO : Bouton sauver et quitter
	}

	//	Méthode pour afficher le nombre de mines restantes
	public void setMinesLeft(int minesLeft){
		this.removeAll();
		this.add(new MineLeft(minesLeft,this.getSize()));
		this.repaint();
	}

	//	Méthode pour indiquer au joueur sa Victoire
	public void setVictoire(){
		this.add(new Fin("Victoire !",this.getSize()));
		this.repaint();
		//	TODO : délai
		new FrameMenu();
        this.fenetre.dispose();
	}

	//	Méthode pour indiquer au joueur sa Défaite
	public void setDefaite(){
		this.add(new Fin("Défaite !",this.getSize()));
		this.repaint();
		//	TODO : délai
		new FrameMenu();
        this.fenetre.dispose();
	}
}