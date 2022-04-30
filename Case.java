import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {
	private JPanel panel = new JPanel();
	private int entourage;
	private boolean visible;
	private boolean minee;
	private Listener listener;

	public Case(Dimension caseSize, boolean visible, boolean minee, int entourage) {
		super();
		this.entourage=entourage;
		this.visible=visible;
		this.minee=minee;
		this.panel.setSize(caseSize);
		this.listener = new Listener();
		panel.addMouseListener(listener);

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
				this.panel.add(new Chiffre(entourage,caseSize));	
			}
		}

	}

	public JPanel getCase() {
		return this.panel;
	}

}
