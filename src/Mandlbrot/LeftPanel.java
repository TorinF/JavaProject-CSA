package Mandlbrot;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/* It's time to start using a layout manager,
it's just a lot more professional and makes adding
stuff easier

*/

/**
 *
 * @author torin
 */
public class LeftPanel extends JPanel
{
    private JButton b;
    private BoxLayout lay;
    private JComboBox comb;
    public LeftPanel() throws IOException
    {
        
        super();
        lay = new BoxLayout(this, Y_AXIS);
        
        setLayout(lay);
        
        this.setMaximumSize(new Dimension(300, Main.height));
        
        JEditorPane help = new JEditorPane();
        help.setEditable(false);
        java.net.URL file = getClass().getResource("directions.html");
        help.setPage(file);
        help.setOpaque(false);
        
		
        b = new JButton("Iterate");
        b.setPreferredSize(new Dimension(50, 30));
        b.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
		
        
        comb = new JComboBox(new String[]{"Sunset", "Hot Iron"});
        comb.setEditable(false);
        
        JPanel topPan = new JPanel();
        
        GridLayout grid2 = new GridLayout(0,1);
        
        grid2.setVgap(6);
        
        
        topPan.setLayout(grid2);
        topPan.setMaximumSize(new Dimension(this.getMaximumSize().width,50));
        topPan.setAlignmentX(SwingConstants.LEFT);
        topPan.setBackground(new Color(0, 0, 0,100));
        topPan.setOpaque(false);
        
        
        topPan.add(b);
        topPan.add(comb);
        
        //topPan.setOpaque(false);
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.setBackground(new Color(0, 0, 0,100));
        
        
        add(topPan);
        add(help);
    }
	public void setIterateButtonLink(FracWindow frac)
	{
		b.addActionListener(new ActionListener() {
            /* This creates an anonomous class that overrides the action
			Performed method*/
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frac.passiter();
            }
        });
		
	}
    public JButton getIterButton()
    {
        return b;
    }
    public JComboBox getCombBox()
    {
        return comb;
    }
}
