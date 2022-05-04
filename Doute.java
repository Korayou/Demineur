import javax.swing.JComponent;
import java.awt.*;
 
public class Doute extends JComponent {
  private Dimension caseSize;
  public Doute(Dimension caseSize) {
    super();
    this.caseSize=caseSize;
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics chiffre = pinceau.create();
    Font font = new Font("Arial", Font.BOLD, caseSize.width*3/5);
    chiffre.setFont(font);
    chiffre.setColor(new Color(236, 0, 140));
    chiffre.drawString("?",caseSize.width*3/10,caseSize.height*4/5);
  }
}
