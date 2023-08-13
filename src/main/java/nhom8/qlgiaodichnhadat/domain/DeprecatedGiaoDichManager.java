package nhom8.qlgiaodichnhadat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichDat;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichNha;
import nhom8.qlgiaodichnhadat.hash.ObjectHasher;
import nhom8.qlgiaodichnhadat.hash.SHA256ObjectHasher;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.notifiers.ErrorNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;
import nhom8.qlgiaodichnhadat.pattern.observer.Subject;
import nhom8.qlgiaodichnhadat.persistence.IGiaoDichDBHandler;
import nhom8.qlgiaodichnhadat.persistence.dao.HibernateGiaoDichDAO;
import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;
import nhom8.qlgiaodichnhadat.persistence.GiaoDichDBHandler;

@Deprecated
public class DeprecatedGiaoDichManager extends Subject implements IGiaoDichManager, Originator<GDMMemento> {
    // FIELDS:
    private IGiaoDichDBHandler dbHandler;

    private CareTaker<GDMMemento> careTaker;

    private List<GiaoDich> data;

    // CONSTRUCTORS:
    public DeprecatedGiaoDichManager() {
        // Inherit from super class's default constructor
        super();

        // DBHandler initialization
        dbHandler = new GiaoDichDBHandler(
            new HibernateGiaoDichDAO()
        );

        // Care taker initialization
        careTaker = new CareTaker<GDMMemento>();
    }

    // METHODS:
    @Override
    public void saveGiaoDichs(GiaoDich... giaoDichs) {
        // Pack giaoDichs into a list
        List<GiaoDich> giaoDichList = new ArrayList<GiaoDich>();
        for (GiaoDich giaoDich : giaoDichs) {
            giaoDichList.add(giaoDich);
        }

        // Create a list of data
        List<GiaoDichData> dataList = this.packDatas(giaoDichList);

        // Get array of data
        GiaoDichData[] data = new GiaoDichData[]{};
        data = dataList.toArray(data);

        // Save data
        dbHandler.saveGiaoDichs(data);
    }

    @Override
    public void removeGiaoDichs(GiaoDich... giaoDichs) {
        // Pack giaoDichs into a list of GiaoDich objects
        List<GiaoDich> giaoDichList = new ArrayList<GiaoDich>();
        for (GiaoDich giaoDich: giaoDichs) {
            giaoDichList.add(giaoDich);
        }
        
        // Create a list of data
        List<GiaoDichData> dataList = this.packDatas(giaoDichList);

        // Get array of data
        GiaoDichData[] data = new GiaoDichData[]{};
        data = dataList.toArray(data);

        // Remove data
        dbHandler.removeGiaoDichs(data);
    }

    @Override
    public List<GiaoDich> getAllGiaoDichs() {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // Check data null
        if (data == null) {
            return null;
        }

        // Load GiaoDich objects from data
        List<GiaoDich> giaoDichs = this.loadGiaoDichs(data);

        // Set data
        this.setData(giaoDichs);

        // Return
        return giaoDichs;
    }

    @Override
    public List getGiaoDichsByKeyWord(String keyWord) {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // List of GiaoDich objects declaration
        List<GiaoDich> giaoDichs = null;

        // Check data null
        if (data != null) {
            // Load GiaoDich objects from data
            giaoDichs = this.loadGiaoDichs(data);

            // Create a remove list
            List<GiaoDich> removeList = new ArrayList<GiaoDich>();

            // Filtering data
            for (GiaoDich giaoDich : giaoDichs) {
                // Check if giaoDich matches to keyWord
                if (giaoDich.matches(keyWord)) {
                    continue;
                }

                // Otherwise
                // Add this giaoDich into removeList
                removeList.add(giaoDich);
            }

            // Remove all objects in removeList from data
            for (GiaoDich giaoDich : removeList) {
                giaoDichs.remove(giaoDich);
            }

            // Set data
            this.setData(giaoDichs);
        }

        // Return
        return giaoDichs;
    }

