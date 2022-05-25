import java.awt.event.*;
public class Chargement implements ActionListener {
    private FrameMenu menu;
    public Chargement(FrameMenu menu){
        this.menu=menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.menu.setVisible(false);
        this.menu.deleteCharger();
        SaveManager saveManager = new SaveManager();
        SaveManager.SaveData donnees = saveManager.load("Save.txt");

        new FrameJeu((int) donnees.taille.getHeight(),(int) donnees.taille.getWidth(), donnees,(int) donnees.mines, this.menu);
    }
    
}
