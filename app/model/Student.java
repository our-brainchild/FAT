package model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

/**
 * Created by anton on 27.03.17.
 */
@Table
@Entity
public class Student{

    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String groupNumber;
    @Column
    private double grants;
    @Column
    private String specialityNumber;

    public Student() {}
    public Student(String name, String groupNumber,
                   double grants, String specialityNumber)
    {
        this.name = name;
        this.groupNumber = groupNumber;
        this.grants = grants;
        this.specialityNumber = specialityNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public double getGrants() {
        return grants;
    }

    public String getSpecialityNumber() {
        return specialityNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setGrants(double grants) {
        this.grants = grants;
    }

    public void setSpecialityNumber(String specialityNumber) {
        this.specialityNumber = specialityNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", grants=" + grants +
                ", specialityNumber='" + specialityNumber + '\'' +
                '}';
    }

}
