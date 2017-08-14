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
import javax.swing.JFrame;
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
    AntModel ant;
    
 
    
    public UI(GameSettingsModel model) throws IOException {
        this.randomRows = new ArrayList();
        initComponents();
   //  uiMatrix = new JLabel[model.getLarge()][model.getWidth()];
        logicM1 = new int[model.getLarge()][model.getWidth()];
        gameSettings = model;
        creationMatrixByModel();
       // creationOfMatrix();
        //creationOfLogicMatrix();
       
    }   JLabel fin = new JLabel();

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(940, 20, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/GARDEN.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1330, 1180);

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
           }   
       }
        
       else if(evt.getKeyCode() == 38){
           uiMatrix = antObject.MoveUp();
           if(antObject.getSound())
               soundEvent();
           // moveUp(); //key up pressed
       }
       jLabel2.setText(String.valueOf(antObject.getStepsbyAnt()));
       showMovement();
    }//GEN-LAST:event_formKeyPressed

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
    
    private void continueAntGame() throws IOException{
        showMatrix(GameOfAnt.gameObject.getUiMatrix());
        
    }
    private void getInformationTXT(int line)throws FileNotFoundException, IOException {
        
        FileReader f = new FileReader("C:\\Users\\JeanCarlo\\Documents\\GitHub\\Game-of-drunken-ant\\Current.txt");
        BufferedReader b = new BufferedReader(f);
        String fileInformation="";
        int cont = 0;
        //While
        while ((fileInformation = b.readLine()) != null) {
            
            if( line == 0){
                for (int i = 0; i < logicM1.length; i++) {
                    for (int j = 0; j < logicM1[i].length; j++) {
                        //Here we can save the numbers of logicMatrix in the file
                        String number ="";
                        while (!String.valueOf(fileInformation.charAt(cont)).equals(" ")) {
                            number += String.valueOf(fileInformation.charAt(cont));
                            cont++;
                        }
                        logicM1[i][j] = Integer.parseInt(number);
                        cont++;
                    }
                }
                //Creation about Ant class
                gameModel.setCurrentLogicM1(logicM1);
                ant = new AntModel(gameModel.getUiMatrix(), logicM1);
              
                //Send currentPositions
                setCurrentsPositions(fileInformation, cont);
            }
            else{
              
                  
            }
            //Line of file    
        }
        b.close();
    } 
    private void setCurrentsPositions(String fileInformation,int cont){
        //Here we can send the information about the current possitions 
        boolean bus = true;
        while (bus || !bus) {
         
            String number = "";
            while (!String.valueOf(fileInformation.charAt(cont)).equals(" ")) {
                number += String.valueOf(fileInformation.charAt(cont));
                cont++;
            }
            //verify for to get the row
            if (bus) //Set the currentRow in the ant object
                ant.setCurrentRow(Integer.parseInt(number)); 
            
            else//Set the currentColumn in the ant object{
            {
                  ant.setCurrentColumn(Integer.parseInt(number));
                  return; //Ready
            }
            cont++;
            bus=false;            
        }
    }
               
    
    private void antCreation(){
        //Creation of Ant with uiMatrix and  logicm1
        GameOfAnt.antObject = new AntModel(gameModel.getUiMatrix(), gameModel.getLogicM1());
        
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
                       jLabel1.add(fin,null);
                   } 
                 jLabel1.add(uiMatrix[i][j],null);
            }
             x = 45;
            y += 50;
        }
    }     
   
    private void showMovement(){
     //Here we can show the current matrix the recent movement
      uiMatrix = antObject.getUiMatrix();
          for (int i = 0; i < uiMatrix.length; i++) {
            for (int j = 0; j < uiMatrix[i].length; j++) {
                 jLabel1.add(uiMatrix[i][j],null);
                 if(antObject.getLogicM1()[i][j] == -1)
                      return;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
