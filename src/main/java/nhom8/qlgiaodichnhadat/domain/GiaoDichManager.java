package nhom8.qlgiaodichnhadat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.pattern.observer.Subject;

public class GiaoDichManager extends Subject implements IGiaoDichManager {
    // FIELDS:
    private SessionFactory sessionFactory;

    private List data;

    // CONSTRUCTORS:
    public GiaoDichManager() {
        // Inherit from super class's default constructor
        super();

        // Configuration definition
        Configuration configuration = null;

        try {
            // Configuring
            configuration = new Configuration();
            configuration = configuration.configure();

            // Build session factory
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (Exception e) {
            // Show error message
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // METHODS:
    @Override
    public void saveGiaoDichs(GiaoDich... giaoDichs) {
        // Check session factory
        if (sessionFactory == null) {
            JOptionPane.showMessageDialog(
                null,
                "No session factory found!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        // Saving giaodich objects
        for (GiaoDich giaoDich : giaoDichs) {
            session.saveOrUpdate(giaoDich);
        }

        try {
            // Commit transaction
            transaction.commit();
        }
        catch (Exception e) {
            // Show error notification
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

            try {
                // Rollback transaction
                transaction.rollback();
            }
            catch (Exception e2) {
                JOptionPane.showMessageDialog(
                    null,
                    e2.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Close session
        session.close();
    }

    @Override
    public void removeGiaoDichs(GiaoDich... giaoDichs) {
        // Check session factory
        if (sessionFactory == null) {
            JOptionPane.showMessageDialog(
                null,
                "No session factory found!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        // Removing giaodich objects
        for (GiaoDich giaoDich : giaoDichs) {
            session.delete(giaoDich);
        }

        try {
            // Commit transaction
            transaction.commit();
        }
        catch (Exception e) {
            // Show error notification
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

            try {
                // Rollback transaction
                transaction.rollback();
            }
            catch (Exception e2) {
                JOptionPane.showMessageDialog(
                    null,
                    e2.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Close session
        session.close();
    }

    @Override
    public List getAllGiaoDichs() {
        // Load data
        List data = this.loadData();

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
        List data = this.loadData();

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
        List data = this.loadData();

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
        List data = this.loadData();

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
        // GiaoDich object definition
        GiaoDich giaoDich = null;

        // Get all GiaoDich objects
        List all = this.loadData();

        // Check all
        if (all != null) {
            // Fetching
            for (Object obj : all) {
                GiaoDich gd = (GiaoDich)obj;
                if (gd.getMaGiaoDich() == maGiaoDich) {
                    giaoDich = gd;
                    break;
                }
            }
        }

        // Return
        return giaoDich;
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

    public List loadData() {
        // Check sessionFactory
        if (sessionFactory == null) {
            // Show error message
            JOptionPane.showMessageDialog(
                null,
                "Session factory not found!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

            // Return
            return null;
        }

        // Data initialization
        List data = null;

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();

            // HQL Command initialization
            String hql = "FROM GiaoDich";

            // Create query
            Query query = session.createQuery(hql);

            // List 
            data = query.list();
        }
        catch (Exception e) {
            // Show error message
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }

        // Check and close session
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }

        // Return
        return data;
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
}
