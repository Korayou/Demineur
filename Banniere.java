import javax.swing.*;
import java.awt.*;

public class Banniere extends JPanel {
	//	Définition du constructeur
	public Banniere(int mines) {
		super();

        //  On défini un style à la bannière
		this.setBackground( new Color(0, 236, 96));
		
		// TODO : Bouton sauver et quitter
	}

	//	Méthode pour afficher le nombre de mines restantes
	public void setMinesLeft(int minesLeft){
		this.removeAll();
		this.add(new MineLeft(minesLeft,this.getSize()));
		this.repaint();
		this.updateUI();
	}
}