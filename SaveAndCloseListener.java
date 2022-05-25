import java.awt.event.*;
/**
* La classe <code>SaveAndCloseListener</code> implémente WindowListener
* elle genère un tableau de case et une Bannière
* @version 1.1
* @author Kayyissa Haïssous
*/
public class SaveAndCloseListener implements WindowListener {
    /**
    *grille de jeu
    */ 
    private Grille grille;

    /**
    * Constructeur qui ne sert qu'à la création de la constante grille
    * @param grille la grille de Jeu
    */
    public SaveAndCloseListener(Grille grille) {
        this.grille=grille;
    }

    /**
    * Méthode à écrire qui n'intervient pas 
    * @param e L'évenement sur la fenêtre
    */
    @Override
    public void windowOpened(WindowEvent e) {
    }

    /**
    * Méthode à écrire qui sert à sauvegarder la partie à la fermeture de la fenêtre
    * @param e L'évenement sur la fenêtre
    */
    @Override
    public void windowClosing(WindowEvent e) {
        SaveManager saveManager = new SaveManager();
        saveManager.save(this.grille, "Save.txt");
        
    }

    /**
    * Méthode à écrire qui n'intervient pas 
    * @param e L'évenement sur la fenêtre
    */
    @Override
    public void windowClosed(WindowEvent e) {
    }

    /**
    * Méthode à écrire qui n'intervient pas 
    * @param e L'évenement sur la fenêtre
    */
    @Override
    public void windowIconified(WindowEvent e) {
    }

    /**
    * Méthode à écrire qui n'intervient pas 
    * @param e L'évenement sur la fenêtre
    */
    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    /**
    * Méthode à écrire qui n'intervient pas 
    * @param e L'évenement sur la fenêtre
    */
    @Override
    public void windowActivated(WindowEvent e) {
    }

    /**
    * Méthode à écrire qui n'intervient pas 
    * @param e L'évenement sur la fenêtre
    */
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
