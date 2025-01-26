package pe.resource.casadecambio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.resource.casadecambio.entity.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long>{
}
