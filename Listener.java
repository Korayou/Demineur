import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Listener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent evenement){ 
		System.out.println("mouseClicked");
        JPanel lb = (JPanel)evenement.getSource();
        lb.setBackground(new Color(255, 255, 255));
	}        
	public void mouseEntered(MouseEvent evenement){
		System.out.println("mouseEntered");
	}         
	public void mouseExited(MouseEvent evenement){
		System.out.println("mouseExited");
	}        
	public void mousePressed(MouseEvent evenement){
		System.out.println("mousePressed");
	}      
	public void mouseReleased(MouseEvent evenement){
		System.out.println("mouseReleased");
	}

}
