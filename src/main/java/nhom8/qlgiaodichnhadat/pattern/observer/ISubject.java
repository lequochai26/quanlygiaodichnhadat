package nhom8.qlgiaodichnhadat.pattern.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface ISubject {
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void firePropertyChange(String propertyName, Object newValue, Object oldValue);
    void firePropertyChange(PropertyChangeEvent e);
}
