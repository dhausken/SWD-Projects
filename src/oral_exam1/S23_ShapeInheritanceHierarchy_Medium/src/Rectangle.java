/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of rectangles
 * @see Rectangular2DShapes
 * @version 1.0
 */
public class Rectangle extends Rectangular2DShapes
{
    /**
     * Constructor
     * @param name Name of the rectangle.
     * @param color Color of the rectangle.
     * @param isFilled Whether or not the rectangle is filled with the color.
     * @param length Length of the rectangle.
     * @param width Width of the rectangle.
     */
    public Rectangle(String name, String color, boolean isFilled, double length, double width) {
        super(name, color, isFilled, length, width);
    }

    /**
     * Calculates the area of the rectangle.
     * @return Double of the area of the rectangle.
     */
    public double calculateArea()
    {
        setArea(getLength()*getWidth());
        return getArea();
    }

    /**
     * Calculates the perimeter of the rectangle.
     * @return Double of the perimeter of the rectangle.
     */
    public double calculatePerimeter()
    {
        setPerimeter(2*getLength() + 2*getWidth());
        return getPerimeter();
    }
}
