import javax.swing.*;
import java.awt.*;

public class Fond {
    public Fond(JFrame fenetre) {
    	
        // On créer un damier aux couleurs du démineur pour le fond ainsi que des décors
		
		// Découpage de la fenêtre pour la mise en place du damier 
	    Dimension damierSize = fenetre.getSize();
		Dimension gridSize = new Dimension(damierSize.width/75, damierSize.height/75);
	    GridLayout damier = new GridLayout(gridSize.height, gridSize.width);
		fenetre.setLayout(damier);

		// Création des couleurs
		Color gray1 = new Color(70,70,70);
		Color gray2 = new Color(60,60,60);

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
    } 
}
