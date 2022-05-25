import java.awt.event.*;

public class ListenerCase implements MouseListener {
	private int marquage = 0;

	@Override
	// Méthode qui va servir à détecter le click de la souris
	public void mouseClicked(MouseEvent evenement) {
		Case panel = (Case) evenement.getSource();
		if (panel.getEnJeu()) {
			// Si le joueur clique gauche, on tente de révéler la case
			if ((evenement.getButton() == MouseEvent.BUTTON1)&&(!panel.getVisible())&&(!panel.getReperee())){
				panel.setVisible();
			}
			// Si le joueur clique droit, la case sera marquée
			if ((evenement.getButton() == MouseEvent.BUTTON3) && (panel.getVisible() == false)) {
				// Au premier click, on place une étoile pour indiquer la présence d'une mine
				if (this.marquage == 0) {
					panel.setReperee(true,1);
					this.marquage = 1;
				}
				// Au second, on met un point d'interrogation en cas de soupçon pour aider à la
				// réflexion
				else if (this.marquage == 1) {
					panel.removeAll();
					panel.setReperee(true, 2);
					this.marquage = 2;
				}
				// Au troisième click on efface tout marquage
				else if (this.marquage == 2) {
					panel.setReperee(false,0);
					panel.removeAll();
					this.marquage = 0;
				}
				// On met à jour l'affichage de la case cliquée
				panel.updateUI();
			}
		}
	}

	// Les autres méthodes de l'interface n'interviennent pas
	public void mouseEntered(MouseEvent evenement) {
	}

	public void mouseExited(MouseEvent evenement) {
	}

	public void mousePressed(MouseEvent evenement) {
	}

	public void mouseReleased(MouseEvent evenement) {
	}

}
