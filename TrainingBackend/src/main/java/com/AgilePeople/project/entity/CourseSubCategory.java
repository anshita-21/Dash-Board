package com.AgilePeople.project.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "course_sub_category")
public class CourseSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "sub_category_name", nullable = true)
    private String subCategoryName;
    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "active", nullable = false)
    private String active;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    public CourseSubCategory() {
    }

    public CourseSubCategory(Long id, String code, String subCategoryName, String duration, String active, String createdBy, String updatedBy) {
        this.id = id;
        this.code = code;
        this.subCategoryName = subCategoryName;
        this.duration = duration;
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

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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