import javax.swing.JComponent;
import java.awt.*;
 
public class MineLeft extends JComponent {
  private int minesLeft;
  private Dimension banniereSize;
  public MineLeft(int minesLeft, Dimension banniereSize) {
    super();
    this.minesLeft = minesLeft;
    this.banniereSize=banniereSize;
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    this.setSize(banniereSize);
    Graphics chiffre = pinceau.create();
    Font font = new Font("Arial", Font.BOLD, banniereSize.width*1/10);
    chiffre.setFont(font);
    chiffre.setColor(new Color(0, 22, 236));
    chiffre.drawString(Integer.toString(this.minesLeft),banniereSize.width*1/5,banniereSize.height*2/3);
    System.out.println(this.getSize());
  }
}
