/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import view.AddEmployee;

import view.Home;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javax.management.Query.or;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Employee;
/**
 *
 * @author PhelanUX
 */
public class EController {
    private String NameEdit,PhoneEdit,AddressEdit;
    
    public void Back(){
                    Home HomeFrame =new Home();
                    HomeFrame.setVisible(true);
                    HomeFrame.pack();                    
                    HomeFrame.setLocationRelativeTo( null);//c:null
    }
    public void AEmployee(){
        AddEmployee n=new AddEmployee();
        n.setVisible(true);
        n.pack();
        n.setLocationRelativeTo(null);
    }

    public void setNameEdit(String NameEdit) {
        this.NameEdit = NameEdit;
    }

    public void setPhoneEdit(String PhoneEdit) {
        this.PhoneEdit = PhoneEdit;
    }
    
    public String getNameEdit() {
        return NameEdit;
    }

    public String getPhoneEdit() {
        return PhoneEdit;
    }

    public String getAddressEdit() {
        return AddressEdit;
    }

    public void setAddressEdit(String AddressEdit) {
        this.AddressEdit = AddressEdit;
    }

    
    
    
    public void refreshTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện có
        // Cập nhật JTable để hiển thị dữ liệu mới
        table.repaint();
    }
    
    
    
    public List<Employee> getAllInfo(String maquan){
        String query="SELECT * FROM employee where maquan=?";
        List<Employee> list=new ArrayList<>();
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            PreparedStatement pss=conn.prepareStatement(query);
            pss.setString(1, maquan);
            ResultSet rs = pss.executeQuery();
            while(rs.next()){
                list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
            }
            
        }catch(Exception e){
            return null;
        }
        return list;
    }
    public void update(int id,String name, String phone, String address, int sogiolam){
        
        String query ="UPDATE employee SET name = ?, phone = ?, address = ?, sogiolam=? WHERE id = ?";
        if("".equals(name)){
                JOptionPane.showMessageDialog(new JFrame(),"Cần điền vào trường Tên","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(phone)){
                JOptionPane.showMessageDialog(new JFrame(),"Cần điền vào trường SDT","Error", JOptionPane.ERROR_MESSAGE);
            }else if ("".equals(address)){
                JOptionPane.showMessageDialog(new JFrame(),"Cần điền vào trường Địa chỉ","Error", JOptionPane.ERROR_MESSAGE);
            }else{
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            PreparedStatement pss=conn.prepareStatement(query);
            pss.setString(1, name);
            pss.setString(2, phone);
            pss.setString(3, address);
            pss.setInt(5, sogiolam);
            pss.setInt(4, id);
            int rs = pss.executeUpdate();
            showMessageDialog(null,"Cập nhật thành công");
        }catch(Exception e){
               JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề khi cập nhật","Error", JOptionPane.ERROR_MESSAGE);
               
            }
        }
    }
    public void deleteEmployee(int id) {
    String query = "DELETE FROM employee WHERE ID = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        // Thiết lập tham số cho câu lệnh SQL DELETE
        pstmt.setInt(1, id);

        // Thực thi câu lệnh SQL DELETE
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            showMessageDialog(null,"Đã xóa nhân viên");
        } else {
            showMessageDialog(null,"Không tìm thấy nhân viên .");
        }
    } catch (SQLException e) {
         JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề khi xóa nhân viên","Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
}
