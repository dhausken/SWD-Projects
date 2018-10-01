/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of 2D triangles.
 * @see TwoDimensional
 * @version 1.0
 */
public class Triangular2DShapes extends TwoDimensional
{
    /**
     * Base of the 2D triangular shape.
     */
    private double base;
    /**
     * Height of the 2D triangular shape.
     */
    private double height;

    /**
     * Constructor
     * @param name Name of the 2D triangular shape.
     * @param color Color of the 2D triangular shape.
     * @param isFilled Whether or not the 2D triangular shape is filled.
     * @param base Base of the 2D triangular shape.
     * @param base Height of the 2D triangular shape.
     */
    public Triangular2DShapes(String name, String color, boolean isFilled, double height, double base) {
        super(name, color, isFilled);
        this.base = base;
        this.height = height;
    }

    /**
     * Getter for the base.
     * @return Double of the base.
     */
    public double getBase() {
        return base;
    }

    /**
     * Setter for the base.
     * @param base Desired value for the base.
     */
    public void setBase(double base) {
        this.base = base;
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
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Calculate the area of the 2D triangular shape.
     * @return Double of the area.
     */
    public double calculateArea()
    {
        setArea(0.5*getBase()*getHeight());
        return getArea();
    }
}
