package com.laqqueta.healthcare.user.biodata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laqqueta.healthcare.user.UserModel;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "m_biodata")
public class BiodataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "mobile_phone", length = 15)
    private String mobilePhone;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_path")
    private String imagePath;

    @OneToOne(mappedBy = "biodata")
    @JsonIgnore
    private UserModel user;

    @Column(name = "is_deleted", nullable = false)
    @ColumnDefault("false")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    private UserModel createdBy;

    @Column(name = "created_on", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name = "modified_by", referencedColumnName = "id")
    private UserModel modifiedBy;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @ManyToOne
    @JoinColumn(name = "deleted_by", referencedColumnName = "id")
    private UserModel deletedBy;

    @Column(name = "deleted_on")
    private LocalDateTime deletedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public UserModel getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UserModel modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public UserModel getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(UserModel deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LocalDateTime getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(LocalDateTime deletedOn) {
        this.deletedOn = deletedOn;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
