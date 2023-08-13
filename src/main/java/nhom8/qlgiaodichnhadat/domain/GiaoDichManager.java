package nhom8.qlgiaodichnhadat.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.hash.ObjectHasher;
import nhom8.qlgiaodichnhadat.hash.SHA256ObjectHasher;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.objectconverter.GiaoDichConverter;
import nhom8.qlgiaodichnhadat.objectconverter.GiaoDichDataListConverter;
import nhom8.qlgiaodichnhadat.objectconverter.GiaoDichListConverter;
import nhom8.qlgiaodichnhadat.objectconverter.ListArrayConverter;
import nhom8.qlgiaodichnhadat.objectconverter.ObjectConverter;
import nhom8.qlgiaodichnhadat.pattern.observer.Subject;
import nhom8.qlgiaodichnhadat.persistence.GiaoDichDBHandler;
import nhom8.qlgiaodichnhadat.persistence.IGiaoDichDBHandler;
import nhom8.qlgiaodichnhadat.persistence.dao.FileGiaoDichDAO;
import nhom8.qlgiaodichnhadat.persistence.dao.HibernateGiaoDichDAO;
import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

public class GiaoDichManager extends Subject implements IGiaoDichManager, Originator<GDMMemento> {
    // FIELDS:
    private IGiaoDichDBHandler dbHandler;

    private ObjectConverter<GiaoDich,GiaoDichData> giaoDichConverter;
    private ObjectConverter<List<GiaoDich>,GiaoDich[]> giaoDichListConverter;
    private ObjectConverter<List<GiaoDichData>,GiaoDichData[]> giaoDichDataListConverter;

    private CareTaker<GDMMemento> careTaker;

    private List<GiaoDich> data;

    // CONSTRUCTORS:
    public GiaoDichManager() {
        // Inherit from super class's default constructor
        super();

        // dbHandler initialization
        dbHandler = new GiaoDichDBHandler(
            new FileGiaoDichDAO(
                new File("data")
            )
        );

        // careTaker initialization
        careTaker = new CareTaker<GDMMemento>();

        // Converters initialization
        giaoDichConverter = GiaoDichConverter.getInstance();
        giaoDichListConverter = GiaoDichListConverter.getInstance();
        giaoDichDataListConverter = GiaoDichDataListConverter.getInstance();
    }

    // METHODS:
    @Override
    public void saveGiaoDichs(GiaoDich... giaoDichs) {
        // Create a list of GiaoDichData objects
        List<GiaoDichData> dataList = new ArrayList<GiaoDichData>();

        // Data getting
        for (GiaoDich giaoDich : giaoDichs) {
            dataList.add(
                giaoDich.getData()
            );
        }

        // Converter dataList into data array
        GiaoDichData[] data = giaoDichDataListConverter.convert(dataList);

        // Save
        dbHandler.saveGiaoDichs(data);
    }

    @Override
    public void removeGiaoDichs(GiaoDich... giaoDichs) {
        // Create a list of GiaoDichData objects
        List<GiaoDichData> dataList = new ArrayList<GiaoDichData>();

        // Data getting
        for (GiaoDich giaoDich : giaoDichs) {
            dataList.add(
                giaoDich.getData()
            );
        }

        // Convert dataList in to an array
        GiaoDichData[] data = giaoDichDataListConverter.convert(dataList);

        // Remove
        dbHandler.removeGiaoDichs(data);
    }

    @Override
    public List<GiaoDich> getAllGiaoDichs() {
        // Load data
        List<GiaoDichData> datas = dbHandler.getAllGiaoDichs();

        // Check if datas null
        if (datas == null) {
            return null;
        }

        // Create a list of GiaoDich objects
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // Convert datas into giaoDichs
        for (GiaoDichData data : datas) {
            // Convert data to GiaoDich object and add into giaoDichs
            giaoDichs.add(
                giaoDichConverter.reverse(data)
            );
        }

        // Set data
        this.setData(giaoDichs);

        // Return
        return giaoDichs;
    }

    @Override
    public List<GiaoDich> getGiaoDichsByKeyWord(String keyWord) {
        // Load data
        List<GiaoDichData> datas = dbHandler.getAllGiaoDichs();

        // Check datas null
        if (datas == null) {
            return null;
        }

        // Create a list of GiaoDich objects
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // Converting and filtering
        for (GiaoDichData data : datas) {
            // Convert data into giao dich
            GiaoDich giaoDich = giaoDichConverter.reverse(data);

            // Bypass if giao dich not matches to keyword
            if (!giaoDich.matches(keyWord)) {
                continue;
            }

            // Otherwise
            // Add giao dich into giaoDichs
            giaoDichs.add(giaoDich);
        }

        // Set data
        this.setData(giaoDichs);

        // Return
        return giaoDichs;
    }

    @Override
    public List<GiaoDich> getGiaoDichsByType(Class type) {
        // Load data
        List<GiaoDichData> datas = dbHandler.getAllGiaoDichs();

        // Check datas null
        if (datas == null) {
            return null;
        }

        // Create a list of GiaoDich objects
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // Converting and filtering
        for (GiaoDichData data : datas) {
            // Convert data into giao dich object
            GiaoDich giaoDich = giaoDichConverter.reverse(data);

            // Bypass if not match type
            if (giaoDich.getClass() != type) {
                continue;
            }

            // Otherwise
            // Add giao dich into giaoDichs
            giaoDichs.add(giaoDich);
        }

        // Set data
        this.setData(giaoDichs);

        // Return
        return giaoDichs;
    }

