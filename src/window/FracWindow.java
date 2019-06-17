package window;

//Use IDE to manage what packages are used
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author torin
 */
public class FracWindow extends JPanel {

    
    
     
    private final int width, height;
    private Fractal frac;
    private int iter = Fractal.STARTITER;
    
    public FracWindow(int width, int height) {
        // Make sure there's 0 whitespace between border of panel & image
        super(new FlowLayout(FlowLayout.LEADING, 0, 0));
       
        this.width = width;
        this.height = height;
        
        this.setBackground(new Color(0,0,0,0));
        this.setPreferredSize(new Dimension(width, height));
        
        frac = new Fractal(width,height);
        
        // Converts buffered image to ImageIcon
        // images are displayed with labels
        JLabel l = new JLabel(new ImageIcon(frac));
        
        // Adds single image to cover panel
        add(l);
        
        
        mapActions();
    }
    
    //For button presses we need to use callable methods instead of keybinding 
    //actions
    
    public void passiter() {
        frac.iterate();
        frac.drawFractal();
        repaint();
        this.requestFocus();
    }

    void passColor(byte color) {
        frac.setColorSetting(color);
    }

    /**
     * This method creates keybindings that work as long as the window is in 
     * focus
     */
    public void mapActions() {
        InputMap inMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inMap.put(KeyStroke.getKeyStroke("C"), "iterate");
        inMap.put(KeyStroke.getKeyStroke("X"), "iterate5");
        inMap.put(KeyStroke.getKeyStroke("Z"), "zoomIn");
        inMap.put(KeyStroke.getKeyStroke("SPACE"), "zoomOut");
        
        inMap.put(KeyStroke.getKeyStroke("UP"), "up");
        inMap.put(KeyStroke.getKeyStroke("DOWN"), "down");
        inMap.put(KeyStroke.getKeyStroke("LEFT"), "left");
        inMap.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        
        Action iterate = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.iterate();
                        frac.drawFractal();
                        repaint();
                        
                }
        };
        Action iterate5= new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.iterate(5);
                        frac.drawFractal();
                        repaint();
                        
                }
        };
        Action zoomOut = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.zoomOut();
                        frac.drawFractal();
                        repaint();
                        
                }
        };
        Action zoomIn = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.zoomIn();
                        frac.drawFractal();
                        repaint();
                        
                }
        };
        Action up = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.moveUp();
                        frac.drawFractal();
                        repaint();
                        
                }
        };
        Action down = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.moveDown();
                        frac.drawFractal();
                        repaint();
                        
                }
        };
        Action left = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.moveLeft();
                        frac.drawFractal();
                        repaint();
                        
                }
        };
        Action right = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                        frac.moveRight();
                        frac.drawFractal();
                        repaint();
                }
        };
        
        //Creates Action map that calls actions based on input map strings
        ActionMap actmap = this.getActionMap();
        actmap.put("iterate", iterate);
        actmap.put("iterate5", iterate5);
        actmap.put("zoomIn", zoomIn);
        actmap.put("zoomOut", zoomOut);
        
        actmap.put("up", up);
        actmap.put("down", down);
        actmap.put("left", left);
        actmap.put("right", right);
    }

}
