import java.awt.event.*;
/**
* La classe <code>ListenerCase</code> implémente l'interface MouseListener
* Elle permet de recharger la case cliquée avec les modifications apportées par l'utilisateur
*  
* @version 1.1
* @author Kayyissa Haïssous
*/
public class ListenerCase implements MouseListener {
	/**
 	* nombre représentant le marquage sur la case
 	*/
	private int marquage = 0;

	@Override
	/**
 	* Méthode à écrire qui réagit au click de la souris
 	* @param evenement L'évenement de la souris
 	*/
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

	/**
 	* Méthode à écrire qui n'intervient pas 
 	* @param evenement L'évenement de la souris
 	*/
	public void mouseEntered(MouseEvent evenement) {
	}
	/**
 	* Méthode à écrire qui n'intervient pas 
 	* @param evenement L'évenement de la souris
 	*/
	public void mouseExited(MouseEvent evenement) {
	}
	/**
 	* Méthode à écrire qui n'intervient pas 
 	* @param evenement L'évenement de la souris
 	*/
	public void mousePressed(MouseEvent evenement) {
	}
	/**
 	* Méthode à écrire qui n'intervient pas 
 	* @param evenement L'évenement de la souris
 	*/
	public void mouseReleased(MouseEvent evenement) {
	}

}
