package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nhom8.qlgiaodichnhadat.command.RedoCommand;
import nhom8.qlgiaodichnhadat.domain.GiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
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
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Check domain instance of GiaoDichManager
        if (!(domain instanceof GiaoDichManager)) {
            return;
        }

        // Cast domain to GiaoDichManager
        GiaoDichManager gdManager = (GiaoDichManager)domain;

        // Get care taker
        CareTaker<GDMMemento> careTaker = gdManager.getCareTaker();
        
        // Create command
        Command command = new RedoCommand(gdManager, careTaker);

        // Execute command
        command.execute();
    }
}
