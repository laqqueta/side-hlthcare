package com.laqqueta.healthcare.user;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.properties.BaseProperties;
import com.laqqueta.healthcare.role.RoleModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "m_user")
public class UserModel extends BaseProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleModel role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "biodata_id", referencedColumnName = "id")
    private BiodataModel biodata;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_locked")
    private Boolean isLocked;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    public UserModel() {
    }

    public UserModel(Long id, String email, BiodataModel biodata, RoleModel role) {
        this.id = id;
        this.role = role;
        this.biodata = biodata;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public BiodataModel getBiodata() {
        return biodata;
    }

    public void setBiodata(BiodataModel biodata) {
        this.biodata = biodata;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
