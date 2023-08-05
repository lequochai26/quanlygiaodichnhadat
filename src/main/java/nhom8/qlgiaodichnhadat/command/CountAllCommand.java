package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class CountAllCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;

    // CONSTRUCTORS:
    public CountAllCommand(JFrame frame, IGiaoDichManager domain) {
        this.frame = frame;
        this.domain = domain;
    }

    // METHODS:
    @Override
    public void execute() {
        // Count all
        int count = domain.countAllGiaoDichs();

        // Show message
        JOptionPane.showMessageDialog(
            frame,
            "Số lượng: " + count,
            "Số lượng giao dịch",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
