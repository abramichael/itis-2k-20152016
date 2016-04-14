package ru.kpfu.itis.univer2016.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="groups")
public class Group {

    private Long id;

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_id_seq")
    @SequenceGenerator(name = "group_id_seq", sequenceName = "group_id_seq", allocationSize = 1)
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private List<Student> students;

    @OneToMany(targetEntity = Student.class, mappedBy = "group")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
