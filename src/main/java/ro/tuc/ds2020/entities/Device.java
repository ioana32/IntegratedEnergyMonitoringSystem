package ro.tuc.ds2020.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;
import ro.tuc.ds2020.dtos.DeviceDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "maxEnergy", nullable = false)
    private int maxEnergy;


    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    @JsonBackReference
    private Users user;

    @OneToMany(mappedBy="device", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Consumption> consumptions;

    public Device() {
    }

    public Device(DeviceDTO deviceDTO){
        this.description = deviceDTO.getDescription();
        this.maxEnergy = deviceDTO.getMaxEnergy();
        this.address = deviceDTO.getAddress();
        this.user = deviceDTO.getUser();
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", maxEnergy=" + maxEnergy +
                ", user=" + user +
                ", consumptions=" + consumptions +
                '}';
    }
}
