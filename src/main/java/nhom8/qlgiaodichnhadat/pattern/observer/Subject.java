package nhom8.qlgiaodichnhadat.pattern.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Subject implements ISubject {
    // FIELDS:
    private PropertyChangeSupport support;

    // CONSTRUCTORS:
    public Subject() {
        // Support initialization
        support = new PropertyChangeSupport(this);
    }

    // METHODS:
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void firePropertyChange(String propertyName, Object newValue, Object oldValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }

    @Override
    public void firePropertyChange(PropertyChangeEvent e) {
        support.firePropertyChange(e);
    }
}
