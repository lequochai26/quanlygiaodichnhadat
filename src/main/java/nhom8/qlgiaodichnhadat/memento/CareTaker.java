package nhom8.qlgiaodichnhadat.memento;

import java.util.Stack;

public class CareTaker<T> {
    // FIELDS:
    private Stack<T> done;
    private Stack<T> undone;

    // CONSTRUCTORS:
    public CareTaker() {
        done = new Stack<T>();
        undone = new Stack<T>();
    }

    // METHODS:
    public T getLatestDone() {
        if (done.empty()) {
            return null;
        }

        return done.pop();
    }

    public void addDone(T memento) {
        done.push(memento);
    }

    public T getLatestUndone() {
        if (undone.empty()) {
            return null;
        }

        return undone.pop();
    }

    public void addUndone(T memento) {
        undone.push(memento);
    }
}
