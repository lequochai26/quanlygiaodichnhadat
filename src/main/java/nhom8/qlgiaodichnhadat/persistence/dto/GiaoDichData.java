package nhom8.qlgiaodichnhadat.persistence.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "GiaoDich")
@Table (name = "GiaoDich")
public class GiaoDichData {
    // FIELDS:
    @Column (name = "loaiGiaoDich")
    private String loaiGiaoDich;

    @Id
    @Column (name = "maGiaoDich")
    private int maGiaoDich;

    @Column (name = "ngayGiaoDich")
    private Date ngayGiaoDich;

    @Column (name = "donGia")
    private double donGia;

    @Column (name = "dienTich")
    private double dienTich;

    @Column (name = "loaiDat")
    private String loaiDat;

    @Column (name = "loaiNha")
    private String loaiNha;

    @Column (name = "diaChi")
    private String diaChi;

    // CONSTRUCTORS:
    public GiaoDichData() {

    }

    public GiaoDichData(String loaiGiaoDich, int maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich, String loaiDat, String loaiNha, String diaChi) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.loaiDat = loaiDat;
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    // METHODS:
    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }
    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
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
    public String getLoaiDat() {
        return loaiDat;
    }
    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }
    public String getLoaiNha() {
        return loaiNha;
    }
    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
