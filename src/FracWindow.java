//Use IDE to manage what packages are used
import java.awt.FlowLayout;
import java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author torin
 */
public class FracWindow extends JPanel implements KeyListener {

    private double xs, xe, ys, ye;
    
    
    
    private final int width, height;
    private Fractal frac;
    
    public FracWindow(int width, int height, double xs, double xe, double ys, double ye)
    {
        // Make sure there's 0 whitespace between border of panel & image
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.xe = xe;
        this.xs = xs;
        this.ye = ye;
        this.ys = ys;
       
        this.width = width;
        this.height = height;
        
        frac = new Fractal(width,height);
        
        // Converts buffered image to ImageIcon
        // images are displayed with labels
        JLabel l = new JLabel(new ImageIcon(frac));
        
        // Adds single image to cover panel
        add(l);
        
        // Adds keylistener
        addKeyListener(this);
    }
    
    public void passiter(int iter) {
        frac.drawFractal(iter, xs, xe, ys, ye);
        repaint();
    }

    /* This will use key codes:
    VK_UP
    VK_DOWN
    VK_LEFT
    VK_RIGHT
    */
    


    @Override
    public void keyTyped(java.awt.event.KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent ke) {
        int key = ke.getKeyCode();
        switch(key)
        {
            case VK_UP:
                frac.moveUp();
                repaint();
                break;
            case VK_DOWN:
                frac.moveDown();
                repaint();
                break;
            case VK_LEFT:
                frac.moveLeft();
                repaint();
                break;
            case VK_RIGHT:
                frac.moveRight();
                repaint();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
