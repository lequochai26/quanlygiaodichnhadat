package nhom8.qlgiaodichnhadat.objectconverter;

public interface ObjectConverter<F,T> {
    T convert(F obj);
    F reverse(T obj);
}
