package nhom8.qlgiaodichnhadat.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiDat;
import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

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
    public String toString() {
        return "GiaoDichDat{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", ngayGiaoDich='" + new Date(ngayGiaoDich.getTime()) + '\'' +
                ", donGia=" + donGia +
                ", dienTich=" + dienTich +
                ", loaiDat='" + loaiDat + '\'' +
                '}';
    }

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
    public void loadData(GiaoDichData data) {
        // Load super class's data
        super.loadData(data);

        // Load additional data
        loaiDat = LoaiDat.valueOf(data.getLoaiDat());
    }

    @Override
    public GiaoDichData getData() {
        // Get data from super class's
        GiaoDichData data = super.getData();
        
        // Additional data assignments
        data.setLoaiGiaoDich(getClass().getName());
        data.setLoaiDat(loaiDat.toString());

        // Return
        return data;
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

    public LoaiDat getLoaiDat() {
        return loaiDat;
    }
    public void setLoaiDat(LoaiDat loaiDat) {
        this.loaiDat = loaiDat;
    }
}
