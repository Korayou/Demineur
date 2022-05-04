import javax.swing.*;
import java.awt.*;

public class EtatPartie extends JPanel {
	private ListenerCase listener;
	//	Définition du constructeur
	public EtatPartie(Grille grille, int mines) {
		super();

        //	On place un listener sur notre grille pour avoir accès à l'état de la partie
		this.listener = new ListenerCase();
		this.addMouseListener(this.listener);

        //  On défini un style et une taille à la bannière
        Dimension grilleSize= grille.getGrilleSize();
		Dimension banniereSize=new Dimension(grilleSize.width,grilleSize.height/8);
		this.setSize(banniereSize);
		this.setBackground( new Color(0, 236, 96));
    }
}