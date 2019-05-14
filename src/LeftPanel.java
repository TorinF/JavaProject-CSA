
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

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
        lay = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(lay);
        
        
        JEditorPane help = new JEditorPane();
        help.setEditable(false);
        java.net.URL file = getClass().getResource("directions.html");
        help.setPage(file);
        help.setOpaque(false);
        
        //this.setOpaque(false);
        

<<<<<<< HEAD
        setBackground( new Color(0, 0, 0, 100) );
        JButton b = new JButton("g");
        b.setAlignmentX(0);
=======
    setBackground( new Color(0, 0, 0, 255) );
>>>>>>> 846917876651bba4471c4a26737bc3b97d925f70
        
        add(b);
        add(help);
    
    }
}
