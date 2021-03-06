package View;

import Model.AntModel;
import Model.GameModel;
import Model.GameSettingsModel;
import static View.GameOfAnt.gameObject;
import static View.GameOfAnt.model1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Settings extends javax.swing.JFrame {
    
    String fileInformation="";
    String currentFile="" ;
    int contInformation = 0;
    public Settings(Boolean bus) throws IOException {
        initComponents();
        findInformation("C:\\Users\\JeanCarlo\\Documents\\GitHub\\Game-of-drunken-ant\\Settings.txt");
        if(getGameInformation()){
            showAntAttributes();
            if (bus) {
                showUI(false);
            }
        }
        }
        

    private boolean verifyText() {
        if (jTextFieldNickNma.getText().equals("") || jTextFieldObstacles.getText().equals("")) {
            return false;
        }
        
        return true;
    }
    
    public void createGame(String large, String weight, String nickName, String quantityObstacles) {
        try {
            //Call the file
            String dir = "C:\\Users\\JeanCarlo\\Documents\\GitHub\\Game-of-drunken-ant\\Settings.txt";
            File file = new File(dir);

            //Object about buffer
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("");
            FileWriter write1 = new FileWriter(file, true);
            
            String information = "";
            information += large;
            information += " " + weight;
            information += " " + nickName;
            information += " " + quantityObstacles;
            
            write1.write(information);            
            write1.close();
            findInformation(dir);
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    //In this method we can get the information inside of file 
    private void findInformation(String fileDir) throws FileNotFoundException, IOException {
        
        FileReader f = new FileReader(fileDir);
        BufferedReader b = new BufferedReader(f);

        //While
        if ((fileInformation = b.readLine()) != null) {
            System.out.println(fileInformation);
            //Line of file    
        }
        b.close();
    }
    

    private boolean getGameInformation() throws IOException {
        try{
            
            boolean bus = false;
            String result = "";
            int cont = 0;
            //Find the quantity of rows
            if (!fileInformation.equals("")) {

                while (!String.valueOf(fileInformation.charAt(cont)).equals(" ")) {
                    result += String.valueOf(fileInformation.charAt(cont));
                    cont++;
                    bus = true;
                }
                int rows = Integer.parseInt(result);
                cont++;
                result = ""; //Reset the variable

                //Find the quantity of columns
                while (!String.valueOf(fileInformation.charAt(cont)).equals(" ")) {
                    result += String.valueOf(fileInformation.charAt(cont));
                    cont++;
                }
                int columns = Integer.parseInt(result);
                cont++;
                result = ""; //Reset the variable

                //Find the nickName
                while (!String.valueOf(fileInformation.charAt(cont)).equals(" ")) {
                    result += String.valueOf(fileInformation.charAt(cont));
                    cont++;
                }
                String nickName = result;
                cont++;
                result = ""; //Reset the variable

                //Find the quantity of obstacles
                while (!String.valueOf(fileInformation.charAt(cont)).equals(" ")) {
                    result += String.valueOf(fileInformation.charAt(cont));
                    if (cont + 1 == fileInformation.length()) {
                        break;
                    }
                    cont++;
                }
                int obstaclesQuantity = Integer.parseInt(result);

                model1 = new GameSettingsModel(nickName, rows, columns, obstaclesQuantity);
                gameObject = new GameModel(rows, columns);
                gameObject.setUiMatrix();
                gameObject.setLogicM1(obstaclesQuantity);
                getInformationTXT();
                return bus;
            }
            else
                return false;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    private void getInformationTXT()throws FileNotFoundException, IOException {
        
        FileReader f = new FileReader("C:\\Users\\JeanCarlo\\Documents\\GitHub\\Game-of-drunken-ant\\Current.txt");
        BufferedReader b = new BufferedReader(f);
        String fileInformation1="";
        int[][] logicM1 = new int[model1.getLarge()][model1.getWidth()];
        int cont = 0;
        //While
        while ((fileInformation1 = b.readLine()) != null) {
            
           
                for (int i = 0; i < logicM1.length; i++) {
                    for (int j = 0; j < logicM1[i].length; j++) {
                        //Here we can save the numbers of logicMatrix in the file
                        String number ="";
                        while (!String.valueOf(fileInformation1.charAt(cont)).equals(" ")) {
                            number += String.valueOf(fileInformation1.charAt(cont));
                            cont++;
                        }
                        logicM1[i][j] = Integer.parseInt(number);
                        cont++;
                    }
                }
                //Creation about Ant class
                gameObject.setCurrentLogicM1(logicM1);
                GameOfAnt.antObject = new AntModel(gameObject.getUiMatrix(), logicM1,false);
              
                //Send currentPositions
              cont = setCurrentsPositions(fileInformation1, cont);
              currentFile = fileInformation1;
              saveAntAttributes(cont);
            //Line of file    
        }
        b.close();
    } 
    private String getAntAttributes(){
        //Get information of each attribute, little by little
          String number="";
          while (!String.valueOf(currentFile.charAt(contInformation)).equals(" ")) {
                 if (contInformation + 1 == fileInformation.length()) {
                break;
            }
        
            number += String.valueOf(currentFile.charAt(contInformation));
            contInformation++;
        }
          contInformation++;
          return number;
    }
    private void saveAntAttributes(int cont){
        //Here we can getting the current: life, alcholismLevel,SugarLevel,PossionLevel,Steps
        contInformation = cont;
     
         //life Found it
         GameOfAnt.antObject.setLife(Integer.parseInt(getAntAttributes()));
              
       //Alcholism found it
        GameOfAnt.antObject.setAlcoholismLevel(Integer.parseInt(getAntAttributes()));
        
       //Possion found it
        GameOfAnt.antObject.setPossion(Integer.parseInt(getAntAttributes()));
        
       //Steps found it
        GameOfAnt.antObject.setStepsbyAnt(Integer.parseInt(getAntAttributes()));
        
         //Pass position found it
        GameOfAnt.antObject.setPassPosition(getAntAttributes());
        
          //Pass row found it
        GameOfAnt.antObject.setPassRow(Integer.parseInt(getAntAttributes()));
        
       //Pass column found it
        GameOfAnt.antObject.setPassColumn(Integer.parseInt(getAntAttributes()));
        
        //Status of ant
        GameOfAnt.antObject.setLoser(Boolean.valueOf(getAntAttributes()));
    }
     private int setCurrentsPositions(String fileInformation,int cont){
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
                GameOfAnt.antObject.setCurrentRow(Integer.parseInt(number)); 
            
            else//Set the currentColumn in the ant object{
            {
                  GameOfAnt.antObject.setCurrentColumn(Integer.parseInt(number));
               
                  return cont+1; //Ready
            }
            cont++;
            bus=false;            
        }
        return 0;
    }
     
    private void showAntAttributes(){
        jLabelCurrentLife.setText(String.valueOf(GameOfAnt.antObject.getLife()));
 //     jLabelSuarLevel.setText(String.valueOf(GameOfAnt.antObject.getSugarLevel()));
        jLabelAlcholismLevel.setText(String.valueOf(GameOfAnt.antObject.getAlcoholismLevel()));
        jLabelPossion.setText(String.valueOf(GameOfAnt.antObject.getPossion()));
        jLabelSteps.setText(String.valueOf(GameOfAnt.antObject.getStepsbyAnt()));
        nickName.setText(GameOfAnt.model1.getNickName());
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNickNma = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldObstacles = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nickName = new javax.swing.JLabel();
        jLabelCurrentLife = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelSteps = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelAlcholismLevel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelPossion = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCurrentLife1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(236, 239, 241));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "8", "9", "10", "11", "12", "13" }));

        jLabel4.setText("X");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "8", "9", "10", "11", "12", "13", "14", "15", "17", "18" }));

        jButton1.setBackground(new java.awt.Color(104, 159, 56));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("New game");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Matrix :");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/settings2.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("NickName :");

        jTextFieldNickNma.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Obstacles Quantity:  ");

        jTextFieldObstacles.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/HormigaRun.png"))); // NOI18N

        label1.setText("label1");

        label2.setText("label2");

        label3.setText("label3");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/depositphotos_3928487-stock-illustration-cartoon-tree.jpg"))); // NOI18N

        jLabel3.setText("jLabel3");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/TESTTREE3.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/TESTTREE3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(413, 413, 413)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(75, 75, 75)
                                        .addComponent(jTextFieldObstacles, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(142, 142, 142)
                                        .addComponent(jTextFieldNickNma, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(109, 109, 109)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel4)
                                        .addGap(60, 60, 60)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(1100, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(814, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(794, 794, 794)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNickNma, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel6)))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldObstacles, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(315, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(296, 296, 296)))
        );

        jTabbedPane1.addTab("New Settings", jPanel2);

        jPanel3.setBackground(new java.awt.Color(236, 239, 241));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/HormigaRun.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel12.setText("Home");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/icon_home.png"))); // NOI18N

        nickName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nickName.setForeground(new java.awt.Color(104, 159, 56));
        nickName.setText("NickName");

        jLabelCurrentLife.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelCurrentLife.setText("jLabel15");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(104, 159, 56));
        jLabel15.setText("Steps");

        jLabelSteps.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelSteps.setText("jLabel15");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(104, 159, 56));
        jLabel16.setText("Possion Level");

        jLabelAlcholismLevel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelAlcholismLevel.setText("jLabel15");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(104, 159, 56));
        jLabel18.setText("Alcholism Level");

        jLabelPossion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelPossion.setText("jLabel15");

        jButton2.setBackground(new java.awt.Color(104, 159, 56));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Continue Game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/TESTTREE3.png"))); // NOI18N

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/FondGame.jpg"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(104, 159, 56));
        jLabel23.setText("Current Life");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel23))
                                        .addGap(262, 262, 262)
                                        .addComponent(jLabel22))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelPossion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(nickName))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(81, 81, 81)
                                                    .addComponent(jLabelAlcholismLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelCurrentLife)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabelSteps))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(jButton2)))
                .addContainerGap(823, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(nickName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCurrentLife))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 182, Short.MAX_VALUE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSteps))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelAlcholismLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPossion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );

        jTabbedPane1.addTab("Current  settings", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 50, 1870, 910);

        jPanel1.setBackground(new java.awt.Color(255, 152, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome to  Ants drunk");

        jLabelCurrentLife1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelCurrentLife1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gameofant/Images/close-button.png"))); // NOI18N
        jLabelCurrentLife1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCurrentLife1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(481, 481, 481)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jLabelCurrentLife1)
                .addContainerGap(1327, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCurrentLife1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 2237, 63);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (verifyText()) {
            String dir = "C:\\Users\\JeanCarlo\\Documents\\GitHub\\Game-of-drunken-ant\\Current.txt";
            File file = new File(dir);

            //Object about buffer
            BufferedWriter bw;
            try {
                bw = new BufferedWriter(new FileWriter(file));
                bw.write("");
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }

            createGame(jComboBox2.getSelectedItem().toString(), jComboBox1.getSelectedItem().toString(), jTextFieldNickNma.getText(), jTextFieldObstacles.getText());
            try {
                getGameInformation();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            model1.setGetAntInformation(false);
            UI newView;
            try {
                newView = new UI(model1); //13 * 18 maximun
                newView.setVisible(true);
                newView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.hide();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please, complete all spaces", "Problems!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        
    private void showUI(boolean  bus) throws IOException{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            model1.setGetAntInformation(bus);
            UI newView = new UI(model1); //13 * 18 maximun
            newView.setVisible(true);
            newView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newView.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.hide();
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //Here we can to coninue our game,because the information is saved in the Settings file
             showUI(true);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabelCurrentLife1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCurrentLife1MouseClicked
        
    }//GEN-LAST:event_jLabelCurrentLife1MouseClicked

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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Settings(false).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAlcholismLevel;
    private javax.swing.JLabel jLabelCurrentLife;
    private javax.swing.JLabel jLabelCurrentLife1;
    private javax.swing.JLabel jLabelPossion;
    private javax.swing.JLabel jLabelSteps;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldNickNma;
    private javax.swing.JTextField jTextFieldObstacles;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JLabel nickName;
    // End of variables declaration//GEN-END:variables
}
