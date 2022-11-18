package org.example.task;

import javax.persistence.*;

@Entity
@Table(name = "School")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "school_number")
    private Integer schoolNumber;

    @OneToOne()
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    private Principal principal;

    public School() {
    }

    public School(Integer schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(Integer schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolNumber=" + schoolNumber +
                '}';
    }
}
