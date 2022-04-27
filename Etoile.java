import javax.swing.JComponent;
import java.awt.*;
 

// Création d'un Jcomponent Etoile, qui sert pour le marquage des mines
public class Etoile extends JComponent {
  private Image etoileImage;
  public Etoile() {
    super();
    this.etoileImage = Toolkit.getDefaultToolkit().getImage("etoile.png");
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics etoile = pinceau.create();
    etoile.drawImage(this.etoileImage,5,10,90,80,this);
  }
}