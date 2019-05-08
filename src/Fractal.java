import java.awt.image.BufferedImage;
import java.awt.Color;

public class Fractal extends BufferedImage
{
    public Fractal(int width, int height)
    {
        super( width,  height,  TYPE_BYTE_INDEXED );
        drawFractal(1);
    }
    public void drawFractal(int iter)
    {
        double iteration = 0;
        double maxIteration = (double) iter;
        double x0 = 0;
        double y0 = 0;
        double x = 0;
        double y = 0;
        double xtemp;
        
        
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                //setRGB(i,j, rgb2int(166,67,0));
                x0 = (double)(i-500)/350+.01;
                y0 = (double)(j-500)/350+.01;
                x = 0;
                y = 0;
                iteration = 0;
                while(iteration < maxIteration && x*x + y*y <= 4)
                {
                    xtemp = (x*x) - (y*y) + x0;
                    y = 2*x*y + y0;
                    x = xtemp;
                    iteration ++;
                }
                
                setRGB(i,j, rgb2int((int)(255*iteration/maxIteration),(int)(255*iteration/maxIteration),(int)(255*iteration/maxIteration)));
                
                
                
            }
        }
    }
    
    public static int rgb2int(int red, int green, int blue)
    {
        return new Color(red, green, blue).getRGB();
        
    }
    
    public static void main()
    {
        Fractal test = new Fractal(600,400);
        System.out.println(test.getColorModel());
    }
}
