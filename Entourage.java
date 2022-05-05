import javax.swing.JComponent;
import java.awt.*;
 
public class Entourage extends JComponent {
  private int entourage;
  private Dimension caseSize;
  public Entourage(int entourage, Dimension caseSize) {
    super();
    this.entourage = entourage;
    this.caseSize=caseSize;
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics chiffre = pinceau.create();
    Font font = new Font("Arial", Font.BOLD, caseSize.width*2/5);
    chiffre.setFont(font);
    chiffre.setColor(new Color(236, 214, 0));
    chiffre.drawString(Integer.toString(this.entourage),caseSize.width*2/5,caseSize.height*3/5);
  }
}
