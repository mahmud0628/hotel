package uz.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.hotel.entity.Mijoz;

import java.util.List;
@Repository
public interface MijozRepository extends JpaRepository<Mijoz,Long> {


}
