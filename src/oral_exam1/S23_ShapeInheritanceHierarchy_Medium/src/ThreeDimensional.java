/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class to determine characteristics of 3D shapes.
 * @see Shapes
 * @version 1.0
 */
public class ThreeDimensional extends Shapes
{
    /**
     * Volume of the three dimensional shape.
     */
    private double volume;
    /**
     * Surface area of the three dimensional shape.
     */
    private double surfaceArea;

    /**
     * Constructor
     * @param name Name of the three dimensional shape.
     * @param color Color of the three dimensional shape.
     * @param isFilled Whether or not the three dimensional shape is filled.
     */
    public ThreeDimensional(String name, String color, boolean isFilled)
    {
        super(name, color, isFilled);
    }

    /**
     * Getter for the volume.
     * @return Double of the volume.
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Setter for the volume.
     * @param volume Desired value for the volume.
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Getter for the surface area
     * @return Double of the surface area.
     */
    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Setter for the surface area.
     * @param surfaceArea
     */
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }
}
