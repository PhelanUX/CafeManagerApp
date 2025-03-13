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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.CallableStatement;

/**
 *
 * @author PhelanUX
 */
public class SignUpController {
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
    public boolean isUsernameExist(String username) {
      String  URL = "jdbc:MySQL://localhost:3306/cafemanager";
    String USER = "root";
    String PASSWORD = "";
        String query = "SELECT COUNT(*) FROM user WHERE user_name = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
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
    public boolean isEmailExist(String email) {
      String  URL = "jdbc:MySQL://localhost:3306/cafemanager";
    String USER = "root";
    String PASSWORD = "";
        String query = "SELECT COUNT(*) FROM user WHERE email = ?";
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
    public void ConnectDB(String username, String name,String pass, String pass1, String Email, String Idcoffe, int Role){
     String SUrl,SUser,SPass;
        String fullName, user_name, password,query,email, idcoffe;
        int role;
         SUrl="jdbc:mysql://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
       if(containsSpecialCharacter(username)||containsSpecialCharacter(name)){
           JOptionPane.showMessageDialog(null, "Tên hoặc tên đăng nhập không thể chứa kí tự đặc biệt", "Error", JOptionPane.ERROR_MESSAGE);      
       }else if (isUsernameExist(username)) {
            JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);            
        }else{
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(SUrl,SUser,SPass);
            Statement st=con.createStatement();
            if("".equals(name)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường Tên","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(username)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường user name","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(pass)&& "".equals(pass1)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường mật khẩu","Error", JOptionPane.ERROR_MESSAGE);
            }else if(!pass.equals(pass1)){
                JOptionPane.showMessageDialog(new JFrame(),"Mật khẩu không khớp","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if ("".equals(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường Email","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!isValidEmail(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Hãy nhập đúng định dạng email \n____@gmail.com","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(isEmailExist(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Email đã được sử dụng","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                fullName=name.trim();
                user_name=username.trim();
                password=pass;
                email=Email;
                idcoffe=Idcoffe;
                role=Role;
                //System.out.print(password);
                query="INSERT INTO user(user_name,password,role,name,email,maquan)"+
                        "VALUES(?,?,?,?,?,?)";
                
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1,user_name);
                pst.setString(2,password);  
                pst.setInt(3, role);
                pst.setString(4,fullName);
                pst.setString(5,Email);
                pst.setString(6, idcoffe);
                pst.executeUpdate();
            }
               // st.execute(query);

                //roleText.setText("");
                showMessageDialog(null,"Đăng kí tài khoản thành công");
            }
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),"Không thể dang ki","Error", JOptionPane.ERROR_MESSAGE);
        }
       }
}
    public void Login(){
        Login LoginFrame =new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        
    }
    public void ConnectDBProc(String username, String name,String pass, String pass1, String Email, String Idcoffe, int Role){
     String SUrl,SUser,SPass;
        String fullName, user_name, password,query,email, idcoffe;
        int role;
         SUrl="jdbc:mysql://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
            Connection con=null;
            CallableStatement cstmt=null;
       if(containsSpecialCharacter(username)||containsSpecialCharacter(name)){
           JOptionPane.showMessageDialog(null, "Tên hoặc tên đăng nhập không thể chứa kí tự đặc biệt", "Error", JOptionPane.ERROR_MESSAGE);      
       }else if (isUsernameExist(username)) {
            JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);            
        }else{
        try{
            if("".equals(name)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường Tên","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(username)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường user name","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(pass)&& "".equals(pass1)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường mật khẩu","Error", JOptionPane.ERROR_MESSAGE);
            }else if(!pass.equals(pass1)){
                JOptionPane.showMessageDialog(new JFrame(),"Mật khẩu không khớp","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if ("".equals(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Không thể để trống trường Email","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!isValidEmail(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Hãy nhập đúng định dạng email \n____@gmail.com","Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(isEmailExist(Email)){
                JOptionPane.showMessageDialog(new JFrame(),"Email đã được sử dụng","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            query = "{CALL EncryptPasswordPlus(?, ?,?,?,?,?)}";
            cstmt = con.prepareCall(query);
            cstmt.setString(1, username);
            cstmt.setString(2, pass);
            cstmt.setInt(3, Role);
            cstmt.setString(4, Email);
            cstmt.setString(5, name);
            cstmt.setString(6, Idcoffe);
            cstmt.execute();
            showMessageDialog(null,"Đăng kí tài khoản thành công");
                }catch(Exception e){
                     JOptionPane.showMessageDialog(new JFrame(),"Không thể đăng kí tài khoản","Error", JOptionPane.ERROR_MESSAGE);
                     //System.out.print(e.getMessage());
                    }
            }
        }catch(Exception e){
             e.printStackTrace();
        }finally {
        try {
            if (cstmt != null) cstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       }
       }}
}
