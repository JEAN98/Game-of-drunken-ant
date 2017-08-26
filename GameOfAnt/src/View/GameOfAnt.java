
package View;

import Model.AntModel;
import Model.GameModel;
import Model.GameSettingsModel;
import View.UI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;


public class GameOfAnt {

   public static GameSettingsModel model1;
   public static AntModel antObject;  
   public static GameModel gameObject;
   
   
    public static void main(String[] args) throws IOException {
        //
    
        Settings settings = new Settings(false);
        
        settings.setVisible(true);
        settings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settings.setExtendedState(JFrame.MAXIMIZED_BOTH);      
        
    
                
        
//     newView.setVisible(true);
//      newView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//       newView.setExtendedState(JFrame.MAXIMIZED_BOTH);
//      

    }

}