    @Override
    public List getGiaoDichsByType(Class type) {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // List of GiaoDich objects declaration
        List<GiaoDich> giaoDichs = null;

        // Check data null
        if (data != null) {
            // Get list of GiaoDich objects from data
            giaoDichs = this.loadGiaoDichs(data);

            // Create a removeList
            List<GiaoDich> removeList = new ArrayList<GiaoDich>();

            // Filtering data
            for (GiaoDich giaoDich : giaoDichs) {
                // Check if giaoDich's type is matches to type
                if (giaoDich.getClass() == type) {
                    continue;
                }

                // Otherwise
                // Add giaoDich into removeList
                removeList.add(giaoDich);
            }

            // Remove all objects in removeList from giaoDichs
            for (GiaoDich giaoDich : removeList) {
                giaoDichs.remove(giaoDich);
            }

            // Set data
            this.setData(giaoDichs);
        }

        // Return
        return giaoDichs;
    }

    @Override
    public List getGiaoDichsInRangeOfDate(Date start, Date end) {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // List of GiaoDich objects declaration
        List<GiaoDich> giaoDichs = null;

        // Check data null
        if (data != null) {
            // Load GiaoDich objects from data
            giaoDichs = this.loadGiaoDichs(data);

            // Create a remove list
            List<GiaoDich> removeList = new ArrayList<GiaoDich>();

            // Filtering
            for (GiaoDich giaoDich : giaoDichs) {
                // Get giaoDich's ngayGiaoDich
                Date ngayGiaoDich = giaoDich.getNgayGiaoDich();

                // Check if ngayGiaoDich in range of start date and end date
                if
                (
                    ngayGiaoDich.compareTo(start) >= 0
                    &&
                    ngayGiaoDich.compareTo(end) <= 0
                ) {
                    continue;
                }

                // Add giaoDich into removeList
                removeList.add(giaoDich);
            }

            // Remove all GiaoDich objects in removeList from giaoDichs
            for (GiaoDich giaoDich : removeList) {
                giaoDichs.remove(giaoDich);
            }

            // Set data
            this.setData(giaoDichs);
        }
        
        // Return
        return giaoDichs;
    }

    @Override
    public GiaoDich getGiaoDich(int maGiaoDich) {
        // Get target data
        GiaoDichData targetData = dbHandler.getGiaoDich(maGiaoDich);
        
        // Target declaration
        GiaoDich target = null;

        // List of GiaoDich objects initialization
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // Check targetData
        if (targetData != null) {
            // Load GiaoDich object
            target = this.loadGiaoDich(targetData);

            // Add target into giaoDichs
            giaoDichs.add(target);
        }

        // Set data
        this.setData(giaoDichs);

        // Return target
        return target;
    }

    @Override
    public GiaoDich getGiaoDich(String hash) {
        // Target declaration
        GiaoDich target = null;

        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // Check data null
        if (data != null) {
            // Get hasher
            ObjectHasher hasher = SHA256ObjectHasher.getInstance();

            // Get a List of GiaoDich objects from data
            List<GiaoDich> giaoDichs = this.loadGiaoDichs(data);

            // Filtering
            for (GiaoDich giaoDich : giaoDichs) {
                // Hash giaoDich
                String giaoDichHash = hasher.hashObject(giaoDich);

                // Check if giaoDichHash is different from hash
                if (!giaoDichHash.equals(hash)) {
                    continue;
                }

                // Assign giaoDich into target
                target = giaoDich;

                // Break
                break;
            }
        }

        // Filtered data initialization
        List<GiaoDich> filteredData = new ArrayList<GiaoDich>();

        // Check and add target into filteredData
        if (target != null) {
            filteredData.add(target);
        }

        // Set data
        this.setData(filteredData);

        // Return
        return target;
    }

    @Override
    public int countAllGiaoDichs() {
        // Count default definition
        int count = 0;

        // Get all
        List all = this.getAllGiaoDichs();

        // Check all
        if (all != null) {
            count = all.size();
        }

        // Return
        return count;
    }

