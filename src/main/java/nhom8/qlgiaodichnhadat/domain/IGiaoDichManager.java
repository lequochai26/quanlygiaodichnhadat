package nhom8.qlgiaodichnhadat.domain;

import java.util.Date;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;

public interface IGiaoDichManager {
    void saveGiaoDichs(GiaoDich... giaoDichs);
    void removeGiaoDichs(GiaoDich... giaoDichs);
    List getAllGiaoDichs();
    List getGiaoDichsByKeyWord(String keyWord);
    List getGiaoDichsByType(Class type);
    List getGiaoDichsInRangeOfDate(Date start, Date end);
    GiaoDich getGiaoDich(int maGiaoDich);
    GiaoDich getGiaoDich(String hash);
    int countAllGiaoDichs();
    int countGiaoDichsByType(Class type);
    double averageThanhTienAll();
    double averageThanhTienByType(Class type);
}
