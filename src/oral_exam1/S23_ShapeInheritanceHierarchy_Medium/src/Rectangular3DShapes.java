/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of 3D Rectangular shapes
 * @see ThreeDimensional
 * @version 1.0
 */
public class Rectangular3DShapes extends ThreeDimensional
{
    /**
     * Length of the 3D rectangular shape.
     */
    private double length;
    /**
     * Width of the 3D rectangular shape.
     */
    private double width;
    /**
     * Height of the 3D rectangular shape.
     */
    private double height;

    /**
     * Constructor
     * @param name Name of the 3D rectangular shape.
     * @param color Color of the 3D rectangular shape.
     * @param isFilled Whether or not the 3D rectangular shape is filled with the color.
     * @param length Length of the 3D rectangular shape.
     * @param width Width of the 3D rectangular shape.
     * @param height Height of the 3D rectangular shape.
     */
    public Rectangular3DShapes(String name, String color, boolean isFilled, double length, double width, double height) {
        super(name, color, isFilled);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Getter for the length.
     * @return Double of the length.
     */
    public double getLength() {
        return length;
    }

    /**
     * Setter for the length.
     * @param length Desired value of the length.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Getter for the width.
     * @return Double of the width
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

    /**
     * Getter for the height.
     * @return Double of the height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter for the height.
     * @param height Desired value of the height.
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
