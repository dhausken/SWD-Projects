/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of circles
 * @see TwoDimensional
 * @version 1.0
 */
public class Circle extends Circular2DShapes
{
    public Circle(String name, String color, boolean isFilled, double radius) {
        super(name, color, isFilled, radius);
    }

    public double calculateArea()
    {
        setArea(Math.PI * Math.pow(getRadius(),2));
        return getArea();
    }

    public double calculateCircumference()
    {
        setPerimeter(2*Math.PI*getRadius());
        return getPerimeter();
    }
}
