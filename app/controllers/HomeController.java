package controllers;

import DAO.StudentServiceImpl;
import model.Student;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

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

        Student student = new Student(11,"Anton1", "ИВТ-32о", 2840.0, "09.03.01");
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.update(student);


        return ok(index.render("Your new application is ready."));
    }

}
