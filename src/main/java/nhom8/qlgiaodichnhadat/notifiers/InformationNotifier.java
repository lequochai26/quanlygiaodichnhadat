package nhom8.qlgiaodichnhadat.notifiers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InformationNotifier implements Notifier {
    // STATIC FIELDS:
    private static InformationNotifier instance = new InformationNotifier();

    // STATIC METHODS:
    public static InformationNotifier getInstance() {
        return instance;
    }

    // CONSTRUCTORS:
    private InformationNotifier() {

    }

    // METHODS:
    @Override
    public void notify(JFrame frame, Object content, String title) {
        JOptionPane.showMessageDialog(
            frame,
            content,
            title,
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void notify(Object content, String title) {
        notify(null, content, title);
    }

    @Override
    public void notify(Object content) {
        notify(content, "Information");
    }
}