    @Override
    public int countGiaoDichsByType(Class type) {
        // Count default initialization
        int count = 0;

        // Get by type
        List giaoDichs = this.getGiaoDichsByType(type);

        // Check giaoDichs and get count
        if (giaoDichs != null) {
            count = giaoDichs.size();
        }

        // Return
        return count;
    }

    @Override
    public double averageThanhTienAll() {
        // Result default definition
        double result = 0;

        // Get all
        List all = this.getAllGiaoDichs();

        // Check all
        if (all != null) {
            // Calculating
            for (Object obj : all) {
                GiaoDich giaoDich = (GiaoDich)obj;
                result += giaoDich.tinhThanhTien();
            }

            result /= all.size();
        }
        
        // Return
        return result;
    }

    @Override
    public double averageThanhTienByType(Class type) {
        // Result default definition
        double result = 0;

        // Get GiaoDichs by type
        List giaoDichs = this.getGiaoDichsByType(type);

        // Check giaoDichs
        if (giaoDichs != null) {
            // Calculating
            for (Object obj : giaoDichs) {
                GiaoDich giaoDich = (GiaoDich)obj;
                result += giaoDich.tinhThanhTien();
            }

            result /= giaoDichs.size();
        }

        // Return
        return result;
    }

    @Override
    public GDMMemento saveMemento() {
        return new GDMMemento(data);
    }

    @Override
    public void applyMemento(GDMMemento memento) {
        // Clear db
        dbHandler.clearGiaoDichs();

        // Get memento's data
        List<GiaoDich> giaoDichs = memento.getData();

        // Pack giaoDichs into data
        List<GiaoDichData> data = this.packDatas(giaoDichs);
        GiaoDichData[] arrData = new GiaoDichData[]{};
        arrData = data.toArray(arrData);

        // Save giaoDichs
        dbHandler.saveGiaoDichs(arrData);

        // Set data
        this.setData(giaoDichs);
    }

    private List<GiaoDich> loadGiaoDichs(List data) {
        // List of GiaoDich objects initialization
        List<GiaoDich> giaoDichs = new ArrayList<GiaoDich>();

        // Loading
        for (Object obj : data) {
            GiaoDichData giaoDichData = (GiaoDichData)obj;

            GiaoDich giaoDich = null;

            Class loaiGiaoDich = null;

            try {
                loaiGiaoDich = Class.forName(giaoDichData.getLoaiGiaoDich());
            }
            catch (Exception e) {
                continue;
            }

            if (loaiGiaoDich == GiaoDichDat.class) {
                giaoDich = new GiaoDichDat();
            }
            else {
                giaoDich = new GiaoDichNha();
            }

            giaoDich.loadData(giaoDichData);

            giaoDichs.add(giaoDich);
        }

        // Return
        return giaoDichs;
    }

    private GiaoDich loadGiaoDich(GiaoDichData data) {
        GiaoDich giaoDich = null;

        Class loaiGiaoDich = null;

        try {
            loaiGiaoDich = Class.forName(data.getLoaiGiaoDich());
        }
        catch (Exception e) {
            return giaoDich;
        }

        if (loaiGiaoDich == GiaoDichDat.class) {
            giaoDich = new GiaoDichDat();
        }
        else {
            giaoDich = new GiaoDichNha();
        }

        giaoDich.loadData(data);

        return giaoDich;
    }

    private List<GiaoDichData> packDatas(List<GiaoDich> giaoDichs) {
        // List of GiaoDichData objects initialization
        List<GiaoDichData> datas = new ArrayList<GiaoDichData>();

        // Packing
        for (GiaoDich giaoDich : giaoDichs) {
            datas.add(
                giaoDich.getData()
            );
        }

        // Return
        return datas;
    }
    
    public void setData(List data) {
        // Check data null
        if (data == null) {
            return;
        }

        // oldValue, newValue definition
        List newValue = data;
        List oldValue = this.data;

        // Update data
        this.data = newValue;

        // Fire property change
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
