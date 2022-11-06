package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.entities.Consumption;
import ro.tuc.ds2020.entities.Device;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class ConsumptionDTO {

    private LocalDateTime timestamp;
    private float energyConsumption;
    private Device device;

    public ConsumptionDTO(){}

    public ConsumptionDTO(Consumption consumption){
        this.timestamp=consumption.getTimestamp();
        this.energyConsumption=consumption.getEnergyConsumption();
        this.device=consumption.getDevice();
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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
}
