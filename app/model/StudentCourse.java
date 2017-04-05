package model;

import javax.persistence.*;

/**
 * Created by anton on 05.04.17.
 */
@Entity
@Table
public class StudentCourse {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int recordBookNumber;
    @Column
    private String courseName;

    public StudentCourse() {}
    public StudentCourse(int recordBookNumber, String courseName) {
        this.recordBookNumber = recordBookNumber;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public int getRecordBookNumber() {
        return recordBookNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecordBookNumber(int recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
