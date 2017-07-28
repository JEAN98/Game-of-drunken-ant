/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofant;

import javax.swing.JLabel; import javax.swing.JTextField;
import javax.swing.JPanel; import javax.swing.JFrame;
import javax.swing.SwingConstants; import javax.swing.BorderFactory;
import javax.swing.border.Border; import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class UI extends javax.swing.JFrame {

    JLabel [][] UImatriz;
    int [][] logic;
    int steps;
    int alcholemiaLevel;
    int life;
    int large;
    int width;
    //ImageIcon iconZero = new ImageIcon("ga/hang0.gif"); 
    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.black, 1);
    
    public UI(int large1,int width1) {
        initComponents();
        
        UImatriz = new JLabel[large1][width1];
        logic = new int[large1][width1];
        steps = 0;
        alcholemiaLevel = 0;
        life = 100;
        large = large1;
        width = width1;
        creationOfMatriz();
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
     char caracter = evt.getKeyChar(); 
     
    }//GEN-LAST:event_formKeyPressed

 
    
     //In this method we can create of Matriz
    private void creationOfMatriz(){
       //minimum of widh is 2 and 2of large
       //Maximiun of width is 8 and 8 of large

        int x=125;//Large
        int y = 76; //width
             
           for (int i = 0; i < UImatriz.length; i++) {            
               for (int k = 0; k < UImatriz[i].length; k++) {
                   UImatriz[i][k] = new JLabel();
                   UImatriz[i][k].setBorder(border);                  
                   UImatriz[i][k].setBounds(x,y,125,76);
                   if(i==0 && k==0){
                          UImatriz[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/ImageFirst.jpg")));
                   }
                   else if(i==UImatriz.length -1 && k == UImatriz[i].length -1){
                       UImatriz[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FinalTest.jpg")));
                   }
                   else 
                   {
                          UImatriz[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/BadGround.jpg")));
                   }
                 
                   UImatriz[i][k].setText("");
                
                   add(UImatriz[i][k],null);
                   System.out.println("Good");
                   x+=110;
               }
               x=125;
               y += 76;
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
