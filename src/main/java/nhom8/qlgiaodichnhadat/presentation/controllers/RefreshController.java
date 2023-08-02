package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class RefreshController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public RefreshController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Get all GiaoDich objects
        List all = domain.getAllGiaoDichs();

        // Check all
        if (all != null) {
            // Update mainWindow's tblData
            mainWindow.setData(all);
        }
    }
}
