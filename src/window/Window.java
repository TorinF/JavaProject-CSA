package window;




//msc. classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

//swing classes
import javax.swing.JComboBox;
import javax.swing.JPanel;



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
        
        LayoutManager lay = new BorderLayout();
        setLayout(lay);
        
        JPanel pane = new JPanel();
        
        LayoutManager layout2 = new BoxLayout(pane, BoxLayout.X_AXIS);
        pane.setAlignmentY(1);
        pane.setLayout(layout2);
        pane.setOpaque(false);
        
        pane.setBackground(new Color(0, 0, 0,0));
        
        
        this.setSize(width, height);
        
        
        
        //Adds fractal window
        FracWindow frac = new FracWindow(fracwidth, fracheight);
        
        LeftPanel left = new LeftPanel();
        
        left.getIterButton().addActionListener(new ActionListener() {
            /* This creates an anonomous class that overrides the action 
            performed method*/
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frac.passiter();
            }
        });
        
        left.getCombBox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Get the source of the component, which is our combo
                // box.
                JComboBox comb = (JComboBox) event.getSource();

               
                Object selected = comb.getSelectedItem();
                if(selected.equals("Sunset"))
                {
                    frac.passColor(Fractal.SUNSET_SHERBERT);
                }
                else
                {
                    frac.passColor(Fractal.HOT_IRON);
                }
            }});

        
        left.setPreferredSize(new Dimension(300, height));
        
        
        
        pane.add(left);
        pane.add(frac);
        this.requestFocus();
        
        
        add(Box.createHorizontalStrut(30), BorderLayout.LINE_START);
        add(Box.createHorizontalStrut(30), BorderLayout.LINE_END);
        add(Box.createVerticalStrut(30), BorderLayout.PAGE_START);
        add(Box.createVerticalStrut(30), BorderLayout.PAGE_END);
        
        add(pane, BorderLayout.CENTER);
    }
}
