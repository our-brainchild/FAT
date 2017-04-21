package DAO;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import model.Student;
import model.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import play.api.ConfigLoader;
import play.api.Configuration;
import play.api.db.Database;
import play.api.db.PooledDatabase;
import play.db.Databases;
import service.Service;


import javax.inject.Inject;
import java.util.List;

/**
 * Created by anton on 17.04.17.
 */

interface StudentService<Student> extends Service<Student> {
    @Override
    List<Student> selectAll();

    @Override
    Student selectById(int id);

    @Override
    void remove(int id);

    @Override
    void update(Student student);

    @Override
    void create(Student student);
}

public class StudentServiceImpl implements StudentService<Student> {

    @Override
    public List<Student> selectAll() {
        Session session = openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Student");
        List<Student> list = query.list();

        session.getTransaction().commit();
        return list;
    }

    @Override
    public Student selectById(int id) {
        Session session = openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, id);

        session.getTransaction().commit();
        return student;
    }

    @Override
    public void remove(int id) {
        Session session = openSession();
        session.beginTransaction();

        Student student = (Student) session.get(Student.class, id);
        if (student != null)
           session.delete(student);

        session.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        if (student == null) return;

        Session session = openSession();
        session.beginTransaction();

        Student st = selectById(student.getId());

        st.setGrants(student.getGrants());
        st.setGroupNumber(student.getGroupNumber());
        st.setName(student.getName());
        st.setSpecialityNumber(student.getSpecialityNumber());

        session.update(st);

        session.getTransaction().commit();
    }

    @Override
    public void create(Student student) {
        Session session = openSession();
        session.beginTransaction();

        session.save(student);

        session.getTransaction().commit();
    }
    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}
