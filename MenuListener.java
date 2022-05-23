import java.awt.event.*;
public class MenuListener implements ActionListener{
    private FrameJeu fenetre;
    private FrameMenu menu;
    public MenuListener(FrameJeu fenetre, FrameMenu menu){
        this.fenetre=fenetre;
        this.menu=menu;
    }
    public void actionPerformed(ActionEvent event){
        this.menu.setVisible(true);
        this.fenetre.dispose();
    }
}