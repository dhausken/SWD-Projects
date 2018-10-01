/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of spheres
 * @see Circular3DShapes
 * @version 1.0
 */
public class Sphere extends Circular3DShapes
{
    /**
     * Constructor
     * @param name Name of the sphere.
     * @param color Color of the sphere.
     * @param isFilled Whether or not the sphere is filled with the color.
     * @param radius Radius of the sphere.
     */
    public Sphere(String name, String color, boolean isFilled, double radius)
    {
        super(name,color,isFilled,radius);
    }

    /**
     * Calculate the volume of the sphere.
     * @return Double of the volume of the sphere.
     */
    public double calculateVolume()
    {
        setVolume(4/3*Math.PI*Math.pow(getRadius(),3));
        return getVolume();
    }

    /**
     * Calculate the surface area of the sphere.
     * @return Double of the surface area of the sphere.
     */
    private double calculateSurfaceArea()
    {
        setSurfaceArea(4 * Math.PI * Math.pow(getRadius(),2));
        return getSurfaceArea();
    }
}
