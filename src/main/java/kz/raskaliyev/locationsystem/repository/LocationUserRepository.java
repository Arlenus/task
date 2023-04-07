package kz.raskaliyev.locationsystem.repository;

import kz.raskaliyev.locationsystem.model.entity.LocationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocationUserRepository extends JpaRepository<LocationUser,Long> {
    List<LocationUser> findByLocationId(Long locationId);
    List<LocationUser> findByUserId(Long userId);
}
