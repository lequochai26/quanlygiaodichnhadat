package nhom8.qlgiaodichnhadat;

import javax.swing.UIManager;

import nhom8.qlgiaodichnhadat.presentation.GUI;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class App 
{
    public static void main( String[] args )
    {
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // GUI initialization
        GUI gui = new MainWindow();

        // Display gui
        gui.display();
    }
}
