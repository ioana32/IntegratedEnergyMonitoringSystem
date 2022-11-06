package ro.tuc.ds2020.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Users;

import java.util.List;

public class UserDetailsDTO {

    private Long id;
    private String name;
    private String password;
    private boolean role;
    @JsonManagedReference
    private List<Device> devices;



    public UserDetailsDTO(Users user) {
        this.id= user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.role = user.isRole();
        this.devices = user.getDevices();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
