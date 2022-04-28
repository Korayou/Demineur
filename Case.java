import javax.swing.*;
import java.awt.*;


public class Case extends JComponent{
	private JPanel panel= new JPanel();

       public Case (Dimension caseSize, boolean visible, boolean minee){
		   super();
		   this.panel.setSize(caseSize);
		   if (visible==false){
				Color gray2 = new Color(70,70,70);
				this.panel.setBackground(gray2);
		   } else if (visible==true){
				Color gray1 = new Color(80,80,80);
				this.panel.setBackground(gray1);
				if (minee==true){
					Color rose = new Color(236,0,140);
					this.panel.setBackground(rose);
					System.out.println("J'ai miné ! ");
				}
		   }
		   
	   }

	   public JPanel getCase(){
			return this.panel;
	   }

	   
}
