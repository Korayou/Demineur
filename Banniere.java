import javax.swing.*;
import java.awt.*;

public class Banniere extends JPanel {
	private FrameJeu fenetre;
	private FrameMenu menu;
	//	Définition du constructeur
	public Banniere(int mines, FrameJeu fenetre, FrameMenu menu, Dimension grilleSize) {
		super();
		this.fenetre=fenetre;
		this.menu=menu;
		this.setSize(grilleSize.width,grilleSize.height/8);

        //  On défini un style à la bannière
		this.setBackground(new Color(0, 236, 96));

		// TODO : Bouton sauver et quitter
	}

	//	Méthode pour afficher le nombre de mines restantes
	public void setMinesLeft(int minesLeft) {
		this.removeAll();
		this.add(new JLabel("Mines restantes : "+Integer.toString(minesLeft)),BorderLayout.CENTER);
		this.repaint();
	}

	//	Méthode pour indiquer au joueur sa Victoire
	public void setVictoire() {
		JLabel victoire = new JLabel("Victoire !   Retour au menu...");
		victoire.setForeground(new Color(0, 22, 236));
		this.add(victoire,BorderLayout.SOUTH);
  		Timer timerMenu = new Timer(5000, new MenuListener(this.fenetre, this.menu));
  		timerMenu.setRepeats(false);
		timerMenu.start();
	}

	//	Méthode pour indiquer au joueur sa Défaite
	public void setDefaite() {
		JLabel defaite = new JLabel("Défaite !   Retour au menu...");
		defaite.setForeground(new Color(0, 22, 236));
		this.add(defaite,BorderLayout.SOUTH);
		Timer timerMenu = new Timer(5000, new MenuListener(this.fenetre, this.menu));
  		timerMenu.setRepeats(false);
  		timerMenu.start();
	}
}