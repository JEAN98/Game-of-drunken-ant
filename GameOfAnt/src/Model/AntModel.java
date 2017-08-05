
package Model;

import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

  //-1 In logicM1 is meant of Current position of Ant
    //-2 In logicM1 is meant of end position of matrix
  
public class AntModel implements AntOperations{
    private JLabel [][] uiMatrix;
    private int [][] logicM1;
    //private GameSettingsModel gameSettings;
    private int life;
    private int alcoholismLevel;
    private int sugarLevel;
    private int currentRow;
    private int currentColumn;
    private int passRow;
    private int passColumn;
    private int stepsbyAnt;
    private boolean sound;
    private boolean winner;

    public AntModel(JLabel[][] uiMatrix,int [][] logicM1) {
      this.logicM1 = logicM1;
      this.uiMatrix = uiMatrix;
      this.life = 100;
      currentRow = 0;
      currentColumn = 0;
    }

    public JLabel[][] getUiMatrix() {
        return uiMatrix;
    }

    public void setUiMatrix(JLabel[][] uiMatrix) {
        this.uiMatrix = uiMatrix;
    }
    
    public int[][] getLogicM1() {
        return logicM1;
    }

    public void setLogicM1(int large , int width) {
        logicM1 = new int[large][width];
    }

   private void saveStepsHistory(int i, int k){
       //Here we can save the pass steps by ant
        passRow = i ;
        passColumn = k;
   }
   
   private void saveCurrentCell(int i, int k){
    //Here we can save the current steps by ant
        passRow = i ;
        passColumn = k;
   }
   
    
    private int verifyObstacles(int i, int k) {
      //Here we can verify if the current cell have something
      if(logicM1[i][k] == 5){
           //JOptionPane.showMessageDialog(null, "Very good", "Sugar", JOptionPane.INFORMATION_MESSAGE);
            return 5;
        }
        if(logicM1[i][k] == 10)
        {
           //JOptionPane.showMessageDialog(null, "Bad", "Sugar with alchol", JOptionPane.INFORMATION_MESSAGE);
            return 10;
        }
        if(logicM1[i][k] == 15){
         //JOptionPane.showMessageDialog(null, "Bad", "Possion!!", JOptionPane.INFORMATION_MESSAGE);
            return 5;
        }
       return 0;
    }

    public boolean getSound() {
        return sound;
    }
    
    public boolean getWinner() {
        return winner;
    }

  
    @Override
    public JLabel[][] MoveRight() {
     for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify previous cell

                    //Verify if the next cell is the end
                    if (i == logicM1.length - 1 && k + 1 == logicM1[i].length - 1) {
                        //Verify previous cell
                        if (i != passRow || k + 1 != passColumn) {
                            logicM1[i][k + 1] = -1;//New current position
                            uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                            uiMatrix[i][k + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                            stepsbyAnt++; //Quantity of steps increased
                            saveStepsHistory(i, k);
                            saveCurrentCell(i, k+1);
                            winner = true;
                            sound = false;
                            return uiMatrix;
                        } 
                        else {
                            winner = false;
                            sound = true;
                             return uiMatrix;
                        }
                    } else {
                        //Verify if ant can move right
                        if (k + 1 < logicM1[i].length) {
                            if (i != passRow || k + 1 != passColumn) {
                              //   verifyObstacles(i, k+1);
                                logicM1[i][k + 1] = -1;//New current position
                                logicM1[i][k] = 0; //Empty position
                                uiMatrix[i][k + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                                uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                                stepsbyAnt++; //Quantity of steps increased
                                saveStepsHistory(i, k);
                                saveCurrentCell(i, k+1);
                                winner = false;
                                sound = false;
                                return uiMatrix;
                            }
                            else {
                                 winner = false;
                                 sound = true;
                                 return uiMatrix;
                            }

                        }
                    }
                }
            }
        }
     return uiMatrix;
    }

    @Override
    public JLabel[][] MoveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JLabel[][] MoveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JLabel[][] MoveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
