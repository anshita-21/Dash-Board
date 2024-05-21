package com.AgilePeople.project.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = true)
    private String name;
    @Column(name = "duration", nullable = false)
    private String duration;
    @Column(name = "total_seats", nullable = true)
    private String totalSeats;
    @Column(name = "course_category_id", nullable = true)
    private long courseCategoryId;
    @Column(name = "course_sub_category_id", nullable = true)
    private long courseSubCategoryId;
    @Column(name = "fees", nullable = true)
    private String fees;
    @Column(name = "active", nullable = false)
    private String active;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    public Course() {
    }

    public Course(Long id, String code, String name, String duration, String totalSeats, long courseCategoryId, long courseSubCategoryId, String fees, String active, String createdBy, String updatedBy) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.totalSeats = totalSeats;
        this.courseCategoryId = courseCategoryId;
        this.courseSubCategoryId = courseSubCategoryId;
        this.fees = fees;
        this.active = active;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public long getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(long courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public long getCourseSubCategoryId() {
        return courseSubCategoryId;
    }

    public void setCourseSubCategoryId(long courseSubCategoryId) {
        this.courseSubCategoryId = courseSubCategoryId;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}