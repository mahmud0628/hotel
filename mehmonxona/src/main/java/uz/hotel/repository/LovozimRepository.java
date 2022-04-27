package uz.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.hotel.entity.Lovozim;
@Repository
public interface LovozimRepository extends JpaRepository<Lovozim,Long> {
}
