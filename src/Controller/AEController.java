/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import view.Employee;
import java.sql.*;

/**
 *
 * @author PhelanUX
 */
public class AEController {
    
    public boolean isNumeric(String str) {
    // Sử dụng biểu thức chính quy để kiểm tra xem chuỗi có phải là số hay không
    return str != null && str.matches("[0-9]+");
    }
    public void Back(){
        Employee e =new Employee();
        e.setVisible(true);
        e.pack();
        e.setLocationRelativeTo(null);        
    }
    public void AddDB(String name, String phone, String address,String maquan){
     String SUrl,SUser,SPass;
        String idd, Name,Phone,Address,query;
         SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
        int workt=0;
     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=java.sql.DriverManager.getConnection(SUrl,SUser,SPass);
            Statement st=con.createStatement();
            if("".equals(name)){
                JOptionPane.showMessageDialog(new JFrame(),"Không được bỏ trống trường Tên","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(phone)){
                JOptionPane.showMessageDialog(new JFrame(),"Không được bỏ trống trường SDT","Error", JOptionPane.ERROR_MESSAGE);
            }else if(!isNumeric(phone)){
                JOptionPane.showMessageDialog(new JFrame(),"SDT không thể chứa chữ và kí tự đặc biệt","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Name=name;
                Phone=phone;
                Address=address;
                //System.out.print(password);
                query="INSERT INTO employee(name,phone,address,maquan,sogiolam)"+
                        "VALUES(?,?,?,?,?)";
                
            try (PreparedStatement pst = con.prepareStatement(query)) {
                
                pst.setString(1,Name);
                pst.setString(2,Phone);    
                pst.setString(3,Address);
                pst.setString(4, maquan);
                pst.setInt(5, workt);
                pst.executeUpdate();
            }
                   
                showMessageDialog(null,"Add new employee successfully");
            }
        }catch(Exception e){
            
        }
}
}
