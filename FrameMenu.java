import javax.swing.*;

import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameMenu{
	private int lignes;
	private int colonnes;
	private int mines;
	private JSlider sliderLignes;
	private JSlider sliderColonnes;
	private JSlider sliderMines;
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
		this.sliderLignes = new JSlider(4,30);
		this.sliderColonnes = new JSlider(4,30);
		this.sliderMines = new JSlider(0,900, 16);

		sliderLignes.addChangeListener(new SettingsListener(0,this));
		sliderColonnes.addChangeListener(new SettingsListener(1,this));
		sliderMines.addChangeListener(new SettingsListener(2,this));

		this.lignes=sliderLignes.getValue();
		this.colonnes=sliderColonnes.getValue();
		this.mines=sliderMines.getValue();
		
		fenetre.add(sliderLignes);
		fenetre.add(sliderColonnes);
		fenetre.add(sliderMines);
		
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(new NewGameListener(this));

		fenetre.add(newGame);

		// A faire : bouton jouer, charger et quitter
	    fenetre.setVisible(true);
	}

	//	Méthode pour récupérer les valeurs des paramètres
	public void setSettings(int settingToSet, int settingValue){
		if (settingToSet==0){
			this.lignes=settingValue;
		} else if (settingToSet==1){
			this.colonnes=settingValue;
		} else if (settingToSet==2){
			this.mines=settingValue;
		}
		this.sliderMines.setMaximum(this.colonnes*this.lignes);
		System.out.println("Lignes : "+this.lignes+" Colonnes : "+this.colonnes+" Mines : "+this.mines);
    }

	// 	Methode pour connaître les paramètres de la partie
	public int[] getSettings(){
		int[] settings = new int[3];
		settings[0]=this.lignes;
		settings[1]=this.colonnes;
		settings[2]=this.mines;
		return settings;
	}
}