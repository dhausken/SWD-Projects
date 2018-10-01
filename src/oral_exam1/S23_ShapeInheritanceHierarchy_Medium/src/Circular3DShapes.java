/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of 3D circular shapes.
 * @see ThreeDimensional
 * @version 1.0
 */
public class Circular3DShapes extends ThreeDimensional
{
    /**
     * Radius of the 3D circular shape.
     */
    private double radius;

    /**
     * Constructor
     * @param name Name of the 3D circular shape.
     * @param color Color of the 3D circular shape.
     * @param isFilled Whether the 3D circular shape is filled with the color or not.
     * @param radius Radius of the 3D circular shape.
     */
    public Circular3DShapes(String name, String color, boolean isFilled, double radius) {
        super(name, color, isFilled);
        this.radius = radius;
    }

    /**
     * Getter for the radius of the 3D circular shape.
     * @return Radius of the 3D circular shape.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for the radius of the 3D circular shape.
     * @param radius Desired radius of the 3D circular shape.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
