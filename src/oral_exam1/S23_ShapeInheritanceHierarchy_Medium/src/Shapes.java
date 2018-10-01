/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Base class for shape hierarchy
 */
public class Shapes
{
    /**
     * Name of the shape.
     */
    private String name;
    /**
     * Color of the shape. Useful for drawing program.
     */
    private String color;
    /**
     * Determines whether or not the shape is filled with the color.
     * Useful for drawing program.
     */
    private boolean isFilled;

    /**
     * Constructor
     *
     * @param name Name of the shape.
     * @param color Color of the shape.
     * @param isFilled Determines whether or not the shape is filled with the color.
     */
    public Shapes(String name, String color, boolean isFilled)
    {
        this.name = name;
        this.isFilled = isFilled;
    }

    /**
     * Getter for name.
     * @return String of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name Name of the shape
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for isFilled
     * @return boolean value for isFilled.
     */
    public boolean isFilled() {
        return isFilled;
    }

    /**
     * Setter for isFilled
     * @param filled Whether or not the shape is filled with a color.
     */
    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    /**
     * Getter for color.
     * @return Color of the shape.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for color
     * @param color The color to set the shape to.
     */
    public void setColor(String color) {
        this.color = color;
    }
}
