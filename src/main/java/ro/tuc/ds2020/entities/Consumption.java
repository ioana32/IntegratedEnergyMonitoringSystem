package ro.tuc.ds2020.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
    @JoinColumn(name="device_id", nullable=false)
    private Device consumption;

    public Consumption(){

    }

    public Consumption(LocalDateTime timestamp, float energyConsumption, Device consumption) {
        this.timestamp = timestamp;
        this.energyConsumption = energyConsumption;
        this.consumption = consumption;
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

    public Device getConsumption() {
        return consumption;
    }

    public void setConsumption(Device consumption) {
        this.consumption = consumption;
    }
}
