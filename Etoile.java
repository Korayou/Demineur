import javax.swing.JComponent;
import java.awt.*;
 

// Création d'un Jcomponent Etoile, qui sert pour le marquage des mines
public class Etoile extends JComponent {
  private Image etoileImage;
  private Dimension caseSize;
  public Etoile(Dimension caseSize) {
    super();
    this.caseSize=caseSize;
    this.etoileImage = Toolkit.getDefaultToolkit().getImage("etoile.png");
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics etoile = pinceau.create();
    etoile.drawImage(this.etoileImage,this.caseSize.width*1/20,this.caseSize.height*1/10,this.caseSize.width*9/10,this.caseSize.height*8/10,this);
  }
}