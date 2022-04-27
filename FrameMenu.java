import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameMenu{
	public FrameMenu() {

		// On récupère les dimensions de l'écran pour adapter la taille de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth = screenSize.width * 3/5;
		int frameHeight = screenSize.height * 2/3;
		int frameLocation[]={screenSize.width * 1/5, screenSize.height * 1/6};

		// On crée ensuite notre fenêtre
		JFrame fenetre = new JFrame("Démineur - Menu");
	    fenetre.setSize(frameWidth,frameHeight);
	    fenetre.setLocation(frameLocation[0],frameLocation[1]);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// On crée un objet Fond pour habiller notre fenêtre
		new Fond(fenetre);
		


		// A faire : choix de la taille de la grille, bouton jouer, charger et quitter, déscription/règles du jeu

	    fenetre.setVisible(true);
	}
}