/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of 3D triangles.
 * @see ThreeDimensional
 * @version 1.0
 */
public class Triangular3DShapes extends ThreeDimensional
{
    /**
     * Height of the 3D triangular shape.
     */
    private double height;
    /**
     * Base of the 3D triangular shape.
     */
    private double base;

    /**
     * Constructor
     * @param name Name of the 3D triangular shape.
     * @param color Color of the 3D triangular shape.
     * @param isFilled Whether or not the 3D triangular shape is filled.
     * @param height Height of the 3D triangular shape.
     * @param base Base of the 3D triangular shape.
     */
    public Triangular3DShapes(String name, String color, boolean isFilled, double height, double base) {
        super(name, color, isFilled);
        this.height = height;
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
     * @param height Desired value for the height.
     */
    public void setHeight(double height) {
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
}
