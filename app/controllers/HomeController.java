package controllers;

import DAO.StudentService;
import DAO.StudentServiceImpl;
import model.Student;
import model.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import play.api.db.Database;
import play.mvc.*;

import views.html.*;

import java.io.File;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     * some comment
     */
    public Result index() {

        Student student = new Student("Anton", "ИВТ-32о", 2840.0, "09.03.01");
        StudentService studentService = new StudentServiceImpl();
        studentService.remove(9);
        return ok(index.render("Your new application is ready."));
    }

}
