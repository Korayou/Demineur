import javax.swing.JComponent;
import java.awt.*;
 
public class Fin extends JComponent {
  private String message;
  private Dimension banniereSize;
  public Fin(String message, Dimension banniereSize) {
    super();
    this.message = message;
    this.banniereSize=banniereSize;
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    this.setSize(banniereSize);
    Graphics chiffre = pinceau.create();
    Font font = new Font("Arial", Font.BOLD, banniereSize.width/50);
    chiffre.setFont(font);
    chiffre.setColor(new Color(0, 22, 236));
    chiffre.drawString(message,banniereSize.width/100,banniereSize.height*2/3);
  }
}
