package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichDat;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichNha;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;
import nhom8.qlgiaodichnhadat.presentation.views.objectholders.ObjectHolder;

public class LoaiGiaoDichSelectedController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public LoaiGiaoDichSelectedController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get cbLoaiGiaoDich
        JComboBox cbLoaiGiaoDich = mainWindow.getCbLoaiGiaoDich();

        // Get holder selected
        ObjectHolder holder = (ObjectHolder)cbLoaiGiaoDich.getSelectedItem();

        // Get class from holder
        Class loaiGiaoDich = (Class)holder.getObject();

        // Setup mainWindow based on loaiGiaoDich
        mainWindow.getCbLoaiDat().setEnabled(
            (loaiGiaoDich == GiaoDichDat.class)
        );
        mainWindow.getCbLoaiNha().setEnabled(
            (loaiGiaoDich == GiaoDichNha.class)
        );
        mainWindow.getTxtDiaChi().setEnabled(
            (loaiGiaoDich == GiaoDichNha.class)
        );
    }
}
