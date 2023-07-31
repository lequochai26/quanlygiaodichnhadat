package nhom8.qlgiaodichnhadat.entities;

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
