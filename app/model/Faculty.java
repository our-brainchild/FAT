package model;

import javax.persistence.*;

/**
 * Created by anton on 05.04.17.
 */
@Table
@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String facultyNumber;

    public Faculty() {}

    public Faculty(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
