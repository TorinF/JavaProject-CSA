package app.src;

//Use IDE to manage what packages are used
import java.awt.FlowLayout;

import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
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
    private final int up, down, left, right, zoom, zoomOut, iterate, iteratex5;
    private Properties props;
    public FracWindow(int width, int height) throws IOException
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
        
        // Load keybindings
        
        
        
        
        // Adds keylistener
        addKeyListener(this);
        
        props = new Properties();
        System.out.println(getClass().getResource("./").getPath());
        String path = getClass().getResource("../resources/options.properties").getPath();
        System.out.println("path = " + path);
        props.load(new FileInputStream(path));

        up = Integer.parseInt(props.getProperty("up"));
        down = Integer.parseInt(props.getProperty("down"));
        left = Integer.parseInt(props.getProperty("left"));
        right = Integer.parseInt(props.getProperty("right"));
        
        zoom=Integer.parseInt(props.getProperty("zoom"));
        zoomOut= Integer.parseInt(props.getProperty("zoomOut"));
        
        iterate= Integer.parseInt(props.getProperty("iterate"));
        
        iteratex5 = Integer.parseInt(props.getProperty("iteratex5"));
        
        
    }
    
    /*private void setProps() throws FileNotFoundException, IOException
    {
        Properties props = new Properties();
        String path = getClass().getResource("options.properties").getPath();
        props.load(new FileInputStream(path));
        System.out.println(props.values()); 
        System.out.println("props.elements() = " + props.elements());
        Enumeration<Object> elements = props.elements();
        
        up = Integer.parseInt(props.getProperty("up"));
        down = Integer.parseInt(props.getProperty("down"));
        left = Integer.parseInt(props.getProperty("left"));
        right = Integer.parseInt(props.getProperty("right"));
        
        zoom=Integer.parseInt(props.getProperty("zoom"));
        
        zoomOut= Integer.parseInt(props.getProperty("zoomOut"));
        
        iterate= Integer.parseInt(props.getProperty("iterate"));
        
    }*/
    
    public void passiter() {
        frac.iterate();
        frac.drawFractal();
        repaint();
        this.requestFocus();
    }

    public Fractal getFrac()
    {
        return frac;
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
	if(key==Integer.parseInt(props.getProperty("iteratex5"))) {
                frac.iterate(5);
                frac.drawFractal();
                repaint();
        }
        else if(key==Integer.parseInt(props.getProperty("iterate"))) {
            frac.iterate(1);
            frac.drawFractal();
            repaint();
        }
	else if(key==Integer.parseInt(props.getProperty("zoomOut"))) {
                frac.zoomOut();
                frac.drawFractal();
                repaint();
	}
        else if(key==Integer.parseInt(props.getProperty("zoom"))) {
                frac.zoomIn();
                frac.drawFractal();
                repaint();
	}
        else if(key==Integer.parseInt(props.getProperty("up"))) {
                frac.moveUp();
                frac.drawFractal();
                repaint();
	}
	else if(key==Integer.parseInt(props.getProperty("down"))) {
                frac.moveDown();
                frac.drawFractal();
                repaint();
	}
        else if(key==Integer.parseInt(props.getProperty("left"))) {
                frac.moveLeft();
                frac.drawFractal();
                repaint();
        }       
        else if(key==Integer.parseInt(props.getProperty("right"))) {
                frac.moveRight();
                frac.drawFractal();
                repaint();
	}
    }
    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {}
}
