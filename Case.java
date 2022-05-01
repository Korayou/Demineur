import javax.swing.*;
import java.awt.*;

public class Case extends JPanel {
	private Dimension caseSize;
	private int entourage;
	private boolean visible;
	private boolean minee;
	private Listener listener;

	public Case(Dimension caseSize, boolean minee, int entourage) {
		super();
		this.entourage=entourage;
		this.visible=false;
		this.minee=minee;
		this.caseSize= caseSize;
				
		this.setSize(caseSize);
		
		this.listener = new Listener();
		this.addMouseListener(this.listener);
		
		GridLayout unique = new GridLayout(1,1);
		this.setLayout(unique);
	}

	public void setVisible(){
		this.visible=true;
		this.updateUI();
	}

	public boolean getVisible(){
		return this.visible;
	}

	public Case getCase(){
		if (this.visible == false) {
			this.setBackground(new Color(70, 70, 70));
		} else if (this.visible == true) {
			if (this.minee == true) {
				this.setBackground(new Color(236, 0, 140));	
			} else {
				this.setBackground(new Color(80, 80, 80));
				if (this.entourage>0){
					this.add(new Chiffre(entourage,caseSize));
				}
			}
		}
		return this;
	}

	public boolean getMine(){
		return this.minee;
	}
}
