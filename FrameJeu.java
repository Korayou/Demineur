import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameJeu{
	public FrameJeu(Grille grille, int mines) {

		// On récupère les dimensions de l'écran pour adapter la taille par défaut de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre avec des valeurs par défaut
		JFrame fenetre = new JFrame("Démineur - En Jeu");
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Couleur
		Color vert = new Color(0, 236, 96);

		//	Mise en page
		fenetre.setLayout(new GridBagLayout());
		GridBagConstraints miseEnPage = new GridBagConstraints();


		// Création de la bannière (qui sera dans une autre classe)
		Dimension grilleSize= grille.getGrilleSize();
		JPanel banniere= new JPanel();
		banniere.setBackground(vert);
		Dimension banniereSize=new Dimension(grilleSize.width,grilleSize.height/8);
		banniere.setSize(banniereSize);

		//	Mise en place de la bannière
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
		//fenetre.setResizable(false);
	    fenetre.setVisible(true);
	}
}