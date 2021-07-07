
package View;
import view.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RegisterView extends JFrame implements ActionListener {
    public static void main(String[] args) {
        RegisterView rv = new RegisterView();
        rv.formRegis();
    }
    private JTextField fieldnama, fieldpw,fieldconfirm;
    private JLabel labeljudul, labelnama, labelpw, labelconfirm;
    private JButton btnbatal, btnregister;

public void formRegis() {
    setTitle("Registration");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300,225);
    
    labeljudul = new JLabel("Register Account ");
    labelnama = new JLabel(" Username ");
    fieldnama = new JTextField(18);
    labelpw = new JLabel(" Password ");
    fieldpw = new JTextField(6);
    labelconfirm = new JLabel("Confirm Password ");
    fieldconfirm = new JTextField(6);
    
    
    btnbatal = new JButton(" Batal ");
    btnregister = new JButton(" Register ");
    
    setLayout(null);
    add(labeljudul);
    add(labelnama);
    add(fieldnama);
    add(labelpw);
    add(fieldpw);
    add(labelconfirm);
    add(fieldconfirm);
    add(btnbatal);
    add(btnregister);
    
    labeljudul.setBounds(85,10,120,20);
    labelnama.setBounds(10,45,120,20);
    fieldnama.setBounds(150,45,90,20);
    labelpw.setBounds(10,70,120,20);
    fieldpw.setBounds(150,70,90,20);
    labelconfirm.setBounds(10,90,120,20);
    fieldconfirm.setBounds(150,90,90,20);
    btnbatal.setBounds(150,125,90,20);
    btnbatal.setBackground(Color.red);
    btnbatal.setForeground(Color.white);
    btnbatal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //btnlogin.addActionListener(this);
    btnregister.setBounds(30,125,90,20);
    btnregister.setBackground(Color.blue);
    btnregister.setForeground(Color.white);
    btnregister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                setMessage("Massa barang harus diisi");
                }
            if(fieldpw.getText().equals(fieldconfirm.getText())){              
                  String[] data = {
                           fieldnama.getText(),
                           fieldpw.getText()
                    };
                   //controller
//                //fungsiinputkedatabase
                }
            else{
                 setMessage("Harap Konfimasi dengan Benar!");
            }
        }
        
        if(e.getSource()==btnbatal) {
           
            dispose();
        }
        
    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message); 
    }
}
