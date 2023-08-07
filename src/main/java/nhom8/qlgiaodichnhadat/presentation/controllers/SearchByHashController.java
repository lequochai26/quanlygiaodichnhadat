package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nhom8.qlgiaodichnhadat.command.SearchByHashCommand;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class SearchByHashController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public SearchByHashController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Create command
        Command command = new SearchByHashCommand(mainWindow, domain);

        // Execute command
        command.execute();
    }
}
