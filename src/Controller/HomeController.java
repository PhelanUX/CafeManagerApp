/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.NewCoffeController.isValidEmail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author PhelanUX
 */
public class HomeController {
     public void AddHours(int sogio, String name){
     String SUrl, SUser, SPass;
    String query = "UPDATE employee SET sogiolam = sogiolam + ? WHERE name = ?";
    SUrl = "jdbc:MySQL://localhost:3306/cafemanager";
    SUser = "root";
    SPass = "";
    int sogiol = sogio;

    try (Connection con = java.sql.DriverManager.getConnection(SUrl, SUser, SPass);
         PreparedStatement pst = con.prepareStatement(query)) {
         
        pst.setInt(1, sogiol);
        pst.setString(2, name);
        pst.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        // JOptionPane.showMessageDialog(new JFrame(), "Không thể thêm vào CSDL", "Error", JOptionPane.ERROR_MESSAGE);
        }           
     }

}
