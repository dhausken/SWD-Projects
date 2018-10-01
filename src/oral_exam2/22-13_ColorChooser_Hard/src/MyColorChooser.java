import javax.swing.*;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles most of the Color Chooser behaviors.
 * Handles the sliders, labels, paint method, and change listeners.
 */
public class MyColorChooser extends JFrame {
    /**
     * Slider for the color red.
     */
    private JSlider redSlider;
    /**
     * Slider for the color blue.
     */
    private JSlider blueSlider;
    /**
     * Slider for the color green.
     */
    private JSlider greenSlider;

    /**
     * Constructor for MyColorChooser. Creates several sliders as well as lavels and change
     * listeners.
     */
    public MyColorChooser() {
        setLayout(new FlowLayout());
        redSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        blueSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        greenSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        JLabel redLabel = new JLabel("Red Slider:");
        JLabel blueLabel = new JLabel("Blue Slider:");
        JLabel greenLabel = new JLabel("Green Slider:");

        redSlider.setMajorTickSpacing(10);
        redSlider.setPaintTicks(true);
        blueSlider.setMajorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        greenSlider.setMajorTickSpacing(10);
        greenSlider.setPaintTicks(true);

        redSlider.addChangeListener(new slideMoved());
        blueSlider.addChangeListener(new slideMoved());
        greenSlider.addChangeListener(new slideMoved());

        add(redLabel);
        add(redSlider);
        add(greenLabel);
        add(greenSlider);
        add(blueLabel);
        add(blueSlider);
    }

    /**
     * Paint method for the rectangle. Rectangle color dependent on the position
     * of sliders.
     * @param g Graphic where the rectangle goes.
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Color rectangleColor = new Color(redSlider.getValue(),greenSlider.getValue(),blueSlider.getValue());
        g.setColor(rectangleColor);
        g.fillRect(25,200,200,100);
    }

    /**
     * Method that calls the paint method again every time the slider is changed.
     */
    class slideMoved implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent e)
        {
            if(redSlider == e.getSource() || blueSlider == e.getSource() || greenSlider == e.getSource())
            {
                repaint();
            }
        }
    }
}


