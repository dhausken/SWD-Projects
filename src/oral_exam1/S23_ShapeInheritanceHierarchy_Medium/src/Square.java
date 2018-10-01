/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of squares.
 * @see Rectangular2DShapes
 * @version 1.0
 */
public class Square extends Rectangular2DShapes
{
    /**
     * Constructor. Both sides must equal eachother.
     * @param name Name of the square.
     * @param color Color of the square.
     * @param isFilled Whether or not the square is filled with the color or not.
     * @param length Length of the square.
     * @param width Width of the square.
     */
    public Square(String name, String color, boolean isFilled, double length, double width) {
        super(name, color, isFilled, length, width);
        if(length != width)
        {
            throw new IllegalArgumentException("Length must equal width");
        }
    }

    /**
     * Calculate the area of the square.
     * @return Double of the area of the square.
     */
    public double calculateArea()
    {
        setArea(2*getLength());
        return getArea();
    }

    /**
     * Calculate the perimeter of the square.
     * @return Double of the perimeter of the square
     */
    public double calculatePerimeter()
    {
        setPerimeter(4*getLength());
        return getPerimeter();
    }
}
