import javax.swing.*;
import java.awt.*;
/**
 * La classe <code>Banniere</code> affiche l'état de la partie,
 * gère la sauvegarde la victoire et la défaite
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class Banniere extends JPanel {
	/**
    * fenetre de Jeu
    */
	private FrameJeu fenetre;
	/**
    * fenetre du menu lié
    */
	private FrameMenu menu;
	/**
    * Bouton qui permet de sauver et quitter
    */
	private JButton save;
	/**
    * le JLabel qui affiche le nombre de mines restantes
    */
	private JLabel mines;
	
	/**
    * Constructeur qui sert à la création de la bannière et l'ajout du bouton sauver et quitter
    * @param mines le nombre de mines dans la partie
	* @param fenetre la fenêtre de jeu
	* @param menu la fenêtre de menu rattachée
	* @param grille la grille de jeu
    */
	public Banniere(int mines, FrameJeu fenetre, FrameMenu menu, Grille grille) {
		super();
		this.fenetre=fenetre;
		this.menu=menu;
		this.setSize(grille.getWidth(),grille.getHeight()/8);

        //  On défini un style à la bannière
		this.setBackground(new Color(0, 236, 96));
		this.setLayout(new BorderLayout());

		//	Compteur de mines restantes
		this.mines= new JLabel();
		this.add(this.mines, BorderLayout.NORTH);

		//	Bouton pour sauver et quitter
		this.save = new JButton("Sauver et quitter");
		save.addActionListener(new SaveListener(grille, fenetre));
		this.add(this.save, BorderLayout.EAST);
	}

	/**
    * Méthode pour afficher le nombre de mines restantes
    * @param minesLeft le nombre de mines restantes
    */
	public void setMinesLeft(int minesLeft) {
		this.mines.setText("Mines restantes : "+Integer.toString(minesLeft));
		this.repaint();
	}

	/**
    * Méthode pour indiquer au joueur sa Victoire
    */
	public void setVictoire() {
		remove(this.save);
		JLabel victoire = new JLabel("Victoire !   Retour au menu...");
		victoire.setForeground(new Color(0, 22, 236));
		victoire.setFont(new Font("Arial", Font.PLAIN, 30));
		this.add(victoire, BorderLayout.CENTER);
  		Timer timerMenu = new Timer(7000, new MenuListener(this.fenetre, this.menu));
  		timerMenu.setRepeats(false);
		timerMenu.start();
	}

	/**
    * Méthode pour indiquer au joueur sa Défaite
    */
	public void setDefaite() {
		remove(this.save);
		JLabel defaite = new JLabel("Défaite !   Retour au menu...");
		defaite.setForeground(new Color(0, 22, 236));
		defaite.setFont(new Font("Arial", Font.PLAIN, 30));
		this.add(defaite, BorderLayout.CENTER);
		Timer timerMenu = new Timer(7000, new MenuListener(this.fenetre, this.menu));
  		timerMenu.setRepeats(false);
  		timerMenu.start();
	}
}