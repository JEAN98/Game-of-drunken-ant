/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofant;

import javax.swing.JLabel; import javax.swing.BorderFactory;
 import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class UI extends javax.swing.JFrame {
    //1 In logicM1 is meant of Current position of Ant
    //2 In logicM1 is meant of end position of matrix
    //0 In logicM1 is meant of The cell is empty
    //Key Up 38;    //Key left  37;     //Key Right 39;    // Key Down 40;
    
    JLabel [][] uiMatrix;
    int [][] logicM1;
    int steps;
    int alcholemiaLevel;
    int life;
    int large;
    int width;
    int currentRow;
    int currentColumn;
  
    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.black, 1);
    
    public UI(int large1,int width1) {
        initComponents();
      
        uiMatrix = new JLabel[large1][width1];
        logicM1 = new int[large1][width1];
        steps = 0;
        alcholemiaLevel = 0;
        life = 100;
        large = large1;
        width = width1;
        currentColumn = 0;
        currentRow = 0;
        creationOfMatrix();
        creationOfLogicMatrix();
    }

 
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1060, 20, 60, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
          System.out.println("Enter ");
          System.out.println("Enter ");
      }
     
      
       if (evt.getKeyCode() == 39) 
           moveRight();
        
       else if(evt.getKeyCode() == 37)
           moveLeft();
       
       else if (evt.getKeyCode() == 40)
           moveDown();
       
       else if(evt.getKeyCode() == 38)
           moveUp();
    }//GEN-LAST:event_formKeyPressed
   
     //In this method we can create the Matrix of game
    private void creationOfMatrix(){
       //minimum of widh is 2 and 2of large
       //Maximiun of width is 8 and 8 of large

        int x=125;//Large
        int y = 76; //width
             
           for (int i = 0; i < uiMatrix.length; i++) {            
               for (int k = 0; k < uiMatrix[i].length; k++) {
                   
                   uiMatrix[i][k] = new JLabel();
                   uiMatrix[i][k].setBorder(border);                  
                   uiMatrix[i][k].setBounds(x,y,125,76);
                   
                   if (i == 0 && k == 0) {
                       //First space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/ImageFirst.jpg")));
                       
                   } /*else if (i == uiMatrix.length - 1 && k == uiMatrix[i].length - 1) {
                       //End space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FinalTest.jpg")));
                   } */
                   
                   else {
                       //The rest of the others space
                       uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                   }
                 
                   uiMatrix[i][k].setText("");                
                   add(uiMatrix[i][k],null); //Adding from code a jframe
                  
                   x+=110;
               }
               x=125;
               y += 76;
        }
    }
    private void creationOfLogicMatrix(){
        for (int i = 0; i < logicM1.length; i++) {
            for (int k = 0; k < logicM1[i].length; k++) {
                
                if (i == 0 && k == 0) {
                    logicM1[i][k] = 1; //Current position of Ant( image of Ant)
                } else if (i == uiMatrix.length - 1 && k == uiMatrix[i].length - 1) {
                     logicM1[i][k] = 2; //End cell  (Image of colony)
                    //End space
                }               
                else{
                    logicM1[i][k]=0;
                }
               
            }
        }
    }
    
    public void moveRight(){
         for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                if (logicM1[i][k] == 1) {
                    if (i == logicM1.length-1 && k+1 == logicM1[i].length -1 ) {
                        uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                        uiMatrix[i][k+1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FinalTest.jpg")));
                        JOptionPane.showMessageDialog(null, "Very good", "Winner", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (k + 1 < logicM1[i].length) {
                            logicM1[i][k + 1] = 1;//New current position
                            logicM1[i][k] = 0; //Empty position
                            uiMatrix[i][k + 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/ImageFirst.jpg")));
                            uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Fuera de rango", "Upps", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }
            }
        }
    }
    public void moveLeft(){
          for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                if (logicM1[i][k] == 1) {
               
                      if (k - 1 >= 0) {
                          logicM1[i][k - 1] = 1;//New current position
                          logicM1[i][k] = 0; //Empty position
                          uiMatrix[i][k - 1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/ImageFirst.jpg")));
                          uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                          return;
                      } else {
                          JOptionPane.showMessageDialog(null, "Fuera de rango", "Upps", JOptionPane.INFORMATION_MESSAGE);
                      }

                  }
              }
        }
    }
    public void moveUp(){
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                   if(logicM1[i][k] == 1){
                       
                       if( i-1 >= 0){
                           logicM1[i-1][k]=1;//New current position
                           logicM1[i][k] = 0; //Empty position
                           uiMatrix[i-1][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/ImageFirst.jpg")));
                           uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                         return;
                       }
                       else{
                             JOptionPane.showMessageDialog(null, "Fuera de rango", "Upps" , JOptionPane.INFORMATION_MESSAGE);
                       }
                   }
            }
        }
    }
    public void moveDown(){
        for (int i = 0; i < uiMatrix.length; i++) {
            for (int k = 0; k < uiMatrix[i].length; k++) {
                if (logicM1[i][k] == 1) {
                    if (i +1 == logicM1.length -1 && k == logicM1[i].length-1) {
                          uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                          uiMatrix[i+1][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FinalTest.jpg")));
                          
                        JOptionPane.showMessageDialog(null, "Very good", "Winner", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (i + 1 < uiMatrix.length) {
                            logicM1[i + 1][k] = 1;//New current position
                            logicM1[i][k] = 0; //Empty position
                            uiMatrix[i + 1][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/ImageFirst.jpg")));
                            uiMatrix[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                            return;
                        } 
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
                new UI(0,0).setVisible(true);
            }
        });
    }
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}