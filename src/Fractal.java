import java.awt.image.BufferedImage;
import java.awt.Color;

public class Fractal extends BufferedImage
{
    double xs = -2;
    double xe = 2;
    double ys = -2;
    double ye = 2;
    public static final int SHIFTDIV = 12;
    public static final int STARTITER = 2;

    /**
     * Creates a buffered image then runs fractal
     * @param width 
     * @param height
     */
    public Fractal(int width, int height)
    {
        super( width,  height,  TYPE_BYTE_INDEXED );
        drawFractal(STARTITER);
    }
    public void drawFractal(int iter)
    {
        
        double iteration;
        double maxIteration = (double) iter;
        double x0;
        double y0;
        double x;
        double y;
        double xtemp;
        
        
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                //setRGB(i,j, rgb2int(166,67,0));
                x0 = ((double)i*(xe-xs)/getWidth()) + xs;
                y0 = ((double)j*(ye-ys)/getHeight()) + ys;
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
                
                setRGB(i,j, rgb2int((int)(255*iteration/maxIteration),(int)(255-(255*iteration/maxIteration)),(int)(255 - 255*iteration/maxIteration)));
                
                
                
            }
        }
    }
    
    /* These methods will shift the x and y ranges
    if we add a zoom feature it would be useful to make the graph 
    shift proportional to how zoomed in it is*/
    public void moveRight()
    {
        double range = Math.abs(xe - xs);
        xs += range/SHIFTDIV;
        xe += range/SHIFTDIV;
    }
    public void moveLeft()
    {
        double range = Math.abs(xe - xs);
        xs -= range/SHIFTDIV;
        xe -= range/SHIFTDIV;
    }
    public void moveUp()
    {
        double range = Math.abs(ye - ys);
        ys += range/SHIFTDIV;
        ye += range/SHIFTDIV;
    }
    public void moveDown()
    {
        double range = Math.abs(ye - ys);
        ys -= range/SHIFTDIV;
        ye -= range/SHIFTDIV;
    }
    
    /**
     * Turns three color values into a single int
     * that is used by the computer
     * should be optimized later
     * @param red
     * @param green
     * @param blue
     * @return 
     */
    public static int rgb2int(int red, int green, int blue)
    {
        return new Color(red, green, blue).getRGB();
        
    }
    
}
