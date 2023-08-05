package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import nhom8.qlgiaodichnhadat.command.RemoveCommand;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.pattern.command.Command;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;
import nhom8.qlgiaodichnhadat.presentation.views.objectgetters.ObjectGetter;

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
        ObjectGetter giaoDichGetter = mainWindow.getGiaoDichGetter();

        // Get GiaoDich object
        GiaoDich giaoDich = (GiaoDich)giaoDichGetter.getObject();

        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();
        
        // Create command
        Command command = new RemoveCommand(domain, giaoDich);

        // Execute command
        command.execute();
    }
}
