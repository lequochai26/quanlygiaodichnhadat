package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class AverageByTypeCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private IGiaoDichManager domain;
    private Class type;

    // CONSTRUCTORS:
    public AverageByTypeCommand(JFrame frame, IGiaoDichManager domain, Class type) {
        this.frame = frame;
        this.domain = domain;
        this.type = type;
    }

    // METHODS:
    @Override
    public void execute() {
        // Calculate average by type
        double result = domain.averageThanhTienByType(type);

        // Show message
        JOptionPane.showMessageDialog(
            frame,
            "Kết quả: " + result,
            "Tính trung bình thành tiền",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
