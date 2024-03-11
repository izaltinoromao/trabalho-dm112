package br.inatel.dm112.EntregaDM112.repository;

import br.inatel.dm112.EntregaDM112.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
