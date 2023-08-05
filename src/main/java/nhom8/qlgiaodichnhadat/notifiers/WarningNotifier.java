package nhom8.qlgiaodichnhadat.notifiers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WarningNotifier implements Notifier {
    // STATIC FIELDS:
    private static WarningNotifier instance = new WarningNotifier();

    // STATIC METHODS:
    public static WarningNotifier getInstance() {
        return instance;
    }

    // CONSTRUCTORS:
    private WarningNotifier() {

    }

    // METHODS:
    @Override
    public void notify(JFrame frame, Object content, String title) {
        JOptionPane.showMessageDialog(
            frame,
            content,
            title,
            JOptionPane.WARNING_MESSAGE
        );
    }

    @Override
    public void notify(Object content, String title) {
        notify(null, content, title);
    }

    @Override
    public void notify(Object content) {
        notify(content, "Warning");
    }
}
