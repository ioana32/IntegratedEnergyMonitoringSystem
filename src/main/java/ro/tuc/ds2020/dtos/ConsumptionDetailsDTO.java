package ro.tuc.ds2020.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import ro.tuc.ds2020.entities.Consumption;
import ro.tuc.ds2020.entities.Device;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class ConsumptionDetailsDTO {

    private Long id;
    private LocalDateTime timestamp;
    private float energyConsumption;
    private Device device;

    public ConsumptionDetailsDTO(Consumption consumption){
        this.id=consumption.getId();
        this.device=consumption.getDevice();
        this.energyConsumption=consumption.getEnergyConsumption();
        this.timestamp=consumption.getTimestamp();
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

    public void setDevice(Device consumption) {
        this.device = device;
    }
}
