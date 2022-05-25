import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * La classe <code>SettingsListener</code> implémente l'interface ChangeListener
 * et permet de connaître la valeur des paramètres
 *  
 * @version 1.1
 * @author Kayyissa Haïssous
 */
public class SettingsListener implements ChangeListener{
    private int settingToSet;
    private int settingValue;
    private FrameMenu menu;
    public SettingsListener(int settingToSet, FrameMenu menu){
        this.settingToSet=settingToSet;
        this.menu=menu;
    }

    /**
    * Méthode qui doit être rédigée
    * @param evenement l'évenement sur le JSlider
    */
    @Override
    public void stateChanged(ChangeEvent evenement) {
        JSlider slider = (JSlider) evenement.getSource();
        settingValue=slider.getValue();
        this.menu.setSettings(this.settingToSet, settingValue);
    }
    

}