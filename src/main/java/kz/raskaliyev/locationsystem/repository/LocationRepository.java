package kz.raskaliyev.locationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.raskaliyev.locationsystem.model.entity.Location;
import kz.raskaliyev.locationsystem.model.entity.User;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
