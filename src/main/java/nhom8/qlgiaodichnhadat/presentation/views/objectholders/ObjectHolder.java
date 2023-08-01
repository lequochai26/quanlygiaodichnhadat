package nhom8.qlgiaodichnhadat.presentation.views.objectholders;

public interface ObjectHolder<T> {
    @Override
    String toString();
    T getObject();
    void setObject(T object);
}
