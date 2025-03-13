
package view;

import Controller.Control;
import Controller.LoginController;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.showMessageDialog;
public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        init();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        LoginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        FPasswordBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        newCafeBtn = new javax.swing.JButton();
        textDate = new javax.swing.JLabel();
        textTime = new javax.swing.JLabel();
        BtnPW = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setText("Powered by PhelanUX");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quản lí quán cafe");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication15/images.jpg"))); // NOI18N

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 470);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Phần mềm quản lí quán cafe");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tên đăng nhập:");

        user_name.setBackground(new java.awt.Color(255, 255, 255));
        user_name.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(51, 51, 51));
        user_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_nameActionPerformed(evt);
            }
        });
        user_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                user_nameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mật khẩu:");

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(102, 102, 102));
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        LoginBtn.setBackground(new java.awt.Color(0, 102, 102));
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Đăng nhập");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        LoginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginBtnKeyPressed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Tôi không có tài khoản");

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Đăng kí");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        FPasswordBtn.setBackground(new java.awt.Color(255, 102, 102));
        FPasswordBtn.setForeground(new java.awt.Color(255, 255, 255));
        FPasswordBtn.setText("Quên Mật Khẩu");
        FPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FPasswordBtnActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Bạn là chủ quán mới?");

        newCafeBtn.setBackground(new java.awt.Color(153, 153, 153));
        newCafeBtn.setForeground(new java.awt.Color(255, 51, 51));
        newCafeBtn.setText("Đăng kí quán");
        newCafeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCafeBtnActionPerformed(evt);
            }
        });

        textDate.setBackground(new java.awt.Color(255, 255, 255));
        textDate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        textDate.setForeground(new java.awt.Color(0, 0, 0));

        textTime.setBackground(new java.awt.Color(255, 255, 255));
        textTime.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        textTime.setForeground(new java.awt.Color(0, 0, 0));
        textTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        BtnPW.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(newCafeBtn))
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(LeftLayout.createSequentialGroup()
                            .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(textTime, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LeftLayout.createSequentialGroup()
                            .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(user_name, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LeftLayout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LeftLayout.createSequentialGroup()
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnPW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textTime, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(textDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnPW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newCafeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel1.add(Left);
        Left.setBounds(400, 0, 400, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void init(){
        setTime();
        ImageIcon originalshowIcon = new ImageIcon(getClass().getResource("/Images/see.jpg"));
        Image scaledshowImage = originalshowIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedshowIcon = new ImageIcon(scaledshowImage);
        ImageIcon originalhideIcon = new ImageIcon(getClass().getResource("/Images/unsee.jpg"));
        Image scaledhideImage = originalhideIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedhideIcon = new ImageIcon(scaledhideImage);
        BtnPW.setIcon(resizedshowIcon);
        BtnPW.addActionListener(new ActionListener() {
            private boolean isPasswordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                isPasswordVisible = !isPasswordVisible; // Đổi trạng thái
                if (isPasswordVisible) {
                    password.setEchoChar((char) 0); // Hiển thị mật khẩu
                    //toggleButton.setText("Ẩn");
                    BtnPW.setIcon(resizedhideIcon);
                } else {
                    password.setEchoChar('*'); // Ẩn mật khẩu
                    //toggleButton.setText("Hiển thị");
                    BtnPW.setIcon(resizedshowIcon);
                }
            }
        });
    }
    private void user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoginController Login =new LoginController();
        Login.SignUp();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed

           String User_name, Password;
            LoginController login =new LoginController();
            User_name=user_name.getText().trim();
            Password=password.getText();
            //login.InsertBD(User_name, Password);
            login.InsertBDProc(User_name, Password);
            if(login.visi==true){
                this.dispose();
            }            
            
            //System.out.print(Control.getInstance().getRole()+" "+Control.getInstance().getName());
            Control.getInstance().setCurrent(textTime.getText().substring(0, 8));
            Control.getInstance().setUsernamed(user_name.getText());
            Control.getInstance().setIdquan(login.getIDquan(User_name));
            
            
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void FPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FPasswordBtnActionPerformed
        LoginController Login =new LoginController();
        Login.ForgotPass();
        this.dispose();
        
    }//GEN-LAST:event_FPasswordBtnActionPerformed

    private void newCafeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCafeBtnActionPerformed
         LoginController Login =new LoginController();
        Login.CreateNewCompany();
        this.dispose();
    }//GEN-LAST:event_newCafeBtnActionPerformed

    private void LoginBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginBtnKeyPressed
        
    }//GEN-LAST:event_LoginBtnKeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if( evt.getKeyCode()==KeyEvent.VK_ENTER){
            String User_name, Password;
            LoginController login =new LoginController();
            User_name=user_name.getText().trim();
            Password=password.getText();
            //login.InsertBD(User_name, Password);
            login.InsertBDProc(User_name, Password);
            if(login.visi==true){
                this.dispose();
            }            
            Control.getInstance().setCurrent(textTime.getText().substring(0, 8));
            Control.getInstance().setUsernamed(user_name.getText());

        }
    }//GEN-LAST:event_passwordKeyPressed

    private void user_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_nameKeyPressed
        if( evt.getKeyCode()==KeyEvent.VK_ENTER){
            String User_name, Password;
            LoginController login =new LoginController();
            User_name=user_name.getText().trim();
            Password=password.getText();
            //login.InsertBD(User_name, Password);
            login.InsertBDProc(User_name, Password);
            if(login.visi==true){
                this.dispose();
            }            
            
            //System.out.print(Control.getInstance().getIdquan());
            Control.getInstance().setCurrent(textTime.getText().substring(0, 8));
            Control.getInstance().setUsernamed(user_name.getText());

        }
        
    }//GEN-LAST:event_user_nameKeyPressed
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
                    SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat df1 =new SimpleDateFormat("EEEE");
                    String time = tf.format(date);
                    textTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    textDate.setText(df.format(date));
                    
                }
            }           
        }).start();
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPW;
    private javax.swing.JButton FPasswordBtn;
    private javax.swing.JPanel Left;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPanel Right;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newCafeBtn;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel textDate;
    private javax.swing.JLabel textTime;
    private javax.swing.JTextField user_name;
    // End of variables declaration//GEN-END:variables
}
