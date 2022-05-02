import java.awt.event.*;
import java.awt.*;

public class Listener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent evenement){
		Case panel = (Case)evenement.getSource();
		if ((evenement.getButton() == MouseEvent.BUTTON1)&&(panel.getVisible()==false)){
        	panel.setVisible();
			panel.getCase();
			if (panel.getMine()==true){
				System.out.println("Perdu!");
			}
		}
		if (evenement.getButton() == MouseEvent.BUTTON3) {
        	panel.add(new Etoile(panel.getSize()), BorderLayout.CENTER);
			panel.updateUI();
			System.out.println("Marquage");
		}
	}        
	public void mouseEntered(MouseEvent evenement){
		//	System.out.println("mouseEntered");
	}         
	public void mouseExited(MouseEvent evenement){
		//	System.out.println("mouseExited");
	}        
	public void mousePressed(MouseEvent evenement){
		//	System.out.println("mousePressed");
	}      
	public void mouseReleased(MouseEvent evenement){
		//	System.out.println("mouseReleased");
	}

}
