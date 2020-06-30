package Mandlbrot;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class Fractal extends BufferedImage {

	double minX = -2;
	double maxX = 2;
	double minY = -2;
	double maxY = 2;

	public int iter;
	public static final int MOVEFACTOR = 12;
	public static final int STARTITER = 2;

	private byte colorSetting;
	public static final byte SUNSET_SHERBERT = 0;
	public static final byte HOT_IRON = 1;

	/**
	 * Creates a buffered image then runs fractal
	 *
	 * @param width
	 * @param height
	 */
	public Fractal(int width, int height) {
		super(width, height, TYPE_INT_RGB);
		iter = this.STARTITER;
		colorSetting = Fractal.SUNSET_SHERBERT;
		drawFractal();
	}

	public void drawFractal() {

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
				x0 = ((double) i * (maxX - minX) / getWidth()) + minX;
				y0 = ((double) j * (maxY - minY) / getHeight()) + minY;
				x = 0;
				y = 0;
				iteration = 0;
				while (iteration < maxIteration && x * x + y * y <= 4) {
					xtemp = (x * x) - (y * y) + x0;
					y = 2 * x * y + y0;
					x = xtemp;
					iteration++;
				}
				float f = (float) (iteration / maxIteration);
				setColor(colorSetting, i, j, f);

			}
		}
	}

	/* These methods will shift the x and y ranges
    if we add a zoom feature it would be useful to make the graph 
    shift proportional to how zoomed in it is*/
	public void moveRight() {
		double range = Math.abs(maxX - minX);
		minX += range / MOVEFACTOR;
		maxX += range / MOVEFACTOR;
	}

	public void moveLeft() {
		double range = Math.abs(maxX - minX);
		minX -= range / MOVEFACTOR;
		maxX -= range / MOVEFACTOR;
	}

	public void moveUp() {
		double range = Math.abs(maxY - minY);
		minY -= range / MOVEFACTOR;
		maxY -= range / MOVEFACTOR;
	}

	public void moveDown() {
		double range = Math.abs(maxY - minY);
		minY += range / MOVEFACTOR;
		maxY += range / MOVEFACTOR;
	}

	// Zooms in by reducing ranges
	public void zoomIn() {
		double rangeX = Math.abs(maxX - minX);
		double rangeY = Math.abs(maxY - minY);
		minX += rangeX / MOVEFACTOR;
		maxX -= rangeX / MOVEFACTOR;
		minY += rangeY / MOVEFACTOR;
		maxY -= rangeY / MOVEFACTOR;

	}

	public void zoomOut() {
		double rangeX = Math.abs(maxX - minX);
		double rangeY = Math.abs(maxY - minY);
		minX -= rangeX / MOVEFACTOR;
		maxX += rangeX / MOVEFACTOR;
		minY -= rangeY / MOVEFACTOR;
		maxY += rangeY / MOVEFACTOR;
	}
	// Iterate functions to change the iteration

	public void iterate() {
		iter++;
	}

	public void iterate(int add) {
		iter += add;
	}

	public void setIteration(int iteration) {
		this.iter = iteration;
	}

	// Change color setting
	public void setColorSetting(byte color) {
		this.colorSetting = color;
	}

	public byte getColorSetting() {
		return colorSetting;
	}

	/**
	 * Turns three color values into a single int that is used by the computer
	 *
	 * @param red
	 * @param green
	 * @param blue
	 * @return
	 */
	public static int rgb2int(double c) {

		if (c < 85) {
			return rgb2intq((int) c * 3, 0, 0);
		} else if (c < 170) {
			return rgb2intq(255, (int) (c - 85) * 3, 0);
		} else {
			return rgb2intq(255, 255, (int) (c - 170) * 3);
		}

		//return new Color(red, green, blue).getRGB();
		/**
		 * int DIV = 8; for(int i = 1; i <= DIV; i++) { if(c < (i*255/DIV) && c
		 * > (i-1)*255/DIV) { return Color(c*8, 0, 0).getRGB() } }
		 *
		 */
	}

	// It may be quicker to do this way instead of creating a whole new
	// object that has to be cleaned by the garbage collector
	public static int rgb2intq(int red, int green, int blue) {
		int rgb = red;
		rgb = (rgb << 8) + green;
		rgb = (rgb << 8) + blue;
		return rgb;
	}

	public void setColor(byte color, int i, int j, float fl) {
		if (color == Fractal.SUNSET_SHERBERT) {
			setRGB(i, j, Color.HSBtoRGB(fl, (float) 1, 1 - fl));
		} else {
			setRGB(i, j, rgb2int((255 * fl)));
		}
	}

}
