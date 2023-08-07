package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class SearchByHashCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;

    // CONSTRUCTORS:
    public SearchByHashCommand(JFrame frame, IGiaoDichManager domain) {
        this.domain = domain;
    }

    // METHODS:
    @Override
    public void execute() {
        // Hash input
        String hash = JOptionPane.showInputDialog(
            frame,
            "Nhập chuỗi mã băm: ",
            "Tìm kiếm",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check hash null
        if (hash == null) {
            return;
        }

        // Get giao dich by hash
        domain.getGiaoDich(hash);
    }
}
