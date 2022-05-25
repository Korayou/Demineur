import java.awt.event.*;
/**
 * La classe <code>MenuListener</code> implémente l'interface ActionListener
 * ferme le jeu et sauvegarde la partie en cours dans le fichier Save.txt
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class SaveListener implements ActionListener {
    /**
    * Grille de Jeu
    */
    private Grille grille;
    /**
    * fenetre de Jeu
    */
    private FrameJeu fenetre;

    /**
    * Constructeur qui ne sert qu'à la création de constantes
    * @param grille la grille de Jeu
    * @param fenetre la fenêtre de jeu
    */
    public SaveListener(Grille grille, FrameJeu fenetre){
        this.grille=grille;
        this.fenetre=fenetre;
    }

    /**
    * Méthode qui doit être rédigée
    * @param event l'évenement sur le Bouton
    */
    @Override
    public void actionPerformed(ActionEvent event){
        SaveManager saveManager = new SaveManager();
        saveManager.save(this.grille, "Save.txt");
        this.fenetre.dispose();
    }
}
