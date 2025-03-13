/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import view.Login;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import view.Home;


/**
 *
 * @author PhelanUX
 */
public class FPController {
    public String getPasswordAndEmail(String username) {
        String email = null;
        String password = null;
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String dbPassword = "";

        String query = "SELECT email, password FROM user WHERE email = ?";

        try (Connection con = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                email = rs.getString("email");
                password = rs.getString("password");

                
                sendEmail(email, password);
            } else {
                 JOptionPane.showMessageDialog(new JFrame(),"Không tìm thấy người dùng theo email bạn đã nhập","Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return email;
    }
    // Phương thức gửi email sử dụng JavaMail API
    public void sendEmail(String recipientEmail, String password) {
        // Cấu hình các thuộc tính của mail server (ví dụ sử dụng Gmail)
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server của Gmail
        properties.put("mail.smtp.port", "587");

        // Thông tin tài khoản email của bạn để gửi
        String Email = "baba1999m.m@gmail.com";
        String EmailPassword = "zdakogdlwfvivdcv"; // Mật khẩu ứng dụng (app passwords)

        // Tạo phiên làm việc (session)
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Email, EmailPassword);
            }
        });

        try {
            // Tạo tin nhắn email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Email)); // Địa chỉ email người gửi
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // Địa chỉ người nhận
            message.setSubject("Yêu cầu khôi phục mật khẩu"); // Chủ đề của email
            message.setText("Mật khẩu của bạn là: " + password); // Nội dung email

            // Gửi email
            Transport.send(message);

            JOptionPane.showMessageDialog(new JFrame(),"Email đã được gửi thành công","Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    } 
    public void Home(){
        Login SignUpFrame =new Login();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo( null);
       
    }
    public String resetPasswordAndSendEmail(String email) {
    String plainPassword = null; // Mật khẩu chưa mã hóa trả về từ procedure
    String url = "jdbc:mysql://localhost:3306/cafemanager";
    String user = "root";
    String dbPassword = "";

    String callProcedure = "{CALL ResetPasswordAndUpdate2(?, ?)}";

    try (Connection con = DriverManager.getConnection(url, user, dbPassword);
         CallableStatement cst = con.prepareCall(callProcedure)) {

        // Thiết lập tham số đầu vào
        cst.setString(1, email);

        // Thiết lập tham số đầu ra
        cst.registerOutParameter(2, java.sql.Types.VARCHAR);

        // Thực thi procedure
        cst.execute();

        // Lấy mật khẩu chưa mã hóa từ tham số đầu ra
        plainPassword = cst.getString(2);

        if (plainPassword != null) {
            // Gửi email chứa mật khẩu mới
            sendEmail(email, plainPassword);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Không tìm thấy email trong cơ sở dữ liệu!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(new JFrame(), "Có lỗi xảy ra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return plainPassword;
}




}
