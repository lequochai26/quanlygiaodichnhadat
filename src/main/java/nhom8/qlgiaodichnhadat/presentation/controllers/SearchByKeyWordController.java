package nhom8.qlgiaodichnhadat.presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class SearchByKeyWordController implements ActionListener {
    // FIELDS:
    private MainWindow mainWindow;

    // CONSTRUCTORS:
    public SearchByKeyWordController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // Show input dialog
        String keyWord = JOptionPane.showInputDialog(
            mainWindow,
            "Nhập từ khóa: ",
            "Tìm kiếm",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Check if keyWord is null
        if (keyWord == null) {
            return;
        }

        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Tells domain to get giaodich data by keyWord
        domain.getGiaoDichsByKeyWord(keyWord);
    }
}
