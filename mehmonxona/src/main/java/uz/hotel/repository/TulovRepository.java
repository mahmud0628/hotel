package uz.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.hotel.entity.Tulov;
@Repository
public interface TulovRepository  extends JpaRepository<Tulov,Long> {
}
