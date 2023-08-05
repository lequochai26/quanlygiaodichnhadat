package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class AverageAllCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;

    // CONSTRUCTORS:
    public AverageAllCommand(JFrame frame, IGiaoDichManager domain) {
        this.frame = frame;
        this.domain = domain;
    }

    // METHODS:
    @Override
    public void execute() {
        // Calculate average all using domain
        double result = domain.averageThanhTienAll();

        // Show message dialog
        JOptionPane.showMessageDialog(
            frame,
            "Kết quả: " + result,
            "Trung bình thành tiền",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}