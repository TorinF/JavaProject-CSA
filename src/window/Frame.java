package window;


import java.awt.BorderLayout;
import java.awt.Container;
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
    public static int width = 1500;
    
    public Frame(int width, int height) throws IOException
    {
        super();
        
        
        setLayout(null);
        
        Image image = ImageIO.read(getClass().getResource("/Images/spacemind.jpg"));
        
        Container pane = getContentPane();
        
//        pane.add(Box.createHorizontalStrut(20), BorderLayout.LINE_START);
//        pane.add(Box.createHorizontalStrut(20), BorderLayout.LINE_END);
//        pane.add(Box.createVerticalStrut(20), BorderLayout.PAGE_START);
//        pane.add(new JButton("hujygugyuguy"), BorderLayout.PAGE_END);
//        
        Window win = new Window(width, height, image);
        pane.add(win, BorderLayout.CENTER);
        
        // This closes program when window is closed
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent winEvt) {

                System.out.println("closing");
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) throws IOException
    {
        Frame f=new Frame(width, height);
        
        f.setSize(width,height);
        f.setVisible(true);// making the frame visible
    }
}
