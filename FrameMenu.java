import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// Cette classe à pour but d'afficher un menu et de réagir aux directives de l'utilisateur (lancer le jeu, le quitter...)
public class FrameMenu extends JFrame{
	private int lignes;
	private int colonnes;
	private int mines;
	private JSlider sliderLignes;
	private JSlider sliderColonnes;
	private JSlider sliderMines;
	private JLabel showLines;
	private JLabel showColumns;
	private JLabel showMines;

	public FrameMenu() {

		// On récupère les dimensions de l'écran pour adapter la taille de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre
		this.setTitle("Démineur - Menu");
		Dimension frameSize = new Dimension (screenSize.width * 3/5,screenSize.height * 2/3);
	    this.setSize(frameSize);
	    this.setLocation(screenSize.width * 1/5, screenSize.height * 1/6);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		//	On créer les zones de textes de saisie
		this.sliderLignes = new JSlider(4,30,20);
		this.sliderColonnes = new JSlider(4,30,25);
		this.sliderMines = new JSlider(1,900, 50);

		sliderLignes.addChangeListener(new SettingsListener(0,this));
		sliderColonnes.addChangeListener(new SettingsListener(1,this));
		sliderMines.addChangeListener(new SettingsListener(2,this));

		this.lignes=sliderLignes.getValue();
		this.colonnes=sliderColonnes.getValue();
		this.mines=sliderMines.getValue();
		
		sliderLignes.setBounds(frameSize.width*2/3, frameSize.height*6/15, frameSize.width/4, frameSize.height/20);
		sliderColonnes.setBounds(frameSize.width*2/3, frameSize.height*8/15, frameSize.width/4, frameSize.height/20);
		sliderMines.setBounds(frameSize.width*2/3, frameSize.height*10/15, frameSize.width/4, frameSize.height/20);

		this.add(sliderLignes);
		this.add(sliderColonnes);
		this.add(sliderMines);

		this.showLines= new JLabel("Lignes : 20");
		this.showColumns= new JLabel("Colonnes : 25");
		this.showMines= new JLabel("Mines : 50");

		this.showLines.setBounds(frameSize.width*2/3, frameSize.height*7/15, frameSize.width/4, frameSize.height/20);
		this.showColumns.setBounds(frameSize.width*2/3, frameSize.height*9/15, frameSize.width/4, frameSize.height/20);
		this.showMines.setBounds(frameSize.width*2/3, frameSize.height*11/15, frameSize.width/4, frameSize.height/20);

		this.add(showLines);
		this.add(showColumns);
		this.add(showMines);
		
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(new NewGameListener(this));

		newGame.setBounds(frameSize.width*3/5, frameSize.height*12/15, frameSize.width/8, frameSize.height/15);;
		this.add(newGame);

		JButton exit = new JButton("Quitter");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		exit.setBounds(frameSize.width/10, frameSize.height*12/15, frameSize.width/8, frameSize.height/15);
		this.add(exit);

		//TODO : Bouton charger
	    this.setVisible(true);
	}

	//	Méthode pour récupérer les valeurs des paramètres et les afficher à l'écran
	public void setSettings(int settingToSet, int settingValue){
		if (settingToSet==0){
			this.lignes=settingValue;
			showLines.setText("Lignes : "+settingValue);
		} else if (settingToSet==1){
			this.colonnes=settingValue;
			showColumns.setText("Colonnes : "+settingValue);
		} else if (settingToSet==2){
			this.mines=settingValue;
			showMines.setText("Mines : "+settingValue);
		}
		this.sliderMines.setMaximum(this.colonnes*this.lignes);
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