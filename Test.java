import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        // On récupère les dimensions de l'écran pour adapter la taille de notre fenêtre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth = screenSize.width * 2/3;
		int frameHeight = screenSize.height * 2/3;
		int frameLocation[]={screenSize.width * 1/6, screenSize.height * 1/6};

		// On crée ensuite notre fenêtre
		JFrame fenetre = new JFrame("Démineur - Menu");
	    fenetre.setSize(frameWidth,frameHeight);
	    fenetre.setLocation(frameLocation[0],frameLocation[1]);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        fenetre.setVisible(true); 
        }
}
