package window;




//msc. classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

//swing classes
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;



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
    BoxLayout lay;
    
    public Window(int width, int height, java.awt.Image image) throws IOException {

        super(image, BackgroundPanel.SCALED, 0.0f, 0.0f);
        
        this.setOpaque(false);
        this.setBackground(new Color(0,0,0,1));
        
        LayoutManager lay = new BorderLayout(50,30);
        setLayout(lay);
        
        JPanel pane = new JPanel();
        
        LayoutManager layout2 = new BoxLayout(pane, BoxLayout.X_AXIS);
        pane.setAlignmentY(1);
        pane.setLayout(layout2);
        
        pane.setBackground(new Color(0, 0, 0,0));
        
        
        this.setSize(width, height);
        
        
        
        //Adds fractal window
        FracWindow frac = new FracWindow(fracwidth, fracheight);
        frac.setBorder(BorderFactory.createLineBorder(Color.black));
        
        LeftPanel left = new LeftPanel();
        
        left.getIterButton().addActionListener(new ButtonPress() {
            /* This creates an anonomous class that overrides the action 
            performed method*/
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frac.passiter();
            }
        });
        
        left.setPreferredSize(new Dimension(300, height));
        
        
        pane.add(left);
        addKeyListener(frac);
        pane.add(frac);
        this.requestFocus();
        
        
        add(Box.createHorizontalStrut(20), BorderLayout.LINE_START);
        add(Box.createHorizontalStrut(20), BorderLayout.LINE_END);
        add(Box.createVerticalStrut(20), BorderLayout.PAGE_START);
        add(Box.createVerticalStrut(40), BorderLayout.PAGE_END);
        pane.setOpaque(false);
        add(pane, BorderLayout.CENTER);
    }
}
