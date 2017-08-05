
package Model;

import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class AntModel implements AntOperations{
    private JLabel [][] uiMatrix;
    private int [][] logicM1;
    private GameSettingsModel gameSettings;
    private int life;
    private int alcoholismLevel;
    private int sugarLevel;
    private int currentRow;
    private int currentColumn;
    private int passRow;
    private int passColumn;
    private int stepsbyAnt;

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

    public GameSettingsModel getGameSettings() {
        return gameSettings;
    }

    public void setGameSettings(GameSettingsModel gameSettings) {
        this.gameSettings = gameSettings;
    }
  
      

     
   private void saveStepsHistory(int i, int k){
       //Here we can save the steps by ant
       gameSettings.setRowHistory(i);
       gameSettings.setColumnHistory(k);
   }
   
   private void saveCurrentCell(int i, int k){
       gameSettings.setCurrentRow(i);
       gameSettings.setCurrentColumn(k);
   }

    @Override
    public JLabel[][] MoveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public int verifyObstacles(int i, int k) {
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
    
    
}
