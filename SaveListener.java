import java.awt.event.*;
public class SaveListener implements ActionListener {
    private Grille grille;
    private FrameJeu fenetre;
    public SaveListener(Grille grille, FrameJeu fenetre){
        this.grille=grille;
        this.fenetre=fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent event){
        SaveManager saveManager = new SaveManager();
        saveManager.save(this.grille, "Save.txt");
        SaveManager.SaveData donnees = saveManager.load("Save.txt");
        this.fenetre.dispose();
    }
}
