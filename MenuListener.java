import java.awt.event.*;
public class MenuListener implements ActionListener{
    private FrameJeu fenetre;
    private FrameMenu menu;
    public MenuListener(FrameJeu fenetre, FrameMenu menu){
        this.fenetre=fenetre;
        this.menu=menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        this.menu.setVisible(true);
        WindowListener[] wl= this.fenetre.getWindowListeners();
        this.fenetre.removeWindowListener(wl[0]);
        this.fenetre.dispose();
    }
}