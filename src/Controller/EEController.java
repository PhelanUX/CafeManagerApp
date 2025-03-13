/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.Employee;

/**
 *
 * @author PhelanUX
 */
public class EEController {
    public void Back(){
         Employee e =new Employee();
        e.setVisible(true);
        e.pack();
        e.setLocationRelativeTo(null);   
    }
}
