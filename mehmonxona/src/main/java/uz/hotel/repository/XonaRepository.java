package uz.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.hotel.entity.Xona;
@Repository
public interface XonaRepository extends JpaRepository<Xona,Long> {


}
