package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.notifiers.ErrorNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class SearchByIdCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;
    
    private Notifier errorNotifier;

    // CONSTRUCTORS:
    public SearchByIdCommand(JFrame frame, IGiaoDichManager domain) {
        this.frame = frame;
        this.domain = domain;

        errorNotifier = ErrorNotifier.getInstance();
    }

    // METHODS:
    @Override
    public void execute() {
        // Show input dialog
        String content = null;
        content = JOptionPane.showInputDialog(
            frame,
            "Nhập mã giao dịch: ",
            "Tìm kiếm",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check content
        if (content == null) {
            return;
        }

        try {
            // Parse content into an int
            int maGiaoDich = Integer.parseInt(content);

            // Get giao dich
            domain.getGiaoDich(maGiaoDich);
        }
        catch (Exception e) {
            errorNotifier.notify(e);
        }
    }
}
