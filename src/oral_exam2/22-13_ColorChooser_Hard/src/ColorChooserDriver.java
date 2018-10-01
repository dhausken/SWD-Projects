import javax.swing.JFrame;

public class ColorChooserDriver
{
    public static void main(String[] args)
    {
        MyColorChooser colorChooser = new MyColorChooser();
        colorChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorChooser.setSize(250,450);
        colorChooser.setVisible(true);
    }
}


