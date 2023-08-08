package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import nhom8.qlgiaodichnhadat.command.CommandFacade;
import nhom8.qlgiaodichnhadat.command.RemoveCommand;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.Originator;
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

        // Get domain originator
        Originator originator = mainWindow.getDomainOriginator();

        // Get domain care taker
        CareTaker careTaker = mainWindow.getDomainCareTaker();
        
        // Execute command
        CommandFacade
        .getInstance()
        .executeRemoveCommand(domain, giaoDich, originator, careTaker);
    }
}
