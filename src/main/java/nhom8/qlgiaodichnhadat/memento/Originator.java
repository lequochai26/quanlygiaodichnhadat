package nhom8.qlgiaodichnhadat.memento;

public interface Originator<T> {
    T saveMemento();
    void applyMemento(T memento);
}
