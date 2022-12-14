package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Users;

public class DeviceDTO {

    private String description;
    private String address;
    private int maxEnergy;
    private Users user;


    public DeviceDTO(Device device) {
        this.description = device.getDescription();
        this.address=device.getAddress();
        this.maxEnergy = device.getMaxEnergy();
        this.user = device.getUser();
    }
    public DeviceDTO(){}

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

    public Users getUser() {
        return user;
    }

    public Long getUserId(){
        return user.getId();
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", maxEnergy=" + maxEnergy +
                ", user=" + user +
                '}';
    }
}
