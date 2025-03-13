/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.data.category.DefaultCategoryDataset;
import view.Home;
import view.RevenueDetails;
import java.time.LocalDate;
/**
 *
 * @author PhelanUX
 */
public class RevenueController {
    private String totalweek;
    private String totaldate;
    private String totalmonth;
    public void SelectTotalDay(String maquan){
        String SUrl,SUser,SPass;
        
        
       
         SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
        
        try (Connection connection = DriverManager.getConnection(SUrl, SUser, SPass)) {
            String query = "SELECT sum(total) as tong FROM revenue WHERE DATE(date) = CURDATE() and maquan=?;  ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,maquan);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String data = resultSet.getString("tong"); // 
                totaldate= data;
                
            } else {
               showMessageDialog(null,"Khong the tim thay bat ki du lieu nao ve doanh thu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String getTotalDate(){
        return totaldate;
    }
    public void SelectTotalWeek(String maquan){
        String SUrl,SUser,SPass;
        
        
       
         SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
        
        try (Connection connection = DriverManager.getConnection(SUrl, SUser, SPass)) {
            String query = "SELECT sum(total) as tong FROM revenue WHERE YEARWEEK(date, 1) = YEARWEEK(CURDATE(), 1) and maquan=?;  ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1,maquan);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String data = resultSet.getString("tong"); 
                totalweek= data;
                
            } else {
                showMessageDialog(null,"Khong the tim thay bat ki du lieu nao ve doanh thu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public String getTotalWeek(){
        return totalweek;
     }
     public void SelectTotalMonth(String maquan){
        String SUrl,SUser,SPass;
        
        
       
         SUrl="jdbc:MySQL://localhost:3306/cafemanager";
            SUser="root";
            SPass="";
        
        try (Connection connection = DriverManager.getConnection(SUrl, SUser, SPass)) {
            String query = "SELECT sum(total) as tong FROM revenue WHERE YEAR(date) = YEAR(CURDATE()) AND MONTH(date) = MONTH(CURDATE()) and maquan =?;  ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,maquan);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String data = resultSet.getString("tong"); 
                totalmonth= data;
                
            } else {
                showMessageDialog(null,"Cant found any data in database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public String getTotalMonth(){
        return totalmonth;
     }
    public void Back(){
                    Home HomeFrame =new Home();
                    HomeFrame.setVisible(true);
                    HomeFrame.pack();                    
                    HomeFrame.setLocationRelativeTo( null);//c:null
    }  
    public void RevenueDetails(){
                    RevenueDetails RevenueFrame =new RevenueDetails();
                    RevenueFrame.setVisible(true);
                    RevenueFrame.pack();                    
                    RevenueFrame.setLocationRelativeTo( null);//c:null
    } 


    public static DefaultCategoryDataset getRevenueDataset(int month, int year) {
        // Kết nối cơ sở dữ liệu
        String url = "jdbc:mysql://localhost:3306/cafemanager"; // Thay bằng thông tin của bạn
        String username = "root"; // Tên người dùng
        String password = ""; // Mật khẩu

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            // Kết nối tới database
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Truy vấn SQL lấy dữ liệu theo tháng và năm nhập vào
            String query = """
                SELECT 
                    DATE(revenue.date) AS sale_date, 
                    SUM(total) AS total_revenue
                FROM 
                    revenue
                WHERE 
                    MONTH(revenue.date) = ? AND YEAR(revenue.date) = ?
                GROUP BY 
                    DATE(revenue.date)
                ORDER BY 
                    revenue.date ASC
            """;
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,month);            
           preparedStatement.setInt(2,year);
            ResultSet rs = preparedStatement.executeQuery();

            // Đọc kết quả và thêm vào dataset
            while (rs.next()) {
                String saleDate = rs.getString("sale_date"); // Ngày
                double totalRevenue = rs.getDouble("total_revenue"); // Tổng doanh thu
                 String dayOfMonth = saleDate.split("-")[2];
                dataset.addValue(totalRevenue, "Doanh thu", dayOfMonth); // Thêm vào dataset
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }
    public static DefaultCategoryDataset getRevenueDatasetCurrent() {
        // Kết nối cơ sở dữ liệu
        String url = "jdbc:mysql://localhost:3306/cafemanager"; // Thay bằng thông tin của bạn
        String username = "root"; // Tên người dùng
        String password = ""; // Mật khẩu

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            // Kết nối tới database
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Truy vấn SQL lấy dữ liệu theo tháng và năm nhập vào
            String query = """
                SELECT 
                       DATE(revenue.date) AS sale_date, 
                       SUM(total) AS total_revenue
                    FROM 
                        revenue
                    WHERE 
                        MONTH(revenue.date) = MONTH(CURDATE()) 
                        AND YEAR(revenue.date) = YEAR(CURDATE())
                    GROUP BY 
                        date(revenue.date)
                    ORDER BY 
                        revenue.date ASC;
            """;
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            //preparedStatement.setInt(1,month);            
           //preparedStatement.setInt(2,year);
            ResultSet rs = preparedStatement.executeQuery();

            // Đọc kết quả và thêm vào dataset
            while (rs.next()) {
                String saleDate = rs.getString("sale_date"); // Ngày
                double totalRevenue = rs.getDouble("total_revenue"); // Tổng doanh thu

                dataset.addValue(totalRevenue, "Doanh thu", saleDate); // Thêm vào dataset
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }
     public static DefaultCategoryDataset getRevenueDatasetYear(int year) {
        // Kết nối cơ sở dữ liệu
        String url = "jdbc:mysql://localhost:3306/cafemanager"; // Thay bằng thông tin của bạn
        String username = "root"; // Tên người dùng
        String password = ""; // Mật khẩu

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            // Kết nối tới database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL lấy dữ liệu theo năm nhập vào
            String query = """
                SELECT 
                        MONTH(revenue.date) AS month, 
                        SUM(total) AS total_revenue
                    FROM 
                        revenue
                    WHERE 
                        YEAR(revenue.date) = ?
                    GROUP BY 
                        MONTH(revenue.date)
                    ORDER BY 
                        month ASC;
            """;

            // Sử dụng PreparedStatement để tránh SQL injection
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, year); // Thêm năm vào câu truy vấn

            ResultSet rs = preparedStatement.executeQuery();

            // Đọc kết quả và thêm vào dataset
            while (rs.next()) {
                int month = rs.getInt("month"); // Lấy giá trị tháng (1-12)
                double totalRevenue = rs.getDouble("total_revenue"); // Tổng doanh thu

                // Thêm giá trị vào dataset với tháng là nhãn
                dataset.addValue(totalRevenue, "Doanh thu", String.valueOf(month)); // Thêm vào dataset
            }

            rs.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }
}
