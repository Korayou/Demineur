import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameJeu extends JFrame{
	public FrameJeu(int lignes, int colonnes, int mines) {

		// On récupère les dimensions de l'écran pour adapter la taille par défaut de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre
		this.setTitle("Démineur - En Jeu");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//	Mise en page
		this.setLayout(new GridBagLayout());
		GridBagConstraints miseEnPage = new GridBagConstraints();

		//	Création de la grille de Jeu
        Grille grille=new Grille(lignes,colonnes,mines,this);

		// Récupération de la bannière
		Banniere banniere = grille.getBanniere();



		//	Mise en place de la bannière
		miseEnPage.fill = GridBagConstraints.BOTH;
		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 0;
		miseEnPage.weightx =1;
		miseEnPage.weighty  = 0.15;
		this.add(banniere, miseEnPage);

	
		// 	Mise en place de la grille
		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 1;
		miseEnPage.weightx =1;
		miseEnPage.weighty  = 0.85;
		miseEnPage.fill = GridBagConstraints.BOTH;
		this.add(grille, miseEnPage);

		// Mise en place de la fenêtre et affichage
		this.pack();
		Dimension grilleSize= grille.getGrilleSize();
		this.setSize(grilleSize.width,grilleSize.height*9/8);
		Dimension fenetreSize=this.getSize();
		this.setLocation(screenSize.width/2-(fenetreSize.width/2), screenSize.height/2-(fenetreSize.height/2));
	    this.setVisible(true);
	}
}