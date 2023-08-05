package nhom8.qlgiaodichnhadat.notifiers;

import javax.swing.JFrame;

public interface Notifier {
    void notify(JFrame frame, Object content, String title);
    void notify(Object content, String title);
    void notify(Object content);
}
