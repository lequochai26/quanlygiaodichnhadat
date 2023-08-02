package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class CountGiaoDichByTypeController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;
    private Class type;

    // CONSTRUCTORS:
    public CountGiaoDichByTypeController(MainWindow mainWindow, Class type) {
        this.mainWindow = mainWindow;
        this.type = type;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Count by type
        int count = domain.countGiaoDichsByType(type);

        // Show message dialog
        JOptionPane.showMessageDialog(
            mainWindow,
            "Số lượng " + type.getSimpleName() + ": " + count,
            "Số lượng giao dịch",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
