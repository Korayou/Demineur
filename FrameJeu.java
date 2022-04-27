import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameJeu{
	public FrameJeu(JPanel grille, int mines) {

		// On récupère les dimensions de l'écran pour adapter la taille par défaut de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre avec des valeurs par défaut
		JFrame fenetre = new JFrame("Démineur - En Jeu");
		fenetre.setSize( screenSize.width * 2/3,screenSize.height * 2/3);
	    fenetre.setLocation(screenSize.width * 1/6, screenSize.height * 1/6);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*Banniere banniere = new Banniere(mines);
		fenetre.add(banniere, BorderLayout.NORTH)*/
		fenetre.add(grille, BorderLayout.SOUTH);
		
  		fenetre.pack();
	    fenetre.setVisible(true);
	}
}