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
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                setRGB(i,j, rgb2int(166,67,0));
                if(j>392)
                {
                    setRGB(i,j, rgb2int(20,67,70));
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
