import java.awt.image.BufferedImage;
import java.awt.Color;

public class Fractal extends BufferedImage
{
    public Fractal(int width, int height)
    {
        super( width,  height,  TYPE_BYTE_INDEXED );
        drawFractal();
        drawBlank();
    }
    private void drawBlank()
    {
        int iteration = 0;
        int maxIteration = 20;
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
                while(iteration < maxIteration)
                {
                    xtemp = (x*x) - (y*y) + x0;
                    y = 2*x*y + y0;
                    x = xtemp;
                    iteration ++;
                }
                if(x*x + y*y <= 3)
                {
                    setRGB(i,j, rgb2int(iteration*2,7*iteration,5*iteration));
                }
                else if(x*x + y*y<10)
                {
                    setRGB(i,j, rgb2int(iteration*5,1*iteration,10*iteration));
                }
                else
                {
                    setRGB(i, j, rgb2int(0, 0, 0));
                }
                
            }
        }
    }
    /**
     * This draws a fractal using setRGB(int x,int y,int rgb)
     * we need to have a list of numbers with a length equal to the height or width
     * ranging from the beguinning to end of the graph
     */
    private void drawFractal()
    {
        
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
