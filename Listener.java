import java.awt.event.*;
import java.awt.*;

public class Listener implements MouseListener{
	private int marquage=0;

    @Override
    public void mouseClicked(MouseEvent evenement){
		Case panel = (Case)evenement.getSource();
		if ((evenement.getButton() == MouseEvent.BUTTON1)&&(panel.getVisible()==false)&&(this.marquage==0)){
        	panel.setVisible();
			if (panel.getMine()==true){
				System.out.println("Perdu!");
			}
		}
		if (evenement.getButton() == MouseEvent.BUTTON3) {
        	if (this.marquage==0){
				panel.add(new Etoile(panel.getSize()), BorderLayout.CENTER);
				this.marquage=1;
			}
			else if (this.marquage==1){
				panel.removeAll();
				panel.add(new Sus(panel.getSize()), BorderLayout.CENTER);
				this.marquage=2;
			}
			else if (this.marquage==2){
				panel.removeAll();
				this.marquage=0;
			}
			panel.updateUI();

			System.out.println(""+this.marquage);
		}
	}        
	public void mouseEntered(MouseEvent evenement){
	}         
	public void mouseExited(MouseEvent evenement){
	}        
	public void mousePressed(MouseEvent evenement){
	}      
	public void mouseReleased(MouseEvent evenement){
	}

}
