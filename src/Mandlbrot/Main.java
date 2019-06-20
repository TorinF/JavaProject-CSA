package Mandlbrot;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author torin
 */
public class Main extends JFrame{
    
    // Instance vars
    public static int height = 800;
    public static int width = 1200;
    
    public Main(int width, int height) throws IOException
    {
        super("MandleBrot Lite");
        
        //Background image
        Image image = ImageIO.read(getClass().getResource("/Images/spacemind.jpg"));
        
        //Set application icon
        Image icon = ImageIO.read(getClass().getResource("/Images/icon.jpg"));
        this.setIconImage(icon);
        
        
        Container pane = getContentPane();
        
        Window win = new Window(width, height, image);
        win.setPreferredSize(new Dimension(width,height));
        pane.add(win, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) throws IOException
    {
        Main f=new Main(width, height);
        
        f.setSize(width,height);
        f.setVisible(true); //making the frame visible
    }
}
