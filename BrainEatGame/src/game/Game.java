/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.lang.*;
/**
 *
 * @author user
 */
public class Game extends JFrame implements Runnable {
    private int x;
    private int y;
    private int xArah;
    private int yArah;
    private ArrayList<Sniper> sniper;
    private ArrayList<Brain> brain;
    private boolean Pemain;
    Image gambar;
    private Image background;
    private Image background2;
    Dimension size; 
    AudioClip soundTrack;
    AudioClip soundTrack2;
    AudioClip soundTrack3;
    int skor = 0;
    private boolean bool=true;
    
     public void run() {
        
        while (bool) {
            move();
           
            
            for (int i = 0; i < brain.size(); i++) {
                Rectangle brainHitbox = brain.get(i).getHitbox();
                Rectangle playerHitbox = getPlayerHitbox();
                if (brainHitbox.intersects(playerHitbox))
                    brain.remove(i);
                    
                if(brainHitbox.intersects(playerHitbox)){
                    skor +=10;
                    
                if(brainHitbox.intersects(playerHitbox)){
                    soundTrack2 = Applet.newAudioClip(getClass().getResource("Crunch.wav"));
                     soundTrack2.play();
                    }
                                       
                }
            }
            for (int i = 0; i < sniper.size(); i++) {
                Rectangle musuhHitbox = sniper.get(i).getHitbox();
                Rectangle playerHitbox = getPlayerHitbox();
                if (musuhHitbox.intersects(playerHitbox))
                    Pemain = false ;
                if (Pemain==false){
                    sniper.removeAll(sniper);
                    brain.removeAll(brain);
                    
                    soundTrack3 = Applet.newAudioClip(getClass().getResource("gameover.wav"));
                    soundTrack3.play();
                }
            }
                              
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                System.err.println("Error: Thread Interrupted.");
            }
        }
    }
    
    private void move() {
        
        x += xArah;
        y += yArah;
        if (x < 0)
            x = 0;
        if (y < 20)
            y = 20;
        if (x > 580)
            x = 580;
        if (y > 440)
            y = 440;
        
    }
    
       
    
    Game() {
        
        setPreferredSize(size);
        setSize(640, 480);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Brain Eating Zombie");
        x = 320;
        y = 240;
        xArah = 0;
        yArah = 0;
        addKeyListener(new KeyListener());
        
        sniper = new ArrayList<Sniper>();
        brain = new ArrayList<Brain>(); 
        Pemain = true;
        size = new Dimension();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        background = new ImageIcon(this.getClass().getResource("hutan.jpg")).getImage();
        
        size.width = background.getWidth(null);
        size.height = background.getHeight(null);
        setPreferredSize(size);
        soundTrack = Applet.newAudioClip(getClass().getResource("sound.wav"));
        soundTrack.loop();
        
        
        
    }
    
    public void paint(Graphics g) {
        
        
        Image dbImg = createImage(getWidth(), getHeight());
        Graphics dbg = dbImg.getGraphics();
        draw(dbg);
        g.drawImage(dbImg, 0, 0, this);   
        
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        
        if (Pemain) {
            Image zombie = new ImageIcon(this.getClass().getResource("zombie.png")).getImage();
            g.drawImage(zombie, x, y, this);
        
            
            g2d.setFont(new Font("Arial",Font.BOLD,18));
                    g2d.setColor(Color.WHITE);
                    g2d.drawString("SCORE : " + Integer.toString(skor),20,50);
        }
        else{
        soundTrack.stop();
        bool=false;
        background = new ImageIcon(this.getClass().getResource("gameover.jpg")).getImage();
        size.width = background.getWidth(null);
        size.height = background.getHeight(null);
        
        g2d.setFont(new Font("Arial",Font.BOLD,50));
		g2d.setColor(Color.RED);
		g2d.drawString("SCORE : " + Integer.toString(skor),200,300);
		      
		
        }
        
        for (int i = 0; i < sniper.size(); i++) {
            Sniper e = sniper.get(i);
            e.draw(g);
        }
        for (int i = 0; i < brain.size(); i++) {
            Brain e = brain.get(i);
            e.draw(g);
             
        }
        
        repaint();
        
    }
    
    
    public static Image loadImage(String fileName) {
        ImageIcon icon = new ImageIcon(fileName);
        return icon.getImage();
    }
     
    private void Lawanmusuh() {
        Sniper e = new Sniper();
        sniper.add(e);
        Thread t = new Thread(e);
        t.start();
    }
    private void munculMakanan() {
        Brain e = new Brain();
        brain.add(e);
       Thread t = new Thread(e);
        t.start();
        
    }
     
    
    private Rectangle getPlayerHitbox() {
        return new Rectangle(x, y, 69, 42);
    }

    public static void main(String[] args) {
        Game gh = new Game();
        Thread t = new Thread(gh);
        t.start();
        while (true) {
            if (gh.sniper.size() < 15 && gh.Pemain) {
                gh.Lawanmusuh();
            }
            if (gh.brain.size() < 15 && gh.Pemain) {
                gh.munculMakanan();
            }
            
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                System.err.println("Error: Thread Interrupted.");
            }
        }
        
        
    }
    
    private class KeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    yArah = -2;
                    break;
                case KeyEvent.VK_DOWN:
                    yArah = 2;
                    break;
                case KeyEvent.VK_LEFT:
                    xArah = -2;
                    break;
                case KeyEvent.VK_RIGHT:
                    xArah = 2;
                    break;
                default:
                    break;
            }
        }
        
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                    yArah = 0;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    xArah = 0;
                    break;
                default:
                    break;
            }
        }
        
         
    }
    
}