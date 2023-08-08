package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import nhom8.qlgiaodichnhadat.command.CommandFacade;
import nhom8.qlgiaodichnhadat.command.SaveCommand;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.pattern.command.Command;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;
import nhom8.qlgiaodichnhadat.presentation.views.objectgetters.ObjectGetter;

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
        ObjectGetter giaoDichGetter = mainWindow.getGiaoDichGetter();

        // Get GiaoDich object
        GiaoDich giaoDich = (GiaoDich)giaoDichGetter.getObject();

        // Get domain object
        IGiaoDichManager domain = mainWindow.getDomain();

        // Get domain originator
        Originator<GDMMemento> originator = mainWindow.getDomainOriginator();

        // Get domain care taker
        CareTaker<GDMMemento> careTaker = mainWindow.getDomainCareTaker();

        // Execute command
        CommandFacade
        .getInstance()
        .executeSaveCommand(domain, giaoDich, originator, careTaker);
    }
}
