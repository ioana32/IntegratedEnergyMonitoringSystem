package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Person;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Transactional
    @Modifying
    @Query(value =
            "DELETE FROM Device d " +
                    "WHERE d.id = :deviceId")
    Integer deleteDeviceById(@Param("deviceId") Long deviceId);

    List<Device> findAllByUser(Long userId);

}
