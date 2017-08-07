
package Model;

import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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

    public void setLogicM1(int[][] logicM1) {
        this.logicM1 = logicM1;
    }
    
    private ImageIcon verifyObstacles(int i, int k) {
      //Here we can verify if the current cell have something
      if(logicM1[i][k] == 5){
           //JOptionPane.showMessageDialog(null, "Very good", "Sugar", JOptionPane.INFORMATION_MESSAGE);
            return new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg"));
        }
        if(logicM1[i][k] == 10)
        {
           //JOptionPane.showMessageDialog(null, "Bad", "Sugar with alchol", JOptionPane.INFORMATION_MESSAGE);
            return new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg"));
        }
        if(logicM1[i][k] == 15){
         //JOptionPane.showMessageDialog(null, "Bad", "Possion!!", JOptionPane.INFORMATION_MESSAGE);
            return new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg"));
        }
       return null;
    }

    public boolean getSound() {
        return sound;
    }
    
    public boolean getWinner() {
        return winner;
    }
    
    private void updateMatrix(int currentI,int currentK, int i ,int k,ImageIcon icon){
        //Here we can update logic matrix and fisical matrix
        logicM1[currentI][currentK] = -1;
        logicM1[i][k] = 0;
        uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
        stepsbyAnt++;
        
        if(icon!=null)
            uiMatrix[i][k+1].setIcon(icon);
        else
            uiMatrix[currentI][currentK].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
        
        currentRow = currentI; // save current row
        currentColumn = currentK; // save current column
        passRow = i; //save the previous row 
        passColumn = k; //save  previous column
    
    }
  
    @Override
    public JLabel[][] MoveRight() {
     for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                     //Verify if the next cell is the end
                    if (i == logicM1.length - 1 && k + 1 == logicM1[i].length - 1) {
                        //Verify previous cell
                        if (i != passRow || k + 1 != passColumn) {
                            ImageIcon icon = verifyObstacles(i, k+1);
                            if ( icon != null) {
                               JOptionPane.showMessageDialog(null, "Bad OR GOOD", "SomeThing", JOptionPane.INFORMATION_MESSAGE);
                                updateMatrix(i, k+1, i, k, icon);
                                return uiMatrix;
                            } else {
                                updateMatrix(i, k+1, i, k,null);
                                winner = true;
                                sound = false;
                                return uiMatrix;
                            }
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
                                ImageIcon icon = verifyObstacles(i, k + 1);
                                if (icon != null) {
                                    JOptionPane.showMessageDialog(null, "Bad OR GOOD", "SomeThing", JOptionPane.INFORMATION_MESSAGE);
                                    updateMatrix(i, k+1, i, k, icon);
                                    return uiMatrix;
                                } else {
                                    updateMatrix(i, k+1, i, k,null);
                                    winner = false;
                                    sound = false;
                                    return uiMatrix;
                                }
                            }
                            else {
                                 winner = false;
                                 sound = false;
                                 return uiMatrix;
                            }
                        }
                        else{
                            sound = true;
                            return uiMatrix; 
                        }
                    }
                }
            }
        }
     return uiMatrix;
    }
    
    @Override
    public JLabel[][] MoveLeft() {
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                 //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify if can move left
                    if (k - 1 >= 0) {
                         //Verify the previous cell
                        if (passRow != i || k - 1 != passColumn) {
                           ImageIcon icon = verifyObstacles(i, k+1);
                            if ( icon != null) {
                                JOptionPane.showMessageDialog(null, "Bad OR GOOD", "SomeThing", JOptionPane.INFORMATION_MESSAGE);
                                updateMatrix(i, k-1, i, k, icon);
                                sound = false;
                                return uiMatrix;
                            }
                            else{
                            updateMatrix(i, k-1, i, k, null);
                            sound = false;
                            return uiMatrix;
                            }
                           
                        } else {
                            //JOptionPane.showMessageDialog(null, "This cell was your previous cell", "One more time!", JOptionPane.INFORMATION_MESSAGE);
                             sound = true;
                             return uiMatrix;
                        }
                    } //Can't move
                    else {
                        sound = true;
                        return uiMatrix;
                    }

                }
            }
        }
         return uiMatrix;
    }

    @Override
    public JLabel[][] MoveUp() {
         for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify if can move up
                    if (i - 1 >= 0) {
                        if (i - 1 != passRow || k != passColumn) {
                            ImageIcon icon = verifyObstacles(i, k + 1);
                            if (icon != null) {
                                updateMatrix(i - 1, k, i, k, icon);
                                JOptionPane.showMessageDialog(null, "Bad OR GOOD", "SomeThing", JOptionPane.INFORMATION_MESSAGE);
                                sound = false;
                                return uiMatrix;
                                
                            } else {
                                updateMatrix(i - 1, k, i, k, icon);
                                sound = false;
                                return uiMatrix;
                            }

                        } else {
                            sound = true;
                            return uiMatrix;
                        }

                    } //Can't move up, for this we are going to show a message
                    else {
                        sound = true;
                        return uiMatrix;
                    }
                }
            }
        }
         return uiMatrix;
    }

    @Override
    public JLabel[][] MoveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
