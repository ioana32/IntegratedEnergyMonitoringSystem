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
    public ResponseEntity<List<DeviceDTO>> getDevices(){
        return null;
    }

    @GetMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDetailsDTO> getDevice(@PathVariable("deviceId") Long deviceId){
        DeviceDetailsDTO dto = deviceService.getDevice(deviceId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DeviceDTO> createDevice(@RequestBody DeviceDTO deviceDTO){
        return new ResponseEntity<>(deviceService.createDevice(deviceDTO),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> updateDevice(@PathVariable("deviceId") Long deviceId, @RequestBody DeviceDTO deviceDTO){
        return new ResponseEntity<>(deviceService.updateDevice(deviceId,deviceDTO),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> deleteDevice(@PathVariable("deviceId") Long deviceId) throws NotFoundException {
        return new ResponseEntity<>(deviceService.deleteDevice(deviceId),HttpStatus.OK);
    }
    
}