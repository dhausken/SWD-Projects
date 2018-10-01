/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of 2D circular shapes.
 * @see TwoDimensional
 * @version 1.0
 */
public class Circular2DShapes extends TwoDimensional
{
    /**
     * Radius of the circle.
     */
    private double radius;

    /**
     * Constructor
     * @param name Name of the circular shape.
     * @param color Color of the circular shape.
     * @param isFilled Whether the circular shape is filled with the color or not.
     * @param radius Radius of the circular shape.
     */
    public Circular2DShapes(String name, String color, boolean isFilled,double radius) {
        super(name, color, isFilled);
        this.radius = radius;
    }

    /**
     * Getter for radius of the circular shape.
     * @return Double of the radius of the circular shape.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for the radius of the circular shape.
     * @param radius Desired radius of the circular shape.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
