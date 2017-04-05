package model;

import model.utils.HibernateUtil;
import org.hibernate.Session;

import java.io.File;

/**
 * Created by anton on 27.03.17.
 */
public class TestHib {
    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        System.out.println(new File("app/resources/hibernate.cfg.xml").exists());

        Faculty faculty = new Faculty();


        //Save the employee in database
        session.save(faculty);

        //Commit the transaction
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
