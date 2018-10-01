/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of cubes
 * @see Rectangular3DShapes
 * @version 1.0
 */
public class Cube extends Rectangular3DShapes
{
    /**
     * Constructor. All sides must be equal.
     * @param name Name of the cube.
     * @param color Color of the cube.
     * @param isFilled Whether or not the cube is filled with the color.
     * @param length Length of the cube.
     * @param width Width of the cube.
     * @param height Height of the cube.
     */
    public Cube(String name, String color, boolean isFilled, double length, double width, double height) {
        super(name, color, isFilled, length, width, height);
        if(length != width || length != height || width != height)
        {
            throw new IllegalArgumentException("All sides must be equal in a cube");
        }
    }

    /**
     * Surface area of the cube.
     * @return Double of the surface area for the cube.
     */
    public double calculateSurfaceArea()
    {
        setSurfaceArea(6*Math.pow(getLength(),2));
        return getSurfaceArea();
    }

    /**
     * Volume of the cube.
     * @return Double of the volume for the cube.
     */
    public double calculateVolume()
    {
        setVolume(Math.pow(getLength(),3));
        return getVolume();
    }
}
