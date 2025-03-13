/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PhelanUX
 */
public class Control {
   private String usernamed;
   private static Control instance;
   private String idquan;
   public String name ;
   public int role;
   public String current;
   public String logoutt;

    public Control(String idquan, int role, String current, String logoutt,String usernamed) {
        this.idquan = idquan;
        this.role = role;
        this.current=current;
        this.logoutt=logoutt;
        this.usernamed=usernamed;

    }

    public Control(String usernamed) {
        this.usernamed = usernamed;
    }
    
    public int getRole() {
        return role;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public void setLogoutt(String logoutt) {
        this.logoutt = logoutt;
    }

    public String getCurrent() {
        return current;
    }

    public String getLogoutt() {
        return logoutt;
    }

    public void setRole(int role) {
        this.role = role;
    }
   
   private Control() {
        name="";
        idquan="";
    }
    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getIdquan() {
        return idquan;
    }

    public void setIdquan(String idquan) {
        this.idquan = idquan;
    }

    public  String getUsernamed() {
        return usernamed;
    }

    public void setUsernamed(String usernamed) {
       this.usernamed = usernamed;
    }
   
   
}
