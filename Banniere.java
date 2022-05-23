import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Banniere extends JPanel {
	private FrameJeu fenetre;
	private FrameMenu menu;
	//	Définition du constructeur
	public Banniere(int mines, FrameJeu fenetre, FrameMenu menu) {
		super();
		this.fenetre=fenetre;
		this.menu=menu;

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
  		ActionListener backToMenu = new MenuListener(this.fenetre, this.menu);
  		Timer timerMenu = new Timer(5000, backToMenu);
  		timerMenu.setRepeats(false);
		timerMenu.start();
	}

	//	Méthode pour indiquer au joueur sa Défaite
	public void setDefaite(){
		this.add(new Fin("Défaite !",this.getSize()));
		this.repaint();
  		ActionListener backToMenu = new MenuListener(this.fenetre, this.menu);
  		Timer timerMenu = new Timer(5000, backToMenu);
  		timerMenu.setRepeats(false);
  		timerMenu.start();
	}
}