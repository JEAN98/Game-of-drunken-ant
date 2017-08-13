
package View;

import Model.GameSettingsModel;
import View.UI;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFrame;


public class GameOfAnt {

   public static GameSettingsModel model1;
   
    public static void main(String[] args) {
        //
        model1 = new GameSettingsModel("Jean", 13, 18, 5);
        UI newView = new UI(model1); //13 * 18 maximun
        Settings settings = new Settings();
        
        settings.setVisible(true);
        settings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settings.setExtendedState(JFrame.MAXIMIZED_BOTH);       
        
//     newView.setVisible(true);
//      newView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//       newView.setExtendedState(JFrame.MAXIMIZED_BOTH);
//      

    }

}
