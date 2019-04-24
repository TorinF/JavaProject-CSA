

import javax.swing.*;
public class Window
{
    public static void main()
    {
        JFrame f=new JFrame();
        String [] items = {"MandleBrot","other"};
        JComboBox b=new JComboBox(items);//creating instance of JButton  
        b.setBounds(10, 10,100, 40);//x axis, y axis, width, height  
        
        f.add(b);//adding button in JFrame
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
    }
    
}
