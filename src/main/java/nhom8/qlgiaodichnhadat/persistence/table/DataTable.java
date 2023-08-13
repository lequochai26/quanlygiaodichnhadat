package nhom8.qlgiaodichnhadat.persistence.table;

import java.util.List;

public interface DataTable<K,V> {
    void saveData(V obj);
    void removeData(V key);
    void clearData();
    V getData(K key);
    List<V> getAllData();
}
