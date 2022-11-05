package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;

public class DeviceDetailsDTO {

    private Long id;
    private String description;

    private String address;
    private int maxEnergy;
    private User user;

    public DeviceDetailsDTO(Device device) {
        this.id = device.getId();
        this.description = device.getDescription();
        this.address = device.getAddress();
        this.maxEnergy = device.getMaxEnergy();
        this.user = device.getUser();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
