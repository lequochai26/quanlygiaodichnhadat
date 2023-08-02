package nhom8.qlgiaodichnhadat.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiDat;

@Entity (name = "GiaoDichDat")
@Table (name = "GiaoDich")
public class GiaoDichDat extends GiaoDich {
    // FIELDS:
    @Column (name = "loaiDat")
    private LoaiDat loaiDat;

    // CONSTRUCTORS:
    public GiaoDichDat() {

    }

    public GiaoDichDat(int maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich, LoaiDat loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        
        this.loaiDat = loaiDat;
    }

    // METHODS:
    @Override
    public double tinhThanhTien() {
        if (loaiDat == LoaiDat.B || loaiDat == LoaiDat.C) {
            return (dienTich * donGia);
        }

        if (loaiDat == LoaiDat.A) {
            return (dienTich * donGia * 1.5);
        }

        return 0;
    }

    @Override
    public boolean matches(String keyWord) {
        // Lowercase keyWord
        keyWord = keyWord.toLowerCase();

        // Turn informations into lowercase strings
        String loaiGiaoDich = this.getClass().getSimpleName().toLowerCase();
        String loaiDat = (
            this.loaiDat != null ?
            this.loaiDat.toString().toLowerCase() :
            ""
        );

        // Return
        return (
            super.matches(keyWord) ||
            loaiGiaoDich.contains(keyWord) ||
            loaiDat.contains(keyWord)
        );
    }

    @Override
    public String toString() {
        return "GiaoDichDat{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", ngayGiaoDich='" + ngayGiaoDich + '\'' +
                ", donGia=" + donGia +
                ", dienTich=" + dienTich +
                ", loaiDat='" + loaiDat + '\'' +
                '}';
    }

    public LoaiDat getLoaiDat() {
        return loaiDat;
    }
    public void setLoaiDat(LoaiDat loaiDat) {
        this.loaiDat = loaiDat;
    }
}
