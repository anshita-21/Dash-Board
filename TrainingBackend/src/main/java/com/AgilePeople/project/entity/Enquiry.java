package com.AgilePeople.project.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "enquiry")
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "mobile", nullable = true)
    private String mobile;
    @Column(name = "course", nullable = false)
    private String course;
    @Column(name = "message", nullable = true)
    private String message;
    @Column(name = "active", nullable = false)
    private String active;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_by", nullable = false)
    private String updated_by;

    public Enquiry() {
    }

    public Enquiry(Long id, String name, String mobile, String course, String message, String active, String created_by, String updated_by) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.course = course;
        this.message = message;
        this.active = active;
        this.created_by = created_by;
        this.updated_by = updated_by;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}