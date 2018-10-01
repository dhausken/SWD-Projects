/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of right triangles.
 * @see Triangular2DShapes
 * @version 1.0
 */
public class RightTriangle extends Triangular2DShapes
{
    /**
     * Hypotenuse length of the right triangle.
     */
    private double hypotenuse;

    /**
     * Constructor. Hypotenuse value dependent on base and height.
     * @param name Name of the right triangle.
     * @param color Color of the right triangle.
     * @param isFilled Whether or not the right triangle is filled with the color.
     * @param base Base length for the right triangle.
     * @param height Height length for the right triangle.
     */
    public RightTriangle(String name, String color, boolean isFilled,double height, double base) {
        super(name, color, isFilled, height, base);
        this.hypotenuse = Math.sqrt(Math.pow(base,2)*Math.pow(height,2));
    }

    /**
     * Calculates the perimeter of the right triangle.
     * @return Double of the perimeter of the right triangle.
     */
    public double calculatePerimeter()
    {
        setPerimeter(getBase() + getHeight() + hypotenuse);
        return getPerimeter();
    }

    /**
     * Getter for the hypotenuse of the right triangle.
     * @return Double of the hypotenuse.
     */
    public double getHypotenuse()
    {
        return hypotenuse;
    }
}
