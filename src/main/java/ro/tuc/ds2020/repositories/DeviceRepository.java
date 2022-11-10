package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Device;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Transactional
    @Modifying
    @Query(value =
            "DELETE FROM Device d " +
                    "WHERE d.id = :deviceId")
    Integer deleteDeviceById(@Param("deviceId") Long deviceId);

    @Query(value = "SELECT d " +
            "FROM Device d " +
            "WHERE d.user.id = :userId")
    List<Device> findAllByUser(@Param("userId") Long userId);

//    List<Device> findByUser(Long userId);
//
}
