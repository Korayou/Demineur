import java.awt.event.*;
public class Chargement implements ActionListener {
    private FrameMenu menu;
    public Chargement(FrameMenu menu){
        this.menu=menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.menu.dispose();
        SaveManager saveManager = new SaveManager();
        SaveManager.SaveData donnees = saveManager.load("Save.txt");
        System.out.println(donnees);
    }
    
}
