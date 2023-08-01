package nhom8.qlgiaodichnhadat.domain;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;

public class GiaoDichManager implements IGiaoDichManager {
    // FIELDS:
    private SessionFactory sessionFactory;

    // CONSTRUCTORS:
    public GiaoDichManager() {
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
        // Check sessionFactory
        if (sessionFactory == null) {
            JOptionPane.showMessageDialog(
                null,
                "Session factory not found!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        // Result decleration
        List result = null;

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();

            // HQL command initialization
            String hql = "FROM GiaoDich";

            // Create query
            Query query = session.createQuery(hql);

            // List
            result = query.list();
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
        return result;
    }

    @Override
    public List getGiaoDichsByKeyWord(String keyWord) {
        // Check session factory
        if (sessionFactory == null) {
            // Show error message
            JOptionPane.showMessageDialog(
                null,
                "Session factory not found!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

            // Return null
            return null;
        }

        // Result declaration
        List result = null;

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();

            // HQL command initialization
            String hql = "FROM GiaoDich";

            // Create query
            Query query = session.createQuery(hql);

            // List
            result = query.list();
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

        // Check result
        if (result != null) {
            // Filtering
            for (Object obj : result) {
                // Check instance of GiaoDich
                if (!(obj instanceof GiaoDich)) {
                    continue;
                }

                // Cast obj to GiaoDich
                GiaoDich giaoDich = (GiaoDich)obj;

                // Check matches keyWord
                if (giaoDich.matches(keyWord)) {
                    continue;
                }

                // Otherwise
                // Remove giaoDich from result
                result.remove(giaoDich);
            }
        }

        // Return
        return result;
    }

    @Override
    public List getGiaoDichsByType(Class type) {
        // Check session factory
        if (sessionFactory == null) {
            // Show error message
            JOptionPane.showMessageDialog(
                null,
                "Session factory not found!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

            // Return null
            return null;
        }

        // Result declaration
        List result = null;

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();

            // HQL command initialization
            String hql = "FROM GiaoDich";

            // Create query
            Query query = session.createQuery(hql);

            // List
            result = query.list();
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

        // Check result
        if (result != null) {
            // Filtering result
            for (Object obj : result) {
                // Check if obj is instance of class cls
                if (obj.getClass() == type) {
                    continue;
                }

                // Remove obj from result
                result.remove(obj);
            }
        }

        // Return
        return result;
    }

    @Override
    public List getGiaoDichsInRangeOfDate(Date start, Date end) {
        // Check session factory
        if (sessionFactory == null) {
            // Show error message
            JOptionPane.showMessageDialog(
                null,
                "Session factory not found!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

            // Return null
            return null;
        }

        // Result declaration
        List result = null;

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();

            // HQL command initialization
            String hql = "FROM GiaoDich";

            // Create query
            Query query = session.createQuery(hql);

            // List
            result = query.list();
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

        // Check result and filtering
        if (result != null) {
            for (Object obj : result) {
                // Check obj is an instance of GiaoDich
                if (!(obj instanceof GiaoDich)) {
                    continue;
                }

                // Cast obj to GiaoDich type
                GiaoDich giaoDich = (GiaoDich)obj;

                // Check giaoDich's ngayGiaoDich
                Date ngayGiaoDich = giaoDich.getNgayGiaoDich();

                // Check ngayGiaoDich
                if (
                    ngayGiaoDich.compareTo(start) >= 0 ||
                    ngayGiaoDich.compareTo(end) <= 0
                ) {
                    continue;
                }

                // Remove giaoDich from result
                result.remove(giaoDich);
            }
        }

        // Return
        return result;
    }

    @Override
    public GiaoDich getGiaoDich(int maGiaoDich) {
        // GiaoDich object definition
        GiaoDich giaoDich = null;

        // Get all GiaoDich objects
        List all = this.getAllGiaoDichs();

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
}
