package nhom8.qlgiaodichnhadat.persistence;

import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

public class GiaoDichDBHandler implements IGiaoDichDBHandler {
    // FIELDS:
    private GiaoDichDAO dao;

    // CONSTRUCTORS:
    public GiaoDichDBHandler(GiaoDichDAO dao) {
        this.dao = dao;
    }

    // METHODS:
    @Override
    public void saveGiaoDichs(GiaoDichData... giaoDichs) {
        dao.saveGiaoDichs(giaoDichs);
    }

    @Override
    public void removeGiaoDichs(GiaoDichData... giaoDichs) {
        dao.removeGiaoDichs(giaoDichs);
    }

    @Override
    public void clearGiaoDichs() {
        dao.clearGiaoDichs();
    }

    @Override
    public GiaoDichData getGiaoDich(int maGiaoDich) {
        return dao.getGiaoDich(maGiaoDich);
    }

    @Override
    public List getAllGiaoDichs() {
        return dao.getAllGiaoDichs();
    }
}
