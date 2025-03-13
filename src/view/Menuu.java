/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package view;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Controller.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import javax.swing.JCheckBox;
import view.Home;
import Controller.*;
/**
 *
 * @author PhelanUX
 */
public class Menuu extends javax.swing.JFrame {

    /**
     * Creates new form Menuu
     */
    public Menuu() {
        initComponents();
        init();
    }
    private  String datesql;
    private String timesql;
    private int totalsql=0;
    private int x;
    private int total=0;
    private void init(){
        setImage();
        setTime();
        setDrink();
        Cafe();
        setTotal();
        if(!TotalText.getText().equals(String.valueOf(total))){
            DeleteLineBtn.setEnabled(false);
        }
    }
    //reset giá trị về 0
     private void reset(){
        total=0;
        x=0;
        DeleteLineBtn.setEnabled(true);
        jSpinner8.setValue(0);
        jSpinner9.setValue(0);
        jSpinner10.setValue(0);
        jSpinner11.setValue(0);
        jSpinner12.setValue(0);
        jSpinner13.setValue(0);
        jSpinner14.setValue(0);
        jSpinner15.setValue(0);
        jSpinner16.setValue(0);
        jSpinner17.setValue(0);
        TotalText.setText("0");       
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox12.setSelected(false);
        jCheckBox10.setSelected(false);
        jCheckBox11.setSelected(false);
        jCheckBox17.setSelected(false);
        jCheckBox16.setSelected(false);
        jCheckBox13.setSelected(false);
        jCheckBox14.setSelected(false);
        jCheckBox15.setSelected(false);
        PurchaseArea.setText("");
        
    }
    
