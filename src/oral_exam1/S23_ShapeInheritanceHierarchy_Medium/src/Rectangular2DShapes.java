/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of 2D Rectangular shapes
 * @see TwoDimensional
 * @version 1.0
 */
public class Rectangular2DShapes extends TwoDimensional
{
    /**
     * Length of the 2D rectangular shape.
     */
    private double length;
    /**
     * Width of the 2D rectangular shape.
     */
    private double width;

    /**
     * Constructor
     * @param name Name of the 2D rectangular shape.
     * @param color Color of the 2D rectangular shape.
     * @param isFilled Whether or not the 2D rectangular shape is filled with the color.
     * @param length Length of the 2D rectangular shape.
     * @param width Width of the 2D rectangular shape.
     */
    public Rectangular2DShapes(String name, String color, boolean isFilled, double length, double width) {
        super(name, color, isFilled);
        this.length = length;
        this.width = width;
    }

    /**
     * Getter for the length.
     * @return Double of the length.
     */
    public double getLength() {
        return length;
    }

    /**
     * Setter for the length
     * @param length Desired value of the length.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Getter for the width.
     * @return Double of the width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setter for the width.
     * @param width Desired value of the width.
     */
    public void setWidth(double width) {
        this.width = width;
    }
}
