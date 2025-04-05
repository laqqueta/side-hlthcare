package com.laqqueta.healthcare.biodata;

import com.laqqueta.healthcare.properties.BaseProperties;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "m_biodata")
public class BiodataModel extends BaseProperties {
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

    public BiodataModel() {
    }

    public BiodataModel(Long id, String fullName, String mobilePhone, byte[] image, String imagePath) {
        this.id = id;
        this.fullName = fullName;
        this.mobilePhone = mobilePhone;
        this.image = image;
        this.imagePath = imagePath;
    }

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

    @Override
    public String toString() {
        return "BiodataModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", image=" + Arrays.toString(image) +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
