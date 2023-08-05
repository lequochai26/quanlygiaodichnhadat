package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class SearchByKeyWordCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;

    // CONSTRUCTORS:
    public SearchByKeyWordCommand(JFrame frame, IGiaoDichManager domain) {
        this.frame = frame;
        this.domain = domain;
    }

    // METHODS:
    @Override
    public void execute() {
        // Show input dialog
        String keyWord = JOptionPane.showInputDialog(
            frame,
            "Nhập từ khóa: ",
            "Tìm kiếm",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check if keyWord is null
        if (keyWord == null) {
            return;
        }

        // Search by keyword
        domain.getGiaoDichsByKeyWord(keyWord);
    }
}
