package nhom8.qlgiaodichnhadat.objectconverter;

import java.util.ArrayList;
import java.util.List;

public abstract class ListArrayConverter<T> implements ObjectConverter<List<T>,T[]> {
    // FIELDS:
    private T[] array;

    // CONSTRUCTORS:
    public ListArrayConverter() {
        array = generateArray();
    }

    // METHODS:
    @Override
    public T[] convert(List<T> obj) {
        // Create a local array
        T[] array = obj.toArray(this.array);

        // Regenerate instance's array
        this.array = generateArray();

        // Return
        return array;
    }

    @Override
    public List<T> reverse(T[] obj) {
        // List of T objects initialization
        List<T> list = new ArrayList<T>();

        // Adding objects in obj
        for (T object : obj) {
            list.add(object);
        }

        // Return
        return list;
    }

    public abstract T[] generateArray();
}
