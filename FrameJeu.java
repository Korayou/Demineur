import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>FrameJeu</code> génère une grille de jeu
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class FrameJeu extends JFrame{
	/**
    * grille de jeu
    */
	private Grille grille;

	/**
    * Constructeur qui sert à géréner une nouvelle grille
    * @param lignes le nombre de lignes
	* @param colonnes le nombre de colonnes
	* @param mines le nombre de mines
	* @param menu la fenêtre du menu rattaché à la partie
    */
	public FrameJeu(int lignes, int colonnes, int mines, FrameMenu menu) {
		super();
		//	Création d'une grille pour une nouvelle partie
        this.grille=new Grille(lignes,colonnes,mines,this, menu);
		MiseEnPage();

	}

	/**
    * Constructeur qui sert à charger la grille d'une ancienne partie
    * @param lignes le nombre de lignes
	* @param colonnes le nombre de colonnes
	* @param donnees la sauvegarde
	* @param mines le nombre de mines
	* @param menu la fenêtre du menu rattaché à la partie
    */
	public FrameJeu (int lignes, int colonnes, SaveManager.SaveData donnees, int mines, FrameMenu menu){
		super();
		//	Génération d'une grille à partir de la sauvegarde
		this.grille=new Grille(lignes,colonnes,donnees,mines,this, menu);
		MiseEnPage();
	}

	/**
    * Méthode qui sert à créer la fenêtre avec ses élements
    */
	public void MiseEnPage(){
		
		// On récupère les dimensions de l'écran pour adapter la taille par défaut de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre
		this.setTitle("Démineur - En Jeu");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//	Mise en page
		this.setLayout(new GridBagLayout());
		GridBagConstraints miseEnPage = new GridBagConstraints();

		// Récupération de la bannière
		Banniere banniere = grille.getBanniere();

		this.addWindowListener(new SaveAndCloseListener(grille));

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