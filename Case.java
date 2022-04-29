import javax.swing.*;
import java.awt.*;

public class Case extends JComponent {
	private JPanel panel = new JPanel();
	private int entourage;
	private boolean visible;
	private boolean minee;

	public Case(Dimension caseSize, boolean visible, boolean minee, int entourage) {
		super();
		this.entourage=entourage;
		this.visible=visible;
		this.minee=minee;
		this.panel.setSize(caseSize);

		GridLayout unique = new GridLayout(1,1);
		this.panel.setLayout(unique);

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
				this.panel.add(new Chiffre(entourage,caseSize));	
			}
		}

	}

	public JPanel getCase() {
		return this.panel;
	}

}
