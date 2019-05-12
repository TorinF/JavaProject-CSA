


//msc. classes
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

//swing classes
import javax.swing.JButton;



public class Window extends BackgroundPanel
{
    final int fracwidth = 700;
    final int fracheight = 700;
    private int iter = Fractal.STARTITER;
    
    //these values control the initial zoom/range for viewing
    final double rangeXS = -0;
    final double rangeXE = 1;
    final double rangeYS = -1;
    final double rangeYE = 2;
    
    // layout
    FlowLayout lay;
    
    public Window(int width, int height, java.awt.Image image) throws IOException {

        super(image, BackgroundPanel.SCALED, 0.0f, 0.0f);
        
        lay = new FlowLayout(FlowLayout.LEADING);
        
        setLayout(lay);
        
        this.setSize(width, height);
        
        
        
        //Adds fractal window
        FracWindow frac = new FracWindow(fracwidth, fracheight);
        frac.setBounds(350, 0, fracwidth, fracheight);
        
        
        
        
        LeftPanel left = new LeftPanel();
        left.setBounds(5,100,300,250);
        
        ((JButton)left.getComponent(0)).addActionListener(new ButtonPress() {
            /* This creates an anonomous class that overrides the action 
            performed method*/
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("this");
                frac.passiter();
            }
        });;
        
        
        
        
        add(left);
        addKeyListener(frac);
        add(frac);
        this.requestFocus();
        
    }
}
