import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameMenu{
	public FrameMenu() {

		// On récupère les dimensions de l'écran pour adapter la taille de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre
		JFrame fenetre = new JFrame("Démineur - Menu");
	    fenetre.setSize(screenSize.width * 3/5,screenSize.height * 2/3);
	    fenetre.setLocation(screenSize.width * 1/5, screenSize.height * 1/6);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLayout(null);
		fenetre.setLayout(new GridBagLayout());
		GridBagConstraints miseEnPage = new GridBagConstraints();


		// On crée un objet Fond pour habiller notre fenêtre
		//fenetre.getContentPane().add(new Fond(fenetre));
		
		//	On créer les zones de textes de saisie
		JTextField fieldLignes = new JTextField();
		JTextField fieldColonnes = new JTextField();
		JTextField fieldMines = new JTextField();
		fieldLignes.setBackground(Color.GREEN);
		fieldColonnes.setBackground(Color.BLUE);
		fieldMines.setBackground(Color.MAGENTA);

		//	On place les zones de textes
		miseEnPage.fill = GridBagConstraints.BOTH;
		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 0;
		miseEnPage.weightx =0.3;
		fenetre.add(fieldLignes, miseEnPage);

		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 1;
		miseEnPage.weightx =0.3;
		miseEnPage.fill = GridBagConstraints.BOTH;
		fenetre.add(fieldColonnes, miseEnPage);

		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 2;
		miseEnPage.weightx =0.3;
		miseEnPage.fill = GridBagConstraints.BOTH;
		fenetre.add(fieldMines, miseEnPage);

		// A faire : choix de la taille de la grille, bouton jouer, charger et quitter
	    fenetre.setVisible(true);
	}
}