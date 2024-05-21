package com.AgilePeople.project.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "course_category")
public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "course_type", nullable = true)
    private String courseType;
    @Column(name = "has_sub_category", nullable = false)
    private String hasSubCategory;
    @Column(name = "active", nullable = false)
    private String active;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    public CourseCategory() {
    }

    public CourseCategory(Long id, String code, String courseType, String hasSubCategory, String active, String createdBy, String updatedBy) {
        this.id = id;
        this.code = code;
        this.courseType = courseType;
        this.hasSubCategory = hasSubCategory;
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

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getHasSubCategory() {
        return hasSubCategory;
    }

    public void setHasSubCategory(String hasSubCategory) {
        this.hasSubCategory = hasSubCategory;
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