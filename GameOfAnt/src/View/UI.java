/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.AntModel;
import Model.GameModel;
import Model.GameSettingsModel;
import static View.GameOfAnt.antObject;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import javax.swing.JLabel; import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.html.parser.DTDConstants;


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
    GameModel gameModel;
    int sugarCont = 0;
    int sugarWineCont = 0;
    int possionContn = 0;
    ArrayList<Integer> randomRows;
    
    public UI(GameSettingsModel model) throws IOException {
        this.randomRows = new ArrayList();
        initComponents();
        logicM1 = new int[model.getLarge()][model.getWidth()];
        gameSettings = model;
        creationMatrixByModel();
        showInformationAboutAnt();
        jLabelx.setVisible(true);
        jLabelLife1.setText(String.valueOf(antObject.getLife()));
        jLabel7.setText(gameSettings.getNickName());
    }   JLabel fin = new JLabel();

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabeHip = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelLife1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelx = new javax.swing.JLabel();
        jLabelBadGround = new javax.swing.JLabel();

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
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hip:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(1000, 180, 50, 50);

        jLabeHip.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabeHip.setForeground(new java.awt.Color(255, 255, 255));
        jLabeHip.setText("Desactive");
        jPanel2.add(jLabeHip);
        jLabeHip.setBounds(1090, 180, 110, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Steps:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(990, 60, 110, 50);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("0");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(1100, 60, 60, 50);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Life:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(1000, 120, 50, 50);

        jLabelLife1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelLife1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLife1.setText("100");
        jPanel2.add(jLabelLife1);
        jLabelLife1.setBounds(1100, 120, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/return.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 50, 50);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NickName");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(1010, 260, 210, 30);

        jLabelx.setForeground(new java.awt.Color(255, 255, 255));
        jLabelx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/close-button.png"))); // NOI18N
        jLabelx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelxMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelx);
        jLabelx.setBounds(1240, 0, 50, 47);

        jLabelBadGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/GARDEN.jpg"))); // NOI18N
        jLabelBadGround.setText("jLabel9");
        jPanel2.add(jLabelBadGround);
        jLabelBadGround.setBounds(-10, -10, 1340, 1190);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1360, 1190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      //Here we can detect what is key pressed
           
       if (evt.getKeyCode() == 39) 
       {
           uiMatrix = antObject.MoveRight();
           if( antObject.getSound())
               soundEvent();
           
           if(antObject.getWinner()){
               JOptionPane.showMessageDialog(null, "Very good", "you are the winner", JOptionPane.INFORMATION_MESSAGE);
               fin.setVisible(true);
               try {
                   showMessage();
               } catch (IOException ex) {
                   Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           //  moveRight();//key rigth pressed
       }

       else if(evt.getKeyCode() == 37)
       {
           uiMatrix = antObject.MoveLeft();
            if(antObject.getSound())
               soundEvent();
           // moveLeft();//key left pressed
       }
       
       else if (evt.getKeyCode() == 40)
       {
           uiMatrix = antObject.MoveDown();
          if(antObject.getSound())
               soundEvent();
           
           if(antObject.getWinner()){
              JOptionPane.showMessageDialog(null, "Very good", "you are the winner", JOptionPane.INFORMATION_MESSAGE);
            //moveDown();//key down pressed
            fin.setVisible(true);
               try {
                   showMessage();
               } catch (IOException ex) {
                   Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
               }
           }   
       }
        
       else if(evt.getKeyCode() == 38){
           uiMatrix = antObject.MoveUp();
           if(antObject.getSound())
               soundEvent();
           // moveUp(); //key up pressed
       }
       if(antObject.getLoser()){
           jLabel7.setText("Game over");
           return;
       }
       jLabel5.setText(String.valueOf(antObject.getStepsbyAnt()));
       showMovement();
    }//GEN-LAST:event_formKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            Settings x = new Settings();
            x.setVisible(true);
            x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            x.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.hide();
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel1MouseClicked
    public void showMessage() throws IOException{
        JTextField topicTitle = new JTextField();
        JTextField topicDesc = new JTextField();
        Object[] message = {"Would you like to play again with the same matrix?"};

        JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        JDialog getTopicDialog = pane.createDialog(null, "Play");
        getTopicDialog.setVisible(true);
        
        int value = ((Integer)pane.getValue()).intValue();
        if (value == JOptionPane.YES_OPTION) {
            //here we can play again with the same matrix
            System.out.println("Good");
            gameModel = new GameModel(gameSettings.getLarge(), gameSettings.getWidth());
            gameModel.setUiMatrix();
            gameModel.setLogicM1(gameSettings.getObstacleQuantity());

            antCreation(); // here we can play with new game
            showMatrix(gameModel.getUiMatrix());
          
            
            creationMatrixByModel();
        
        } else{
            this.hide();
            Settings x = new Settings();
            x.setVisible(true);
        }
    }
    private void jLabelxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelxMouseClicked
  private void showInformationAboutAnt(){
      jLabel5.setText(String.valueOf(antObject.getStepsbyAnt()));
  }
   private void showGarden(){
       ImageIcon fond = new ImageIcon(new ImageIcon(getClass().getResource("/gameofant/Images/GARDEN.jpg")).getImage());
   }

   private void soundEvent(){
      //Here can to display of sound 
      AudioClip sound;
      //we must to search the sound inside the package
      sound = java.applet.Applet.newAudioClip(getClass().getResource("/gameofant/Images/Sonido_de_interrupci_n_Tuuuuuu.wav"));
      sound.play();
    }
   
    private void creationMatrixByModel() throws IOException{
    //Here we are going to send the information about 
    //large and width that matrix is going to have
        gameModel = new GameModel(gameSettings.getLarge(),gameSettings.getWidth());
        gameModel.setUiMatrix();
        gameModel.setLogicM1(gameSettings.getObstacleQuantity());
        if (gameSettings.getAntInformation()){
            showMatrix(GameOfAnt.gameObject.getUiMatrix());
        }
           
        else {
            antCreation(); // here we can play with new game
            showMatrix(gameModel.getUiMatrix());
        }
          
    } 
    
      
    private void antCreation(){
        //Creation of Ant with uiMatrix and  logicm1
        GameOfAnt.antObject = new AntModel(gameModel.getUiMatrix(), gameModel.getLogicM1(),false);
        
    }
    private void showMatrix(JLabel[][] matrixGraphic)
    {
       //Here we are going to show the matrix that we created in the class
       javax.swing.border.Border border = BorderFactory.createLineBorder(Color.black, 1);
        int x=45;//Large
        int y = 50; //width
        uiMatrix = matrixGraphic;
      //  logicM1 = gameModel.getLogicM1();
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int j = 0; j < uiMatrix[i].length; j++) {
                 x+=45;
                 if (i == uiMatrix.length - 1 && j == uiMatrix[i].length - 1) {
                     //Here we are going to create the house of ant
                       fin.setBounds(x,y,45+52,50+19);
                       fin.setBorder(border); 
                       fin.setVisible(false);
                       fin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/4.jpg")));
                       jLabelBadGround.add(fin,null);
                   } 
                 if(logicM1[i][j] == 105)
                    uiMatrix[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/press_blue_1.png")));
                 jLabelBadGround.add(uiMatrix[i][j],null);
            }

            x = 45;
            y += 50;
        }
    }     
   
    private void showMovement(){
     //Here we can show the current matrix the recent movement
     jLabelLife1.setText(String.valueOf(antObject.getLife()));
      uiMatrix = antObject.getUiMatrix();
      logicM1 = antObject.getLogicM1();
          for (int i = 0; i < uiMatrix.length; i++) {
            for (int j = 0; j < uiMatrix[i].length; j++) {
                 jLabelBadGround.add(uiMatrix[i][j],null);
                 if(logicM1[i][j] == -1){
                     jLabelBadGround.setVisible(false);
                     jLabelBadGround.setVisible(true);
                      return;
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
                try {
                    new UI(null).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabeHip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBadGround;
    private javax.swing.JLabel jLabelLife1;
    private javax.swing.JLabel jLabelx;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
