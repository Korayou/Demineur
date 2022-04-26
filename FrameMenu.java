import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameMenu{
	public FrameMenu() {

		// On récupère les dimensions de l'écran pour adapter la taille de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth = screenSize.width * 2/3;
		int frameHeight = screenSize.height * 2/3;
		int frameLocation[]={screenSize.width * 1/6, screenSize.height * 1/6};

		// On crée ensuite notre fenêtre
		JFrame fenetre = new JFrame("Menu");
	    fenetre.setSize(frameWidth,frameHeight);
	    fenetre.setLocation(frameLocation[0],frameLocation[1]);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// On créer un damier aux couleurs du démineur pour le fond ainsi que des décors
		
		// Découpage de la fenêtre pour la mise en place du damier 
	    Dimension damierSize = fenetre.getSize();
		Dimension caseSize = new Dimension(damierSize.width/75, damierSize.height/75);
	    GridLayout damier = new GridLayout(caseSize.height, caseSize.width);
		fenetre.setLayout(damier);

		// Création des couleurs
		Color gray1 = new Color(80,80,80);
		Color gray2 = new Color(60,60,60);

		// Réalisation du damier et ajout d'éléments graphiques
		Etoile etoile = new Etoile();
		etoile.setPreferredSize(caseSize);
		for (int line=0; line<caseSize.height; line++){
			for(int cases = 0; cases < caseSize.width; cases++){
				if (line%2==0){
	  				if (cases%2==0){
	  					JPanel dark = new JPanel();
		    			dark.setBackground(gray2);
						if ((line==0)&&(cases==8)){
							dark.add(etoile);
							System.out.println("ok");
						}
	  					fenetre.add(dark);
	  				} else {
	  					JPanel light = new JPanel();
		    			light.setBackground(gray1);
	  					fenetre.add(light);
	  				}
	  			} else {
	  				if (cases%2==0){
	  					JPanel light = new JPanel();
		    			light.setBackground(gray1);
	  					fenetre.add(light);
	  				} else {
	  					JPanel dark = new JPanel();
		    			dark.setBackground(gray2);
	  					fenetre.add(dark);	
	  				}			
				}
	  		}
  		}

		// A faire : choix de la taille de la grille, bouton jouer et quitter, déscription/règles du jeu, décorations

	    fenetre.setVisible(true);
	}
}