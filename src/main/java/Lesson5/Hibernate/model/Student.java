package Lesson5.Hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private Integer mark;

    public Student() {
    }

    public Student(Long id, String name, Integer mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student {id= " + id + ", name= " + name + ", mark= " + mark + "}";
    }
}