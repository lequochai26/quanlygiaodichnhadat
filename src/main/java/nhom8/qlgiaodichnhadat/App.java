package nhom8.qlgiaodichnhadat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import nhom8.qlgiaodichnhadat.entities.GiaoDichDat;
import nhom8.qlgiaodichnhadat.entities.GiaoDichNha;

public class App 
{
    public static void main( String[] args )
    {
        GiaoDichDat gd = new GiaoDichDat(
            1,
            new java.util.Date(),
            20,
            50,
            nhom8.qlgiaodichnhadat.entities.enums.LoaiDat.B
        );

        GiaoDichNha gdNha = new GiaoDichNha(
            0,
            new java.util.Date(),
            55,
            555,
            nhom8.qlgiaodichnhadat.entities.enums.LoaiNha.THUONG,
            "592/5A Lac Long Quan, P. 5, Q. 11, Tp. HCM"
        );

        Configuration configuration = new Configuration().configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(gd);
        session.saveOrUpdate(gdNha);
        transaction.commit();
        session.close();
    }
}
