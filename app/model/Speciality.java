package model;

import javax.persistence.*;

/**
 * Created by anton on 05.04.17.
 */

@Table
@Entity
public class Speciality {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String specialityNumber;
    @Column
    private String name;
    @Column
    private String facultyNumber;

    public Speciality() {}
    public Speciality(String specialityNumber, String name, String facultyNumber) {
        this.specialityNumber = specialityNumber;
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public int getId() {
        return id;
    }

    public String getSpecialityNumber() {
        return specialityNumber;
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

    public void setSpecialityNumber(String specialityNumber) {
        this.specialityNumber = specialityNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
