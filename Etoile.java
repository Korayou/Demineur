import javax.swing.JComponent;
import java.awt.*;
 
public class Etoile extends JComponent {
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics etoile = pinceau.create();
    int[] x={0,35,50,65,100,70,90,50,20,35};
    int[] y={40,40,0,40,40,60,100,80,100,80};
    etoile.setColor(Color.MAGENTA);
    etoile.fillPolygon(x,y,10);
  }
}