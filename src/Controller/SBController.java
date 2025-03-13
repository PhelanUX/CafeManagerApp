/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;
import java.util.Vector;
import view.RevenueDetails;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author PhelanUX
 */
public class SBController {
    public void BackToRD(){
        RevenueDetails ReFrame =new RevenueDetails();
        ReFrame.setVisible(true);
        ReFrame.pack();
        ReFrame.setLocationRelativeTo(null);
    }
    public TableModel importDataToJTable(String date,String maquan) {
    try {
        if("".equals(date)){
                JOptionPane.showMessageDialog(new JFrame(),"Fill the text","Error", JOptionPane.ERROR_MESSAGE);
                return null;
        }else{    
        //  Kết nối đến cơ sở dữ liệu
        Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
        //khoi tao truy van va set gia tri can tim
        String sql = "SELECT * FROM revenue WHERE date = ? and maquan=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDate(1, java.sql.Date.valueOf(date));
        statement.setString(2, maquan);// Thay thế giá trị ? bằng ngày cụ thể từ Java
        ResultSet rs = statement.executeQuery();
        //  Đưa dữ liệu vào DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(new String[]{"Ngày", "Giờ", "Tổng"}, 0)
                {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Ngăn không cho chỉnh sửa ô
                }
            };
        while(rs.next()) {
            String col2 = rs.getString("time");
            String col3 = rs.getString("total");
            String col1 = rs.getString("date");
            model.addRow(new Object[]{col1, col2, col3});
        }

        //  Đặt DefaultTableModel này cho JTable
        return model;
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }
    }
    public String getBillFromSearch(String date, String time) {
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String password = "";
        String query = "SELECT ctietbill from bill where bill.date=? and bill.time=?";
        String billDetails = null;

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, date);
            pst.setString(2, time);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                billDetails = rs.getString("ctietbill");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return billDetails;
    }
    
}
