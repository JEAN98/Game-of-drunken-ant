
package gameofant;

import javax.swing.JFrame;


public class GameOfAnt {

  
    public static void main(String[] args) {
        //
        UI newView = new UI(48,48); //13 * 18 maximun
        newView.show(true);
        newView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
    
}