    @Override
    public List<GiaoDich> getGiaoDichsInRangeOfDate(Date start, Date end) {
        // Load data
        List<GiaoDichData> datas = dbHandler.getAllGiaoDichs();

        // Check datas null
        if (datas == null) {
            return null;
        }

        // Creat a list of giao dich objects
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // Converting and filtering
        for (GiaoDichData data : datas) {
            // Convert data into giao dich object
            GiaoDich giaoDich = giaoDichConverter.reverse(data);

            // Get ngay giao dich
            Date ngayGiaoDich = giaoDich.getNgayGiaoDich();

            // Bypass if giaoDich not in range of date
            if (ngayGiaoDich.compareTo(start) < 0 ||
            ngayGiaoDich.compareTo(end) > 0) {
                continue;
            }

            // Add giao dich into giaoDichs
            giaoDichs.add(giaoDich);
        }

        // Set data
        this.setData(giaoDichs);

        // Return
        return giaoDichs;
    }

    @Override
    public GiaoDich getGiaoDich(int maGiaoDich) {
        // Get data
        GiaoDichData data = dbHandler.getGiaoDich(maGiaoDich);

        // Target declaration
        GiaoDich target = null;
        
        // Check data null
        if (data != null) {
            // Convert data into giao dich object and assign into target
            target = giaoDichConverter.reverse(data);
        }

        // Create a list of GiaoDich objects
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // If found target, add target into giaoDichs
        if (target != null) {
            giaoDichs.add(target);
        }

        // Set data
        this.setData(giaoDichs);

        // Return
        return target;
    }

    @Override
    public GiaoDich getGiaoDich(String hash) {
        // Load data
        List<GiaoDichData> datas = dbHandler.getAllGiaoDichs();

        // Check datas null
        if (datas == null) {
            return null;
        }

        // Target declaration
        GiaoDich target = null;

        // Get hasher
        ObjectHasher hasher = SHA256ObjectHasher.getInstance();

        // Detecting
        for (GiaoDichData data : datas) {
            // Convert data into giao dich object
            GiaoDich giaoDich = giaoDichConverter.reverse(data);

            // Hash giao dich
            String giaoDichHash = hasher.hashObject(giaoDich);

            // Bypass if hashs different from each other
            if (!giaoDichHash.equals(hash)) {
                continue;
            }

            // Otherwise, found target
            target = giaoDich;
            break;
        }

        // Create a list of GiaoDich objects
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // Add target into giaoDichs if target found
        if (target != null) {
            giaoDichs.add(target);
        }

        // Set data
        this.setData(giaoDichs);

        // Return
        return target;
    }

    @Override
    public int countAllGiaoDichs() {
        // Get all
        List<GiaoDich> all = this.getAllGiaoDichs();

        // Check all null
        if (all == null) {
            return 0;
        }

        // Get count
        int count = all.size();

        return count;
    }

    @Override
    public int countGiaoDichsByType(Class type) {
        // Get giao dich objects by type
        List<GiaoDich> giaoDichs = this.getGiaoDichsByType(type);

        // Check giaoDichs null
        if (giaoDichs == null) {
            return 0;
        }

        // Get count
        int count = giaoDichs.size();

        // Return
        return count;
    }

    @Override
    public double averageThanhTienAll() {
        // Get all
        List<GiaoDich> all = this.getAllGiaoDichs();

        // Check all null
        if (all == null) {
            return 0;
        }

        // Result definition
        double result = 0;

        // Calculating
        for (GiaoDich giaoDich : all) {
            result += giaoDich.tinhThanhTien();
        }
        result /= all.size();

        // Return
        return result;
    }

    @Override
    public double averageThanhTienByType(Class type) {
        // Get giao dich objects by type
        List<GiaoDich> giaoDichs = this.getGiaoDichsByType(type);

        // Check giaoDichs null
        if (giaoDichs == null) {
            return 0;
        }

        // Result definition
        double result = 0;

        // Calculating
        for (GiaoDich giaoDich : giaoDichs) {
            result += giaoDich.tinhThanhTien();
        }
        result /= giaoDichs.size();

        // Return
        return result;
    }

    @Override
    public void applyMemento(GDMMemento memento) {
        // Get data
        List<GiaoDich> giaoDichs = memento.getData();

        // Clear database's data
        dbHandler.clearGiaoDichs();

        // Convert giao dich objects into data objects
        List<GiaoDichData> datas = new ArrayList<GiaoDichData>();
        for (GiaoDich giaoDich : giaoDichs) {
            datas.add(
                giaoDichConverter.convert(giaoDich)
            );
        }

        // Save data
        dbHandler.saveGiaoDichs(
            giaoDichDataListConverter.convert(datas)
        );

        // Set data
        this.setData(giaoDichs);
    }

    @Override
    public GDMMemento saveMemento() {
        return new GDMMemento(data);
    }

    public void setData(List<GiaoDich> data) {
        List<GiaoDich> oldValue = this.data;
        List<GiaoDich> newValue = data;
        this.data = newValue;
        this.firePropertyChange(
            "data",
            newValue,
            oldValue
        );
    }

    public CareTaker<GDMMemento> getCareTaker() {
        return careTaker;
    }
}
