/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Drink;
import model.Employee;
import view.Menuu;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
/**
 *
 * @author PhelanUX
 */
public class EDController {
    private String NameEdit,PriceEdit;
    
    public void Back(){
                    Menuu HomeFrame =new Menuu();
                    HomeFrame.setVisible(true);
                    HomeFrame.pack();                    
                    HomeFrame.setLocationRelativeTo( null);//c:null
    }


    public void setNameEdit(String NameEdit) {
        this.NameEdit = NameEdit;
    }

    public String getPriceEdit() {
        return PriceEdit;
    }

   
    
    public String getNameEdit() {
        return NameEdit;
    }

    public void setPriceEdit(String PriceEdit) {
        this.PriceEdit = PriceEdit;
    }

   


 

    
 
    public void refreshTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện có
        // Cập nhật JTable để hiển thị dữ liệu mới
        table.repaint();
    }
    
    
    
    public List<Drink> getAllInfo(){
        String query="SELECT masp,tensp,dongia FROM drink";
        try{
            List<Drink> list=new ArrayList<>();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            PreparedStatement pss=conn.prepareStatement(query);
            ResultSet rs = pss.executeQuery();
            while(rs.next()){
                list.add(new Drink(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            return list;
        }catch(Exception e){
            return null;
        }
    }
    public List<Drink> getAllInfoImage(){
        String query="SELECT masp,tensp,dongia,image FROM drink";
        try{
            List<Drink> list=new ArrayList<>();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            PreparedStatement pss=conn.prepareStatement(query);
            ResultSet rs = pss.executeQuery();
            while(rs.next()){
                int id=rs.getInt("masp");
                String name=rs.getString("tensp");
                String price =rs.getString("dongia");
                byte[] imgBytes =rs.getBytes("image");
                BufferedImage img=null;
                if(imgBytes!=null){
                     ByteArrayInputStream bais = new ByteArrayInputStream(imgBytes);
                    img = ImageIO.read(bais);
                }
                list.add(new Drink(id, name, price, img));
            }
            
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void update(int id,String name, String price){
        
        String query ="UPDATE drink SET  tensp = ?, dongia = ? WHERE masp = ?";
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            PreparedStatement pss=conn.prepareStatement(query);
            pss.setString(1, name);
            pss.setString(2, price);            
            pss.setInt(3, id);
            int rs = pss.executeUpdate();
            showMessageDialog(null,"Cập nhật đồ uống thành công");
        }catch(Exception e){
                JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề khi cập nhật","Error", JOptionPane.ERROR_MESSAGE);
            }
        
    }
    public void updateWithImage(int id,String name, String price, BufferedImage img, String imgFormat){
        
        String query ="UPDATE drink SET  tensp = ?, dongia = ?, image= ? WHERE masp = ?";
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
            PreparedStatement pss=conn.prepareStatement(query);
            pss.setString(1, name);
            pss.setString(2, price);
            ByteArrayOutputStream baos= new ByteArrayOutputStream();
            ImageIO.write(img, imgFormat, baos);
            byte[] imgBytes= baos.toByteArray();          
            pss.setBytes(3, imgBytes);
            pss.setInt(4, id);
            int rs = pss.executeUpdate();
            if (rs > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật đồ uống thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy đồ uống để cập nhật", "Error", JOptionPane.ERROR_MESSAGE);
        }
            pss.close();
            conn.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề khi cập nhật","Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        
    }
    public void add(String name, String price, String maquan) { 
    String query = "INSERT INTO drink(tensp, dongia, maquan) VALUES(?, ?, ?)"; 

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
        PreparedStatement pss = conn.prepareStatement(query);
        
        pss.setString(1, name);  // Đặt tên đồ uống
        pss.setString(2, price); // Đặt giá đồ uống
        pss.setString(3, maquan);
        int rs = pss.executeUpdate();
        JOptionPane.showMessageDialog(null, "Thêm đồ uống thành công"); 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "Có vấn đề khi thêm đồ uống", "Error", JOptionPane.ERROR_MESSAGE); 
    }
}
    public void delete(int id) { 
    String query = "DELETE FROM drink WHERE masp = ?"; 

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
        PreparedStatement pss = conn.prepareStatement(query);
        
        pss.setInt(1, id);  // Đặt giá trị của id vào vị trí tham số thứ nhất trong câu lệnh SQL

        int rs = pss.executeUpdate();
        JOptionPane.showMessageDialog(null, "Xóa đồ uống thành công"); 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "Có vấn đề khi xóa", "Error", JOptionPane.ERROR_MESSAGE); 
    }
}
    public void saveImagetoDatabase(JLabel ImageLabel,String drinkname) {
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String username = "root";
        String password = "";
        
        String insertSQL = "INSERT INTO images (tensp, data) VALUES (?, ?)";
        PreparedStatement pstmt = null;
        try(Connection conn=DriverManager.getConnection(url, url, password)){
            ImageIcon icon =(ImageIcon) ImageLabel.getIcon();
            if(icon!=null){
                BufferedImage bImage =new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
                bImage.getGraphics().drawImage(icon.getImage(),0,0,null);
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                ImageIO.write(bImage, "jpg", baos);
                byte[] imageInBytes=baos.toByteArray();
                  pstmt = conn.prepareStatement(insertSQL);
                pstmt.setString(1, drinkname); 
                pstmt.setBytes(2, imageInBytes);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(new JFrame(),"Thêm ảnh thành công","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(),"Có vấn đề khi thêm ảnh","Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException  |IOException e){
             e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
    }
    public String getDrinkNameEByCode(String drinkCode) {
        String url = "jdbc:mysql://localhost:3306/cafemanager";
        String user = "root";
        String password = "";
        String query = "SELECT tensp FROM drink WHERE tensp = ?";
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
    public BufferedImage getImageFromDatabase(int id) {
        BufferedImage img = null;
        String query = "SELECT image FROM drink WHERE masp = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafemanager", "root", "");
             PreparedStatement pss = conn.prepareStatement(query)) {

            pss.setInt(1, id);
            ResultSet rs = pss.executeQuery();

            if (rs.next()) {
                byte[] imgBytes = rs.getBytes("image"); // Lấy mảng byte ảnh
                if (imgBytes != null) {
                    ByteArrayInputStream bais = new ByteArrayInputStream(imgBytes);
                    img = ImageIO.read(bais); // Chuyển đổi mảng byte thành BufferedImage
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return img; // Trả về ảnh (BufferedImage) hoặc null nếu không tìm thấy
    }
}
