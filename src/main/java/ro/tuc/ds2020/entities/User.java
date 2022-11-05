package ro.tuc.ds2020.entities;

import ro.tuc.ds2020.dtos.UserDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    //0 - client 1 - admin
    @Column(name = "role", nullable = false)
    private boolean role;

    @OneToMany(mappedBy = "user")
    private List<Device> devices;

    public User() {
    }

    public User(boolean role, String name, String password, List<Device> devices) {
        this.role = role;
        this.name = name;
        this.password = password;
        this.devices = devices;
    }

    public User(UserDTO userDTO){
        this.role=userDTO.isRole();
        this.name=userDTO.getName();
        this.password=userDTO.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
