import javax.swing.JComponent;
import java.awt.*;
 
public class MineLeft extends JComponent {
  private int minesLeft;
  private Dimension banniereSize;
  public MineLeft(int minesLeft, Dimension banniereSize) {
    super();
    this.minesLeft = minesLeft;
    this.banniereSize=banniereSize;
    System.out.println("Mines restantes : "+this.minesLeft);
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics chiffre = pinceau.create();
    //Font font = new Font("Arial", Font.BOLD, banniereSize.width*1/10);
    //chiffre.setFont(font);
    //chiffre.setColor(new Color(236, 214, 0));
    //chiffre.drawString(Integer.toString(this.minesLeft),banniereSize.width*2/5,banniereSize.height/2);
    //chiffre.drawString("ALED",banniereSize.width/2,banniereSize.height/2);
    chiffre.setColor(Color.black);
    chiffre.fillRect(10, 10, 200, 100);
  }
}
