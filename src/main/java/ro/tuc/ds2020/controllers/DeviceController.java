package ro.tuc.ds2020.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.services.DeviceService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) { this.deviceService = deviceService;}
    
    @GetMapping()
    public ResponseEntity<List<DeviceDTO>> getClients(){
        return null;
    }

    @GetMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDetailsDTO> getClients(@PathVariable Long deviceId){
        return new ResponseEntity<>(deviceService.getDevice(deviceId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DeviceDTO> createClient(@RequestBody DeviceDTO deviceDTO){
        return new ResponseEntity<>(deviceService.createDevice(deviceDTO),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> updateClient(@PathVariable Long deviceId, @RequestBody DeviceDTO deviceDTO){
        return new ResponseEntity<>(deviceService.updateDevice(deviceId,deviceDTO),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> deleteClient(@PathVariable Long deviceId) throws NotFoundException {
        return new ResponseEntity<>(deviceService.deleteDevice(deviceId),HttpStatus.OK);
    }
    
}
