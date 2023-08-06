package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nhom8.qlgiaodichnhadat.command.UndoCommand;
import nhom8.qlgiaodichnhadat.domain.GiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.pattern.command.Command;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class UndoController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public UndoController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Check instance of GiaoDichManager
        if (!(domain instanceof GiaoDichManager)) {
            return;
        }

        // Cast domain to GiaoDichManager
        GiaoDichManager gdManager = (GiaoDichManager)domain;

        // Get careTaker
        CareTaker<GDMMemento> careTaker = gdManager.getCareTaker();

        // Create command
        Command command = new UndoCommand(gdManager, careTaker);

        // Execute command
        command.execute();
    }
}
