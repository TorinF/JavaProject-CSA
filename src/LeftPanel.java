
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
    private FlowLayout lay;
    public LeftPanel() throws IOException
    {
        
        super();
        lay = new FlowLayout(FlowLayout.CENTER);
        setLayout(lay);
        
        
        JEditorPane help = new JEditorPane();
        help.setEditable(false);
        java.net.URL file = getClass().getResource("directions.html");
        help.setPage(file);
        help.setOpaque(false);
        
        //this.setOpaque(false);
        JButton b = new JButton("Iterate");
        
        
        
        /* This calls the passiter function on the FracWindow which also redraws it */
        
        
        setBackground( new Color(0, 0, 0, 100) );
        add(b);
        add(help);
    
    }
}
