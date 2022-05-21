import java.awt.event.*;
public class MenuListener implements ActionListener{
    private FrameJeu fenetre;
    public MenuListener(FrameJeu fenetre){
        this.fenetre=fenetre;
    }
    public void actionPerformed(ActionEvent event){
        new FrameMenu();
        this.fenetre.dispose();
    }
}