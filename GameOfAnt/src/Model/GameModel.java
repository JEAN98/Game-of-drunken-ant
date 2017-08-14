
package Model;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class GameModel {
    private JLabel [][] uiMatrix;
    private int [][] logicM1;
    private int large;
    private int width;

    public GameModel(int large, int width) {
        this.large = large;
        this.width = width;
    }

    public JLabel[][] getUiMatrix() {
        return uiMatrix;
    }

    public void setUiMatrix() {
        this.uiMatrix = new JLabel[large][width];
        creationOfMatrix();
    }

    public int[][] getLogicM1() {
        return logicM1;
    }

    public void setLogicM1(int quantityObstacles) {
        this.logicM1 = new int[large][width];
        creationOfLogicMatrix();
        setObstacles(quantityObstacles);
    }
    
    public void setCurrentLogicM1(int [][] oldLogicMatrix){
        this.logicM1 = oldLogicMatrix;
        creationOldMatrix();
    }
    //Old game
    public void creationOldMatrix(){
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.black, 1);
        int x=45;//Large
        int y = 50; //width
       
           for (int i = 0; i < uiMatrix.length; i++) {            
               for (int k = 0; k < uiMatrix[i].length; k++) {
                   
                   uiMatrix[i][k] = new JLabel();
                   uiMatrix[i][k].setBorder(border);                  
                   uiMatrix[i][k].setBounds(x,y,45,50);
                   uiMatrix[i][k].setText("");      
                   if (logicM1[i][k] == -1) {
                       //show ant in the current cell
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));      
                   } 
                   else {
                       //The rest of the others space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                   }                   
                   x+=45;
               }
            x = 45;
            y += 50;
        }
    }
    //New game
     private void creationOfMatrix(){
       //minimum of large is 7 and Maximiun 13 of large
       //Maximiun of width is 7 and Maximiun 18 of width
      javax.swing.border.Border border = BorderFactory.createLineBorder(Color.black, 1);
        int x=45;//Large
        int y = 50; //width
       
           for (int i = 0; i < uiMatrix.length; i++) {            
               for (int k = 0; k < uiMatrix[i].length; k++) {
                   
                   uiMatrix[i][k] = new JLabel();
                   uiMatrix[i][k].setBorder(border);                  
                   uiMatrix[i][k].setBounds(x,y,45,50);
                   uiMatrix[i][k].setText("");      
                   if (i == 0 && k == 0) {
                       //First space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));      
                   } 
                   else {
                       //The rest of the others space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                   }                   
                   x+=45;
               }
            x = 45;
            y += 50;
        }
    }
    private void creationOfLogicMatrix() {
         //-1 In logicM1 is meant of Current position of Ant
        //-2 In logicM1 is meant of end position of matrix
        for (int i = 0; i < logicM1.length; i++) {
            for (int k = 0; k < logicM1[i].length; k++) {

                if (i == 0 && k == 0) {
                    logicM1[i][k] = -1; //Current position of Ant( image of Ant)
                } else if (i == logicM1.length - 1 && k == logicM1[i].length - 1) {
                    logicM1[i][k] = -2; //End cell  (Image of colony)
                    //End space
                } 
                //In this part we are going to insert the obstacles
                else {
                 logicM1[i][k] = 0;
                }
            }
        }
    }
    private void setObstacles(int obstacleQuantity){
        //Here we can create with random the obstacles inside of matrix
        //0 In logicM1 is meant of The cell is empty
        //5 In logicM1 is meant of sugar 
        //10 In logicM1 is meant of sugar with wine
        //15 In logicM1 is meant of sugar with poison
        int cont = 0;
        int rowsQuantity = (large -1);
        int columnsQuantity = (width -1);
        int i = (int) (Math.random() * rowsQuantity);
        int k = (int) (Math.random() * columnsQuantity);
        int obstaclesQuantity = 0;
        obstaclesQuantity = (int)obstacleQuantity*3;
        
        while(cont < obstaclesQuantity){
                
                while(logicM1[i][k] != 0 ){
                    i = (int) (Math.random() * rowsQuantity);
                    k = (int) (Math.random() * columnsQuantity);
                }
                logicM1[i][k] = 5;
                //we are sending a sugar inside of logicM1;
               // sugarCont++;
                cont++;
                
                
                while (logicM1[i][k] != 0) {
                   i = (int) (Math.random() * rowsQuantity);
                   k = (int) (Math.random() * columnsQuantity);
                }
                logicM1[i][k] = 10;
               // we are sending a sugar with wine inside of logicM1;
               // sugarWineCont++;
                cont++;
           
           
                while (logicM1[i][k] != 0) {
                    i = (int) (Math.random() * rowsQuantity);
                    k = (int) (Math.random() * columnsQuantity);
                }
                logicM1[i][k] = 15;
               // we are sending a possion inside of logicM1;
               //possionCont++;
                cont++; 
        }
    }
    
}
