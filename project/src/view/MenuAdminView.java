 package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuAdminView extends JFrame implements ActionListener {
    private JLabel lJudul;
    private JButton bData;
    
    public MenuAdminView(){  
        setTitle("Menu");
        lJudul = new JLabel("Menu Admin", SwingConstants.CENTER);
        bData = new JButton(" Lihat Data ");
        
        setLayout(new GridLayout(4,3));
        add(lJudul);
        add(bData);
        
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        bData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        bData.addActionListener(this);   
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bData)
        {
                dispose();}
    }

}