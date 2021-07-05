package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuView extends JFrame implements ActionListener{
    private JLabel lJudul;
    private JButton bSignUp, bLogin;
    
    public MenuView(){  
        setTitle("Menu");
        lJudul = new JLabel("Main Menu", SwingConstants.CENTER);
        bSignUp = new JButton(" Sign Up ");
        bLogin = new JButton(" Login ");
        
        setLayout(new GridLayout(4,4));
        add(lJudul);
        add(bSignUp);
        add(bLogin);
        
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        bSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        bSignUp.addActionListener(this);  
        bLogin.addActionListener(this);  
        
    }
    
    public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == bSignUp)
            {
                
                dispose();
            }
            
            
            if(e.getSource() == bLogin)
            {
                
                dispose();
            }
            
        }
}
