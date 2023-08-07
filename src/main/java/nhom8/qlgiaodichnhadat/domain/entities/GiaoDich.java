package nhom8.qlgiaodichnhadat.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "GiaoDich")
@Table (name = "GiaoDich")
public abstract class GiaoDich {
    // FIELDS:
    @Id
    @Column (name = "maGiaoDich")
    protected int maGiaoDich;

    @Column (name = "ngayGiaoDich")
    protected Date ngayGiaoDich;

    @Column (name = "donGia")
    protected double donGia;

    @Column (name = "dienTich")
    protected double dienTich;

    // CONSTRUCTORS:
    public GiaoDich() {

    }

    public GiaoDich(int maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    // METHODS:
    public abstract double tinhThanhTien();

    public boolean matches(String keyWord) {
        // Check keyWord
        if (keyWord == null) {
            return false;
        }

        // Lower case keyword
        keyWord = keyWord.toLowerCase();

        // Turn informations into lowercase strings
        String loaiGiaoDich = this.getClass().getSimpleName().toLowerCase();
        String maGiaoDich = "" + this.maGiaoDich;
        String ngayGiaoDich = (
            this.ngayGiaoDich != null
            ?
            new Date(this.ngayGiaoDich.getTime()).toString().toLowerCase()
            :
            ""
        );
        String donGia = "" + this.donGia;
        String dienTich = "" + this.dienTich;

        return (
            loaiGiaoDich.contains(keyWord) ||
            maGiaoDich.contains(keyWord) ||
            ngayGiaoDich.contains(keyWord) ||
            donGia.contains(keyWord) ||
            dienTich.contains(keyWord)
        );
    }

    @Override
    public String toString() {
        return "GiaoDich{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", ngayGiaoDich='" + new Date(ngayGiaoDich.getTime()) + '\'' +
                ", donGia=" + donGia +
                ", dienTich=" + dienTich +
                '}';
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }
    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }
    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }
    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public double getDienTich() {
        return dienTich;
    }
    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }
}
