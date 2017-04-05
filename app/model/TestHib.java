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

        Speciality speciality = new Speciality();


        //Save the employee in database
        session.save(speciality);

        //Commit the transaction
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
