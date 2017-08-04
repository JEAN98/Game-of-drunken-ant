
package gameofant;

import javax.swing.JFrame;


public class GameOfAnt {

   static GameSettingsModel model = new GameSettingsModel("Jean", 13, 18, 5);
    public static void main(String[] args) {
        //
        UI newView = new UI(model); //13 * 18 maximun
        newView.setVisible(true);
        newView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newView.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
    }
    
}
