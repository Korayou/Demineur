import java.awt.event.*;
public class SaveAndCloseListener implements WindowListener{
    private Grille grille;
    public SaveAndCloseListener(Grille grille){
        this.grille=grille;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        SaveManager saveManager = new SaveManager();
        saveManager.save(this.grille, "Save.txt");
        SaveManager.SaveData donnees = saveManager.load("Save.txt");
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
