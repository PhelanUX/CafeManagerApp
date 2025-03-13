/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static javax.swing.JOptionPane.showMessageDialog;
import view.Login;

/**
 *
 * @author PhelanUX
 */
public class NewCoffeController {
    public String callProc() {
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String password = "";
        String randomString="";
       

         try {
                    // Kết nối đến cơ sở dữ liệu
                    Connection conn = DriverManager.getConnection(url, user, password);

                    // Gọi thủ tục
                    String sql = "{CALL generate_random_idcoffe(?)}";
                    CallableStatement stmt = (CallableStatement) conn.prepareCall(sql);

                    // Đăng ký tham số OUT
                    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);

                    // Thực hiện thủ tục
                    stmt.execute();

                    // Lấy giá trị trả về từ thủ tục
                     randomString = stmt.getString(1);
                    stmt.close();
                    conn.close();
                        
                    // Đóng kết nối
                    
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(new JFrame(),"Mật khẩu mới không khớp","Error", JOptionPane.ERROR_MESSAGE);
                }
         return randomString;
        }    
    public void AddNewCompany(String name, String id,String email){
     String SUrl,SUser,SPass;
        String query;
         SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
        String NameC,IDC=id,Email=email;
     
        try{
            
            Connection con=java.sql.DriverManager.getConnection(SUrl,SUser,SPass);
            Statement st=con.createStatement();
            if("".equals(name)){
                JOptionPane.showMessageDialog(new JFrame(),"Không được bỏ trống trường Tên","Error", JOptionPane.ERROR_MESSAGE);
            }else if(containsSpecialCharacter(name)){
                JOptionPane.showMessageDialog(new JFrame(),"Trường tên quán không thể chứa kí tự đặc biệt","Error", JOptionPane.ERROR_MESSAGE);
            }else if(isCoffeNameExist(name)){
                JOptionPane.showMessageDialog(new JFrame(),"Tên quán đã tốn tại, hãy chọn tên khác","Error", JOptionPane.ERROR_MESSAGE);
            }else if(containsSpecialCharacter(id)){
                JOptionPane.showMessageDialog(new JFrame(),"Trường mã quán không thể chứa kí tự đặc biệt","Error", JOptionPane.ERROR_MESSAGE);
            }else if(id.length()<3 || id.length()>3){
                JOptionPane.showMessageDialog(new JFrame(),"Trường mã quán chỉ có thể chứa được 3 kí tự","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường Email","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!isValidEmail(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Hãy nhập đúng định dạng email \n____@gmail.com","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(isEmailExist(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Email đã được sử dụng","Error", JOptionPane.ERROR_MESSAGE);             
            }
            else if ("".equals(id)){
               int result = JOptionPane.showOptionDialog(null, "Bạn chắc chắn muốn bỏ trống trường này?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null); 
               if (result == JOptionPane.YES_OPTION) {    
                    IDC=callProc();                           
                }else{            
                }               
            }
            else{
                NameC=name;                                               
                query="INSERT INTO tenquan(tenquan,maquan,email)"+
                        "VALUES(?,?,?)";
                
            try (PreparedStatement pst = con.prepareStatement(query)) {
                
                pst.setString(1,NameC);
                pst.setString(2,IDC);  
                pst.setString(3,Email);
                pst.executeUpdate();
            }
                   
                showMessageDialog(null,"Thêm quán mới thành công");
            }
        }catch(SQLException e){
           // JOptionPane.showMessageDialog(new JFrame(),"Không thể thêm vào CSDL","Error", JOptionPane.ERROR_MESSAGE);
            }
    }
     public void Login(){
        Login SignUpFrame =new Login();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo( null);
    }
      public void sendEmail(String recipientEmail, String id,String name) {
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
            message.setSubject("Bạn đã tạo tên quán mới trên app của chúng tôi"); // Chủ đề của email
            message.setText("Tên quán là: " + name+"\nId của quán là:"+id+"\n Cảm ơn bạn đã sử dụng app của chúng tôi"); // Nội dung email

            // Gửi email
            Transport.send(message);

            JOptionPane.showMessageDialog(new JFrame(),"Chúng tôi đã gửi email chứa tên và mã quán về cho bạn","Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private static final String EMAIL_PATTERN = 
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }    
    public boolean containsSpecialCharacter(String str) {
    // Sử dụng biểu thức chính quy để kiểm tra xem chuỗi có chứa ký tự đặc biệt hay không
        return str != null && str.matches(".*[^a-zA-Z0-9 ].*");
    }
    public boolean isEmailExist(String email) {
      String  URL = "jdbc:MySQL://localhost:3306/cafemanager";
    String USER = "root";
    String PASSWORD = "";
        String query = "SELECT COUNT(*) FROM tenquan WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isCoffeNameExist(String name) {
      String  URL = "jdbc:MySQL://localhost:3306/cafemanager";
    String USER = "root";
    String PASSWORD = "";
        String query = "SELECT COUNT(*) FROM tenquan WHERE tenquan = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}    


