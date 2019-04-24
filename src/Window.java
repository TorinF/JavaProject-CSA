

import javax.swing.*;
public class Window
{
    public static void main()
    {
        JFrame f=new JFrame();
        String [] items = {"MandleBrot","other"};
        JComboBox d=new JComboBox(items);//creating instance of JButton  
        d.setBounds(10, 10,100, 40);//x axis, y axis, width, height
        JButton b = new JButton("Iterate");
        b.setBounds(40, 10,100, 40);
        f.add(d);
        f.add(b);//adding button in JFrame
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
    }
    
}
