package nhom8.qlgiaodichnhadat.persistence;

import java.util.List;

import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

public interface GiaoDichDAO {
    void saveGiaoDichs(GiaoDichData... giaoDichs);
    void removeGiaoDichs(GiaoDichData...giaoDichs);
    void clearGiaoDichs();
    GiaoDichData getGiaoDich(int maGiaoDich);
    List getAllGiaoDichs();
}
