/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Loginview extends JFrame implements ActionListener {
    private JTextField fieldnama, fieldpw;
    private JLabel lJudul, labelnama, labelpw;
    private JButton bLogin, bRegister;

public void formLogin() {
    setTitle("Login Session");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(220,225);
    
    lJudul = new JLabel(" LOGIN ");
    labelnama = new JLabel(" Userame ");
    fieldnama = new JTextField(18);
    labelpw = new JLabel(" Password ");
    fieldpw = new JTextField(6);
    
    btnlogin = new JButton(" Login ");
    btnregister = new JButton(" Register ");
    
    setLayout(null);
    add(lJudul);
    add(labelnama);
    add(fieldnama);
    add(labelpw);
    add(fieldpw);
    add(bLogin);
    add(bRegister);
    
    labeljudul.setBounds(85,10,120,20);
    labelnama.setBounds(10,45,120,20);
    fieldnama.setBounds(100,45,90,20);
    labelpw.setBounds(10,70,120,20);
    fieldpw.setBounds(100,70,90,20);
    bLogin.setBounds(12,125,90,20);
    bLogin.setBackground(Color.blue);
    bLogin.setForeground(Color.white);
    bLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //btnlogin.addActionListener(this);
    bRegister.setBounds(106,125,90,20);
    bRegister.setBackground(Color.red);
    bRegister.setForeground(Color.white);
    bRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //btnregister.addActionListener(this);
    
    setResizable(false);
    setLocation(450,200);
    setVisible(true);
    

    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bLogin) {
            if (fieldnama.getText().equals("")) {
                setMessage("Username tidak boleh kosong");
                }
            if(fieldpw.getText().equals("")){
                setMessage("Massa barang harus diisi");
                }
            else {
                  String[] data = {
                           fieldnama.getText(),
                           fieldpw.getText()
                    };
                   //controller
//                //fungsiinputkedatabase
                }
        }
    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message); 
    }
}
