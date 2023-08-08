package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.hash.ObjectHasher;
import nhom8.qlgiaodichnhadat.hash.SHA256ObjectHasher;
import nhom8.qlgiaodichnhadat.notifiers.InformationNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;
import nhom8.qlgiaodichnhadat.notifiers.WarningNotifier;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class CheckHashCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private Object target;

    // CONSTRUCTORS:
    public CheckHashCommand(JFrame frame, Object target) {
        this.frame = frame;
        this.target = target;
    }

    // METHODS:
    @Override
    public void execute() {
        // Hash input
        String hash = JOptionPane.showInputDialog(
            frame,
            "Nhập mã băm: ",
            "Dữ liệu",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check hash null
        if (hash == null) {
            return;
        }

        // Get hasher
        ObjectHasher hasher = SHA256ObjectHasher.getInstance();

        // Hash target
        String targetHash = hasher.hashObject(target);

        // Get notifiers
        Notifier informationNotifier = InformationNotifier.getInstance();
        Notifier warningNotifier = WarningNotifier.getInstance();

        // Check if targetHash and hash are equals to each other
        if (targetHash.equals(hash)) {
            // Information notify
            informationNotifier.notify(
                frame,
                "Dữ liệu khớp với chuỗi mã băm!",
                "Dữ liệu"
            );
        }
        else {
            // Warning notify
            warningNotifier.notify(
                frame,
                "Dữ liệu không khớp với chuỗi mã băm!",
                "Dữ liệu"
            );
        }
    }
}
