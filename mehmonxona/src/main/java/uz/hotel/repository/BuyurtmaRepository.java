package uz.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.hotel.entity.Buyurtma;

@Repository
public interface BuyurtmaRepository extends JpaRepository<Buyurtma,Long> {


}
