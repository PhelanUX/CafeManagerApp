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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import model.Drink;
import model.Employee;

/**
 *
 * @author PhelanUX
 */
public class MenuNewController {
    
    public void refreshTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện có
        // Cập nhật JTable để hiển thị dữ liệu mới
        table.repaint();
    }
    public List<Drink> getAllInfo(String maquan){
        String query="SELECT tensp, dongia FROM drink where maquan=?";
         List<Drink> list=new ArrayList<>();
        try{
           
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            PreparedStatement pss=conn.prepareStatement(query);
            pss.setString(1, maquan);
            ResultSet rs = pss.executeQuery();
            while(rs.next()){
                String name = rs.getString("tensp");
                String price = rs.getString("dongia");
                list.add(new Drink(name, price));
            }
            
            rs.close();
        }catch(Exception e){
            return null;
        }
        return list;
    }
    public void InsertDB(String time, double total, String date,String maquan){
    String SUrl,SUser,SPass;
        String query;
        String datesql;
        String timesql;
        double totalsql;
       
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
                
                 query = "INSERT INTO revenue(time, total, date, maquan) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, timesql);
                pst.setDouble(2, totalsql);
                pst.setString(3, datesql);
                pst.setString(4, maquan);
                pst.executeUpdate();
            }

                //roleText.setText("");
                
            }
        }catch(Exception e){
          //System.out.print("Error"+e.getMessage());  
        }
    }
    public double ChangeValue(String Svalue){
       double doubleValue = Double.parseDouble(Svalue);
       return doubleValue;
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
          System.out.print("Error"+e.getMessage());  
        }
    }
    
}
