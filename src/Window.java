


//msc. classes
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;

//swing classes
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Window extends JFrame
{
    final int height = 750;
    final int width = 1000;
    final int fracwidth = 700;
    final int fracheight = 700;
    private int iter = Fractal.STARTITER;
    
    //these values control the initial zoom/range for viewing
    final double rangeXS = -0;
    final double rangeXE = 1;
    final double rangeYS = -1;
    final double rangeYE = 2;
    public Window() throws IOException {

        super();
        
        //Gets image from project file
        Image image = ImageIO.read(getClass().getResource("/Images/spacemind.jpg"));
        
        // Uses image to create background
        JPanel back = new BackgroundPanel(image, BackgroundPanel.SCALED, 0.0f, 0.0f);
        back.setBounds(0,0,width,height);
        
        //Creates button & event listener
        JButton b = new JButton("Iterate");
        
        b.setBounds(5, 5, 100, 40);
        
        LeftPanel left = new LeftPanel();
        left.setBounds(5,100,300,150);
        
        
        
        //Adds fractal window
        FracWindow frac = new FracWindow(fracwidth, fracheight);
        frac.setBounds(150, 0, fracwidth, fracheight);
        
        /* This calls the passiter function on the FracWindow which also redraws it */
        b.addActionListener(new ButtonPress() {
            /* This creates an anonomous class that overrides the action 
            performed method*/
            
            @Override
            public void actionPerformed(ActionEvent e) {
                iter++;
                frac.passiter(iter);
            }
        });
        
        add(left);
        add(back);
        add(b);
        addKeyListener(frac);
        add(frac);
        this.requestFocus();
        
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
        Window f=new Window();
        
        f.setSize(f.width,f.height);
        f.setLayout(null);// using no layout managers, just use set bounds
        f.setVisible(true);// making the frame visible
    }
}
