package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;
import nhom8.qlgiaodichnhadat.presentation.views.objectgetters.ViewObjectGetter;

public class SaveController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public SaveController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get GiaoDich Getter object
        ViewObjectGetter giaoDichGetter = mainWindow.getGiaoDichGetter();

        // Get GiaoDich object
        GiaoDich giaoDich = (GiaoDich)giaoDichGetter.getObject();

        // Get domain object
        IGiaoDichManager domain = mainWindow.getDomain();

        // Check giaoDich exist in DB
        GiaoDich gd = domain.getGiaoDich(giaoDich.getMaGiaoDich());
        if (gd != null) {
            // Check if gd's type is different from giaoDich's type
            if (gd.getClass() != giaoDich.getClass()) {
                // Remove gd
                domain.removeGiaoDichs(gd);
            }
        }

        // Add GiaoDich object using domain
        domain.saveGiaoDichs(giaoDich);

        // Get all GiaoDich objects
        List all = domain.getAllGiaoDichs();

        // Update tblData to mainWindow
        mainWindow.updateTblData(all);
    }
}
