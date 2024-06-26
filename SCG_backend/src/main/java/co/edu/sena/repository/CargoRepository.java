package co.edu.sena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.sena.models.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
