
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import Controller.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class SignUp1 extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp1() {
        initComponents();
        loadDataIntoComboBox();
        BtnShowPW();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        user_nameText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        SignUpBtn = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        passwordText1 = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        BtnShowPW2 = new javax.swing.JButton();
        BtnShowPW1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng kí");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication15/images.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel3.setText("powered by PhelanUX");

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Xin Chào");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(271, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(105, 105, 105))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(89, 89, 89)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 650);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Đăng kí");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tên:");

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(51, 51, 51));

        user_nameText.setBackground(new java.awt.Color(255, 255, 255));
        user_nameText.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        user_nameText.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tên đăng nhập:");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Mật khẩu:");

        passwordText.setBackground(new java.awt.Color(255, 255, 255));
        passwordText.setForeground(new java.awt.Color(51, 51, 51));

        SignUpBtn.setBackground(new java.awt.Color(0, 102, 102));
        SignUpBtn.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        SignUpBtn.setText("Đăng kí");
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(0, 153, 255));
        jToggleButton2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton2.setText("Đăng nhập");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Nhập lại mật khẩu:");

        passwordText1.setBackground(new java.awt.Color(255, 255, 255));
        passwordText1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Email:");

        emailText.setBackground(new java.awt.Color(255, 255, 255));
        emailText.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        emailText.setForeground(new java.awt.Color(51, 51, 51));

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Mã Quán:");

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Bạn là:");

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setMaximumRowCount(2);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lí", "Nhân viên" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Đã có tài khoản?");

        BtnShowPW2.setBackground(new java.awt.Color(204, 204, 204));

        BtnShowPW1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(SignUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(passwordText1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnShowPW2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnShowPW1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnShowPW1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordText1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnShowPW2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SignUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(59, 59, 59))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(400, 0, 400, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void BtnShowPW(){
        ImageIcon originalshowIcon = new ImageIcon(getClass().getResource("/images/see.jpg"));
        Image scaledshowImage = originalshowIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedshowIcon = new ImageIcon(scaledshowImage);
        ImageIcon originalhideIcon = new ImageIcon(getClass().getResource("/images/unsee.jpg"));
        Image scaledhideImage = originalhideIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedhideIcon = new ImageIcon(scaledhideImage);
        BtnShowPW2.setIcon(resizedshowIcon);
        BtnShowPW1.setIcon(resizedshowIcon);
        BtnShowPW1.addActionListener(new ActionListener() {
            private boolean isPasswordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                isPasswordVisible = !isPasswordVisible; // Đổi trạng thái
                if (isPasswordVisible) {
                    passwordText.setEchoChar((char) 0); // Hiển thị mật khẩu
                    //toggleButton.setText("Ẩn");
                    BtnShowPW1.setIcon(resizedhideIcon);
                } else {
                    passwordText.setEchoChar('*'); // Ẩn mật khẩu
                    //toggleButton.setText("Hiển thị");
                    BtnShowPW1.setIcon(resizedshowIcon);
                }
            }
        });
        BtnShowPW2.addActionListener(new ActionListener() {
            private boolean isPasswordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                isPasswordVisible = !isPasswordVisible; // Đổi trạng thái
                if (isPasswordVisible) {
                    passwordText1.setEchoChar((char) 0); // Hiển thị mật khẩu
                    //toggleButton.setText("Ẩn");
                    BtnShowPW2.setIcon(resizedhideIcon);
                } else {
                    passwordText1.setEchoChar('*'); // Ẩn mật khẩu
                    //toggleButton.setText("Hiển thị");
                    BtnShowPW2.setIcon(resizedshowIcon);
                }
            }
        });
    }
    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed
        String selectedText = (String) jComboBox1.getSelectedItem();
        String selectedTextComp = (String) jComboBox2.getSelectedItem();
        
        String Name=name.getText();
        String username=user_nameText.getText();
        String pass=passwordText.getText();
        String pass1=passwordText1.getText();
        SignUpController connect= new SignUpController();
        String email=emailText.getText();
        
        
        int role=2;
        if(selectedText.equals("Quản lí")){
            role=2;
        }else{
            role=3;
        }
        connect.ConnectDBProc(username,Name,pass,pass1,email,selectedTextComp,role);
        SignUpBtn.setSelected(false);
        
        
    }//GEN-LAST:event_SignUpBtnActionPerformed
    private void loadDataIntoComboBox() {
        
        String url = "jdbc:mysql://localhost:3306/cafemanager";
            String user = "root";
            String password = "";
            
        try {
            // Kết nối đến MySQL
            
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String query = "SELECT maquan FROM tenquan"; // Truy vấn lấy dữ liệu

            PreparedStatement pss = conn.prepareStatement(query);
            ResultSet rs = pss.executeQuery();

            // Lấy dữ liệu và thêm vào comboBox
            while (rs.next()) {
                String itemName = rs.getString("maquan");
                jComboBox2.addItem(itemName); // Thêm tên sản phẩm vào comboBox
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data from database", "Error", JOptionPane.ERROR_MESSAGE);
        } 
            
        }
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        SignUpController Login = new SignUpController();
        Login.Login();
        this.dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp1().setVisible(true);
            }
        });
        
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnShowPW1;
    private javax.swing.JButton BtnShowPW2;
    private javax.swing.JToggleButton SignUpBtn;
    private javax.swing.JTextField emailText;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JPasswordField passwordText1;
    private javax.swing.JTextField user_nameText;
    // End of variables declaration//GEN-END:variables
}
