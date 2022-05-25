import javax.swing.JComponent;
import java.awt.*;
/**
* La classe <code>Doute</code> hérite de JComponent
* Création d'un point d'interrogation, qui sert pour le marquage des cases
*  
* @version 1.1
* @author Kayyissa Haïssous
*/
public class Doute extends JComponent {
  /**
  * taille d'une case
  */
  private Dimension caseSize;
  /**
  * Constructeur qui ne sert qu'à la création de la constante caseSize
  * @param caseSize la taille d'une case
  */
  public Doute(Dimension caseSize) {
    super();
    this.caseSize=caseSize;
  }
  /**
  * Méthode de JComponent réécrite pour afficher une étoile
  * @param pinceau pinceau pour dessiner le JComponent
  */
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics chiffre = pinceau.create();
    Font font = new Font("Arial", Font.BOLD, caseSize.width*3/5);
    chiffre.setFont(font);
    chiffre.setColor(new Color(236, 0, 140));
    chiffre.drawString("?",caseSize.width*3/10,caseSize.height*4/5);
  }
}
