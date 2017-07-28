
package gameofant;

import javax.swing.JFrame;


public class GameOfAnt {

  
    public static void main(String[] args) {
        //
        UI newView = new UI(10,10);
        newView.show(true);
        newView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
    
}
