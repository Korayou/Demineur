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

		// On créer un damier aux couleurs du démineur pour le fond
	    Dimension damierSize = fenetre.getSize();
		int damierWidth = damierSize.width/75;
		int damierHeight = damierSize.height/75;
	    GridLayout damier = new GridLayout(damierHeight, damierWidth);
		fenetre.setLayout(damier);
		Color lightGreen = new Color(80,215,100);
		Color darkGreen = new Color(70,200,90);
		for (int line=0; line<damierHeight; line++){
			for(int cases = 0; cases < damierWidth; cases++){
				if (line%2==0){
	  				if (cases%2==0){
	  					JPanel dark = new JPanel();
		    			dark.setBackground(darkGreen);
	  					fenetre.add(dark);
	  				} else {
	  					JPanel light = new JPanel();
		    			light.setBackground(lightGreen);
	  					fenetre.add(light);
	  				}
	  			} else {
	  				if (cases%2==0){
	  					JPanel light = new JPanel();
		    			light.setBackground(lightGreen);
	  					fenetre.add(light);
	  				} else {
	  					JPanel dark = new JPanel();
		    			dark.setBackground(darkGreen);
	  					fenetre.add(dark);	
	  				}			
				}
	  		}
  		}

		// A faire : choix de la taille de la grille, bouton jouer et quitter

	    fenetre.setVisible(true);
	}
}