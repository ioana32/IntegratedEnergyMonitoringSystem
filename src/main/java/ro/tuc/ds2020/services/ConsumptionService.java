package ro.tuc.ds2020.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.ConsumptionDTO;
import ro.tuc.ds2020.dtos.ConsumptionDetailsDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.entities.Consumption;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.repositories.ConsumptionRepository;

@Service
public class ConsumptionService {

    private final ConsumptionRepository consumptionRepository;

    @Autowired
    public ConsumptionService(ConsumptionRepository consumptionRepository) {
        this.consumptionRepository = consumptionRepository;
    }

    public ConsumptionDTO createConsumption(ConsumptionDTO consumptionDTO){
        Consumption consumption = new Consumption(consumptionDTO);
        return new ConsumptionDTO(consumptionRepository.save(consumption));

    }

    public ConsumptionDTO deleteConsumption(Long consumptionId) throws NotFoundException {
        Consumption consumption= consumptionRepository.findById(consumptionId).orElse(null);
        if (consumption == null) {
            //throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
        }
        consumptionRepository.delete(consumption);
        return new ConsumptionDTO(consumption);
    }

    public ConsumptionDTO updateConsumption(Long consumptionId, ConsumptionDTO consumptionDTO){
        Consumption consumption=consumptionRepository.findById(consumptionId).orElse(null);
        if(consumption == null){
            //throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
        } else {
            consumption.setEnergyConsumption(consumptionDTO.getEnergyConsumption());
            consumption.setTimestamp(consumptionDTO.getTimestamp());
        }
        return new ConsumptionDTO(consumptionRepository.save(consumption));

    }

    public ConsumptionDetailsDTO getConsumption(Long consumptionId){
        Consumption consumption = consumptionRepository.findById(consumptionId).orElse(null);
        if(consumption == null) {
            //  throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
        }
        return new ConsumptionDetailsDTO(consumption);

    }

}
