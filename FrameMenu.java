import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;
/**
 * La classe <code>FrameMenu</code> correspond à une fenêtre de menu,
 * elle l'affiche et régit aux directives de l'utilisateur (Jouer, Charger, Quitter)
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class FrameMenu extends JFrame{
	/**
   	* Nombre de lignes pour la partie à lancer
	*/
	private int lignes;
	/**
   	* Nombre de colonnes pour la partie à lancer
	*/
	private int colonnes;
	/**
   	* Nombre de mines pour la partie à lancer
	*/
	private int mines;
	/**
   	* JSlider qui permet de choisir le nombre de lignes
	*/
	private JSlider sliderLignes;
	/**
   	* JSlider qui permet de choisir le nombre de colonnes
	*/
	private JSlider sliderColonnes;
	/**
   	* JSlider qui permet de choisir le nombre de mines
	*/
	private JSlider sliderMines;
	/**
   	* JLabel qui permet d'afficher en temps réel le nombre de lignes
	*/
	private JLabel showLines;
	/**
   	* JLabel qui permet d'afficher en temps réel le nombre de colonnes
	*/
	private JLabel showColumns;
	/**
   	* JLabel qui permet d'afficher en temps réel le nombre de mines
	*/
	private JLabel showMines;
	/**
   	* JButton pour charger une éventuelle sauvegarde
	*/
	private JButton charger;

	/**
    * Constructeur destiné à la création et l'affichage de la fenêtre de menu
	*/
	public FrameMenu() {
		super();

		// On récupère les dimensions de l'écran pour adapter la taille de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// On crée ensuite notre fenêtre
		this.setTitle("Démineur - Menu");
		Dimension frameSize = new Dimension (screenSize.width *2/5,screenSize.height * 2/3);
	    this.setSize(frameSize);
	    this.setLocation(screenSize.width * 3/10, screenSize.height * 1/6);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground( new Color(0, 236, 96));

		//	Ajout du titre
		JLabel titre = new JLabel("Démineur");
		titre.setFont(new Font("Rockwell", Font.PLAIN, 45));
		titre.setBounds((frameSize.width/3), frameSize.height/15,frameSize.width/2,frameSize.height*2/15);
		this.add(titre);
		
		//	On créer les Jsliders et les JLabel qui afficheront leur valeur
		this.sliderLignes = new JSlider(4,30,20);
		this.sliderColonnes = new JSlider(4,30,25);
		this.sliderMines = new JSlider(1,900, 50);

		sliderLignes.addChangeListener(new SettingsListener(0,this));
		sliderColonnes.addChangeListener(new SettingsListener(1,this));
		sliderMines.addChangeListener(new SettingsListener(2,this));

		this.lignes=sliderLignes.getValue();
		this.colonnes=sliderColonnes.getValue();
		this.mines=sliderMines.getValue();
		
		sliderLignes.setBounds(frameSize.width/3, frameSize.height*5/15, frameSize.width/3, frameSize.height/20);
		sliderColonnes.setBounds(frameSize.width/3, frameSize.height*7/15, frameSize.width/3, frameSize.height/20);
		sliderMines.setBounds(frameSize.width/3, frameSize.height*9/15, frameSize.width/3, frameSize.height/20);

		this.add(sliderLignes);
		this.add(sliderColonnes);
		this.add(sliderMines);

		this.showLines= new JLabel("Lignes : 20");
		this.showColumns= new JLabel("Colonnes : 25");
		this.showMines= new JLabel("Mines : 50");

		this.showLines.setBounds(frameSize.width/3, frameSize.height*4/15, frameSize.width/3, frameSize.height/20);
		this.showColumns.setBounds(frameSize.width/3, frameSize.height*6/15, frameSize.width/3, frameSize.height/20);
		this.showMines.setBounds(frameSize.width/3, frameSize.height*8/15, frameSize.width/3, frameSize.height/20);

		this.add(showLines);
		this.add(showColumns);
		this.add(showMines);
		
		//	On créer les boutons Jouer, quitter et si une save existe, charger
		JButton newGame = new JButton("Jouer");
		newGame.addActionListener(new NewGameListener(this));

		newGame.setBounds(frameSize.width*7/10, frameSize.height*12/15, frameSize.width/5, frameSize.height/15);;
		this.add(newGame);

		JButton exit = new JButton("Quitter");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		exit.setBounds(frameSize.width/10, frameSize.height*12/15, frameSize.width/5, frameSize.height/15);
		this.add(exit);
		
		File save = new File("Save.txt");
		if(save.exists()){
			charger = new JButton("Charger");
			charger.addActionListener(new Chargement(this));
			charger.setBounds(frameSize.width*4/10, frameSize.height*12/15, frameSize.width/5, frameSize.height/15);
			this.add(charger);
		}

		this.setResizable(false);
	    this.setVisible(true);
	}

	/**
    * Méthode pour récupérer les valeurs des paramètres et les afficher à l'écran
	* @param settingToSet Le paramètre qui doit être changé
	* @param settingValue La nouvelle valeur à donner au paramètre
    */
	public void setSettings(int settingToSet, int settingValue) {
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

	/**
	* Renvoie les valeurs des paramètres
   	* @return les paramètres pour une nouvelle partie
    */
	public int[] getSettings() {
		int[] settings = new int[3];
		settings[0]=this.lignes;
		settings[1]=this.colonnes;
		settings[2]=this.mines;
		return settings;
	}

	/**
    * Méthode pour supprimer le bouton charger après avoir chargé une partie
    */
	public void deleteCharger() {
		this.remove(this.charger);
	}
}