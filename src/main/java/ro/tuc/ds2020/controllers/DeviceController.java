package ro.tuc.ds2020.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
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
    public ResponseEntity<List<DeviceDetailsDTO>> getDevices(){
        return new ResponseEntity<>(deviceService.getDevices(),HttpStatus.OK);
    }

    @GetMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDetailsDTO> getDevice(@PathVariable("deviceId") Long deviceId){
        DeviceDetailsDTO dto = deviceService.getDevice(deviceId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<DeviceDTO>> getDevicebyUser(@PathVariable("userId") Long userId){
        List<DeviceDTO> dto = deviceService.getDevicesbyUser(userId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DeviceDetailsDTO> createDevice(@RequestBody DeviceDTO deviceDTO){
        DeviceDetailsDTO dto = deviceService.createDevice(deviceDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
       // return new ResponseEntity<>(deviceService.createDevice(deviceDTO),HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDetailsDTO> updateDevice(@PathVariable("deviceId") Long deviceId, @RequestBody DeviceDTO deviceDTO){
        return new ResponseEntity<>(deviceService.updateDevice(deviceId,deviceDTO),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> deleteDevice(@PathVariable("deviceId") Long deviceId) throws NotFoundException {
        return new ResponseEntity<>(deviceService.deleteDevice(deviceId),HttpStatus.OK);
    }
    
}
