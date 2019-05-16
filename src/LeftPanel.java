
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
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
    private BoxLayout lay;
    public LeftPanel() throws IOException
    {
        
        super();
        lay = new BoxLayout(this, Y_AXIS);
        
        setLayout(lay);
        
        this.setMaximumSize(new Dimension(400, Frame.height));
        JEditorPane help = new JEditorPane();
        help.setEditable(false);
        java.net.URL file = getClass().getResource("directions.html");
        help.setPage(file);
        help.setOpaque(false);
        
        
        JButton b = new JButton("Iterate");
        b.setPreferredSize(new Dimension(100, 40));
        
        //I'm trying to make the button go left 
        b.setAlignmentX(SwingConstants.LEFT);
        
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        help.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground( new Color(0, 0, 0,100) );
        add(b);
        add(help);
    }
}
