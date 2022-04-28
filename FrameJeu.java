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
		


		

		// En test
		
		// Couleurs
		//Color rose = new Color(236,0,140);
		Color vert = new Color(0, 236, 96);

		//Essai de mise en page car la bannière est par dessus la grille
		fenetre.setLayout(new GridBagLayout());
		GridBagConstraints miseEnPage = new GridBagConstraints();


		// Création de la bannière (qui sera dans une autre classe)
		Dimension grilleSize= grille.getGrilleSize();
		JPanel banniere= new JPanel();
		banniere.setBackground(vert);
		Dimension banniereSize=new Dimension(grilleSize.width,grilleSize.height/9);
		banniere.setSize(banniereSize);

		// mise en place de la bannière
		miseEnPage.fill = GridBagConstraints.HORIZONTAL;
		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 0;
		miseEnPage.weightx =banniereSize.width;
		miseEnPage.ipady  = banniereSize.height;
		fenetre.add(banniere, miseEnPage);

	
		// 	Mise en place de la grille
		//miseEnPage.fill = GridBagConstraints.BOTH;
		miseEnPage.anchor = GridBagConstraints.SOUTHEAST;
		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 1;
		miseEnPage.weightx =grilleSize.width;
		miseEnPage.ipady  = grilleSize.height;
		fenetre.add(grille.getGrille(), miseEnPage);


		fenetre.pack();
		fenetre.setSize(grilleSize.width,grilleSize.height*10/9);
		Dimension fenetreSize=fenetre.getSize();
		fenetre.setLocation(screenSize.width/2-(fenetreSize.width/2), screenSize.height/2-(fenetreSize.height/2));
		//fenetre.setResizable(false);
	    fenetre.setVisible(true);
	}
}