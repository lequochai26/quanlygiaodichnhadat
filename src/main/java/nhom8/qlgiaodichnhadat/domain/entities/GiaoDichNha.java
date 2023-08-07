package nhom8.qlgiaodichnhadat.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiNha;

@Entity (name = "GiaoDichNha")
@Table (name = "GiaoDich")
public class GiaoDichNha extends GiaoDich {
    // FIELDS:
    @Column (name = "loaiNha")
    private LoaiNha loaiNha;

    @Column (name = "diaChi")
    private String diaChi;

    // CONSTRUCTORS:
    public GiaoDichNha() {

    }

    public GiaoDichNha(int maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich, LoaiNha loaiNha, String diaChi) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);

        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    // METHODS:
    @Override
    public double tinhThanhTien() {
        if (loaiNha == LoaiNha.CAOCAP) {
            return (dienTich * donGia);
        }

        if (loaiNha == LoaiNha.THUONG) {
            return (dienTich * donGia * 0.9);
        }

        return 0;
    }

    @Override
    public boolean matches(String keyWord) {
        // Lowercase keyWord
        keyWord = keyWord.toLowerCase();

        // Turn informations into lowercase strings
        String loaiGiaoDich = this.getClass().getSimpleName().toLowerCase();
        String loaiNha = (
            this.loaiNha != null ?
            this.loaiNha.toString().toLowerCase() :
            ""
        );
        String diaChi = (
            this.diaChi != null ?
            this.diaChi.toLowerCase() :
            ""
        );

        // Return
        return (
            super.matches(keyWord) ||
            loaiGiaoDich.contains(keyWord) ||
            loaiNha.contains(keyWord) ||
            diaChi.contains(keyWord) 
        );
    }

    @Override
    public String toString() {
        return "GiaoDichNha{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", ngayGiaoDich='" + new Date(ngayGiaoDich.getTime()) + '\'' +
                ", donGia=" + donGia +
                ", dienTich=" + dienTich +
                ", loaiNha='" + loaiNha + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    public LoaiNha getLoaiNha() {
        return loaiNha;
    }
    public void setLoaiNha(LoaiNha loaiNha) {
        this.loaiNha = loaiNha;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
