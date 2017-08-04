/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofant;

import javax.swing.JLabel; import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.applet.AudioClip;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class UI extends javax.swing.JFrame {
    //-1 In logicM1 is meant of Current position of Ant
    //-2 In logicM1 is meant of end position of matrix
    //0 In logicM1 is meant of The cell is empty
    //5 In logicM1 is meant of sugar 
    //10 In logicM1 is meant of sugar with wine
    //15 In logicM1 is meant of sugar with poison

    //Key Up 38;    //Key left  37;     //Key Right 39;    // Key Down 40;
    
    JLabel [][] uiMatrix;
    int [][] logicM1;
    GameSettingsModel gameSettings;

    int sugarCont = 0;
    int sugarWineCont = 0;
    int possionContn = 0;
    ArrayList<Integer> randomRows;
 
    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.black, 1);
    
    public UI(GameSettingsModel model) {
        this.randomRows = new ArrayList();
        initComponents();
        uiMatrix = new JLabel[model.getLarge()][model.getWidth()];
        logicM1 = new int[model.getLarge()][model.getWidth()];
        gameSettings = model;
        creationOfMatrix();
        creationOfLogicMatrix();
       
    }   JLabel fin = new JLabel();

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 840));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(940, 20, 60, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      //Here we can detect what is key pressed
           
       if (evt.getKeyCode() == 39) 
           moveRight();//key rigth pressed
       
       
       else if(evt.getKeyCode() == 37)
           moveLeft();//key left pressed
       
       else if (evt.getKeyCode() == 40)
           moveDown();//key down pressed
       
       else if(evt.getKeyCode() == 38)
           moveUp(); //key up pressed
    }//GEN-LAST:event_formKeyPressed
   private void showStepsHistory(){
       //Here we can show the stepts that ant made  
      int cont = 0;
   
      while(cont < gameSettings.getRowHistory().size()){
          uiMatrix[getRowsHistory(cont)][getColumnHistory(cont)].setText("used");  
          cont++;
      }
   }
   private int getRowsHistory(int i){
       return gameSettings.getRowHistory().get(i);
   }
   private int getColumnHistory(int k){
       return gameSettings.getColumnHistory().get(k);
   } 
   
   private void showGarden(){
      
       ImageIcon fond = new ImageIcon(new ImageIcon(getClass().getResource("/gameofant/Images/GARDEN.jpg")).getImage());
         
   }
   
   private void saveCurrentCell(int i, int k){
       gameSettings.setCurrentRow(i);
       gameSettings.setCurrentColumn(k);
   }
   
    private void saveStepsHistory(int i, int k){
       //Here we can save the steps by ant
       gameSettings.setRowHistory(i);
       gameSettings.setColumnHistory(k);
   }
      private void soundEvent(){
      //Here can to display of sound 
      AudioClip sound;
      //we must to search the sound inside the package
      sound = java.applet.Applet.newAudioClip(getClass().getResource("/gameofant/Images/Sonido_de_interrupci_n_Tuuuuuu.wav"));
      sound.play();
    }
     //In this method we can create the Matrix of game
    private void creationOfMatrix(){
       //minimum of large is 7 and Maximiun 13 of large
       //Maximiun of width is 7 and Maximiun 18 of width

        int x=45;//Large
        int y = 50; //width
             
           for (int i = 0; i < uiMatrix.length; i++) {            
               for (int k = 0; k < uiMatrix[i].length; k++) {
                   
                   uiMatrix[i][k] = new JLabel();
                   uiMatrix[i][k].setBorder(border);                  
                   uiMatrix[i][k].setBounds(x,y,45,50);
                   
                   if (i == 0 && k == 0) {
                       //First space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));      
                   } 
                   else {
                       //The rest of the others space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                   }
                   uiMatrix[i][k].setText("");                
                   add(uiMatrix[i][k],null); //Adding from code a jframe
                  
                   x+=45;
                   
                   if (i == uiMatrix.length - 1 && k == uiMatrix[i].length - 1) {
                       //End space
                       //uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FinalTest.jpg")));
                    
                       fin.setBounds(x,y,45+52,50+19);
                      
                       fin.setBorder(border); 
                       fin.setVisible(false);
                       fin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/4.jpg")));
                       add(fin,null);
                   } 
                  
                   
               }
            x = 45;
            y += 50;
        }
    }

    private int randomRowSugar(){
        return (int) (Math.random() * gameSettings.getLarge());
        
    }

    private void creationOfLogicMatrix() {
        for (int i = 0; i < logicM1.length; i++) {
            for (int k = 0; k < logicM1[i].length; k++) {

                if (i == 0 && k == 0) {
                    logicM1[i][k] = -1; //Current position of Ant( image of Ant)
                } else if (i == uiMatrix.length - 1 && k == uiMatrix[i].length - 1) {
                    logicM1[i][k] = -2; //End cell  (Image of colony)
                    //End space
                } 
                //In this part we are going to insert the obstacles
                else {
                 logicM1[i][k] = 0;
                }
            }
        }
        setObstacles();
        System.out.println("Ready");
    }
    
    private int  verifyObstacles(int i,int k){
        
        if(logicM1[i][k] == 5){
            return 5;
        }
        if(logicM1[i][k] == 10)
        {
            return 10;
        }
        if(logicM1[i][k] == 15){
            return 15;
        }
        return 0;
    }
    
    private void setObstacles(){
        int cont = 0;
        int i = (int) (Math.random() * gameSettings.getLarge()-1);;
        int k = (int) (Math.random() * gameSettings.getWidth()-1);
        while(cont <= gameSettings.getObstacleQuantity()*3){
                
                while(logicM1[i][k] != 0 ){
                    i = (int) (Math.random() * gameSettings.getWidth());
                    k = (int) (Math.random() * gameSettings.getLarge());
                }
                logicM1[i][k] = 5;
                sugarCont++;
                cont++;
                
                
                while (logicM1[i][k] != 0) {
                    i = (int) (Math.random() * gameSettings.getWidth());
                    k = (int) (Math.random() * gameSettings.getLarge());
                }
                logicM1[i][k] = 10;
                sugarWineCont++;
                cont++;
           
           
                while (logicM1[i][k] != 0) {
                    i = (int) (Math.random() * gameSettings.getWidth());
                    k = (int) (Math.random() * gameSettings.getLarge());
                }
                logicM1[i][k] = 15;
                possionContn++;
                cont++; 
        }
    }

    public void moveRight() {
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify previous cell

                    //Verify if the next cell is the end
                    if (i == logicM1.length - 1 && k + 1 == logicM1[i].length - 1) {
                        //Verify previous cell
                        if (i != gameSettings.getPassRow() || k + 1 != gameSettings.getPassColumn()) {
                            uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                            uiMatrix[i][k + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                            fin.setVisible(true);
                            gameSettings.setStepsQuantityMade(gameSettings.getStepsQuantityMade()+1); //Quantity of steps increased
                            JOptionPane.showMessageDialog(null, "Very good", "Winner", JOptionPane.INFORMATION_MESSAGE);
                            jLabel2.setText(String.valueOf(gameSettings.getStepsQuantityMade()));
                            saveStepsHistory(i, k);
                        } else {
                            //JOptionPane.showMessageDialog(null, "This cell was your previous cell", "One more time!", JOptionPane.INFORMATION_MESSAGE);
                            soundEvent();
                        }
                    } else {
                        //Verify if ant can move right
                        if (k + 1 < logicM1[i].length) {
                            if (i != gameSettings.getPassRow() || k + 1 != gameSettings.getPassColumn()) {
                                logicM1[i][k + 1] = -1;//New current position
                                logicM1[i][k] = 0; //Empty position
                                uiMatrix[i][k + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                                uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                                gameSettings.setPassRow(i);//save the previous row
                                gameSettings.setPassColumn(k); //save the previous column 
                                gameSettings.setStepsQuantityMade(gameSettings.getStepsQuantityMade()+1); //Quantity of steps increased
                                saveStepsHistory(i, k);
                                saveCurrentCell(i, k+1);
                                return;
                            } else {
                                 //JOptionPane.showMessageDialog(null, "This cell was your previous cell", "One more time!", JOptionPane.INFORMATION_MESSAGE);
                                  soundEvent();
                            }

                        }
                    }
                }
            }
        }
    }
    public void moveLeft(){
          for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                 //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify if can move left
                    if (k - 1 >= 0) {
                         //Verify the previous cell
                        if (gameSettings.getPassRow() != i || k - 1 != gameSettings.getPassColumn()) {
                            logicM1[i][k - 1] = -1;//New current position
                            logicM1[i][k] = 0; //Empty position
                            uiMatrix[i][k - 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                            uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                            gameSettings.setPassRow(i);//save the previous row
                            gameSettings.setPassColumn(k); //save the previous column
                            gameSettings.setStepsQuantityMade(gameSettings.getStepsQuantityMade()+1); //Quantity of steps increased
                            saveStepsHistory(i, k);
                            saveCurrentCell(i, k-1);
                            return;
                        } else {
                            //JOptionPane.showMessageDialog(null, "This cell was your previous cell", "One more time!", JOptionPane.INFORMATION_MESSAGE);
                             soundEvent();
                        }
                    } //Can't move
                    else {
                        JOptionPane.showMessageDialog(null, "Fuera de rango", "Upps", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        }
    }
    public void moveUp(){
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {

                    //Verify if can move up
                    if (i - 1 >= 0) {
                        if (i - 1 != gameSettings.getPassRow() || k != gameSettings.getPassColumn()) {
                            logicM1[i - 1][k] = -1;//New current position
                            logicM1[i][k] = 0; //Empty position
                            uiMatrix[i - 1][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                            uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                            gameSettings.setPassRow(i);//save the previous row
                            gameSettings.setPassColumn(k); //save the previous column
                            gameSettings.setStepsQuantityMade(gameSettings.getStepsQuantityMade()+1); //Quantity of steps increased
                            saveStepsHistory(i, k);
                            saveCurrentCell(i-1, k);
                            return;
                        } else {
                           //JOptionPane.showMessageDialog(null, "This cell was your previous cell", "One more time!", JOptionPane.INFORMATION_MESSAGE);
                            soundEvent();
                            return;
                        }

                    } //Can't move up, for this we are going to show a message
                    else {
                        JOptionPane.showMessageDialog(null, "Fuera de rango", "Upps", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        }
    }

    public void moveDown() {
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                //Verify the current Position
                if (logicM1[i][k] == -1) {
                    //Verify is the end postion
                    if (i + 1 == logicM1.length - 1 && k == logicM1[i].length - 1) {
                        //Verify the pass row and pass column
                        
                            uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                            uiMatrix[i + 1][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                            fin.setVisible(true);
                            gameSettings.setStepsQuantityMade(gameSettings.getStepsQuantityMade()+1); //Quantity of steps increased
                            JOptionPane.showMessageDialog(null, "Very good", "Winner", JOptionPane.INFORMATION_MESSAGE);
                            jLabel2.setText(String.valueOf(gameSettings.getStepsQuantityMade()));
                            saveStepsHistory(i, k);
                            saveCurrentCell(i+1, k);
                            return;

                    } else {
                        //Verify if the ant can move
                        if (i + 1 < uiMatrix.length) {
                            if(i+1 != gameSettings.getPassRow() || k != gameSettings.getPassColumn()){
                                logicM1[i + 1][k] = -1;//New current position
                                logicM1[i][k] = 0; //Empty position
                                uiMatrix[i + 1][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FirstAnt.jpg")));
                                uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                                gameSettings.setPassRow(i);//save the previous row
                                gameSettings.setPassColumn(k); //save the previous column
                                gameSettings.setStepsQuantityMade(gameSettings.getStepsQuantityMade() + 1); //Quantity of steps increased
                                return;
                            } else {
                                //JOptionPane.showMessageDialog(null, "This cell was your previous cell", "One more time!", JOptionPane.INFORMATION_MESSAGE);
                                soundEvent();
                                return;
                            }
                        } //The ant can´t move
                        else {
                            JOptionPane.showMessageDialog(null, "Fuera de rango", "Upps", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        }
    }


    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI(null).setVisible(true);
            }
        });
    }
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
