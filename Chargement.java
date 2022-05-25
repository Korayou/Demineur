import java.awt.event.*;
/**
 * La classe <code>Chargement</code> implémente l'interface ActionListener
 * elle permet de lancer le chargement d'une partie sauvegardée
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class Chargement implements ActionListener {
    /**
    * Fenetre du menu.
    */
    private FrameMenu menu;

    /**
    * Constructeur qui ne sert qu'à la création de la constante menu
    * @param menu la fenêtre de menu
    */
    public Chargement(FrameMenu menu){
        this.menu=menu;
    }

    /**
    * Méthode qui doit être rédigée
    * @param e l'évenement sur le bouton
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.menu.setVisible(false);
        this.menu.deleteCharger();
        SaveManager saveManager = new SaveManager();
        SaveManager.SaveData donnees = saveManager.load("Save.txt");

        new FrameJeu((int) donnees.taille.getHeight(),(int) donnees.taille.getWidth(), donnees,(int) donnees.mines, this.menu);
    }
    
}
