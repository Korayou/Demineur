import java.awt.event.*;
/**
 * La classe <code>NewGameListener</code> implémente l'interface ActionListener
 * et permet de lancer une nouvelle partie.
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class NewGameListener implements ActionListener{
    /**
    * Fenetre du menu.
    */
    private FrameMenu menu;

    /**
    * Constructeur qui ne sert qu'à la création de la constante menu
    * @param menu la fenêtre de menu
    */
    public NewGameListener(FrameMenu menu){
        this.menu=menu;
    }

    /**
    * Méthode qui doit être rédigée
    * @param event l'évenement sur le bouton
    */
    @Override
    public void actionPerformed(ActionEvent event){
        int[] settings =this.menu.getSettings();
        new FrameJeu(settings[0], settings[1], settings[2], this.menu);
        this.menu.dispose();
    }
}
