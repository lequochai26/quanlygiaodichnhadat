package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nhom8.qlgiaodichnhadat.command.CommandFacade;
import nhom8.qlgiaodichnhadat.command.RedoCommand;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.pattern.command.Command;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class RedoController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public RedoController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get originator
        Originator<GDMMemento> originator = mainWindow.getDomainOriginator();

        // Get care taker
        CareTaker<GDMMemento> careTaker = mainWindow.getDomainCareTaker();

        // Execute command
        CommandFacade
        .getInstance()
        .executeRedoCommand(originator, careTaker);
    }
}
