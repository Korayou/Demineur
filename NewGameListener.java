import java.awt.event.*;
public class NewGameListener implements ActionListener{
    private FrameMenu menu;
    public NewGameListener(FrameMenu menu){
        this.menu=menu;
    }
    public void actionPerformed(ActionEvent event){
        int[] settings =this.menu.getSettings();
        new FrameJeu(settings[0], settings[1], settings[2]);
        this.menu.dispose();
    }
}
