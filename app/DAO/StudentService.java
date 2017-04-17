package DAO;

import service.Service;

import java.util.List;

/**
 * Created by anton on 17.04.17.
 */
public interface StudentService<Student> extends Service<Student>{
    @Override
    List<Student> selectAll();

    @Override
    Student selectById(int id);

    @Override
    void remove(int id);

    @Override
    void update(int id, Student student);

    @Override
    void create(Student student);
}
