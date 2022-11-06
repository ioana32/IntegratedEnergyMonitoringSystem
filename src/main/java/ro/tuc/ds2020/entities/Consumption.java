package ro.tuc.ds2020.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import ro.tuc.ds2020.dtos.ConsumptionDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consumption {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    @Column(name = "energy_consumption")
    private float energyConsumption;

    @ManyToOne
    @JoinColumn(name = "device_id", foreignKey = @ForeignKey(name = "device_id"))
    @JsonBackReference
    private Device device;

    public Consumption(){

    }

    public Consumption(LocalDateTime timestamp, float energyConsumption, Device device) {
        this.timestamp = timestamp;
        this.energyConsumption = energyConsumption;
        this.device = device;
    }

    public Consumption(ConsumptionDTO consumptionDTO){
        this.energyConsumption=consumptionDTO.getEnergyConsumption();
        this.timestamp=consumptionDTO.getTimestamp();
        this.device=consumptionDTO.getDevice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public float getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(float energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
