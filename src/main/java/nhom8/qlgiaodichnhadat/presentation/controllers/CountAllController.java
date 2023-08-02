package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class CountAllController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public CountAllController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Count all
        int count = domain.countAllGiaoDichs();

        // Show information message
        JOptionPane.showMessageDialog(
            mainWindow,
            "Tổng số lượng tất cả giao dịch: " + count,
            "Số lượng giao dịch",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
