package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class CountByTypeCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;
    private Class type;

    // CONSTRUCTORS:
    public CountByTypeCommand(JFrame frame, IGiaoDichManager domain, Class type) {
        this.frame = frame;
        this.domain = domain;
        this.type = type;
    }

    // METHODS:
    @Override
    public void execute() {
        // Count by type
        int count = domain.countGiaoDichsByType(type);

        // Show message
        JOptionPane.showMessageDialog(
            frame,
            "Số lượng: " + count,
            "Số lượng giao dịch",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
