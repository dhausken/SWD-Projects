import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles most of the behaviors for BouncingBall.
 * Handles JPanel and multithreading components.
 */
public class BouncingBall extends JFrame
{
    /**
     * JPanel that holds the ball.
     */
    private final JPanel ballPanel = new JPanel(new BorderLayout());
    /**
     * Radius of the ball.
     */
    private int radius = 100;
    /**
     * X position of the ball relative to the JPanel.
     */
    private int xPosition = radius + 50;
    /**
     * Y position of the ball relative to the JPanel.
     */
    private int yPosition = radius + 50;

    /**
     * Constructor for BouncingBall. Handles adding JPanel, layout, and mouse listeners.
     */
    public BouncingBall()
    {
        setLayout(new BorderLayout());
        ballPanel.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e)
                    {
                        ballThread.start();
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );
        add(ballPanel);
        setSize(450,450);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Ball drawing. Radius is used for the size.
     * @param g Graphic where the ball is.
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.fillOval(xPosition,yPosition,radius,radius);

    }

    /**
     * Thread method for the ball moving and bouncing. Moves until it hits the wall
     * and then bounces in the opposite direction. The sleep method determines how
     * fast the ball moves.
     */
    private Thread ballThread = new Thread() {
        public void run() {
            while (true) {
                int ySpeed = 1;
                while(yPosition + radius < 450)
                {
                    yPosition += ySpeed;
                    repaint();
                    try {
                        sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                while(yPosition - radius + 60 > 0)
                {
                    yPosition -= ySpeed;
                    repaint();
                    try {
                        sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    };

}


