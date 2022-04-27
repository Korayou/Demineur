import javax.swing.*;
import java.awt.*;

public class Grille extends JComponent {
    private Dimension grilleSize=new Dimension(0,0);
    private JPanel grille= new JPanel();

    // On créer La grille de jeu
    public Grille(int lignes, int colonnes, int mines){
		
		// Découpage de l'espace en fonction des paramètres pour la mise en place de la grille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.grilleSize = new Dimension(screenSize.width*2/3, screenSize.height*5/9);
		Dimension caseSize = new Dimension(this.grilleSize.width/colonnes,this.grilleSize.width/colonnes);
	    GridLayout damier = new GridLayout(lignes,colonnes);
		this.grille.setLayout(damier);
        this.grille.setSize(grilleSize);

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
	  					this.grille.add(dark);
	  				} else {
	  					JPanel light = new JPanel();
	  					light.setSize(caseSize);
		    			light.setBackground(gray1);
	  					this.grille.add(light);
	  				}
	  			} else {
	  				if (currentCase%2==0){
	  					JPanel light = new JPanel();
	  					light.setSize(caseSize);
		    			light.setBackground(gray1);
	  					this.grille.add(light);
	  				} else {
	  					JPanel dark = new JPanel();
	  					dark.setSize(caseSize);
		    			dark.setBackground(gray2);
	  					this.grille.add(dark);	
	  				}			
				}
	  		}
  		}
    }

    public Dimension getGrilleSize() {
        return grilleSize;
    }
    public JPanel getGrille() {
        return grille;
    }
}
