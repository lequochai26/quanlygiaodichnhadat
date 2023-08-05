package nhom8.qlgiaodichnhadat.notifiers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorNotifier implements Notifier {
    // STATIC FIELDS:
    private static ErrorNotifier instance = new ErrorNotifier();

    // STATIC METHODS:
    public static ErrorNotifier getInstance() {
        return instance;
    }

    // CONSTRUCTORS:
    private ErrorNotifier() {

    }

    // METHODS:
    @Override
    public void notify(JFrame frame, Object content, String title) {
        JOptionPane.showMessageDialog(
            frame,
            content,
            title,
            JOptionPane.ERROR_MESSAGE
        );
    }

    @Override
    public void notify(Object content, String title) {
        notify(null, content, title);
    }

    @Override
    public void notify(Object content) {
        notify(content, "Error");
    }
}
