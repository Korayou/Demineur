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
    Font font = new Font("Arial", Font.BOLD, banniereSize.width/50);
    chiffre.setFont(font);
    chiffre.setColor(new Color(0, 22, 236));
    chiffre.drawString("Nombre de mines restantes : "+Integer.toString(this.minesLeft),banniereSize.width/100,banniereSize.height*2/3);
  }
}
