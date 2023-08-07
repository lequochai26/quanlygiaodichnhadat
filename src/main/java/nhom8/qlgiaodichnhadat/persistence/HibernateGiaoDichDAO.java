package nhom8.qlgiaodichnhadat.persistence;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.notifiers.ErrorNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;
import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

public class HibernateGiaoDichDAO implements GiaoDichDAO {
    // FIELDS:
    private Notifier errorNotifier;

    private SessionFactory sessionFactory;

    // CONSTRUCTORS:
    public HibernateGiaoDichDAO() {
        // Get error notifier
        errorNotifier = ErrorNotifier.getInstance();

        // Get configuration
        Configuration config = new Configuration();
        try {
            config = config.configure();
        }
        catch (Exception e) {
            errorNotifier.notify(e);
            return;
        }

        // Build session factory
        try {
            sessionFactory = config.buildSessionFactory();
        }
        catch (Exception e) {
            errorNotifier.notify(e);
            return;
        }
    }

    // METHODS:
    @Override
    public void saveGiaoDichs(GiaoDichData... giaoDichs) {
        // Check session factory
        if (sessionFactory == null) {
            errorNotifier.notify(
                "Session factory not found!"
            );
            return;
        }

        // Session declaration
        Session session = null;

        // Transaction declaration
        Transaction transaction = null;
        
        try {
            // Open session
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();

            // Save giaoDichs
            for (GiaoDichData giaoDich : giaoDichs) {
                session.saveOrUpdate(giaoDich);
            }

            // Commit transaction
            transaction.commit();
        }
        catch (RollbackException e) {
            errorNotifier.notify(e);
            if (transaction != null) {
                try {
                    transaction.rollback();
                }
                catch(PersistenceException ex) {
                    errorNotifier.notify(ex);
                }
            }
        }
        catch (Exception e2) {
            errorNotifier.notify(e2);
        }

        // Check and close session
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void removeGiaoDichs(GiaoDichData... giaoDichs) {
        // Check session factory
        if (sessionFactory == null) {
            errorNotifier.notify(
                "Session factory not found!"
            );
            return;
        }

        // Session declaration
        Session session = null;

        // Transaction declaration
        Transaction transaction = null;
        
        try {
            // Open session
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();

            // Remove giaoDichs
            for (GiaoDichData giaoDich : giaoDichs) {
                session.remove(giaoDich);
            }

            // Commit transaction
            transaction.commit();
        }
        catch (RollbackException e) {
            errorNotifier.notify(e);
            if (transaction != null) {
                try {
                    transaction.rollback();
                }
                catch(PersistenceException ex) {
                    errorNotifier.notify(ex);
                }
            }
        }
        catch (Exception e2) {
            errorNotifier.notify(e2);
        }

        // Check and close session
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void clearGiaoDichs() {
        // Check session factory
        if (sessionFactory == null) {
            errorNotifier.notify(
                "Session factory not found!"
            );
            return;
        }

        // Session declaration
        Session session = null;

        // Transaction declaration
        Transaction transaction = null;

        try {
            // Open session
            session = sessionFactory.openSession();

            // HQL command initialization
            String hql = "DELETE FROM GiaoDich";

            // Create query
            Query query = session.createQuery(hql);

            // Begin transaction
            transaction = session.beginTransaction();

            // Execute update query
            query.executeUpdate();

            // Commit
            transaction.commit();
        }
        catch (RollbackException e) {
            errorNotifier.notify(e);
            
            if (transaction != null) {
                try {
                    // Rollback
                    transaction.rollback();
                }
                catch (Exception ex) {
                    errorNotifier.notify(ex);
                }
            }
        }
        catch (Exception e) {
            errorNotifier.notify(e);
        }

        // Check and close session
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public GiaoDichData getGiaoDich(int maGiaoDich) {
        // Target declaration
        GiaoDichData target = null;

        // Check session factory
        if (sessionFactory == null) {
            errorNotifier.notify(
                "Session factory not found!"
            );
            return target;
        }

        // Session declaration
        Session session = null;

        try {
            // Open session
            session = sessionFactory.openSession();

            // HQL command initialization
            String hql = "FROM GiaoDich AS G WHERE G.maGiaoDich = :maGiaoDich";

            // Create query
            Query query = session.createQuery(hql);

            // Query paremeter assignment
            query.setParameter("maGiaoDich", maGiaoDich);

            // List
            List list = query.list();

            // Check and get target
            if (list != null) {
                if (list.size() > 0) {
                    target = (GiaoDichData)list.get(0);
                }
            }
        }
        catch (Exception e) {
            errorNotifier.notify(e);
        }

        // Check and close session
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }

        // Return
        return target;
    }

    @Override
    public List getAllGiaoDichs() {
        // Result declaration
        List result = null;

        // Check session factory
        if (sessionFactory == null) {
            errorNotifier.notify(
                "Session factory not found!"
            );
            return result;
        }

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
            errorNotifier.notify(e);
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
}
