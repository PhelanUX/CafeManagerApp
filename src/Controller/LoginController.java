/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.Home;
import view.Login;
import view.SignUp1;
import java.sql.CallableStatement;
import javax.lang.model.util.Types;
import view.*;


/**
 *
 * @author PhelanUX
 */
public class LoginController {
    public void SignUp(){
        SignUp1 SignUpFrame =new SignUp1();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo( null);
    }
    public void CreateNewCompany(){
        NewCoffe SignUpFrame =new NewCoffe();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo( null);
    }
     public void ForgotPass(){
        ForgotPass SignUpFrame =new ForgotPass();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo( null);
    }

    public boolean visi=false;
    public void importDataToLabel(String username, String passwordss) {
          String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String password = "";
        String query = "SELECT name FROM user WHERE user_name = ? and password =?";
        
    try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            pst.setString(2, passwordss);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                        // Lấy tên đầy đủ từ cột full_name trong cơ sở dữ liệu
                        String fullName = rs.getString("name");
                        
                        // Hiển thị tên đầy đủ của người dùng lên JLabel
                        Control.getInstance().setName(fullName);
                    }
        
        
    }catch(Exception e){
          //System.out.print("Error"+e.getMessage());  
        }
    
   }
    public int getRole(String username) {
          String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String password = "";
        String query = "SELECT role FROM user WHERE user_name = ?";
        int roleD=0;
    try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, username);            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                        // Lấy tên đầy đủ từ cột full_name trong cơ sở dữ liệu
                        roleD=rs.getInt("role");                                                
                    }
        
        
    }catch(Exception e){
          JOptionPane.showMessageDialog(new JFrame(),"Không tìm thấy vai trò của người vừa đăng nhập","Error", JOptionPane.ERROR_MESSAGE);
        }
    return roleD;
   }
    public void InsertBD(String user_name, String password){
         String SUrl,SUser,SPass;
        String  User_name, Password,query,fname = null, passDb = null;
            SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
            int notFound=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(SUrl,SUser,SPass);
            Statement st=con.createStatement();
            if("".equals(user_name)){
                JOptionPane.showMessageDialog(new JFrame(),"Vui lòng điền vào trường tên đăng nhập","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(password)){
                JOptionPane.showMessageDialog(new JFrame(),"Vui lòng điền vào trường mật khẩu","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                User_name=user_name;
                Password=password;
                
                query="SELECT* FROM user where user_name='"+User_name+"'";
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){
                    passDb=rs.getString("password");
                    fname=rs.getString("name");
                    notFound=1;
                }
                if(notFound==1 && Password.equals(passDb)){
                    //System.out.print("Okay");
                    Home HomeFrame =new Home();
                    HomeFrame.setVisible(true);
                    HomeFrame.setName(fname);
                    HomeFrame.pack();                    
                    HomeFrame.setLocationRelativeTo( null);//c:null
                    visi=true;
                    
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"Tên dăng nhập hoặc mật khẩu không đúng","Error", JOptionPane.ERROR_MESSAGE);
                }
                
                user_name="";
                password="";                
            }
        }catch(Exception e){
          System.out.print("Error"+e.getMessage());  
        }
    }
    public String getIDquan(String username) {
        String email = null;
        String maquan = null;
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String dbPassword = "";

        String query = "SELECT maquan FROM user WHERE user_name = ?";

        try (Connection con = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);            
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                maquan=rs.getString("maquan");

                
                
            } else {
                 JOptionPane.showMessageDialog(new JFrame(),"Không tìm thấy mã quán dùng tài khoản đã nhập","Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return maquan;
    }
    public String getName(String username) {
       String name="";
        String maquan = null;
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String dbPassword = "";

        String query = "SELECT name FROM user WHERE user_name = ?";

        try (Connection con = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);            
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                name=rs.getString("name");

                
                
            } else {
                 JOptionPane.showMessageDialog(new JFrame(),"Không tìm thấy mã quán dùng tài khoản đã nhập","Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }
    public void  InsertBDProc(String user_name, String password){
         String SUrl,SUser,SPass;
        String  User_name, Password,query,fname = null, passDb = null;
        Boolean isValidPassword=false; 
            SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
            //int notFound=0;
            CallableStatement cstmt=null;          
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(SUrl,SUser,SPass);
           String queryProc="{Call CheckPassword(?,?,?)}";
           cstmt=con.prepareCall(queryProc);
            if("".equals(user_name)){
                JOptionPane.showMessageDialog(new JFrame(),"Vui lòng điền vào trường tên đăng nhập","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(password)){
                JOptionPane.showMessageDialog(new JFrame(),"Vui lòng điền vào trường mật khẩu","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                User_name=user_name;
                Password=password;
                
                cstmt.setString(1, User_name);
                cstmt.setString(2, Password);
                cstmt.registerOutParameter(3, java.sql.Types.BOOLEAN);
                cstmt.execute();
                isValidPassword =cstmt.getBoolean(3);
                if (isValidPassword) {
                                
                /*Home HomeFrame = new Home();
                HomeFrame.setVisible(true);
                HomeFrame.setName(fname);
                HomeFrame.pack();
                HomeFrame.setLocationRelativeTo(null); // c:null
                 visi=true;*/
                drfault HomeFrame = new drfault();
                HomeFrame.setVisible(true);
                HomeFrame.setName(fname);
                HomeFrame.pack();
                HomeFrame.setLocationRelativeTo(null); // c:null
                 visi=true;
                importDataToLabel(User_name,Password);
            
            Control.getInstance().setIdquan(getIDquan(User_name));
            Control.getInstance().setName(getName(User_name));
            Control.getInstance().setRole(getRole(User_name));
            //System.out.print(Control.getInstance().getName());
            
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Tên đăng nhập hoặc mật khẩu không đúng", "Error", JOptionPane.ERROR_MESSAGE);
                
            }

            user_name = "";
            password = "";
                       
            }
        }catch(Exception e){
          System.out.print("Error"+e.getMessage());  
          JOptionPane.showMessageDialog(new JFrame(),"Loi database ","Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}   

