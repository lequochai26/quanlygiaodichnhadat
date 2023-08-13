package nhom8.qlgiaodichnhadat.persistence.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

public class GiaoDichDataTable extends HashMap<Integer,GiaoDichData> implements DataTable<Integer,GiaoDichData> {
    // CONSTRUCTORS:
    public GiaoDichDataTable() {
        // Inherit from super class's default constructors
        super();
    }

    // METHODS:
    @Override
    public void saveData(GiaoDichData giaoDich) {
        this.put(giaoDich.getMaGiaoDich(), giaoDich);
    }

    @Override
    public void removeData(GiaoDichData giaoDich) {
        this.remove(giaoDich.getMaGiaoDich());
    }

    @Override
    public void clearData() {
        this.clear();
    }

    @Override
    public GiaoDichData getData(Integer maGiaoDich) {
        return this.get(maGiaoDich);
    }

    @Override
    public List<GiaoDichData> getAllData() {
        return new ArrayList<GiaoDichData>(
            this.values()
        );
    }
}
