package ro.tuc.ds2020.services;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.repositories.DeviceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceDTO createDevice(DeviceDTO deviceDTO){
        Device device = new Device(deviceDTO);
        return new DeviceDTO(deviceRepository.save(device));
    }

    public DeviceDTO deleteDevice(Long deviceId) throws NotFoundException {
        Device device= deviceRepository.findById(deviceId).orElse(null);
        System.out.println(device);
        if (device == null) {
            //throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
        }
        Integer i =deviceRepository.deleteDeviceById(device.getId());
       // return device.getId();
        return new DeviceDTO(device);
    }

    public DeviceDTO updateDevice(Long deviceId, DeviceDTO deviceDTO){
        Device device=deviceRepository.findById(deviceId).orElse(null);
        if(device == null){
            //throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
        } else {
            device.setAddress(deviceDTO.getAddress());
            device.setMaxEnergy(deviceDTO.getMaxEnergy());
            device.setDescription(deviceDTO.getDescription());
        }
        return new DeviceDTO(deviceRepository.save(device));
    }

    public DeviceDetailsDTO getDevice(Long deviceId){
        Device device = deviceRepository.findById(deviceId).orElse(null);
        if(device == null) {
            //  throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
        }
        return new DeviceDetailsDTO(device);

    }

    public List<DeviceDetailsDTO> getDevices(){
        List<Device> devices=deviceRepository.findAll();
        List<DeviceDetailsDTO> devDTO=new ArrayList<>();
        for(Device dev:devices){
            devDTO.add(new DeviceDetailsDTO(dev));
        }
        return devDTO;
    }

    public List<DeviceDTO> getDevicesbyUser(Long userId){
        List<Device> devices=deviceRepository.findAllByUser(userId);
        List<DeviceDTO> devDTO=new ArrayList<>();
        for(Device dev:devices){
            devDTO.add(new DeviceDTO(dev));
        }
        return devDTO;
    }

}
