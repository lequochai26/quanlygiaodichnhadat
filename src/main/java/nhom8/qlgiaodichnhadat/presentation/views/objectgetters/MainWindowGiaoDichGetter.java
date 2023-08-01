package nhom8.qlgiaodichnhadat.presentation.views.objectgetters;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichDat;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichNha;
import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiDat;
import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiNha;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;
import nhom8.qlgiaodichnhadat.presentation.views.objectholders.ObjectHolder;

public class MainWindowGiaoDichGetter implements ViewObjectGetter<GiaoDich> {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public MainWindowGiaoDichGetter(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public GiaoDich getObject() {
        // Object declaration
        GiaoDich giaoDich = null;
        GiaoDichDat giaoDichDat = null;
        GiaoDichNha giaoDichNha = null;

        // Get necessary components from mainWindow
        JComboBox cbLoaiGiaoDich = mainWindow.getCbLoaiGiaoDich();
        JSpinner jsMaGiaoDich = mainWindow.getJsMaGiaoDich();
        JSpinner jsNgayGiaoDich = mainWindow.getJsNgayGiaoDich();
        JSpinner jsDonGia = mainWindow.getJsDonGia();
        JSpinner jsDienTich = mainWindow.getJsDienTich();
        JComboBox cbLoaiDat = mainWindow.getCbLoaiDat();
        JComboBox cbLoaiNha = mainWindow.getCbLoaiNha();
        JTextField txtDiaChi = mainWindow.getTxtDiaChi();

        // Object initialization
        if (
            ((ObjectHolder)cbLoaiGiaoDich.getSelectedItem())
            .getObject() == GiaoDichDat.class
        ) {
            giaoDichDat = new GiaoDichDat();
            giaoDich = giaoDichDat;
        }
        else {
            giaoDichNha = new GiaoDichNha();
            giaoDich = giaoDichNha;
        }

        // Get necessary informations
        int maGiaoDich = (int)jsMaGiaoDich.getValue();
        Date ngayGiaoDich = (Date)jsNgayGiaoDich.getValue();
        double donGia = (double)jsDonGia.getValue();
        double dienTich = (double)jsDienTich.getValue();
        LoaiDat loaiDat = (LoaiDat)cbLoaiDat.getSelectedItem();
        LoaiNha loaiNha = (LoaiNha)cbLoaiNha.getSelectedItem();
        String diaChi = txtDiaChi.getText();

        // Informations assignment
        giaoDich.setMaGiaoDich(maGiaoDich);
        giaoDich.setNgayGiaoDich(ngayGiaoDich);
        giaoDich.setDonGia(donGia);
        giaoDich.setDienTich(dienTich);
        
        if (giaoDichDat != null) {
            giaoDichDat.setLoaiDat(loaiDat);
        }
        else {
            giaoDichNha.setLoaiNha(loaiNha);
            giaoDichNha.setDiaChi(diaChi);
        }

        return giaoDich;
    }
}
