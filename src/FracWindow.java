//Use IDE to manage what packages are used
import java.awt.FlowLayout;

import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author torin
 */
public class FracWindow extends JPanel implements KeyListener {

    
    
    
    private final int width, height;
    private Fractal frac;
    private int iter = Fractal.STARTITER;
    
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
        
        // Adds keylistener
        addKeyListener(this);
    }
    
    public void passiter() {
        frac.iterate();
        frac.drawFractal();
        repaint();
        this.requestFocus();
    }

    
    /* This will use key codes:
    VK_UP
    VK_DOWN
    VK_LEFT
    VK_RIGHT
    VK_SPACE
    */
    


    @Override
    public void keyTyped(java.awt.event.KeyEvent ke) {}

    @Override
    public void keyPressed(java.awt.event.KeyEvent ke) {
        int key = ke.getKeyCode();
        switch(key)
        {
            case VK_C:
                frac.iterate();
                frac.drawFractal();
                repaint();
                break;
            case VK_X:
                frac.iterate(5);
                frac.drawFractal();
                repaint();
                break;
            case  VK_Z:
                frac.zoomOut();
                frac.drawFractal();
                repaint();
                break;
            case VK_SPACE:
                frac.zoomIn();
                frac.drawFractal();
                repaint();
                break;
            case VK_DOWN:
                frac.moveUp();
                frac.drawFractal();
                repaint();
                break;
            case VK_UP:
                frac.moveDown();
                frac.drawFractal();
                repaint();
                break;
            case VK_RIGHT:
                frac.moveLeft();
                frac.drawFractal();
                repaint();
                break;
            case VK_LEFT:
                frac.moveRight();
                frac.drawFractal();
                repaint();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {}
}
