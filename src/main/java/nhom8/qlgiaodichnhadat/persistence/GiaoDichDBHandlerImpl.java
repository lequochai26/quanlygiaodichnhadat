package nhom8.qlgiaodichnhadat.persistence;

import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;

public class GiaoDichDBHandlerImpl implements GiaoDichDBHandler {
    // FIELDS:
    private GiaoDichDAO dao;

    // CONSTRUCTORS:
    public GiaoDichDBHandlerImpl(GiaoDichDAO dao) {
        this.dao = dao;
    }

    // METHODS:
    @Override
    public void saveGiaoDichs(GiaoDich... giaoDichs) {
        dao.saveGiaoDichs(giaoDichs);
    }

    @Override
    public void removeGiaoDichs(GiaoDich... giaoDichs) {
        dao.removeGiaoDichs(giaoDichs);
    }

    @Override
    public GiaoDich getGiaoDich(int maGiaoDich) {
        return dao.getGiaoDich(maGiaoDich);
    }

    @Override
    public List getAllGiaoDichs() {
        return dao.getAllGiaoDichs();
    }
}
