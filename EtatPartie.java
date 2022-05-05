import javax.swing.*;
import java.awt.*;

public class EtatPartie extends JPanel {
	//	Définition du constructeur
	public EtatPartie(int mines) {
		super();

        //  On défini un style et une taille à la bannière
		this.setBackground( new Color(0, 236, 96));
		setMinesLeft(mines);
    }

	//	Méthode pour afficher le nombre de mines restantes
	protected void setMinesLeft(int minesLeft){
		this.add(new MineLeft(minesLeft,this.getSize()));
		//System.out.println("Mines restantes : "+minesLeft);
		this.repaint();
		this.updateUI();
	}
}