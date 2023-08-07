package nhom8.qlgiaodichnhadat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.hash.ObjectHasher;
import nhom8.qlgiaodichnhadat.hash.SHA256ObjectHasher;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.pattern.observer.Subject;
import nhom8.qlgiaodichnhadat.persistence.IGiaoDichDBHandler;
import nhom8.qlgiaodichnhadat.persistence.GiaoDichDBHandler;
import nhom8.qlgiaodichnhadat.persistence.HibernateGiaoDichDAO;

public class GiaoDichManager extends Subject implements IGiaoDichManager, Originator<GDMMemento> {
    // FIELDS:
    private IGiaoDichDBHandler dbHandler;

    private CareTaker<GDMMemento> careTaker;

    private List data;

    // CONSTRUCTORS:
    public GiaoDichManager() {
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
        dbHandler.saveGiaoDichs(giaoDichs);
    }

    @Override
    public void removeGiaoDichs(GiaoDich... giaoDichs) {
        dbHandler.removeGiaoDichs(giaoDichs);
    }

    @Override
    public List getAllGiaoDichs() {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // Check and setData
        if (data != null) {
            this.setData(data);
        }

        // Return
        return data;
    }

    @Override
    public List getGiaoDichsByKeyWord(String keyWord) {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // Check data null
        if (data != null) {
            // Create a remove list
            List removeList = new ArrayList();

            // Filtering data
            for (Object row : data) {
                // Cast row into a GiaoDich object
                GiaoDich giaoDich = (GiaoDich)row;

                // Check if giaoDich matches to keyWord
                if (giaoDich.matches(keyWord)) {
                    continue;
                }

                // Otherwise
                // Add this giaoDich into removeList
                removeList.add(giaoDich);
            }

            // Remove all objects in removeList from data
            for (Object obj : removeList) {
                data.remove(obj);
            }

            // Set data
            this.setData(data);
        }

        // Return
        return data;
    }

    @Override
    public List getGiaoDichsByType(Class type) {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // Check data null
        if (data != null) {
            // Create a removeList
            List removeList = new ArrayList(0);

            // Filtering data
            for (Object row : data) {
                // Cast row into a GiaoDich object
                GiaoDich giaoDich = (GiaoDich)row;

                // Check if giaoDich's type is matches to type
                if (giaoDich.getClass() == type) {
                    continue;
                }

                // Otherwise
                // Add giaoDich into removeList
                removeList.add(giaoDich);
            }

            // Remove all objects in removeList from data
            for (Object obj : removeList) {
                data.remove(obj);
            }

            // Set data
            this.setData(data);
        }

        // Return
        return data;
    }

    @Override
    public List getGiaoDichsInRangeOfDate(Date start, Date end) {
        // Load data
        List data = dbHandler.getAllGiaoDichs();

        // Check data null
        if (data != null) {
            // Create a remove list
            List removeList = new ArrayList();

            // Filtering
            for (Object row : data) {
                // Cast row into a GiaoDich object
                GiaoDich giaoDich = (GiaoDich)row;

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

            // Remove all objects in removeList from data
            for (Object obj : removeList) {
                data.remove(obj);
            }

            // Set data
            this.setData(data);
        }
        
        // Return
        return data;
    }

    @Override
    public GiaoDich getGiaoDich(int maGiaoDich) {
        // Get
        GiaoDich target = dbHandler.getGiaoDich(maGiaoDich);

        // Data initialization
        List data = new ArrayList();

        // Check and add target into data
        if (target != null) {
            data.add(target);
        }

        // Set data
        this.setData(data);

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

            // Filtering
            for (Object obj : data) {
                // Hash obj
                String objHash = hasher.hashObject(obj);

                // Check if objHash is different from hash
                if (!objHash.equals(hash)) {
                    continue;
                }

                // Cast obj to GiaoDich object and assign into target
                target = (GiaoDich)obj;

                // Break
                break;
            }
        }

        // Filtered data initialization
        List filteredData = new ArrayList();

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
        List data = memento.getData();
        
        // Turns data into an array of GiaoDich objects
        GiaoDich[] giaoDichs = new GiaoDich[]{};
        giaoDichs = ((List<GiaoDich>)data).toArray(giaoDichs);

        // Save giaoDichs
        dbHandler.saveGiaoDichs(giaoDichs);

        // Set data
        this.setData(data);
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
