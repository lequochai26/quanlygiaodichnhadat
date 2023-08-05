package nhom8.qlgiaodichnhadat.command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class SearchInRangeOfDateCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;

    // CONSTRUCTORS:
    public SearchInRangeOfDateCommand(JFrame frame, IGiaoDichManager domain) {
        this.frame = frame;
        this.domain = domain;
    }

    // METHODS:
    @Override
    public void execute() {
        // Get date formatter
        DateFormat formatter = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm:ss"
        );

        // Get start date string
        String content;
        content = JOptionPane.showInputDialog(
            frame,
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
                ex.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Get end date string
        content = JOptionPane.showInputDialog(
            frame,
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

        // Get in range of date
        domain.getGiaoDichsInRangeOfDate(start, end);
    }
}
