package uz.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.hotel.entity.Xodim;
@Repository
public interface XodimRepository extends JpaRepository<Xodim,Long> {


}
