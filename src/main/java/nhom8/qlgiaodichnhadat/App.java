package nhom8.qlgiaodichnhadat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.text.DateFormatter;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichDat;
import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiDat;
import nhom8.qlgiaodichnhadat.presentation.GUI;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class App 
{
    public static void main( String[] args ) throws ParseException
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