     public void setDrink(){
         MenuController me =new MenuController();
         jLabel57.setText(me.getDrinkNameByCode("1"));
         jLabel58.setText(me.getDrinkPriceByCode("1"));
         jLabel62.setText(me.getDrinkNameByCode("2"));
         jLabel63.setText(me.getDrinkPriceByCode("2"));
         jLabel80.setText(me.getDrinkNameByCode("3"));
         jLabel81.setText(me.getDrinkPriceByCode("3"));
         jLabel68.setText(me.getDrinkNameByCode("4"));
         jLabel69.setText(me.getDrinkPriceByCode("4"));
         jLabel74.setText(me.getDrinkNameByCode("5"));
         jLabel75.setText(me.getDrinkPriceByCode("5"));
         jLabel110.setText(me.getDrinkNameByCode("6"));
         jLabel111.setText(me.getDrinkPriceByCode("6"));
         jLabel104.setText(me.getDrinkNameByCode("7"));
         jLabel105.setText(me.getDrinkPriceByCode("7"));
         jLabel86.setText(me.getDrinkNameByCode("8"));
         jLabel87.setText(me.getDrinkPriceByCode("8"));
         jLabel92.setText(me.getDrinkNameByCode("9"));
         jLabel93.setText(me.getDrinkPriceByCode("9"));
         jLabel98.setText(me.getDrinkNameByCode("10"));
         jLabel99.setText(me.getDrinkPriceByCode("10"));
     }
    //set giá trị cho TotalText
    private void setTotal(){
        TotalText.setText(String.valueOf(total));
    }
    //set image cho sản phẩm
    private void setImage(){
        /*ImageIcon icon= new ImageIcon(getClass().getResource("/Images/hotcoffe.jpg"));
        ImageIcon icon1= new ImageIcon(getClass().getResource("/Images/milktea_1.jpg"));
        ImageIcon icon2= new ImageIcon(getClass().getResource("/Images/matcha.jpg"));
        ImageIcon icon3= new ImageIcon(getClass().getResource("/Images/orange-juice.jpg"));
        ImageIcon icon4= new ImageIcon(getClass().getResource("/Images/coconut_1.jpg"));
        ImageIcon icon5= new ImageIcon(getClass().getResource("/Images/greentea.jpg"));
        ImageIcon icon6= new ImageIcon(getClass().getResource("/Images/chocolatecoffe.jpg"));
        ImageIcon icon7= new ImageIcon(getClass().getResource("/Images/mango-frooti.jpg"));
        ImageIcon icon8= new ImageIcon(getClass().getResource("/Images/olong-tea_1.jpg"));
        ImageIcon icon9= new ImageIcon(getClass().getResource("/Images/iced-milk-coffe_1.jpg"));
        
        Image img=icon.getImage().getScaledInstance(jLabel52.getWidth(), jLabel52.getHeight(), Image.SCALE_SMOOTH);
        Image img1=icon1.getImage().getScaledInstance(jLabel53.getWidth(), jLabel53.getHeight(), Image.SCALE_SMOOTH);
        Image img2=icon2.getImage().getScaledInstance(jLabel76.getWidth(), jLabel76.getHeight(), Image.SCALE_SMOOTH);
        Image img3=icon3.getImage().getScaledInstance(jLabel64.getWidth(), jLabel64.getHeight(), Image.SCALE_SMOOTH);
        Image img4=icon4.getImage().getScaledInstance(jLabel70.getWidth(), jLabel70.getHeight(), Image.SCALE_SMOOTH);
        Image img5=icon5.getImage().getScaledInstance(jLabel106.getWidth(), jLabel106.getHeight(), Image.SCALE_SMOOTH);
        Image img6=icon6.getImage().getScaledInstance(jLabel100.getWidth(), jLabel100.getHeight(), Image.SCALE_SMOOTH);
        Image img7=icon7.getImage().getScaledInstance(jLabel82.getWidth(), jLabel82.getHeight(), Image.SCALE_SMOOTH);
        Image img8=icon8.getImage().getScaledInstance(jLabel88.getWidth(), jLabel88.getHeight(), Image.SCALE_SMOOTH);
        Image img9=icon9.getImage().getScaledInstance(jLabel94.getWidth(), jLabel94.getHeight(), Image.SCALE_SMOOTH);
        
        jLabel52.setIcon(new ImageIcon(img));
        jLabel53.setIcon(new ImageIcon(img1));
        jLabel76.setIcon(new ImageIcon(img2));
        jLabel64.setIcon(new ImageIcon(img3));
        jLabel70.setIcon(new ImageIcon(img4));
        jLabel106.setIcon(new ImageIcon(img5));
        jLabel100.setIcon(new ImageIcon(img6));
        jLabel82.setIcon(new ImageIcon(img7));
        jLabel88.setIcon(new ImageIcon(img8));*/
        //jLabel94.setIcon(new ImageIcon(img9));
        MenuController mn=new MenuController();        
        mn.LoadImage(10, jLabel94);
        mn.LoadImage(1, jLabel52);
        mn.LoadImage(9, jLabel88);
        mn.LoadImage(8, jLabel82);
        mn.LoadImage(7, jLabel100);
        mn.LoadImage(6, jLabel106);
        mn.LoadImage(5, jLabel70);
        mn.LoadImage(4, jLabel64);
        mn.LoadImage(3, jLabel76);
        mn.LoadImage(2, jLabel53);
    }
    private boolean qtyisZero(int qty){
        if(qty==0){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng");
            return false;
        }
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jSpinner11 = new javax.swing.JSpinner();
        jCheckBox11 = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel15 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jSpinner13 = new javax.swing.JSpinner();
        jCheckBox13 = new javax.swing.JCheckBox();
        jPanel16 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jSpinner14 = new javax.swing.JSpinner();
        jCheckBox14 = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        jCheckBox15 = new javax.swing.JCheckBox();
        jPanel18 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jSpinner16 = new javax.swing.JSpinner();
        jCheckBox16 = new javax.swing.JCheckBox();
        jPanel19 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jSpinner17 = new javax.swing.JSpinner();
        jCheckBox17 = new javax.swing.JCheckBox();
        ReceiptBtn = new javax.swing.JToggleButton();
        ResetBtn = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PurchaseArea = new javax.swing.JTextArea();
        TotalText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextTime = new javax.swing.JLabel();
        jTextDate = new javax.swing.JLabel();
        jTextDate2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JToggleButton();
        DeleteLineBtn = new javax.swing.JToggleButton();
        InvoiceBtn = new javax.swing.JToggleButton();
        EDBtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đồ uống");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel54.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("Giá:");

        jLabel55.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("Số lượng:");

        jLabel57.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel58.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jCheckBox8.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox8.setText("Mua");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox8)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đồ uống");

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel59.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Giá:");

