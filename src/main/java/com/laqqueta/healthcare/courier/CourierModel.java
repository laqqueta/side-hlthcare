package com.laqqueta.healthcare.courier;

import com.laqqueta.healthcare.properties.BaseProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "m_courier")
public class CourierModel extends BaseProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    public CourierModel() {
    }

    public CourierModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CourierModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
