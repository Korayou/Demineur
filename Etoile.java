import javax.swing.JComponent;
import java.awt.*;
/**
* La classe <code>Etoile</code> hérite de JComponent
* Création d'une Etoile, qui sert pour le marquage des cases
*  
* @version 1.1
* @author Kayyissa Haïssous
*/
public class Etoile extends JComponent {
  /**
  *Image de l'étoile à dessiner
  */
  private Image etoileImage;
  /**
  * taille d'une case
  */
  private Dimension caseSize;

  /**
  * Constructeur qui sert à la création de la constante caseSize et récupère l'image
  * @param caseSize la taille d'une case
  */
  public Etoile(Dimension caseSize) {
    super();
    this.caseSize=caseSize;
    this.etoileImage = Toolkit.getDefaultToolkit().getImage("etoile.png");
  }

  /**
  * Méthode de JComponent réécrite pour afficher une étoile
  * @param pinceau pinceau pour dessiner le JComponent
  */
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics etoile = pinceau.create();
    etoile.drawImage(this.etoileImage,this.caseSize.width*1/20,this.caseSize.height*1/10,this.caseSize.width*9/10,this.caseSize.height*8/10,this);
  }
}