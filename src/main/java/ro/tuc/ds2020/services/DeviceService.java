package ro.tuc.ds2020.services;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Users;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final DeviceRepository deviceRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, UserRepository userRepository, UserService userService, UserRepository userRepository1) {
        this.deviceRepository = deviceRepository;
        this.userService = userService;
        this.userRepository = userRepository1;
    }

    public DeviceDetailsDTO createDevice(DeviceDTO deviceDTO){
        System.out.println(deviceDTO);
        Optional<Users> user=userRepository.findById(Long.valueOf(0));

        Device device = new Device(deviceDTO);
        device.setUser(user.get());
        return new DeviceDetailsDTO(deviceRepository.save(device));
    }

    public Device deleteDevice(Long deviceId) throws NotFoundException {
        Device device= deviceRepository.findById(deviceId).orElse(null);
//        System.out.println(device);
//        if (device == null) {
//            //throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
//        }
//        Integer i =deviceRepository.deleteDeviceById(device.getId());
       // return device.getId();
        deviceRepository.delete(device);
        return device;
    }

    public DeviceDetailsDTO updateDevice(Long deviceId, Long userId,DeviceDTO deviceDTO){
        Device device=deviceRepository.findById(deviceId).orElse(null);
        if(device == null){
            //throw new ResourceNotFoundExeption(String.format("Client with id %d not found ", clientId));
        } else {
            device.setAddress(deviceDTO.getAddress());
            device.setMaxEnergy(deviceDTO.getMaxEnergy());
            device.setDescription(deviceDTO.getDescription());
//            System.out.println(deviceDTO);
            device.setUser(userRepository.findById(userId).get());
        }
        return new DeviceDetailsDTO(deviceRepository.save(device));
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
