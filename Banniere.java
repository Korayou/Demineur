import javax.swing.*;
import java.awt.*;

public class Banniere extends JPanel {
	private FrameJeu fenetre;
	private FrameMenu menu;
	private JButton save;
	//	Définition du constructeur
	public Banniere(int mines, FrameJeu fenetre, FrameMenu menu, Grille grille) {
		super();
		this.fenetre=fenetre;
		this.menu=menu;
		this.setSize(grille.getWidth(),grille.getHeight()/8);

        //  On défini un style à la bannière
		this.setBackground(new Color(0, 236, 96));
		this.setLayout(new BorderLayout());

		//	Bouton pour sauver et quitter
		this.save = new JButton("Sauver et quitter");
		save.addActionListener(new SaveListener(grille, fenetre));
		this.add(this.save, BorderLayout.EAST);
	}

	//	Méthode pour afficher le nombre de mines restantes
	public void setMinesLeft(int minesLeft) {
		JLabel mines = new JLabel("Mines restantes : "+Integer.toString(minesLeft));
		this.add(mines, BorderLayout.NORTH);
		this.repaint();
	}

	//	Méthode pour indiquer au joueur sa Victoire
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

	//	Méthode pour indiquer au joueur sa Défaite
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