        jLabel60.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Số lượng:");

        jLabel62.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel63.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox9.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox9.setText("Mua");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox9)
                            .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel65.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 51));
        jLabel65.setText("Giá:");

        jLabel66.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setText("Số lượng:");

        jLabel68.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(51, 51, 51));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel69.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox10.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox10.setText("Mua");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox10)))
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel71.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(51, 51, 51));
        jLabel71.setText("Giá:");

        jLabel72.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(51, 51, 51));
        jLabel72.setText("Số lượng:");

        jLabel74.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(51, 51, 51));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel75.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner11.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox11.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox11.setText("Mua");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox11)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox11)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel77.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(51, 51, 51));
        jLabel77.setText("Giá:");

        jLabel78.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(51, 51, 51));
        jLabel78.setText("Số lượng:");

        jLabel80.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 51));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel81.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner12.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox12.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox12.setText("Mua");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox12))
                                .addGap(0, 25, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox12)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel83.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(51, 51, 51));
        jLabel83.setText("Giá:");

        jLabel84.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(51, 51, 51));
        jLabel84.setText("Số lượng:");

        jLabel86.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(51, 51, 51));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel87.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner13.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox13.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox13.setText("Mua");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel84)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox13)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel83)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox13)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel89.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(51, 51, 51));
        jLabel89.setText("Giá:");

        jLabel90.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(51, 51, 51));
        jLabel90.setText("Số lượng:");

        jLabel92.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(51, 51, 51));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel93.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner14.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner14.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox14.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox14.setText("Mua");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox14)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel89)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox14)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(204, 204, 204));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel95.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(51, 51, 51));
        jLabel95.setText("Giá:");

        jLabel96.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(51, 51, 51));
        jLabel96.setText("Số lượng:");

        jLabel98.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(51, 51, 51));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel99.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner15.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner15.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox15.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox15.setText("Mua");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox15)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel95)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox15)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel101.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(51, 51, 51));
        jLabel101.setText("Giá:");

        jLabel102.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(51, 51, 51));
        jLabel102.setText("Số lượng:");

        jLabel104.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(51, 51, 51));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel105.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner16.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner16.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox16.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox16.setText("Mua");
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel102)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox16)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel101)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        jLabel107.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(51, 51, 51));
        jLabel107.setText("Giá:");

        jLabel108.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(51, 51, 51));
        jLabel108.setText("Số lượng:");

        jLabel110.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(51, 51, 51));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel111.setForeground(new java.awt.Color(51, 51, 51));

        jSpinner17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSpinner17.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jCheckBox17.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox17.setText("Mua");
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel108)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox17)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel107)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox17)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        ReceiptBtn.setBackground(new java.awt.Color(0, 102, 102));
        ReceiptBtn.setText("Xác nhận HĐ");
        ReceiptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptBtnActionPerformed(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(0, 102, 102));
        ResetBtn.setText("Làm mới");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));

        PurchaseArea.setEditable(false);
        PurchaseArea.setBackground(new java.awt.Color(255, 255, 255));
        PurchaseArea.setColumns(20);
        PurchaseArea.setForeground(new java.awt.Color(51, 51, 51));
        PurchaseArea.setRows(5);
        jScrollPane1.setViewportView(PurchaseArea);

        TotalText.setEditable(false);
        TotalText.setBackground(new java.awt.Color(255, 255, 255));
        TotalText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        TotalText.setForeground(new java.awt.Color(51, 51, 51));
        TotalText.setText("0");
        TotalText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalTextActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Tổng:");

        jTextTime.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jTextTime.setForeground(new java.awt.Color(51, 51, 51));

        jTextDate.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jTextDate.setForeground(new java.awt.Color(51, 51, 51));

        jTextDate2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jTextDate2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Đơn vị tính: VND");

        BackBtn.setBackground(new java.awt.Color(0, 102, 102));
        BackBtn.setText("Trở về ");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        DeleteLineBtn.setBackground(new java.awt.Color(0, 102, 102));
        DeleteLineBtn.setText("Xóa");
        DeleteLineBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteLineBtnMouseClicked(evt);
            }
        });
        DeleteLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteLineBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextTime, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteLineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextTime, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jTextDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteLineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(BackBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        InvoiceBtn.setBackground(new java.awt.Color(0, 102, 102));
        InvoiceBtn.setText("In HĐ");
        InvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvoiceBtnActionPerformed(evt);
            }
        });

        EDBtn.setBackground(new java.awt.Color(0, 102, 102));
        EDBtn.setText("Chỉnh Sửa đồ uống");
        EDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ReceiptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(EDBtn))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EDBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InvoiceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReceiptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        reset();
        Cafe();
        ResetBtn.setSelected(false);
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
                    
                    Home HomeFrame =new Home();
                    HomeFrame.setVisible(true);
                    HomeFrame.pack();                    
                    HomeFrame.setLocationRelativeTo( null);//c:null
                    this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed
    private void Cafe(){
        PurchaseArea.setText("\t**********HTN Cafe*********\n"+"Giờ: "+jTextTime.getText()+"  Ngày: "+jTextDate.getText()+"\nDanh sách đồ uống:\t\t"+"Price($)\n");
    }
    
    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
       // MenuController qtyZ =new MenuController();
       
        
    
        int qty=Integer.parseInt(jSpinner8.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox8.isSelected()){
            if("".equals(jLabel57.getText())|| "".equals(jLabel58.getText()) || "0".equals(jLabel58.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner8.setValue(0);
                jCheckBox8.setSelected(false);                        
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel58.getText());
              int price=qty*value;
              total+=price;         
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel57.getText()+"(SL:"+jSpinner8.getValue()+")"+"\t\t"+price+"\n");
              jSpinner8.setValue(0);
              jCheckBox8.setSelected(false);
              setTotal();
            }
        }else{
           jCheckBox8.setSelected(false);
        }
        
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner9.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox9.isSelected()){
            if("".equals(jLabel62.getText())|| "".equals(jLabel63.getText()) || "0".equals(jLabel63.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner9.setValue(0);
                jCheckBox9.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel63.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel62.getText()+"(SL:"+jSpinner9.getValue()+")"+"\t\t"+price+"\n");
              jSpinner9.setValue(0);
              jCheckBox9.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox9.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner12.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox12.isSelected()){
            if("".equals(jLabel80.getText())|| "".equals(jLabel81.getText()) || "0".equals(jLabel81.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner12.setValue(0);
                jCheckBox12.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel81.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel80.getText()+"(SL:"+jSpinner12.getValue()+")"+"\t\t\t"+price+"\n");
              jSpinner12.setValue(0);
              jCheckBox12.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox12.setSelected(false);
        }
       
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner10.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox10.isSelected()){
            if("".equals(jLabel68.getText())|| "".equals(jLabel69.getText()) || "0".equals(jLabel69.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner10.setValue(0);
                jCheckBox10.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel69.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel68.getText()+"(SL:"+jSpinner10.getValue()+")"+"\t\t"+price+"\n");
              jSpinner10.setValue(0);
              jCheckBox10.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox10.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner11.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox11.isSelected()){
            if("".equals(jLabel74.getText())|| "".equals(jLabel75.getText()) || "0".equals(jLabel75.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner11.setValue(0);
                jCheckBox11.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel75.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel74.getText()+"(SL:"+jSpinner11.getValue()+")"+"\t\t"+price+"\n");
              jSpinner11.setValue(0);
              jCheckBox11.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox11.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner17.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox17.isSelected()){
            if("".equals(jLabel110.getText())|| "".equals(jLabel111.getText()) || "0".equals(jLabel111.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner17.setValue(0);
                jCheckBox17.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel111.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel110.getText()+"(SL:"+jSpinner17.getValue()+")"+"\t\t"+price+"\n");
              jSpinner17.setValue(0);
              jCheckBox17.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox17.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
       // MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner16.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox16.isSelected()){
            if("".equals(jLabel104.getText())|| "".equals(jLabel105.getText()) || "0".equals(jLabel105.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner16.setValue(0);
                jCheckBox16.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel105.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel104.getText()+"(SL:"+jSpinner16.getValue()+")"+"\t\t"+price+"\n");
              jSpinner16.setValue(0);
              jCheckBox16.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox16.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner13.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox13.isSelected()){
            if("".equals(jLabel86.getText())|| "".equals(jLabel87.getText()) || "0".equals(jLabel87.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner13.setValue(0);
                jCheckBox13.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel87.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel86.getText()+"(SL:"+jSpinner13.getValue()+")"+"\t\t"+price+"\n");
              jSpinner13.setValue(0);
              jCheckBox13.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox13.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner14.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox14.isSelected()){
            if("".equals(jLabel92.getText())|| "".equals(jLabel93.getText()) || "0".equals(jLabel93.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner14.setValue(0);
                jCheckBox14.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel93.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel92.getText()+"(SL:"+jSpinner14.getValue()+")"+"\t\t"+price+"\n");
              jSpinner14.setValue(0);
              jCheckBox14.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox14.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        //MenuController qtyZ =new MenuController();
        int qty=Integer.parseInt(jSpinner15.getValue().toString());
        if(qtyisZero(qty)&& jCheckBox15.isSelected()){
            if("".equals(jLabel98.getText())|| "".equals(jLabel99.getText()) || "0".equals(jLabel99.getText())){
                JOptionPane.showMessageDialog(null, "Đồ uống này hiện không được bán");
                jSpinner15.setValue(0);
                jCheckBox15.setSelected(false);
            }else{
            x++;
              if(x==1){
                  Cafe();
              }
              MenuController me =new MenuController();
              int value = me.ChangeValue(jLabel99.getText());
              int price=qty*value;
               total+=price;
              PurchaseArea.setText(PurchaseArea.getText()+x+". "+jLabel98.getText()+"(SL:"+jSpinner15.getValue()+")"+"\t\t"+price+"\n");
              jSpinner15.setValue(0);
              jCheckBox15.setSelected(false);
              setTotal();
            }
        }else{
            jCheckBox15.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox15ActionPerformed
    private int findNthOccurrence(String text, String substr, int n){
        int pos =-1;
        while(n-- >1 && pos!=-1){
            pos=text.indexOf(substr,pos+1);           
        }
        return pos;
    }
    private void DeleteLineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteLineBtnActionPerformed
       String text = PurchaseArea.getText();
                String[] lines = text.split("\n");
                
                
                    if(lines.length>3){

                   // String text = PurchaseArea.getText(); // Lấy toàn bộ văn bản trong JTextArea
                    int lastLineBreak = text.lastIndexOf("\n"); // Tìm vị trí xuống dòng cuối cùng
                    int secondLastLineBreak = text.lastIndexOf("\n", lastLineBreak - 1);
                    if (lastLineBreak >0 && lines.length>3) { // Nếu có dòng để xóa
                        int thlines=findNthOccurrence(text, "\n", 3);
                        DeleteLineBtn.setSelected(false);
                    if(lastLineBreak>thlines){    
                        text = text.substring(0, secondLastLineBreak); // Cắt bỏ dòng cuối cùng
                        text= text+"\n";
                        PurchaseArea.setText(text);// Cập nhật lại JTextArea
                        //PurchaseArea.setCaretPosition(PurchaseArea.getDocument().getLength());
                        DeleteLineBtn.setSelected(false);
                            } 
                        }
                    
                    }
        
    }//GEN-LAST:event_DeleteLineBtnActionPerformed

    private void ReceiptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptBtnActionPerformed
        if(total==0.0){
            JOptionPane.showMessageDialog(null, "Vui lòng mua sản phẩm");
        }else{
            //PurchaseArea.setText(PurchaseArea.getText());
            Date date =new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(date);
            datesql=formattedDate;
            timesql=jTextTime.getText();
            totalsql=total; 
            setTotal();
            PurchaseArea.setText(PurchaseArea.getText()+"Nhân viên thanh toán đơn này: "+Control.getInstance().getName());
            String formatted = String.format("%d", total);
            String time= timesql;
           String text=PurchaseArea.getText() + "\nTổng: " + TotalText.getText();
           int total=totalsql;
        if(total!=0  ){
            if(DeleteLineBtn.isEnabled()){
                int result = JOptionPane.showOptionDialog(null, "Bạn chắc chắn muốn xác nhận hóa đơn?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);   
                if (result == JOptionPane.YES_OPTION) {    
                    MenuController save =new MenuController();
                    save.InsertDB(time,total, datesql);
                    save.InsertBillToDB(time, text, datesql, Control.getInstance().getIdquan());
                     JOptionPane.showMessageDialog(null, "Thanh toán thành công");
                     ReceiptBtn.setSelected(false);
                }else{
            
                }
            }else{
                 JOptionPane.showMessageDialog(null, "Bạn chưa tính tổng cho đơn hàng hiện tại");
            }
            
        }else{
             JOptionPane.showMessageDialog(null, "Bạn chưa tính tổng cho đơn hàng hiện tại");
        }

        }
                
    }//GEN-LAST:event_ReceiptBtnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void TotalTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalTextActionPerformed

    private void InvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvoiceBtnActionPerformed
        if(total!=0  ){
            
                try {
                    PurchaseArea.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(Menuu.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        }else{
             JOptionPane.showMessageDialog(null, "Bạn chưa mua bất kì đồ uống nào");
        }
    }//GEN-LAST:event_InvoiceBtnActionPerformed

    private void EDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDBtnActionPerformed
        EditDrink HomeFrame =new EditDrink();
                    HomeFrame.setVisible(true);
                    HomeFrame.pack();                    
                    HomeFrame.setLocationRelativeTo( null);//c:null
                    this.dispose();
    }//GEN-LAST:event_EDBtnActionPerformed

    private void DeleteLineBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteLineBtnMouseClicked
        
    }//GEN-LAST:event_DeleteLineBtnMouseClicked
    //hàm loop vô tận load thời gian
    private void setTime(){
        
        new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(Menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                     Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss aa ");
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");
                    SimpleDateFormat df1 =new SimpleDateFormat("EEEE");
                    String time = tf.format(date);
                    jTextTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    jTextDate.setText(df.format(date));
                    jTextDate2.setText(df1.format(date));
                }
            }           
        }).start();
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menuu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BackBtn;
    private javax.swing.JToggleButton DeleteLineBtn;
    private javax.swing.JToggleButton EDBtn;
    private javax.swing.JToggleButton InvoiceBtn;
    private javax.swing.JTextArea PurchaseArea;
    private javax.swing.JToggleButton ReceiptBtn;
    private javax.swing.JToggleButton ResetBtn;
    private javax.swing.JTextField TotalText;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner13;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner16;
    private javax.swing.JSpinner jSpinner17;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JLabel jTextDate;
    private javax.swing.JLabel jTextDate2;
    private javax.swing.JLabel jTextTime;
    // End of variables declaration//GEN-END:variables
}
