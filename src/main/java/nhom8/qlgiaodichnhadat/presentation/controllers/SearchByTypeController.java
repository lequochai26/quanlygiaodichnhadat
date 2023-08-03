package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class SearchByTypeController implements ActionListener {
    // FIELDS:
    protected MainWindow mainWindow;
    protected Class type;

    // CONSTRUCTORS:
    public SearchByTypeController(MainWindow mainWindow, Class type) {
        this.mainWindow = mainWindow;
        this.type = type;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Tells domain to get GiaoDich objects by type
        domain.getGiaoDichsByType(type);
    }
}
