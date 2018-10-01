/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of ovals
 * @see Circular2DShapes
 * @version 1.0
 */
public class Oval extends Circular2DShapes
{
    /**
     * Second radius for the oval.
     */
    private double radius2;

    /**
     * Constructor
     * @param name Name of the oval.
     * @param color Color of the oval.
     * @param isFilled Whether or not the oval is filled with the color.
     * @param radius First radius of the oval.
     * @param radius2 Second radius of the oval.
     */
    public Oval(String name, String color, boolean isFilled,double radius, double radius2) {
        super(name, color, isFilled, radius);
        this.radius2 = radius2;
    }

    /**
     * Getter for the second radius.
     * @return Double of the second radius.
     */
    public double getRadius2() {
        return radius2;
    }

    /**
     * Setter for the second radius
     * @param radius2 Desired value for the second radius.
     */
    public void setRadius2(double radius2) {
        this.radius2 = radius2;
    }

    /**
     * Calculates the area of the oval.
     * @return Double of the area of the oval.
     */
    public double calculateArea()
    {
        setArea(Math.PI * radius2 * getRadius());
        return getArea();
    }

    /**
     * Calculates the perimeter of the oval.
     * @return Double of the perimeter of the oval.
     */
    public double calculatePerimeter()
    {
        setPerimeter(Math.PI*(3*getRadius()+getRadius2()) - Math.sqrt((3*getRadius() + getRadius2())*(getRadius() + 3*getRadius2())));
        return getPerimeter();
    }
}