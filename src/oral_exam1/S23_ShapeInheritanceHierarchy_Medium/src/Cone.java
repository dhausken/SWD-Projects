/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of cones.
 * @see Circular3DShapes
 * @version 1.0
 */
public class Cone extends Circular3DShapes
{
    /**
     * Height of the cone.
     */
    private double height;

    /**
     * Constructor
     * @param name Name of the cone.
     * @param color Color of the cone.
     * @param isFilled Whether the cone is filled with the color or not.
     * @param radius Radius of the cone.
     * @param height Height of the cone.
     */
    public Cone(String name, String color, boolean isFilled, double radius, double height) {
        super(name, color, isFilled, radius);
        this.height = height;
    }

    /**
     * Getter for the height of the cone.
     * @return Double of the height of the cone.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter for the height of the cone.
     * @param height Desired height of the cone.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Volume of the cone.
     * @return Double of the volume of the cone.
     */
    public double calculateVolume()
    {
        setVolume(Math.PI * Math.pow(getRadius(),2)*(getHeight()/3));
        return getVolume();
    }

    /**
     * Surface area of the cone
     * @return Double of the surface area of the cone.
     */
    public double calculateSurfaceArea()
    {
       setSurfaceArea(Math.PI * getRadius() * (getRadius() + Math.sqrt(Math.pow(getHeight(),2) + Math.pow(getRadius(),2))));
       return getSurfaceArea();
    }
}
