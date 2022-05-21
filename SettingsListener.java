import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsListener implements ChangeListener{
    private int settingToSet;
    private int settingValue;
    private FrameMenu menu;
    public SettingsListener(int settingToSet, FrameMenu menu){
        this.settingToSet=settingToSet;
        this.menu=menu;
    }
    public void stateChanged(ChangeEvent evenement) {
        JSlider slider = (JSlider) evenement.getSource();
        settingValue=slider.getValue();
        this.menu.setSettings(this.settingToSet, settingValue);
    }
    

}