package nhom8.qlgiaodichnhadat.domain;

import java.util.Date;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;

public interface IGiaoDichManager {
    void saveGiaoDichs(GiaoDich... giaoDichs);
    void removeGiaoDichs(GiaoDich... giaoDichs);
    List<GiaoDich> getAllGiaoDichs();
    List<GiaoDich> getGiaoDichsByKeyWord(String keyWord);
    List<GiaoDich> getGiaoDichsByType(Class type);
    List<GiaoDich> getGiaoDichsInRangeOfDate(Date start, Date end);
    GiaoDich getGiaoDich(int maGiaoDich);
    GiaoDich getGiaoDich(String hash);
    int countAllGiaoDichs();
    int countGiaoDichsByType(Class type);
    double averageThanhTienAll();
    double averageThanhTienByType(Class type);
}
