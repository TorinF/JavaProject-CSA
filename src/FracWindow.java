//Use IDE to manage what packages are used
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author torin
 */
public class FracWindow extends JPanel {

    public void passiter(int iter) {
        frac.drawFractal(iter);
        repaint();
    }
    
    private final int width, height;
    private Fractal frac;
    public FracWindow(int width, int height)
    {
        
        // Make sure there's 0 whitespace between border of panel & image
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        this.width = width;
        this.height = height;
        
        frac = new Fractal(width,height);
        
        // Converts buffered image to ImageIcon
        // images are displayed with labels
        JLabel l = new JLabel(new ImageIcon(frac));
        
        // Adds single image to cover panel
        add(l);
    }
    //public void reDraw()
    /**
     * We will need to redraw the fractal at some point
     * it won't be 60 fps but we can refresh the image by calling a redraw on the
     * Fractal then reassigning the JLabel to a new ImageIcon
     * maybe the ImageIcon will automatically refresh.
     */
}
