package com.AgilePeople.project.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "admission")
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "mobile", nullable = false)
    private String mobile;
    @Column(name = "sex", nullable = false)
    private String sex;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "aadhar", nullable = false)
    private String aadhar;
    @Column(name = "education", nullable = false)
    private String education;
    @Column(name = "branch", nullable = false)
    private String branch;
    @Column(name = "upload_photo", nullable = false)
    private String uploadPhoto;
    @Column(name = "upload_aadhar", nullable = false)
    private String uploadAadhar;
    @Column(name = "active", nullable = false)
    private String active;
    @Column(name = "created_by", nullable = false)
    private String created_by;
    @Column(name = "updated_by", nullable = false)
    private String updated_by;

    public Admission() {
    }

    public Admission(Long id, String firstName, String middleName, String lastName, String mobile, String sex, String email, String aadhar, String education, String branch, String uploadPhoto, String uploadAadhar, String active, String created_by, String updated_by) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.sex = sex;
        this.email = email;
        this.aadhar = aadhar;
        this.education = education;
        this.branch = branch;
        this.uploadPhoto = uploadPhoto;
        this.uploadAadhar = uploadAadhar;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUploadPhoto() {
        return uploadPhoto;
    }

    public void setUploadPhoto(String uploadPhoto) {
        this.uploadPhoto = uploadPhoto;
    }

    public String getUploadAadhar() {
        return uploadAadhar;
    }

    public void setUploadAadhar(String uploadAadhar) {
        this.uploadAadhar = uploadAadhar;
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