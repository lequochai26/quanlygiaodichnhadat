package nhom8.qlgiaodichnhadat.persistence.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

import nhom8.qlgiaodichnhadat.notifiers.ErrorNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;
import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;
import nhom8.qlgiaodichnhadat.persistence.table.DataTable;
import nhom8.qlgiaodichnhadat.persistence.table.GiaoDichDataTable;

public class FileGiaoDichDAO implements GiaoDichDAO {
    // FIELDS:
    private File file;

    private Notifier errorNotifier;

    // CONSTRUCTORS:
    public FileGiaoDichDAO(File file) {
        // Fields assignment
        this.file = file;

        // Get error notifier
        errorNotifier = ErrorNotifier.getInstance();
    }

    // METHODS:
    @Override
    public void saveGiaoDichs(GiaoDichData... giaoDichs) {
        // Get data table
        DataTable<Integer,GiaoDichData> table = this.getTable();

        // Exit if table null
        if (table == null) {
            return;
        }

        // Save giao dich records
        for (GiaoDichData giaoDich : giaoDichs) {
            table.saveData(giaoDich);
        }

        // Save table
        this.saveTable(table);
    }

    @Override
    public void removeGiaoDichs(GiaoDichData... giaoDichs) {
        // Get data table
        DataTable<Integer,GiaoDichData> table = this.getTable();

        // Exit if table null
        if (table == null) {
            return;
        }

        // Remove giao dich records
        for (GiaoDichData giaoDich : giaoDichs) {
            table.removeData(giaoDich);
        }

        // Save table
        this.saveTable(table);
    }

    @Override
    public void clearGiaoDichs() {
        // Get table
        DataTable<Integer,GiaoDichData> table = this.getTable();

        // Exit if table null
        if (table == null) {
            return;
        }

        // Clear table
        table.clearData();

        // Save table
        this.saveTable(table);
    }

    @Override
    public GiaoDichData getGiaoDich(int maGiaoDich) {
        // Target declaration
        GiaoDichData target = null;

        // Get table
        DataTable<Integer,GiaoDichData> table = this.getTable();

        // Exit and return null if table null
        if (table == null) {
            return target;
        }

        // Get
        target = table.getData(maGiaoDich);

        // Return
        return target;
    }

    @Override
    public List<GiaoDichData> getAllGiaoDichs() {
        // Data list declaration
        List<GiaoDichData> all = null;

        // Get table
        DataTable<Integer,GiaoDichData> table = this.getTable();

        // Exit and return null if table null
        if (table == null) {
            return all;
        }

        // Get all
        all = table.getAllData();

        // Return
        return all;
    }

    private DataTable<Integer,GiaoDichData> getTable() {
        // Data table declaration
        DataTable<Integer,GiaoDichData> table = null;

        // Exit and return null if file null
        if (file == null) {
            return table;
        }

        // Try read table from file if file exist
        if (file.exists()) {
            try {
                // Read table from file
                InputStream input = new FileInputStream(file);
                ObjectInputStream oInput = new ObjectInputStream(input);
                table = (GiaoDichDataTable)oInput.readObject();
                input.close();
            }
            catch (Exception e) {
                errorNotifier.notify(
                    e.getStackTrace()
                );
            }
        }

        // Create new table if table still null
        if (table == null) {
            table = new GiaoDichDataTable();
        }

        // Return;
        return table;
    }

    private void saveTable(DataTable<Integer,GiaoDichData> table) {
        try {
            // Write table to file
            OutputStream output = new FileOutputStream(file);
            ObjectOutputStream oOutput = new ObjectOutputStream(output);
            oOutput.writeObject(table);
            output.close();
        }
        catch (Exception e) {
            errorNotifier.notify(
                e.getStackTrace()
            );
        }
    }
}
