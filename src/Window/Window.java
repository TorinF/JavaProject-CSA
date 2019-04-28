package Window;



import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Window
{
    public static void main(String[] args) throws IOException
    {
        //BufferedImage image = ImageIO.read(new File("BigBrain.jpeg"));
        //BackgroundPanel bgPanel = new BackgroundPanel(image, BackgroundPanel.SCALED, 0.0f, 0.0f);
        JFrame f=new JFrame();
        String [] items = {"MandleBrot","other"};
        JComboBox d=new JComboBox(items);//creating instance of JButton  
        JButton b = new JButton("Iterate");
        BackgroundPanel back;
        
        //back = new BackgroundPanel(, BackgroundPanel.SCALED, 1.0f, 0.5f);
        
        f.add(d);
        f.add(b);//adding button in JFrame
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(new FlowLayout());//using no layout managers  
        f.setVisible(true);//making the frame visible  
    }
    
}
