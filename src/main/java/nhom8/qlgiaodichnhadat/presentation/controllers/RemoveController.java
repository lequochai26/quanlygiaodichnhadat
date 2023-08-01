package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;
import nhom8.qlgiaodichnhadat.presentation.views.objectgetters.ViewObjectGetter;

public class RemoveController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public RemoveController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get GiaoDich Object getter
        ViewObjectGetter giaoDichGetter = mainWindow.getGiaoDichGetter();

        // Get GiaoDich object
        GiaoDich giaoDich = (GiaoDich)giaoDichGetter.getObject();

        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();
        
        // Use domain to remove giaoDich
        domain.removeGiaoDichs(giaoDich);

        // Get all GiaoDich objects
        List all = domain.getAllGiaoDichs();

        // Update mainWindow's tblData
        mainWindow.updateTblData(all);
    }
}
