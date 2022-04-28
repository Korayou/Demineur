import javax.swing.*;
import java.awt.*;

public class Case extends JComponent {
	private JPanel panel = new JPanel();
	private int entourage=0;
	private boolean visible=false;
	private boolean minee=false;

	public Case(Dimension caseSize, boolean visible, boolean minee, int entourage) {
		super();
		this.panel.setSize(caseSize);
		this.entourage=entourage;
		this.visible=visible;
		this.minee=minee;

		if (this.visible == false) {
			Color gray2 = new Color(70, 70, 70);
			this.panel.setBackground(gray2);
		} else if (this.visible == true) {
			Color gray1 = new Color(80, 80, 80);
			this.panel.setBackground(gray1);
			if (this.minee == true) {
				Color rose = new Color(236, 0, 140);
				this.panel.setBackground(rose);
			} else if (this.entourage>0){
				System.out.println(""+ this.entourage);
			}
		}

	}

	@Override
  	protected void paintComponent(Graphics pinceau) {
		System.out.println("coucou");
  	}

	public JPanel getCase() {
		return this.panel;
	}

}
