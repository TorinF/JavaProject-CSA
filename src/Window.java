


//msc. classes
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.imageio.ImageIO;

//swing classes
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Window extends JFrame
{
    final int height = 800;
    final int width = 1500;
    final int fracwidth = 1000;
    final int fracheight = 1000;
    private int iter = 0;
    public Window() throws IOException {

        super();
        
        //Gets image from project file
        Image image = ImageIO.read(getClass().getResource("/Images/spacemind.jpg"));
        
        // Uses image to create background
        JPanel back = new BackgroundPanel(image, BackgroundPanel.SCALED, 0.0f, 0.0f);
        back.setBounds(0,0,width,height);
        
        //Creates button & event listener
        JButton b = new JButton("Iterate");
        b.addActionListener(new ButtonPress() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("iter = " + iter);
                iter++;
            }
        });
        b.setBounds(5, 5, 100, 40);
        
        
        //Adds fractal window
        FracWindow frac = new FracWindow(fracwidth, fracheight);
        frac.setBounds(150, 0, fracwidth, fracheight);
        
        add(frac);
        add(back);
        add(b);
    }

    public static void main(String[] args) throws IOException
    {
        Window f=new Window();
        
        f.setSize(f.width,f.height);
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }
}
