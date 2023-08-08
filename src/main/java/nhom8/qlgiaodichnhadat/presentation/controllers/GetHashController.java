package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nhom8.qlgiaodichnhadat.command.CommandFacade;
import nhom8.qlgiaodichnhadat.command.GetHashCommand;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;
import nhom8.qlgiaodichnhadat.presentation.views.objectgetters.ObjectGetter;

public class GetHashController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public GetHashController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get object getter
        ObjectGetter getter = mainWindow.getGiaoDichGetter();

        // Get target object
        Object target = getter.getObject();

        // Execut command
        CommandFacade
        .getInstance()
        .executeGetHashCommand(mainWindow, target);
    }
}
