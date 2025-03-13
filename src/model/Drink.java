/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.image.BufferedImage;

/**
 *
 * @author PhelanUX
 */
public class Drink {
     private int id;
    private String name,price;
    private BufferedImage img;
    public Drink(int id, String name, String price, BufferedImage img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img=img;
    }

    public Drink(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
    
    public Drink(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
   

    
    
}
