import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameJeu{
	public FrameJeu(int lignes, int colonnes) {

		// On récupère les dimensions de l'écran pour adapter la taille par défaut de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth = screenSize.width * 2/3;
		int frameHeight = screenSize.height * 2/3;

		// On crée ensuite notre fenêtre avec des valeurs par défaut
		JFrame fenetre = new JFrame("Démineur - En Jeu");
		fenetre.setSize(frameWidth,frameHeight);
	    fenetre.setLocation(screenSize.width * 1/6, screenSize.height * 1/6);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// On créer La grille de jeu
		
		// Découpage de la fenêtre en fonction des paramètres pour la mise en place du damier
	    Dimension damierSize = fenetre.getSize();
		Dimension caseSize = new Dimension(frameWidth/colonnes,frameWidth/colonnes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
		fenetre.setLayout(damier);

		// Création des couleurs
		Color gray1 = new Color(80,80,80);
		Color gray2 = new Color(70,70,70);

		// Réalisation du damier et ajout d'éléments graphiques
		for (int currentLine=0; currentLine<lignes; currentLine++){
			for(int currentCase = 0; currentCase < colonnes; currentCase++){
				if (currentLine%2==0){
	  				if (currentCase%2==0){
	  					JPanel dark = new JPanel();
	  					dark.setSize(caseSize);
		    			dark.setBackground(gray2);
	  					fenetre.add(dark);
	  				} else {
	  					JPanel light = new JPanel();
	  					light.setSize(caseSize);
		    			light.setBackground(gray1);
	  					fenetre.add(light);
	  				}
	  			} else {
	  				if (currentCase%2==0){
	  					JPanel light = new JPanel();
	  					light.setSize(caseSize);
		    			light.setBackground(gray1);
	  					fenetre.add(light);
	  				} else {
	  					JPanel dark = new JPanel();
	  					dark.setSize(caseSize);
		    			dark.setBackground(gray2);
	  					fenetre.add(dark);	
	  				}			
				}
	  		}
  		}
  		fenetre.pack();
  		fenetre.setLocation(damierSize.width * 1/6,(screenSize.height/2)- frameHeight/2);
	    fenetre.setVisible(true);
	    System.out.println(" Jeu " + damierSize.width * 1/6 +"  "+  ((screenSize.height/2)- frameHeight/2) + "  "+caseSize.width +"  "+ caseSize.height );
	}
}