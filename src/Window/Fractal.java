import java.awt.image.BufferedImage;
import java.awt.Color;

public class Fractal extends BufferedImage
{
    public Fractal(int width, int height)
    {
        super( width,  height,  TYPE_BYTE_INDEXED);
        drawFractal();
    }
    
    /**
     * This draws a fractal using setRGB(int x,int y,int rgb)
     * 
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
