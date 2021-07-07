package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuView extends JFrame implements ActionListener{
    private JLabel lJudul, lmain, lhapus;
    private JButton bMain, bHapus;
    
    public MenuView(){  
        setTitle("Menu");
        lJudul = new JLabel("Main Menu", SwingConstants.CENTER);
        bMain = new JButton(" Main ");
        bHapus = new JButton(" Hapus Akun ");
        
        setLayout(new GridLayout(4,4));
        add(lJudul);
        add(bMain);
        add(bHapus);
        
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        bMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bHapus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        bMain.addActionListener(this);  
        bHapus.addActionListener(this);  
        
    }
    
    public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == bMain)
            {
                
                dispose();
            }
            
            
            if(e.getSource() == bHapus)
            {
                
                dispose();
            }
            
        }
}
