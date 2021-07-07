package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegisterView extends JFrame implements ActionListener{
    private JTextField fieldnama, fieldpw, fieldkonfirm;
    private JLabel labeljudul, labelnama, labelpw, labelkonfirm;
    private JButton btnregister, btnbatal;
    
    public void formRegister() {
    setTitle("Register Account");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(220,225);
    
    labeljudul = new JLabel(" Register Account ");
    labelnama = new JLabel(" Userame ");
    fieldnama = new JTextField(18);
    labelpw = new JLabel(" Password ");
    fieldpw = new JTextField(6);
    labelkonfirm = new JLabel(" Konfirmasi Password ");
    fieldkonfirm = new JTextField(6);
    
   
    btnregister = new JButton(" Register ");
    
    setLayout(null);
    add(labeljudul);
    add(labelnama);
    add(fieldnama);
    add(labelpw);
    add(fieldpw);
    add(labelkonfirm);
    add(fieldkonfirm);
    add(btnregister);
    add(btnbatal);
    
    labeljudul.setBounds(85,10,120,20);
    labelnama.setBounds(10,45,120,20);
    fieldnama.setBounds(100,45,90,20);
    labelpw.setBounds(10,100,120,20);
    fieldpw.setBounds(100,100,90,20);
    labelkonfirm.setBounds(10,100,120,20);
    fieldkonfirm.setBounds(100,100,90,20);
    btnregister.setBounds(12,130,90,20);
    btnregister.setBackground(Color.blue);
    btnregister.setForeground(Color.white);
    btnregister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //btnlogin.addActionListener(this);
    btnbatal.setBounds(106,130,90,20);
    btnbatal.setBackground(Color.red);
    btnbatal.setForeground(Color.white);
    btnbatal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //btnregister.addActionListener(this);
    
    setResizable(false);
    setLocation(450,200);
    setVisible(true);
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnregister) {
            if (fieldnama.getText().equals("")) {
                setMessage("Username tidak boleh kosong");
                }
            if(fieldpw.getText().equals("")){
                setMessage("Password harus diisi");
                }
            if(fieldkonfirm.getText().equals("")){
                setMessage("Konfirmasi Password harus diisi");
                }
            if(fieldpw.getText().equals(fieldkonfirm.getText())) {
                  String[] data = {
                           fieldnama.getText(),
                           fieldpw.getText()
                    };
                   //controller
//                //fungsiinputkedatabase
                }
            else{
             setMessage("Password dan Konfirmasi Password harus benar");
            }
        }
        
        if(e.getSource()==btnregister) {
           
        }
    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message); 
    }
}
