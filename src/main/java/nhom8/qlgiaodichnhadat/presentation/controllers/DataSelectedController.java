package nhom8.qlgiaodichnhadat.presentation.controllers;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.presentation.views.MainWindow;

public class DataSelectedController implements ListSelectionListener {
    // FIELDS:
    private MainWindow mainWindow;
    
    // CONSTRUCTORS:
    public DataSelectedController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    // METHODS:
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Get tblData
        JTable tblData = mainWindow.getTblData();

        // Get selected row
        int selectedRow = tblData.getSelectedRow();

        // Check selected row
        if (selectedRow < 0) {
            return;
        }

        // Get maGiaoDich from tblData
        int maGiaoDich = (int)tblData.getValueAt(selectedRow, 1);

        // Get domain
        IGiaoDichManager domain = mainWindow.getDomain();

        // Get GiaoDich object from given maGiaoDich
        GiaoDich giaoDich = domain.getGiaoDich(maGiaoDich);

        // Update mainWindow
        mainWindow.setGiaoDich(giaoDich);
    }
}
