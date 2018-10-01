/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class used for the characteristics of 2D shapes
 * @see Shapes
 */
public class TwoDimensional extends Shapes
{
    /**
     * Area of the shape.
     */
    private double area;
    /**
     * Perimeter of the shape.
     */
    private double perimeter;

    /**
     * Constructor
     * @param name Name of the shape.
     * @param color Color of the shape.
     * @param isFilled Determines whether the shape is filled with the color.
     */
    public TwoDimensional(String name, String color, boolean isFilled) {
        super(name, color, isFilled);
    }

    /**
     * Getter for area
     * @return Area of the shape.
     */
    public double getArea() {
        return area;
    }

    /**
     * Setter for area
     * @param area The value of the area for the shape.
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Getter for perimeter.
     * @return Perimeter of the shape.
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Setter for perimeter.
     * @param perimeter The value of the perimeter for the shape.
     */
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
