package co.edu.sena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.sena.models.entity.TipoEjercicio;

@Repository
public interface TipoEjercicioRepository extends JpaRepository<TipoEjercicio, Integer> {

}
