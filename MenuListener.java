import java.awt.event.*;
/**
 * La classe <code>MenuListener</code> implémente l'interface ActionListener
 * ferme le jeu et réouvre la fenêtre de menu
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class MenuListener implements ActionListener{
    /**
    * fenetre de Jeu
    */
    private FrameJeu fenetre;
    /**
    * fenetre de Menu
    */
    private FrameMenu menu;

    /**
    * Constructeur qui ne sert qu'à la création de constantes
    * @param fenetre la fenêtre de jeu
    * @param menu la fenêtre de menu
    */
    public MenuListener(FrameJeu fenetre, FrameMenu menu){
        this.fenetre=fenetre;
        this.menu=menu;
    }
    
     /**
    * Méthode qui doit être rédigée
    * @param event l'évenement
    */
    @Override
    public void actionPerformed(ActionEvent event){
        this.menu.setVisible(true);
        WindowListener[] wl= this.fenetre.getWindowListeners();
        this.fenetre.removeWindowListener(wl[0]);
        this.fenetre.dispose();
    }
}