/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Class for characteristics of triangular prisms.
 * @see Triangular3DShapes
 * @version 1.0
 */

public class TriangularPrism extends Triangular3DShapes
{
    /**
     * Length of side 1.
     */
    private double side1;

    /**
     * Length of side 2.
     */
    private double side2;

    /**
     * Length of side 3
     */
    private double side3;

    /**
     * Constructor
     * @param name Name of shape.
     * @param color Color of shape.
     * @param isFilled Whether or not the shape is filled with a color.
     * @param height Height of the shape.
     * @param base Base of the shape.
     * @param side1 Length of side 1.
     * @param side2 Length of side 2.
     * @param side3 Length of side 3
     */
    public TriangularPrism(String name, String color, boolean isFilled, double height, double base, double side1, double side2, double side3) {
        super(name, color, isFilled, height, base);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Getter for side 1
     * @return Length of side 1
     */
    public double getSide1() {
        return side1;
    }

    /**
     * Setter for side 1
     * @param side1 Desired value of side 1
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /**
     * Getter for side 2.
     * @return Length of side 2.
     */
    public double getSide2() {
        return side2;
    }

    /**
     * Setter for side 2
     * @param side2 Desired value for side 2.
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    /**
     * Getter for side 3.
     * @return Length for side 3.
     */
    public double getSide3() {
        return side3;
    }

    /**
     * Setter for side 3.
     * @param side3 Desired value for side 3.
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    /**
     * Calculates surface area for the triangular prism.
     * @return Double value of the surface area.
     */
    public double calculateSurfaceArea()
    {
         setSurfaceArea(getBase()*getHeight()+(getSide1()+getSide2()+getSide3())*getHeight());
         return getSurfaceArea();
    }

    /**
     * Calculates volume for the triangular prism.
     * @return Double value of the volume.
     */
    public double calculateVolume()
    {
         setVolume((1/4)*getHeight()*Math.sqrt(Math.pow(-side1,4)+2*Math.pow(side1*side2,2)-Math.pow(side2,4)+2*Math.pow(side2*side3,2)-Math.pow(side3,4)));
         return getVolume();
    }
}
