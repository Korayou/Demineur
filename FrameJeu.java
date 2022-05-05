import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameJeu{
	public FrameJeu(int lignes, int colonnes, int mines) {

		// On récupère les dimensions de l'écran pour adapter la taille par défaut de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre
		JFrame fenetre = new JFrame("Démineur - En Jeu");
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//	Mise en page
		fenetre.setLayout(new GridBagLayout());
		GridBagConstraints miseEnPage = new GridBagConstraints();

		// Création de la bannière
		EtatPartie banniere = new EtatPartie(mines);

		//	Création de la grille de Jeu
        Grille grille=new Grille(banniere,lignes,colonnes,mines);


		//	Mise en place de la bannière
		Dimension grilleSize= grille.getGrilleSize();
		Dimension banniereSize=new Dimension(grilleSize.width,grilleSize.height/8);
		banniere.setSize(banniereSize);
		miseEnPage.fill = GridBagConstraints.BOTH;
		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 0;
		miseEnPage.weightx =1;
		miseEnPage.weighty  = 0.15;
		fenetre.add(banniere, miseEnPage);

	
		// 	Mise en place de la grille
		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 1;
		miseEnPage.weightx =1;
		miseEnPage.weighty  = 0.85;
		miseEnPage.fill = GridBagConstraints.BOTH;
		fenetre.add(grille, miseEnPage);

		// Mise en place de la fenêtre et affichage
		fenetre.pack();
		fenetre.setSize(grilleSize.width,grilleSize.height*9/8);
		Dimension fenetreSize=fenetre.getSize();
		fenetre.setLocation(screenSize.width/2-(fenetreSize.width/2), screenSize.height/2-(fenetreSize.height/2));
	    fenetre.setVisible(true);
	}
}