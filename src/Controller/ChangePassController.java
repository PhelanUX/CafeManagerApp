/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import view.Home;
import java.sql.*;
import java.sql.Types;

/**
 *
 * @author PhelanUX
 */
public class ChangePassController {
    private String passReturn;
    private String usernameReturn;
    private Boolean userbool;
    private Boolean passbool;
    public void changePass(String user_name, String pass, String passNew, String passNew1){
        
        String sql = "UPDATE user SET password = ? WHERE user_name = ?";
        String passChange=pass;
        String name=user_name;
        String SUrl,SUser,SPass;
        String passN=passNew;
        int role;
         SUrl="jdbc:mysql://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
            
           
        if("".equals(user_name)){
            JOptionPane.showMessageDialog(new JFrame(),"Cần điền đầy đủ thông tin vào trường mật khẩu cũ","Error", JOptionPane.ERROR_MESSAGE);
        }else if("".equals(passNew)){
            JOptionPane.showMessageDialog(new JFrame(),"Cần điền đầy đủ thông tin vào trường mật khẩu mới","Error", JOptionPane.ERROR_MESSAGE);
        }else if("".equals(passNew1)){
            JOptionPane.showMessageDialog(new JFrame(),"Cần điền đầy đủ thông tin vào trường xác nhận mật khẩu","Error", JOptionPane.ERROR_MESSAGE);
        }else if(!passNew.equals(passNew1)){
            JOptionPane.showMessageDialog(new JFrame(),"Mật khẩu mới không khớp","Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(isPassCorrect(user_name,pass)){
                        JOptionPane.showMessageDialog(new JFrame(),"Mật khẩu không khớp","Error", JOptionPane.ERROR_MESSAGE);
        }else{
       
               try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
                       CallableStatement cstmt = con.prepareCall("{CALL UpdatePassword(?, ?)}");){
                                    
            cstmt.setString(1, name);
            cstmt.setString(2, passN);
            cstmt.execute();
            showMessageDialog(null,"Đồi mật khẩu thành công");
                } catch (SQLException e) {
                   JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề khi cập nhật mật khau","Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    }

    public String getPass(String maquan){
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String username = "root";
        String password = "";
        String sql = "Select user_name from user WHERE maquan=?";
        String Name="";

        
        
                try (Connection conn = java.sql.DriverManager.getConnection(url, username, password);
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    // Thiết lập các tham số cho câu lệnh SQL
                    pstmt.setString(1, maquan);
                    
                    
                    
                    //pstmt.executeUpdate();
                    ResultSet rs=pstmt.executeQuery();
                    
                    if(rs.next()){
                        Name=rs.getString("user_name");
                        }
                    else{
                        
                        }
                    
                    
                } catch (SQLException e) {
                   JOptionPane.showMessageDialog(new JFrame(),"Có vần đề phát sinh","Error", JOptionPane.ERROR_MESSAGE);
                }
                return Name;
    }
   /* public void validUser(String user_name, String pass) {
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String username = "root";
        String password = "";
        String sql = "Select user_name from user WHERE user_name = ? and password=?";
        String passChange=pass;
        String name=user_name;
        
        
                try (Connection conn = java.sql.DriverManager.getConnection(url, username, password);
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    // Thiết lập các tham số cho câu lệnh SQL
                    pstmt.setString(1, name);
                    pstmt.setString(2, passChange);
                    
                    
                    //pstmt.executeUpdate();
                    ResultSet rs=pstmt.executeQuery(sql);
                    while(rs.next()){
                    usernameReturn=rs.getString("user_name");
                    if(usernameReturn.equals(user_name)){
                        userbool=true;
                        }
                    else{
                        userbool=false;
                        }
                    }
                    
                    
                } catch (SQLException e) {
                   JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề xảy ra khi tham chiếu đến ten dang nhap trong csdl","Error", JOptionPane.ERROR_MESSAGE);
                }
            }*/
     public boolean isUsernameExist(String username) {
      String  URL = "jdbc:MySQL://localhost:3306/cafemanager";
    String USER = "root";
    String PASSWORD = "";
        String query = "SELECT COUNT(*) FROM user WHERE user_name = ?";
        try (Connection conn = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
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
      public boolean isPassCorrect(String username, String pass) {
      String  URL = "jdbc:MySQL://localhost:3306/cafemanager";
    String USER = "root";
    String PASSWORD = "";
        String query = "{CALL IsUserAuthenticated(?, ?, ?)}";
        
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         CallableStatement cstmt = conn.prepareCall(query)) {

        cstmt.setString(1, username);
        cstmt.setString(2, pass);
        cstmt.registerOutParameter(3,Types.INTEGER ); // Đăng ký tham số đầu ra

        // Thực thi Stored Procedure
        cstmt.execute();

        // Lấy số lượng người dùng
        int count = cstmt.getInt(3);
        return count > 0; // Trả về true nếu tìm thấy người dùng
        }catch(Exception e){
            
        }
        return false;
      }
    public Boolean passbool(){
        return passbool;
    }
    public Boolean userbool(){
        return userbool;
    }
    
     public String passReturn(){
        return passReturn;
     }
     public String usernameReturn(){
        return usernameReturn;
     }
     public void Home(){
        Home SignUpFrame =new Home();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo( null);
       
    }
}


