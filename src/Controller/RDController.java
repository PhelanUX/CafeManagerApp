/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import view.Revenue;
import view.SearchBill;

/**
 *
 * @author PhelanUX
 */
public class RDController {
    public void BackRevenue(){
        Revenue ReFrame =new Revenue();
        ReFrame.setVisible(true);
        ReFrame.pack();
        ReFrame.setLocationRelativeTo(null);
    }
    public void SearchBill(){
        SearchBill SBFrame =new SearchBill();
        SBFrame.setVisible(true);
        SBFrame.pack();
        SBFrame.setLocationRelativeTo(null);
    }
    public String getBillDetails(String date, String time) {
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
