/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PhelanUX
 */
public class background extends JPanel{
    private Image backgroundImage;
    public void ImagePanel(String imagePath){
        backgroundImage=new ImageIcon(imagePath).getImage();
        Dimension Size= new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
        setPreferredSize(Size);
        setMinimumSize(Size);
        setMaximumSize(Size);
        setSize(Size);
        setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0,this);
    }
    
}
