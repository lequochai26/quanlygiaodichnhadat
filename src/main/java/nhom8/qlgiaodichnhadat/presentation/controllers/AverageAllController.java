package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class AverageAllController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS
    public AverageAllController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Average all
        double result = domain.averageThanhTienAll();

        // Show message dialog
        JOptionPane.showMessageDialog(
            mainWindow,
            "Trung bình thành tiền tất cả giao dịch: " + result,
            "Trung bình thành tiền",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
