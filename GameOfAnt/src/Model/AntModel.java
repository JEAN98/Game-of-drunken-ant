
package Model;

import View.GameOfAnt;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private int possion;
    private String passPosition;
    private boolean sound;
    private boolean winner;
    private boolean loser;

    public AntModel(JLabel[][] uiMatrix,int [][] logicM1,boolean status) {
      this.logicM1 = logicM1;
      this.uiMatrix = uiMatrix;
      this.life = 100;
      currentRow = 0;
      currentColumn = 0;
      this.alcoholismLevel = 0;
      this.possion = 0;
      this.stepsbyAnt = 0;
      this.sugarLevel = 0;
      this.loser = false;
      if(status)
        saveInformationTXT();
    }

    public boolean getLoser() {
        return loser;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public int getPassRow() {
        return passRow;
    }

    public int getPossion() {
        return possion;
    }

    public void setPossion(int possion) {
        this.possion = possion;
    }
    

    public void setPassRow(int passRow) {
        this.passRow = passRow;
    }

    public int getPassColumn() {
        return passColumn;
    }

    public void setPassColumn(int passColumn) {
        this.passColumn = passColumn;
    }

    public String getPassPosition() {
        return passPosition;
    }

    public void setPassPosition(String passPosition) {
        this.passPosition = passPosition;
    }
 
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAlcoholismLevel() {
        return alcoholismLevel;
    }

    public void setAlcoholismLevel(int alcoholismLevel) {
        this.alcoholismLevel = alcoholismLevel;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public int getStepsbyAnt() {
        return stepsbyAnt;
    }

    public void setStepsbyAnt(int stepsbyAnt) {
        this.stepsbyAnt = stepsbyAnt;
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
                 
      //Verify the status of possion
       if(possion == 3 )
            possion = 0;
       if(possion > 0)
            possion ++;
      
      
      if(logicM1[i][k] == 5){
          // The ant found sugar
          
            if(possion > 0 && possion < 4){
                life += 20; 
            }
            else{
                life += 10; //Increase life
                if(alcoholismLevel > 0){
                    alcoholismLevel -=  10; //Reduce the alcoholismLevel thanks for the ant find sugar
                }
            }
            return new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/sugar.png"));
        }
        if(logicM1[i][k] == 10)
        {  
            //The ant found sugar with alchol

            if(possion > 0 && possion < 4){
               JOptionPane.showMessageDialog(null, "Sorry!", "The ant is dead for alcholism Level and possion!", JOptionPane.INFORMATION_MESSAGE);
               this.loser = true;
            }
            if(alcoholismLevel == 0){
                 alcoholismLevel += 20; //Increase alcholism level
                 life -= 10; 
            }
            else if(alcoholismLevel > 0 ){
                   alcoholismLevel += 20;//Increase alcholism level
                   life -= 20;
                   logicM1[i][k] = 0;
                   uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                   //Show the image with sugar
                   Hip();
            }
            if(alcoholismLevel >= 50){
                JOptionPane.showMessageDialog(null, "Game over!", "The ant is dead for alcholism Level!", JOptionPane.INFORMATION_MESSAGE);
                this.loser = true;
                //StopGame
            }
          
            return new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/sugarWine.png"));
        }
        if(logicM1[i][k] == 15){
            //The and found the possion
         //   alcoholismLevel=20;
            if(possion > 0 ){
                 JOptionPane.showMessageDialog(null, "Game over!", "The ant is dead for two possions!", JOptionPane.INFORMATION_MESSAGE);
                 this.loser = true;
            }
            else if(alcoholismLevel > 0){
                life -= 50; 
                possion = 1; //Activation according to possion
                return new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/possion.png"));
            }
            
        }
       return null;
    }

    public boolean getSound() {
        return sound;
    }

    public boolean getWinner() {
        return winner;
    }

    private void updateMatrix(int currentI, int currentK, int i, int k, ImageIcon icon) {
        //Here we can update logic matrix and fisical matrix
        logicM1[currentI][currentK] = -1;
        logicM1[i][k] = 105;//That means that ant passed for this cell
        uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/press_blue_1.png")));
        stepsbyAnt++;

        if (icon != null) {
            uiMatrix[currentI][currentK].setIcon(icon);
        } else {
            uiMatrix[currentI][currentK].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
        }

        currentRow = currentI; // save current row
        currentColumn = currentK; // save current column
        passRow = i; //save the previous row 
        passColumn = k; //save  previous column
        saveInformationTXT();

    }

    @Override
    public JLabel[][] MoveRight() {
        sound = false;
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify if the next cell is the end
                    if (k + 1 < uiMatrix[i].length) {
                        if (i == logicM1.length - 1 && k + 1 == logicM1[i].length - 1) {
                            //Verify previous cell
                            updateMatrix(i, k + 1, i, k, null);
                             winner = true;
                             passPosition = "left";
                            return uiMatrix;
                        } else {
                            if (i != passRow || k + 1 != passColumn) {
                                ImageIcon icon = verifyObstacles(i, k + 1);
                                if (icon != null) {
                                    JOptionPane.showMessageDialog(null, "Bad OR GOOD", "SomeThing", JOptionPane.INFORMATION_MESSAGE);
                                    updateMatrix(i, k + 1, i, k, icon);
                                    passPosition = "left";
                                    return uiMatrix;
                                } else {
                                    updateMatrix(i, k + 1, i, k, null);
                                    if(alcoholismLevel > 0 ){
                                        alcoholismLevel -= 10;
                                    }
                                    winner = false;
                                    return uiMatrix;
                                }
                            } else {
                                winner = false;
                                sound = true;
                                return uiMatrix;
                            }
                        }
                    } else {
                        sound = true;
                        return uiMatrix;
                    }
                }
            }
        }

        return uiMatrix;
    }

    @Override
    public JLabel[][] MoveLeft() {
        sound = false;
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                 //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify if can move left
                    if (k - 1 >= 0) {
                         //Verify the previous cell
                        if (passRow != i || k - 1 != passColumn) {
                           ImageIcon icon = verifyObstacles(i, k-1);
                            if ( icon != null) {
                                JOptionPane.showMessageDialog(null, "Bad OR GOOD", "SomeThing", JOptionPane.INFORMATION_MESSAGE);
                                updateMatrix(i, k-1, i, k, icon);
                                 passPosition = "rigth";
                                return uiMatrix;
                            }
                            else{
                            updateMatrix(i, k-1, i, k, null);
                              if(alcoholismLevel > 0 )
                                 alcoholismLevel -= 10;
                                
                               passPosition = "rigth";
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
        sound = false;
         for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify if can move up
                    if (i - 1 >= 0) {
                        if (i - 1 != passRow || k != passColumn) {
                            ImageIcon icon = verifyObstacles(i-1, k);
                            if (icon != null) {
                                updateMatrix(i - 1, k, i, k, icon);
                                JOptionPane.showMessageDialog(null, "Bad OR GOOD", "SomeThing", JOptionPane.INFORMATION_MESSAGE);
                                 passPosition = "down";
                                return uiMatrix;
                                
                            } else {
                                updateMatrix(i - 1, k, i, k, icon);
                                  if(alcoholismLevel > 0 )
                                 alcoholismLevel -= 10;
                                  
                                 passPosition = "down";
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
        sound = false;
           for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify is the end postion
                    if (i + 1 == logicM1.length - 1 && k == logicM1[i].length - 1) {
                            updateMatrix(i+1, k, i, k, null);
                      //      JOptionPane.showMessageDialog(null, "Very good", "Winner", JOptionPane.INFORMATION_MESSAGE);
                            winner = true;
                            passPosition = "up";
                            return uiMatrix;

                    } else {
                        //Verify if the ant can move
                        if (i + 1 < uiMatrix.length) {
                            if(i+1 != passRow || k != passColumn){
                               ImageIcon icon = verifyObstacles(i+1,k);
                            if (icon != null) {
                                updateMatrix(i+1, k, i, k, icon);
                                passPosition = "up";
                                return uiMatrix;
                            }
                            else{
                                 updateMatrix(i+1, k, i, k, null);
                                if (alcoholismLevel > 0) 
                                    alcoholismLevel -= 10; //alcholism can  reduce
                                

                                  passPosition = "up";
                                  return uiMatrix;
                            }
                            } else {
                                 sound = true;                  
                                 return uiMatrix;
                            }
                        } //The ant can´t move
                        else {
                            winner = false;
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
    public void Hip() {
        //Here we are going to create the hip, that is a new position according random
        //HiUp = 1, HipDown = 2, HipRigth = 3, HipLeft = 4

        int result = 0;
        Boolean bus = false;
        while( bus == false){
            result = (int) (Math.random() * 4) + 1;

            if (result == 1 && passPosition != "down") {
                //Verify if we can moveUp
                if (currentRow - 1 >= 0) {
                    MoveUp();
                    return;
                }
            } 
            else if (result == 2 && passPosition != "up") {
                   if(currentRow +1 < logicM1.length){
                       MoveDown();
                       return;
                   }
            }
            else if(result == 3 && passPosition != "left"){
               if(currentColumn -1 > 0 ){
                   MoveLeft();
                   return;
               }
            }
            else if(result == 4 && passPosition != "rigth"){
                if(currentColumn + 1 <  GameOfAnt.model1.getWidth()){
                    MoveRight();
                    return;
                }
            }
        }
    }
    
  private void saveAntAttributes(  FileWriter write1) throws IOException{
      //Here we can save the other attributes according to movements of ant
      
      String information="";
      information += String.valueOf(life) +" ";
      information += String.valueOf(sugarLevel) +" ";
      information += String.valueOf(alcoholismLevel) +" ";
      information += String.valueOf(possion) +" ";
      information += String.valueOf(stepsbyAnt) +" ";
      write1.write(information);
  }
  public void saveInformationTXT(){
        try {
          //Call the file
          String dir = "C:\\Users\\JeanCarlo\\Documents\\GitHub\\Game-of-drunken-ant\\Current.txt";
          File file = new File(dir);

          //Object about buffer
          BufferedWriter bw = new BufferedWriter(new FileWriter(file));
          bw.write("");
          FileWriter write1 = new FileWriter(file, true);
          String information = "";
          for (int i = 0; i < logicM1.length; i++) {
              for (int j = 0; j < logicM1[i].length; j++) {
                  //Here we can save the numbers of logicMatrix in the file
                  information += String.valueOf(logicM1[i][j]);
                  information += " ";
              }
          }
          information += String.valueOf(currentRow) + " ";
          information += String.valueOf(currentColumn) + " ";
          write1.write(information);
          
          saveAntAttributes(write1);
          write1.close();
          //  findInformation(dir);
      } //Si existe un problema al escribir cae aqui
      catch (Exception e) {
          System.out.println("Error al escribir");
      }
  }

}
