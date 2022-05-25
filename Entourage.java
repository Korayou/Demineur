import javax.swing.JComponent;
import java.awt.*;
/**
* La classe <code>Entourage</code> hérite de JComponent
* Elle permet de recharger la case cliquée avec les modifications apportées par l'utilisateur
*  
* @version 1.1
* @author Kayyissa Haïssous
*/
public class Entourage extends JComponent {
  /**
  * nombre de mines autour de la case
  */
  private int entourage;
  /**
  * taille d'une case
  */
  private Dimension caseSize;

  /**
  * Constructeur qui ne sert qu'à la création des constantes
  * @param entourage le nombre de mines à afficher
  * @param caseSize la taille d'une case
  */
  public Entourage(int entourage, Dimension caseSize) {
    super();
    this.entourage = entourage;
    this.caseSize=caseSize;
  }
  /**
  * Méthode de JComponent réécrite pour afficher le nombre de mines
  * @param pinceau pinceau pour dessiner le JComponent
  */
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics chiffre = pinceau.create();
    Font font = new Font("Arial", Font.BOLD, caseSize.width*2/5);
    chiffre.setFont(font);
    chiffre.setColor(new Color(236, 214, 0));
    chiffre.drawString(Integer.toString(this.entourage),caseSize.width*2/5,caseSize.height*3/5);
  }
}
