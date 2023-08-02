package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class SearchInRangeOfDateController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public SearchInRangeOfDateController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Get date formatter
        DateFormat formatter = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm:ss"
        );

        // Get start date string
        String content;
        content = JOptionPane.showInputDialog(
            mainWindow,
            "Từ ngày (dd/MM/yyyy HH:mm:ss): ",
            "Tìm kiếm",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check content
        if (content == null) {
            return;
        }

        // Start date initialization
        Date start = null;

        try {
            // Get start date
            start = formatter.parse(content);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Get end date string
        content = JOptionPane.showInputDialog(
            mainWindow,
            "Đến ngày (dd/MM/yyyy HH:mm:ss): ",
            "Tìm kiếm",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check content
        if (content == null) {
            return;
        }

        // End date initialization
        Date end = null;
        
        try {
            // Get end date
            end = formatter.parse(content);
        }
        catch (Exception ex) {
            // Show error message
            JOptionPane.showMessageDialog(
                null,
                ex.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            
            // End
            return;
        }

        // Get GiaoDich objects in range of date
        List giaoDichs = domain.getGiaoDichsInRangeOfDate(start, end);
        System.out.println(giaoDichs);

        // Check giaoDichs null
        if (giaoDichs == null) {
            return;
        }

        // Update mainWindow's tblData
        mainWindow.setData(giaoDichs);
    }
}
