package window;


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
public class Frame extends JFrame{
    
    // Instance vars
    public static int height = 800;
    public static int width = 1200;
    
    public Frame(int width, int height) throws IOException
    {
        super();
        
        //Background image
        Image image = ImageIO.read(getClass().getResource("/Images/spacemind.jpg"));
        
        Container pane = getContentPane();
        
        Window win = new Window(width, height, image);
        pane.add(win, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) throws IOException
    {
        Frame f=new Frame(width, height);
        
        f.setSize(width,height);
        f.setVisible(true); //making the frame visible
    }
}
