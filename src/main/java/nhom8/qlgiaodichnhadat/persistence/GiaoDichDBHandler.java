package nhom8.qlgiaodichnhadat.persistence;

import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;

public interface GiaoDichDBHandler {
    void saveGiaoDichs(GiaoDich... giaoDichs);
    void removeGiaoDichs(GiaoDich... giaoDichs);
    GiaoDich getGiaoDich(int maGiaoDich);
    List getAllGiaoDichs();
}
