package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.command.CommandFacade;
import nhom8.qlgiaodichnhadat.command.CountByTypeCommand;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class CountByTypeController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;
    private Class type;

    // CONSTRUCTORS:
    public CountByTypeController(MainWindow mainWindow, Class type) {
        this.mainWindow = mainWindow;
        this.type = type;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Execute command
        CommandFacade
        .getInstance()
        .executeCountByTypeCommand(mainWindow, domain, type);
    }
}
