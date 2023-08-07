package nhom8.qlgiaodichnhadat.command;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.hash.ObjectHasher;
import nhom8.qlgiaodichnhadat.hash.SHA256ObjectHasher;
import nhom8.qlgiaodichnhadat.notifiers.ErrorNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class GetHashCommand implements Command {
    // FIELDS:
    private JFrame frame;
    private Object target;

    // CONSTRUCTORS:
    public GetHashCommand(JFrame frame, Object target) {
        this.frame = frame;
        this.target = target;
    }

    // METHODS:
    @Override
    public void execute() {
        // Get hasher
        ObjectHasher hasher = SHA256ObjectHasher.getInstance();

        // Hash target
        String hash = hasher.hashObject(target);

        // Notify
        int option = JOptionPane.showConfirmDialog(
            frame,
            "Mã băm:\n"
            + hash
            + "\n"
            + "\nBạn có muốn copy mã băm không ?",
            "Dữ liệu",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check option
        if (option != JOptionPane.OK_OPTION) {
            return;
        }

        // Get error notifier
        Notifier errorNotifier = ErrorNotifier.getInstance();

        try {
            // Create a string selection
            StringSelection selection = new StringSelection(hash);

            // Get system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Set clipboard content
            clipboard.setContents(selection, null);
        }
        catch (Exception e) {
            errorNotifier.notify(
                e.getStackTrace()
            );
        }
    }
}
