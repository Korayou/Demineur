import javax.swing.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameMenu{
	private int lignes;
	private int colonnes;
	private int mines;
	public FrameMenu() {

		// On récupère les dimensions de l'écran pour adapter la taille de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre
		JFrame fenetre = new JFrame("Démineur - Menu");
	    fenetre.setSize(screenSize.width * 3/5,screenSize.height * 2/3);
	    fenetre.setLocation(screenSize.width * 1/5, screenSize.height * 1/6);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLayout(null);
		fenetre.setLayout(new GridBagLayout());
		GridBagConstraints miseEnPage = new GridBagConstraints();

		
		//	On créer les zones de textes de saisie
		JSlider sliderLignes = new JSlider(4,30);
		JSlider sliderColonnes = new JSlider(4,30);
		JSlider sliderMines = new JSlider(16,900);

		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 0;
		miseEnPage.weightx =0;
		miseEnPage.weighty  = 0.3;
		miseEnPage.fill = GridBagConstraints.BOTH;
		fenetre.add(sliderLignes);

		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 1;
		miseEnPage.weightx =0;
		miseEnPage.weighty  = 0.3;
		miseEnPage.fill = GridBagConstraints.BOTH;
		fenetre.add(sliderColonnes);

		miseEnPage.gridx = 0;
    	miseEnPage.gridy = 2;
		miseEnPage.weightx =0;
		miseEnPage.weighty  = 0.3;
		miseEnPage.fill = GridBagConstraints.BOTH;
		fenetre.add(sliderMines);

		this.lignes=sliderLignes.getValue();
		this.colonnes=sliderColonnes.getValue();
		this.mines=sliderMines.getValue();
		System.out.println("Lignes : "+this.lignes+" Colonnes : "+this.colonnes+" Mines : "+this.mines);
		// A faire : choix de la taille de la grille, bouton jouer, charger et quitter
	    fenetre.setVisible(true);
	}
}