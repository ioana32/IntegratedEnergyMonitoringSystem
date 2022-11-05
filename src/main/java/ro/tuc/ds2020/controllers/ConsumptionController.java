package ro.tuc.ds2020.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ConsumptionDTO;
import ro.tuc.ds2020.dtos.ConsumptionDetailsDTO;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.services.ConsumptionService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/consumptions")
public class ConsumptionController {

    private final ConsumptionService consumptionService;

    @Autowired
    public ConsumptionController(ConsumptionService consumptionService) {
        this.consumptionService = consumptionService;
    }

    @GetMapping()
    public ResponseEntity<List<DeviceDTO>> getConsumptions(){
        return null;
    }

    @GetMapping(value = "/{consumptionId}")
    public ResponseEntity<ConsumptionDetailsDTO> getConsumption(@PathVariable Long consumptionId){
        return new ResponseEntity<>(consumptionService.getConsumption(consumptionId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ConsumptionDTO> createConsumption(@RequestBody ConsumptionDTO consumptionDTO){
        return new ResponseEntity<>(consumptionService.createConsumption(consumptionDTO),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{consumptionId}")
    public ResponseEntity<ConsumptionDTO> updateConsumption(@PathVariable Long consumptionId, @RequestBody ConsumptionDTO consumption){
        return new ResponseEntity<>(consumptionService.updateConsumption(consumptionId,consumption),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{consumptionId}")
    public ResponseEntity<ConsumptionDTO> deleteConsumption(@PathVariable Long consumptionId) throws NotFoundException {
        return new ResponseEntity<>(consumptionService.deleteConsumption(consumptionId),HttpStatus.OK);
    }


}
