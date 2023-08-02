package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class CloseController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public CloseController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Dispose mainWindow
        mainWindow.dispose();
    }
}
