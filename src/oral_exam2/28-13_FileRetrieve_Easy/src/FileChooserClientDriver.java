import javax.swing.*;

public class FileChooserClientDriver
{
    public static void main(String[] args){
        FileChooserClient client = new FileChooserClient("127.0.0.1");
        client.runClient();

    }
}
