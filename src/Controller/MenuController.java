/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author PhelanUX
 */
public class MenuController {
//   public boolean qtyisZero(int qty){
//        if(qty==0){
//            JOptionPane.showMessageDialog(null, "Vui long chon so luong");
//            return false;
//        }
//        return true;
//    }
    
   public void InsertDB(String time, int total, String date){
    String SUrl,SUser,SPass;
        String query;
        String datesql;
        String timesql;
        int totalsql;
       
         SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(SUrl,SUser,SPass);
            Statement st=con.createStatement();
            if("".equals(time)&& "".equals(date)){
                JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề với ngày tháng của bạn","Error", JOptionPane.ERROR_MESSAGE);
            }else if(total<0){
                JOptionPane.showMessageDialog(new JFrame(),"Tổng thanh toán phải lớn hơn 0","Error", JOptionPane.ERROR_MESSAGE);
            }else{
                timesql=time;
                datesql=date;
                totalsql=total;
                
                 query = "INSERT INTO revenue(time, total, date,maquan) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, timesql);
                pst.setInt(2, totalsql);
                pst.setString(3, datesql);
                pst.setString(4, Control.getInstance().getIdquan());
                pst.executeUpdate();
            }

                //roleText.setText("");
                
            }
        }catch(Exception e){
          //System.out.print("Error"+e.getMessage());  
        }
}
   public int ChangeValue(String Svalue){
       int intValue = Integer.parseInt(Svalue);
       return intValue;
   }
    public String getDrinkNameByCode(String drinkCode) {
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String password = "";
        String query = "SELECT tensp FROM drink WHERE masp = ?";
        String drinkName = null;

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, drinkCode);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                drinkName = rs.getString("tensp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return drinkName;
    }
    public String getDrinkPriceByCode(String drinkCode) {
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String password = "";
        String query = "SELECT dongia FROM drink WHERE masp = ?";
        String drinkPrice = null;

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, drinkCode);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                drinkPrice = rs.getString("dongia");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return drinkPrice;
    }
    public void InsertBillToDB(String time, String myTextArea, String date,String maquan){
    String SUrl,SUser,SPass;
        String query;
        String datesql;
        String timesql;
        
       
         SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(SUrl,SUser,SPass);
            Statement st=con.createStatement();
            if("".equals(time)&& "".equals(date)){
                JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề với ngày tháng của bạn","Error", JOptionPane.ERROR_MESSAGE);
            }else if(myTextArea.equals("")){
                JOptionPane.showMessageDialog(new JFrame(),"Bạn cầ mua hàng trước khi thanh toán","Error", JOptionPane.ERROR_MESSAGE);
            }else{
                timesql=time;
                datesql=date;
                
                
                 query = "INSERT INTO bill(maquan, ctietbill, date, time ) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, maquan);
                
                pst.setString(2, myTextArea);
                pst.setString(3, datesql);
                pst.setString(4, timesql);
                pst.executeUpdate();
            }

                //roleText.setText("");
                
            }
        }catch(Exception e){
          //System.out.print("Error"+e.getMessage());  
           JOptionPane.showMessageDialog(new JFrame(),"Có Lỗi "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void LoadImage(int id, JLabel imgLabel){
        String query="select image from drink where masp=?";        
        String    SUrl="jdbc:MySQL://localhost:3306/cafemanager";
        String    SUser="root";
        String    SPass="";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(SUrl,SUser,SPass);
           PreparedStatement pss= con.prepareStatement(query);
           pss.setInt(1, id);
           ResultSet rs= pss.executeQuery();
           if(rs.next()){
               byte[] imgBytes=rs.getBytes("image");
               if(imgBytes!=null){
                   InputStream is=new ByteArrayInputStream(imgBytes);
                   BufferedImage img= ImageIO.read(is);
                   imgLabel.setIcon(new ImageIcon(img));
               }else {
                    JOptionPane.showMessageDialog(null, "Không có hình ảnh cho đồ uống này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
           }else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy đồ uống với ID này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải ảnh: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
