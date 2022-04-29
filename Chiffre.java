import javax.swing.JComponent;
import java.awt.*;
 
public class Chiffre extends JComponent {
  private int entourage;
  private Dimension caseSize;
  public Chiffre(int entourage, Dimension caseSize) {
    super();
    this.entourage = entourage;
    this.caseSize=caseSize;
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics chiffre = pinceau.create();
    Font font = new Font("Arial", Font.BOLD, 40);
    chiffre.setFont(font);
    Color jaune = new Color(236, 214, 0);
    chiffre.setColor(jaune);
    chiffre.drawString(Integer.toString(this.entourage),caseSize.width/3,caseSize.height*8/10);
    System.out.println(""+caseSize);
  }
}
