import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameJeu{
	public FrameJeu(Grille grille, int mines) {

		// On récupère les dimensions de l'écran pour adapter la taille par défaut de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre avec des valeurs par défaut
		JFrame fenetre = new JFrame("Démineur - En Jeu");
		fenetre.setSize(screenSize.width * 2/3,screenSize.height * 2/3);
	    fenetre.setLocation(screenSize.width * 1/6, screenSize.height * 1/6);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		



		// En test

		Color rose = new Color(236,0,140);

		Dimension grilleSize= grille.getGrilleSize();
		JPanel banniere= new JPanel();
		banniere.setBackground(rose);
		Dimension banniereSize=new Dimension(grilleSize.width,grilleSize.height/9);
		banniere.setSize(banniereSize);

		banniere.setBounds( 0,  0, banniereSize.width, banniereSize.height);
		JPanel plateau=grille.getGrille();
		plateau.setBounds( 0,  banniereSize.height, grilleSize.width,grilleSize.height);
		
		fenetre.add(banniere);
		fenetre.add(plateau);
	

		System.out.println("Taille bannière : "+banniereSize);
		System.out.println("Taille grille : "+grilleSize);
		
		fenetre.setLayout(null);  
  		fenetre.pack();
	    fenetre.setVisible(true);
	}
}