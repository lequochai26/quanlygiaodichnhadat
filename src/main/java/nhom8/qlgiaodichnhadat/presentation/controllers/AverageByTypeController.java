package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class AverageByTypeController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;
    private Class type;

    // CONSTRUCTORS:
    public AverageByTypeController(MainWindow mainWindow, Class type) {
        this.mainWindow = mainWindow;
        this.type = type;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Average by type
        double result = domain.averageThanhTienByType(type);

        // Show message dialog
        JOptionPane.showMessageDialog(
            mainWindow,
            "Trung bình thành tiền " + type.getSimpleName() + ": " + result,
            "Trung bình thành tiền",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
