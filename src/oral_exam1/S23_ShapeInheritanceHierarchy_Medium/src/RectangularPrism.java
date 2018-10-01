/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of rectangular prisms.
 * @see Rectangular3DShapes
 * @version 1.0
 */
public class RectangularPrism extends Rectangular3DShapes
{
    /**
     * Constructor
     * @param name Name of the rectangular prism.
     * @param color Color of the rectangular prism.
     * @param isFilled Whether or not the rectangular prism is filled with the color.
     * @param length Length of the rectangular prism.
     * @param width Width of the rectangular prism.
     * @param height Height of the rectangular prism.
     */
    public RectangularPrism(String name, String color, boolean isFilled, double length, double width, double height) {
        super(name, color, isFilled, length, width, height);
    }

    /**
     * Calculate the surface area of the rectangular prism.
     * @return Double of the surface area.
     */
    public double calculateSurfaceArea()
    {

        setSurfaceArea(2*getLength()*getWidth()+2*(getLength()+getWidth())*getHeight());
        return getSurfaceArea();
    }

    /**
     * Calculate the volume of the rectangular prism.
     * @return Double of the volume.
     */
    public double calculateVolume()
    {
        setVolume(getLength()*getWidth()*getHeight());
        return getVolume();
    }


}
