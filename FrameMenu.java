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
		JFrame fenetre = new JFrame("Démineur - Menu");
	    fenetre.setSize(frameWidth,frameHeight);
	    fenetre.setLocation(frameLocation[0],frameLocation[1]);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// On créer un damier aux couleurs du démineur pour le fond ainsi que des décors
		
		// Découpage de la fenêtre pour la mise en place du damier 
	    Dimension damierSize = fenetre.getSize();
		Dimension gridSize = new Dimension(damierSize.width/75, damierSize.height/75);
	    GridLayout damier = new GridLayout(gridSize.height, gridSize.width);
		fenetre.setLayout(damier);
		System.out.println(" Menu " + damierSize.width +"  "+ damierSize.height + "  "+gridSize.width +"  "+ gridSize.height );

		// Création des couleurs
		Color gray1 = new Color(80,80,80);
		Color gray2 = new Color(70,70,70);

		// Réalisation du damier et ajout d'éléments graphiques
		for (int line=0; line<gridSize.height; line++){
			for(int cases = 0; cases < gridSize.width; cases++){
				if (line%2==0){
	  				if (cases%2==0){
	  					JPanel dark = new JPanel();
		    			dark.setBackground(gray2);
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

		// A faire : choix de la taille de la grille, bouton jouer, charger et quitter, déscription/règles du jeu

	    fenetre.setVisible(true);
	}
}